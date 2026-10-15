
import { defineStore } from 'pinia'

const api = 'http://localhost:8080/api/names'

export const useNameStore = defineStore('names', {
  state: () => ({ names: [] }),
  actions: {
    async getNames() {
      this.names = await (await fetch(api)).json()
    },
    async saveName(data, id) {
      await fetch(id ? `${api}/${id}` : api, {
        method: id ? 'PUT' : 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
      })
      await this.getNames()
    },
    async deleteName(id) {
      await fetch(`${api}/${id}`, { method: 'DELETE' })
      await this.getNames()
    }
  }
})
