<script setup>
import { useRouter, useRoute, RouterLink } from 'vue-router';
import { useProiezioniStore, useAuthStore, useAlertStore } from '@/stores';
import { storeToRefs } from 'pinia';

const store = useProiezioniStore();
const authStore = useAuthStore();
const alertStore = useAlertStore();
const route = useRoute();

const id = route.params.id;

const { biglietti, proiezione } = storeToRefs(store);

store.getBiglietti(id);

function onElimina(id){
    alert("TODO..." + id);
}
</script>

<template>
    <p class="title has-text-centered is-size-4">Biglietti <span class="has-text-info is-size-3">{{ proiezione?.programmazione?.film?.titolo }}</span></p>
    <RouterLink v-if="authStore.isUser" :to="`/proiezioni/${id}/biglietti/add`" class="button is-primary">Prenota</RouterLink>
    <div class="list">
        <template v-if="biglietti && biglietti.length">
            <div class="list-item" v-for="item in biglietti">
                <div class="list-item-content">
                    <div class="list-item-title">{{ item.utente.usr }}</div>
                    <div class="list-item-title">Tipo: {{ item.tipo }}</div>
                    <div class="list-item-description">
                        <p class="is-size-4">Quantita: {{ item.quantita }}</p>
                        <p class="is-size-4">Importo: {{ item.importo }}€</p>
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