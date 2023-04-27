<script setup>
import { useRoute, useRouter, RouterLink } from 'vue-router';
import { ref } from 'vue';
import {
    useFilmsStore
    , useAuthStore, useAlertStore
} from '@/stores';
import { storeToRefs } from 'pinia';

const MIN_DATE = new Date().toISOString().slice(0, 10)

const store = useFilmsStore();
const alertStore = useAlertStore();

const route = useRoute();
const router = useRouter();

const id = route.params.id;
console.log('id: ', id);

let title = 'Aggiungi film';

const { film } = storeToRefs(store);
const started = ref(false);

store.$reset();

if (id) {
    title = 'Modifica film';
    store.getById(id);
}

function onSave() {
    started.value = true;
    (id ? store.update(id) : store.create())
        .then(_ => {
            alertStore.success(id ? 'Film aggiornato con successo.' : 'Film creato con successo.');
        }).catch(error => {
            alertStore.error('Si è verificato un errore durante il salvataggio.');
        })
}
</script>

<template>
    <p class="title has-text-centered">{{ title }}</p>
    <template v-if="!alertStore.isLoading || started">
        <form method="post" ref="form">
            <div class="field ">
                <label class="label">Titolo</label>
                <div class="control is-expanded">
                    <input v-model="film.titolo" class="input" type="text" placeholder="titolo" required>
                </div>
            </div>
            <div class="field ">
                <label class="label">Descrizione</label>
                <div class="control is-expanded">
                    <input v-model="film.descrizione" class="input" type="text" placeholder="descrizione">
                </div>
            </div>
            <div class="field ">
                <label class="label">Regista</label>
                <div class="control is-expanded">
                    <input v-model="film.regista" class="input" type="text" placeholder="regista">
                </div>
            </div>
            <div class="field ">
                <label class="label">Eta Minima</label>
                <div class="control is-expanded">
                    <input v-model="film.eta_minima" class="input" type="number" placeholder="eta minima">
                </div>
            </div>
            <div class="field is-grouped">
                <p class="control">
                    <button @click.prevent="onSave" class="button is-primary"
                        :class="{ 'is-loading': alertStore.isLoading }">
                        Salva
                    </button>
                </p>
                <p class="control">
                    <RouterLink to="/films/" class="button is-link is-light">Elenco</RouterLink>
                </p>
            </div>
        </form>
    </template>
    <template v-if="alertStore.isLoading && !started">
        <div class="container loader"></div>
    </template>
</template>