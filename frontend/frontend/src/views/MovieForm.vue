<script setup>
import { computed, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useMovieStore } from '../stores/movieStore'

const store = useMovieStore()
const route = useRoute()      // read the current URL (gives route.params.id)
const router = useRouter()    // change the URL from code

// if the URL has an :id we are editing, otherwise we are adding
const isEdit = computed(() => !!route.params.id)

onMounted(() => {
  if (isEdit.value) {
    store.fetchMovie(route.params.id)   // edit: load that movie into the form
  } else {
    store.resetMovie()                  // add: start with an empty form
  }
})

async function save() {
  if (!store.movie.title || !store.movie.genre) return   // simple check

  if (isEdit.value) {
    await store.updateMovie(route.params.id, store.movie)   // PUT
  } else {
    await store.addMovie(store.movie)                       // POST
  }
  router.push('/')                      // back to the list page
}
</script>

<template>
  <div class="card">
    <h2>{{ isEdit ? 'Edit Movie' : 'Add Movie' }}</h2>

    <!-- v-model links the input and the store value in both directions -->
    <label for="title">Title</label>
    <input id="title" v-model="store.movie.title" placeholder="e.g. Inception" />

    <label for="genre">Genre</label>
    <input id="genre" v-model="store.movie.genre" placeholder="e.g. Sci-Fi" />

    <div class="form-buttons">
      <button class="primary" @click="save">{{ isEdit ? 'Update' : 'Save' }}</button>
      <RouterLink class="btn" to="/">Cancel</RouterLink>
    </div>
  </div>
</template>
