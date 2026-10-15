
<script setup>
import {ref,onMounted} from 'vue'
import Home from './Home.vue'

const names=ref([])
const name=ref(''),email=ref(''),id=ref('')
const page=ref('home')

const api='http:localhost:8080/api/names'

async function getNames(){
    names.value= await(await fetch(api)).json()
}

async function saveName(){
    if(!name.value || !email.value){
        return alert('Enter all details')

    }

    await(fetch(id.value? '${api}/${id.value}' :api,{
        method:id.value?'PUT':'POST',
        headers:{'content-type' :'application/json'},
        body:JSON.stringify({name:name.value,email:email.value})
    }))

    names.value=email.value=id.value=''
    getNames()

}

async function edit(item1) {
    name.vale=item1.name
    email.value=item1.email
    id.value=item1.id
}

async function deleteName(id){
    await fetch('${api}/${id}',{method:'DELETE'})
    getNames()
}

onMounted(getNames)

</script>
<template>
    <h2>Name crud</h2>
    <a href="#" @click.privent="page='home'">Home</a> |
    <a href="#" @click.privent="page='names'">Manage Names</a>
    <hr>
<Home v-if="page==='home'" />
<div v-else>
    
    <h1>Name Management</h1>
    <input v-model="name" placeholder="Name">
    <input v-model="email" placeholder="Email">
    <button @click="saveName">{{ id?'Update':'Save' }}</button>
<table>
<tbody>
 <tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
    <tr v-for="item in names" :key="item.id">
        <td>{{ item.name }}</td>
        <td>{{ item.email }}</td>
        <td><button @click="edit(item)">Edit</button></td>
        <td><button @click="deleteName(item.id)">Delete</button></td>
    </tr>

    </tbody>



</table>

    </div>
</template>
