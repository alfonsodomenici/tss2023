<script setup>
import { useRoute, RouterLink } from 'vue-router';
import { useProgrammazioneStore, useAuthStore, useAlertStore } from '@/stores';
import { storeToRefs } from 'pinia';

const store = useProgrammazioneStore();

const route = useRoute();
const id = route.params.id;
let title = 'Aggiungi programmazione';
let progr = null;
if (id) {
    title = 'Modifica programmazione';
    ({ progr } = storeToRefs(store));
    store.getById(id);
}
</script>

<template>
    <p class="title has-text-centered">{{ title }}</p>
</template>