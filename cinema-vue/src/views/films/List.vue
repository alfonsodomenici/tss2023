<script setup>
import { useRouter, RouterLink } from 'vue-router';
import { useFilmsStore, useAuthStore, useAlertStore } from '@/stores';
import { storeToRefs } from 'pinia';
import { ref } from 'vue';

const store = useFilmsStore();
const authStore = useAuthStore();
const alertStore = useAlertStore();

const { films } = storeToRefs(store);
const started = ref(false);

store.getAll();

function onElimina(id){
    started.value = true;
    store.remove(id);
}
</script>

<template>
    <p class="title has-text-centered">Elenco Film</p>
    <RouterLink to="/films/add" class="button is-primary">Aggiungi</RouterLink>
    <div class="list">
        <template v-if="!alertStore.isLoading || started">
            <div class="list-item" v-for="item in films">
                <div class="list-item-content">
                    <div class="list-item-title">{{ item.titolo }}</div>
                    <div class="list-item-description">
                        <p class="is-size-4">{{ item.descrizione }}</p>
                        <p>di {{ item.regista }}</p>
                        <p>Eta minima {{ item.eta_minima }}</p>
                    </div>
                </div>
                <div class="list-item-controls">
                    <div class="buttons is-right">
                        <RouterLink :to="`/films/edit/${item.id}`" class="button is-link" >Modifica</RouterLink>
                        <RouterLink :to="`/films/programmazione/${item.id}`" class="button is-link" >Programmazione</RouterLink>
                        <button @click="onElimina(item.id)" class="button is-danger" :class="{ 'is-loading': alertStore.isLoading }">Elimina</button>
                    </div>
                </div>
            </div>
        </template>
        <template v-if="alertStore.isLoading && !started">
            <div class="container loader"></div>
        </template>
    </div>
</template>