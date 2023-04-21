<script setup>
import { storeToRefs } from 'pinia';

import { useAuthStore } from '@/stores';

const authStore = useAuthStore();
const { isLogged, loggedUser } = storeToRefs(authStore);
</script>

<template>
    <div v-if="isLogged">
        <h1 class="title">Benvenuto {{ loggedUser }}!!</h1>
        <p class="is-size-4">You're logged in Cinema App with Vue 3 + Pinia & JWT!!</p>
    </div>
</template>
