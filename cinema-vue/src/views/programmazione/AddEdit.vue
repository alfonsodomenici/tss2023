<script setup>
import { useRoute, RouterLink } from 'vue-router';
import { ref } from 'vue';
import {
    useProgrammazioneStore, useFilmsStore
    , useAuthStore, useAlertStore
} from '@/stores';
import { storeToRefs } from 'pinia';

const MIN_DATE = new Date().toISOString().slice(0, 10)

const store = useProgrammazioneStore();
const filmsStore = useFilmsStore();
const alertStore = useAlertStore();

const route = useRoute();
const id = route.params.id;

let title = 'Aggiungi programmazione';
let filmSelected = ref(null);
let quando = ref(null);
let prezzo = ref(null);

const { films } = storeToRefs(filmsStore);
const { progr } = storeToRefs(store);

filmsStore.getAll();

if (id) {
    title = 'Modifica programmazione';
    store.getById(id).then(() => {
        filmSelected.value = progr.value.film.id;
        quando.value = progr.value.il;
        prezzo.value = progr.value.prezzo;
        console.log(filmSelected.value, quando.value, prezzo.value)
    });
}

function onSave(){
    console.log('onSave...');
}
</script>

<template>
    <p class="title has-text-centered">{{ title }}</p>
    <form method="post" ref="form">
        <div class="field ">
            <label class="label">Scegli il film</label>
            <div class="control">
                <div class="select">
                    <select v-model="filmSelected">
                        <option v-for="film in films" :value="film.id">{{ film.titolo }}</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="field">
            <label class="label">Quando</label>
            <div class="control">
                <input v-model="quando" class="input" type="date" placeholder="data di programmazione" :min="MIN_DATE"
                    required>
            </div>
        </div>
        <div class="field ">
            <label class="label">Prezzo</label>
            <div class="control is-expanded">
                <input v-model="prezzo" class="input" type="number" placeholder="prezzo" required>
            </div>
        </div>
        <div class="field is-grouped">
            <p class="control">
                <button @click.prevent="onSave" class="button is-primary" :class="{ 'is-loading': alertStore.isLoading }">
                    Salva
                </button>
            </p>
            <p class="control">
                <RouterLink to="/programmazione/" class="button is-link is-light">Elenco</RouterLink>
            </p>
        </div>
    </form>
</template>