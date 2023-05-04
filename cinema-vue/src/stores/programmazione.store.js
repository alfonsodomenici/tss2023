import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { request } from "@/helpers";
import { config } from '@/app.config.js';

const baseUrl = `${config.baseUrl}/programmazioni`;

export const useProgrammazioneStore = defineStore("programmazione", () => {
  const progrs = ref([]);
  const progr = ref({});

  async function create(progr) {
    const result = await request('POST', `${baseUrl}`, progr);
    progrs.push(result);
  }
  async function getAll() {
    progrs.value = await request('GET', `${baseUrl}`);
  }
  async function getById(id) {
    progr.value = await request('GET', `${baseUrl}/${id}`);
  }
  async function update(progr) {
    progr.value = await request('PUT', `${baseUrl}`, progr);
  }
  async function remove(id) {
     await request('DELETE', `${baseUrl}/${id}`);
     progrs.value = progrs.value.filter(v => v.id !== id);
  }
  async function getProiezioni(id) {
    return await request('GET', `${baseUrl}/${id}/proiezioni`);
  }
  async function createProiezione(id,proiezione) {
    return await request('POST', `${baseUrl}/${id}/proiezioni`);
  }

  return { progrs, progr, create, getAll, getById, update, remove, getProiezioni, createProiezione };
});
