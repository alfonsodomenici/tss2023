<script setup>
import { useRouter, useRoute, RouterLink } from 'vue-router';
import { useFilmsStore, useAuthStore, useAlertStore } from '@/stores';
import { storeToRefs } from 'pinia';

const store = useFilmsStore();
const authStore = useAuthStore();
const alertStore = useAlertStore();
const route = useRoute();

const id = route.params.id;

const { proiezioni, film } = storeToRefs(store);

store.getProiezioni(id);

function onElimina(id){
    alert("TODO..." + id);
}
</script>

<template>
    <p class="title has-text-centered is-size-4">Programmazione <span class="has-text-info is-size-3">{{ film.titolo }}</span></p>
    <RouterLink :to="`/films/${id}/programmazione/add`" class="button is-primary">Aggiungi</RouterLink>
    <div class="list">
        <template v-if="proiezioni && proiezioni.length">
            <div class="list-item" v-for="item in proiezioni">
                <div class="list-item-content">
                    <div class="list-item-title">{{ item.programmazione.il }}</div>
                    <div class="list-item-title">{{ item.sala.nome }}</div>
                    <div class="list-item-description">
                        <p class="is-size-4">{{ item.programmazione.film.titolo }}</p>
                        <p>di {{ item.programmazione.film.regista }}</p>
                        <p>Costo {{ item.programmazione.prezzo }}€</p>
                    </div>
                </div>
                <div class="list-item-controls">
                    <div class="buttons is-right">
                        <button @click="onElimina(item.id)" class="button is-danger">Elimina</button>
                    </div>
                </div>
            </div>
        </template>
        <template v-if="alertStore.isLoading">
            <div class="container loader"></div>
        </template>
    </div>
</template>