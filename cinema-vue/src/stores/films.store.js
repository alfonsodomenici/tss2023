import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { request } from "@/helpers";
import { config } from '@/app.config.js';

const baseUrl = `${config.baseUrl}/films`;

export const useFilmsStore = defineStore("films", () => {
  const films = ref([]);
  const film = ref({});
  const proiezioni = ref([]);
  const progr = ref({});

  function $reset() {
    films.value = [];
    film.value = {};
    proiezioni.value = [];
    progr.value = {};
  }
  async function create() {
    await request('POST', `${baseUrl}`, film.value);
    film.value = {};
  }
  async function getAll() {
    films.value = await request('GET', `${baseUrl}`);
  }
  async function getById(id) {
    film.value = await request('GET', `${baseUrl}/${id}`);
  }
  async function update(id) {
    film.value = await request('PUT', `${baseUrl}/${id}`, film.value);
  }
  async function remove(id) {
    await request('DELETE', `${baseUrl}/${id}`);
    films.value = films.value.filter(v => v.id !== id);
  }

  async function getProiezioni(id) {
    await getById(id);
    proiezioni.value = await request('GET', `${baseUrl}/${id}/proiezioni`);
  }

  async function createProgrammazione(id) {
    progr.value = request('POST', `${baseUrl}/${id}/programmazioni`, progr.value);
    progr.value = {};
  }

  return { films, film, proiezioni, progr, $reset, create, getAll, getById, update, remove, getProiezioni, createProgrammazione };
});
