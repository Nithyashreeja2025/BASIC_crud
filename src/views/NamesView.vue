
<script setup>
import { ref, onMounted } from 'vue'
import { useNameStore } from '../stores/nameStore'

const store = useNameStore()
const id = ref(''), name = ref(''), email = ref('')
onMounted(() => store.getNames())

async function save() {
  if (!name.value || !email.value) return alert('Enter all details')
  await store.saveName({ name: name.value, email: email.value }, id.value)
  id.value = name.value = email.value = ''
}

function edit(item) {
  id.value = item.id
  name.value = item.name
  email.value = item.email
}

async function remove(id) {
  if (confirm('Delete this record?')) await store.deleteName(id)
}
</script>

<template>
  <h2>Name Management</h2>
  <input v-model="name" placeholder="Name">
  <input v-model="email" placeholder="Email">
  <button @click="save">{{ id ? 'Update' : 'Save' }}</button>
  <button v-if="id" @click="id = name = email = ''">Cancel</button>

  <table>
    <tbody>
      <tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
      <tr v-for="item in store.names" :key="item.id">
        <td>{{ item.id }}</td><td>{{ item.name }}</td><td>{{ item.email }}</td>
        <td>
          <button @click="edit(item)">Edit</button>
          <button @click="remove(item.id)">Delete</button>
        </td>
      </tr>
      <tr v-if="!store.names.length"><td colspan="4">No records found</td></tr>
    </tbody>
  </table>
</template>

<style>
table { margin-top: 20px; border-collapse: collapse; width: 100%; }
th, td { border: 1px solid black; padding: 8px; }
input, button { margin: 5px; padding: 8px; }
</style>
