<script setup>
import { RouterLink, RouterView, useRouter } from 'vue-router'
import { storeToRefs } from 'pinia';
import { useAuthStore } from './stores/auth.js';

const authStore = useAuthStore();
const { isLogged } = storeToRefs(authStore);

const router = useRouter();

const onLogout = (e) => {
  authStore.doLogout();
  router.push("/")
}
</script>

<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <span v-if="isLogged === false">
          <RouterLink to="/auth">Accedi</RouterLink>
          <RouterLink to="/registration">Registrati</RouterLink>
        </span>
        <span v-if="isLogged">
          <RouterLink to="/programmazione">Programmazione</RouterLink>
          <a href="#" @click="onLogout" >Logout</a>
        </span>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
