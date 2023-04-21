<script setup>
import { useRouter, RouterLink } from 'vue-router';
import { useProgrammazioneStore, useAuthStore, useAlertStore } from '@/stores';
import { storeToRefs } from 'pinia';

const store = useProgrammazioneStore();
const authStore = useAuthStore();
const alertStore = useAlertStore();

const { items } = storeToRefs(store);

store.getAll();
</script>

<template>
    <p class="title has-text-centered">Film in programma</p>
    <RouterLink to="/programmazione/add" class="button is-primary">Aggiungi</RouterLink>
    <div class="list">
        <template v-if="items.length">
            <div class="list-item" v-for="item in items">
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
                        <RouterLink :to="`/programmazione/edit/${item.id}`" class="button is-link">Modifica</RouterLink>
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