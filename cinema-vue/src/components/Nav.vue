<script setup>
import { RouterLink, RouterView, useRouter } from 'vue-router'
import { useAuthStore } from '@/stores';
import { storeToRefs } from 'pinia';

const authStore = useAuthStore();
const { isLogged } = storeToRefs(authStore);
const router = useRouter();

const onLogout = (e) => {
    authStore.logout();
    router.push("/account/login")
}

</script>

<template>
    <nav v-show="isLogged" class="navbar is-blank has-shadow is-spaced" role="navigation" aria-label="main navigation">
        <div class="navbar-menu">
            <div class="navbar-start">
                <RouterLink to="/" class="navbar-item">Home</RouterLink>
            </div>
            <div class="navbar-end">
                <div class="navbar-item">
                    <div class="buttons">
                        <a class="button is-light" @click.prevent="onLogout">
                            Log out
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</template>