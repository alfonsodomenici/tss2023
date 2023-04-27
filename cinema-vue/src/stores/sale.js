import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { request } from "@/helpers";
import { config } from '@/app.config.js';

const baseUrl = `${config.baseUrl}/sale`;

export const useSaleStore = defineStore("sale", () => {
  const sale = ref([]);
  const sala = ref({});
  
  function $reset() {
    sale.value = [];
    sala.value = {};
  }
  async function create() {
    await request('POST', `${baseUrl}`, sala.value);
    sala.value = {};
  }
  async function getAll() {
    sale.value = await request('GET', `${baseUrl}`);
  }
  async function getById(id) {
    sala.value = await request('GET', `${baseUrl}/${id}`);
  }
  async function update(id) {
    sala.value = await request('PUT', `${baseUrl}/${id}`, sala.value);
  }
  async function remove(id) {
    await request('DELETE', `${baseUrl}/${id}`);
    sale.value = sale.value.filter(v => v.id !== id);
  }
  return { sale, sala, $reset, create, getAll, getById, update, remove };
});
