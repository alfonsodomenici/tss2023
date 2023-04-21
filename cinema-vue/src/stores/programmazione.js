import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { request } from "@/helpers";
import { config } from '@/app.config.js';

const baseUrl = `${config.baseUrl}/programmazioni`;

export const useProgrammazioneStore = defineStore("programmazione", () => {
  const items = ref({});
  const item = ref({});

  async function create(progr) {
    return await request('POST', `${baseUrl}`, progr);
  }
  async function getAll() {
    items.value = {};
    items.value = await request('GET', `${baseUrl}`);
  }
  async function getById() {
    return await request('GET', `${baseUrl}`, progr);
  }
  async function update(progr) {
    return await request('PUT', `${baseUrl}`, progr);
  }
  async function remove(progr) {
    return await request('DELETE', `${baseUrl}`, progr);
  }

  return { items, item, create, getAll, getById, update, remove };
});
