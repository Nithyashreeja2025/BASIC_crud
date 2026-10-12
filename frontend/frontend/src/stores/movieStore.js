import { defineStore } from 'pinia'
import axios from 'axios'

// the backend URL: this is the connection point. It must match @RequestMapping in the controller
const API = 'http://localhost:8080/api/movies'

export const useMovieStore = defineStore('movie', {

  // STATE: the shared data
  state: () => ({
    movies: [],                          // the list shown on the home page
    movie: { title: '', genre: '' }      // the single movie used by the form
  }),

  // ACTIONS: functions that change the state or call the backend
  actions: {
    async fetchMovies() {                // GET all
      const res = await axios.get(API)
      this.movies = res.data
    },

    async fetchMovie(id) {               // GET one (used by the edit page)
      const res = await axios.get(`${API}/${id}`)
      this.movie = res.data
    },

    resetMovie() {                       // empty the form (used by the add page)
      this.movie = { title: '', genre: '' }
    },

    async addMovie(movie) {              // POST
      await axios.post(API, movie)
    },

    async updateMovie(id, movie) {       // PUT
      await axios.put(`${API}/${id}`, movie)
    },

    async deleteMovie(id) {              // DELETE, then reload the list
      await axios.delete(`${API}/${id}`)
      await this.fetchMovies()
    }
  }
})
