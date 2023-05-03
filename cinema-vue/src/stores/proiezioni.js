import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { request } from "@/helpers";
import { config } from '@/app.config.js';

const baseUrl = `${config.baseUrl}/proiezioni`;

export const useProiezioniStore = defineStore("proiezioni", () => {
  const proiezioni = ref([]);
  const proiezione = ref({});
  const biglietti = ref([]);
  const biglietto = ref({});
  async function getAll() {
    proiezioni.value = await request('GET', `${baseUrl}`);
  }
  async function getById(id) {
    proiezione.value = await request('GET', `${baseUrl}/${id}`);
  }
  async function remove(id) {
    await request('DELETE', `${baseUrl}/${id}`);
    proiezioni.value = proiezioni.value.filter(v => v.id !== id);
  }
  async function getBiglietti(id) {
    await getById(id);
    biglietti.value = await request('GET', `${baseUrl}/${id}/biglietti`);
  }

  async function prenota(id) {
    biglietto.value = request('POST', `${baseUrl}/${id}/biglietti`, biglietto.value);
    biglietto.value = {};
  }
  return { proiezioni, proiezione, biglietti, biglietto, getAll, getById, remove, getBiglietti, prenota };
});
