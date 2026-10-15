
<script setup>
import { ref, onMounted } from 'vue'
import Home from './components/Home.vue'

const names = ref([])
const id = ref(''), name = ref(''), email = ref('')
const page = ref('home')
const api = 'http://localhost:8080/api/names'

async function getNames() {
  names.value = await (await fetch(api)).json()
}

async function saveName() {
  if (!name.value || !email.value){
    return alert('Enter all details')
  } 

  await fetch(id.value ? `${api}/${id.value}` : api, {
    method: id.value ? 'PUT' : 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name: name.value, email: email.value })
  })

  id.value = name.value = email.value = ''
  getNames()
}

function editName(item) {
  id.value = item.id
  name.value = item.name
  email.value = item.email
}

async function deleteName(id) {
 
    await fetch(`${api}/${id}`, { method: 'DELETE' })
    getNames()
  
}

onMounted(getNames)
</script>

<template>
  <h1>Name CRUD</h1>
  <a href="#" @click.prevent="page = 'home'">Home</a> |
  <a href="#" @click.prevent="page = 'names'">Manage Names</a>
  <hr>

  <Home v-if="page === 'home'" />

  <div v-else>
    <h2>Name Management</h2>
    <input v-model="name" placeholder="Name">
    <input v-model="email" placeholder="Email">
    <button @click="saveName">{{ id ? 'Update' : 'Save' }}</button>

    <table>
      <tbody>
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
        <tr v-for="item in names" :key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.email }}</td>
          <td>
            <button @click="editName(item)">Edit</button>
            <button @click="deleteName(item.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style>
table { margin-top: 20px; border-collapse: collapse; width: 100%; }
th, td { border: 1px solid black; padding: 8px; }
input, button { margin: 5px; padding: 8px; }
</style>
