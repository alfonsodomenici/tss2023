<script setup>
import { storeToRefs } from 'pinia';

import { useAuthStore } from '@/stores';

const authStore = useAuthStore();
const { isLogged } = storeToRefs(authStore);
</script>

<template>
    <div v-if="isLogged">
        <h1>Hi ...!</h1>
        <p>You're logged in Cinema App with Vue 3 + Pinia & JWT!!</p>
    </div>
</template>
