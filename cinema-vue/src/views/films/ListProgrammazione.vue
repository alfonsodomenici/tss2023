<script setup>
import { useRouter, useRoute, RouterLink } from 'vue-router';
import { useFilmsStore, useAuthStore, useAlertStore } from '@/stores';
import { storeToRefs } from 'pinia';

const store = useFilmsStore();
const authStore = useAuthStore();
const alertStore = useAlertStore();
const route = useRoute();

const id = route.params.id;

const { progrs, film } = storeToRefs(store);

store.getProgrammazione(id);
</script>

<template>
    <p class="title has-text-centered">Programmazione {{ film.titolo }}</p>
    <RouterLink :to="`/films/programmazione/add/${id}`" class="button is-primary">Aggiungi</RouterLink>
    <div class="list">
        <template v-if="progrs && progrs.length">
            <div class="list-item" v-for="item in progrs">
                <div class="list-item-content">
                    <div class="list-item-title">{{ item.il }}</div>
                    <div class="list-item-description">
                        <p class="is-size-4">{{ item.film.titolo }}</p>
                        <p>di {{ item.film.regista }}</p>
                        <p>Costo {{ item.prezzo }}€</p>
                    </div>
                </div>
                <div class="list-item-controls">
                    <div class="buttons is-right">
                        <button class="button is-danger">Elimina</button>
                    </div>
                </div>
            </div>
        </template>
        <template v-if="alertStore.isLoading">
            <div class="container loader"></div>
        </template>
    </div>
</template>