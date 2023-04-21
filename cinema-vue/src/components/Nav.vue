<script setup>
import { RouterLink, RouterView, useRouter } from 'vue-router'
import { useAuthStore } from '@/stores';
import { storeToRefs } from 'pinia';

const authStore = useAuthStore();
const { isLogged } = storeToRefs(authStore);

const onLogout = (e) => {
    authStore.doLogout();
    router.push("/")
}

</script>

<template>
    <nav v-show="isLogged" class="navbar" role="navigation" aria-label="main navigation">
        <div class="navbar-menu">
            <div class="navbar-start">
                <RouterLink to="/" class="navbar-item">Home</RouterLink>
            </div>
        </div>
    </nav>
</template>