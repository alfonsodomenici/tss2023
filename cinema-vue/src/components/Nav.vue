<script setup>
import { ref } from 'vue';
import { RouterLink, RouterView, useRouter } from 'vue-router'
import { useAuthStore } from '@/stores';
import { storeToRefs } from 'pinia';

const authStore = useAuthStore();
const { isLogged, isAdmin } = storeToRefs(authStore);
const router = useRouter();

const burger = ref(null);
const nav = ref(null);

const onBurgerClick = () => {
    burger.value.classList.toggle('is-active');
    nav.value.classList.toggle('is-active');
}

const onLogout = (e) => {
    authStore.logout();
}

</script>

<template>
    <nav v-show="isLogged" class="navbar is-blank has-shadow is-spaced" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <a ref="burger" @click.prevent="onBurgerClick" role="button" class="navbar-burger" aria-label="menu"
                aria-expanded="false" data-target="navMenu">
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
            </a>
        </div>
        <div ref="nav" class="navbar-menu" id="navMenu">
            <div class="navbar-start">
                <RouterLink to="/" class="navbar-item">Home</RouterLink>
                <RouterLink v-if="isAdmin" to="/films" class="navbar-item">Films</RouterLink>
                <RouterLink to="/proiezioni" class="navbar-item">Calendario</RouterLink>
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