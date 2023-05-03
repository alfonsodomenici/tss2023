<script setup>
import { useRoute, RouterLink } from 'vue-router';
import { ref } from 'vue';
import {
    useProiezioniStore
    , useAuthStore, useAlertStore
} from '@/stores';
import { storeToRefs } from 'pinia';

const MIN_DATE = new Date().toISOString().slice(0, 10)

const store = useProiezioniStore();
const alertStore = useAlertStore();

const route = useRoute();
const id = route.params.id;

const { proiezione, biglietto } = storeToRefs(store);

store.getById(id);

function onSave() {
    store.prenota(id);
}
</script>

<template>
    <p class="title has-text-centered is-size-4">Prenota
        <span class="has-text-info is-size-3">{{ proiezione?.programmazione?.film?.titolo }}</span>
    </p>
    <form method="post" ref="form">
        <div class="field ">
            <label class="label">Tipo biglietto</label>
            <div class="select">
                <select v-model="biglietto.tipo">
                    <option value="INTERO">INTERO</option>
                    <option value="RIDOTTO">RIDOTTO</option>
                    <option value="OMAGGIO">OMAGGIO</option>
                </select>
            </div>
        </div>
        <div class="field ">
            <label class="label">Quantita</label>
            <div class="control is-expanded">
                <input v-model="biglietto.quantita" class="input" type="number" placeholder="quantita" required>
            </div>
        </div>

        <div class="field is-grouped">
            <p class="control">
                <button @click.prevent="onSave" class="button is-primary" :class="{ 'is-loading': alertStore.isLoading }">
                    Salva
                </button>
            </p>
            <p class="control">
                <RouterLink :to="`/proiezioni/${id}/biglietti`" class="button is-link is-light">Elenco</RouterLink>
            </p>
        </div>
    </form>
</template>