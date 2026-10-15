
import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/HomeView.vue'
import Names from '../views/NamesView.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: Home },
    { path: '/names', component: Names }
  ]
})
