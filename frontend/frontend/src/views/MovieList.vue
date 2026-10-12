<script setup>
import { onMounted } from 'vue'
import { useMovieStore } from '../stores/movieStore'

const store = useMovieStore()            // access the shared store

onMounted(() => store.fetchMovies())     // when this page opens, load the movies
</script>

<template>
  <div class="card">
    <p v-if="store.movies.length === 0" class="empty">
      No movies yet. Click "Add Movie" to create one.
    </p>

    <table v-else>
      <thead>
        <tr>
          <th>Title</th>
          <th>Genre</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <!-- v-for repeats this row for every movie -->
        <tr v-for="movie in store.movies" :key="movie.id">
          <td>{{ movie.title }}</td>
          <td>{{ movie.genre }}</td>
          <td class="actions">
            <RouterLink class="btn" :to="`/edit/${movie.id}`">Edit</RouterLink>
            <button class="danger" @click="store.deleteMovie(movie.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
