import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { request } from "@/helpers";
import { config } from '@/app.config.js';

const baseUrl = `${config.baseUrl}/films`;

export const useFilmsStore = defineStore("films", () => {
  const films = ref({});
  const film = ref({});

  async function create(film) {
    return await request('POST', `${baseUrl}`, film);
  }
  async function getAll() {
    films.value = await request('GET', `${baseUrl}`);
  }
  async function getById(id) {
    film.value = await request('GET', `${baseUrl}/${id}`);
  }
  async function update(film) {
    film.value = await request('PUT', `${baseUrl}`, film);
  }
  async function remove(id) {
    await request('DELETE', `${baseUrl}/${id}`);
    films.value = films.value.filter(v => v.id !== id);
  }

  return { films, film, create, getAll, getById, update, remove };
});
