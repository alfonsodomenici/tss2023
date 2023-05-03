<script setup>
import { useRouter, RouterLink } from 'vue-router';
import { useProiezioniStore, useAuthStore, useAlertStore } from '@/stores';
import { storeToRefs } from 'pinia';

const store = useProiezioniStore();
const authStore = useAuthStore();
const alertStore = useAlertStore();

const { proiezioni } = storeToRefs(store);

store.getAll();
</script>

<template>
    <p class="title has-text-centered has-text-info">Film in programma</p>
    <div class="list">
        <template v-if="proiezioni && proiezioni.length">
            <div class="list-item" v-for="item in proiezioni">
                <div class="list-item-content">
                    <div class="list-item-title">{{ item.programmazione.il }}</div>
                    <div class="list-item-title">{{ item.sala.nome }}</div>
                    <div class="list-item-title">Posti disponibili: {{ item.disponibilita }}</div>
                    <div class="list-item-description">
                        <p class="is-size-4">{{ item.programmazione.film.titolo }}</p>
                        <p>di {{ item.programmazione.film.regista }}</p>
                        <p>Costo {{ item.programmazione.prezzo }}€</p>
                    </div>
                </div>
                <div class="list-item-controls">
                    <div class="buttons is-right">
                        <RouterLink :to="`/proiezioni/${item.id}/biglietti`" class="button is-link" >Biglietti</RouterLink>
                    </div>
                </div>
            </div>
        </template>
        <template v-if="alertStore.isLoading">
            <div class="container loader"></div>
        </template>
    </div>
</template>