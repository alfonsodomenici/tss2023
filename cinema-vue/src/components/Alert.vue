<script setup>
import { storeToRefs } from 'pinia';

import { useAlertStore } from '@/stores';

const alertStore = useAlertStore();
const { alert } = storeToRefs(alertStore);
</script>

<template>
    <div v-if="alert" class="notification" :class="alert.type">
        <button @click="alertStore.clear()" class="delete"></button>
        {{ alert.message }}
    </div>
</template>