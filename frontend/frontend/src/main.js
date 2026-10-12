import { createApp } from 'vue'          // createApp builds the Vue app
import { createPinia } from 'pinia'      // Pinia = the shared data store
import router from './router'            // our routes
import App from './App.vue'              // the root component
import './style.css'                     // simple global styles

createApp(App)
  .use(createPinia())   // turn Pinia on
  .use(router)          // turn the router on
  .mount('#app')        // show it inside <div id="app"> in index.html
