<script setup>
import { useAuthStore } from '@/stores';
import { router } from '@/router';
import { RouterLink, RouterView } from 'vue-router'

// redirect home if already logged in
const authStore = useAuthStore();
if (authStore.isLogged) {
    router.push('/');
}
</script>

<template>
    <div class="container">
        <div class="columns is-centered">
            <div class="column is-half is-centered">
                <RouterView />
            </div>
        </div>
    </div>
</template>
