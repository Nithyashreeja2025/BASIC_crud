import { createRouter, createWebHistory } from 'vue-router'
import MovieList from '../views/MovieList.vue'
import MovieForm from '../views/MovieForm.vue'

export default createRouter({
  history: createWebHistory(),   // clean URLs like /add (no # in the address)
  routes: [
    { path: '/', component: MovieList },          // home page: the list
    { path: '/add', component: MovieForm },       // add page: empty form
    { path: '/edit/:id', component: MovieForm }   // edit page: :id is a variable part of the URL
  ]
})
