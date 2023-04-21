<script setup>
import { ref } from 'vue';
import { storeToRefs } from 'pinia'
import { useAuthStore } from '@/stores'
import { useRouter } from 'vue-router';
import { RouterLink } from 'vue-router'
import { useAlertStore } from '@/stores';

let usr;
let pwd;

//contiene l'oggetto form
const form = ref(null);

//router
const router = useRouter();

//authStore
const store = useAuthStore();
const { isLogged } = storeToRefs(store);
const alertStore = useAlertStore();

const onLogin = (e) => {
    if (form.value.checkValidity() === false) {
        form.value.reportValidity();
        return;
    }
    store.login({ usr, pwd })
        .then(_ => router.push('/'))
        .catch(error => {
            alertStore.error('login ko');
        })
}
</script>

<template>
    <p class="title has-text-centered">Login</p>
    <form method="post" ref="form">
        <div class="field">
            <label class="label">Username</label>
            <div class="control">
                <input v-model="usr" class="input" type="text" placeholder="username" required>
            </div>
        </div>
        <div class="field">
            <label class="label">Password</label>
            <div class="control">
                <input v-model="pwd" class="input" type="password" placeholder="password" required>
            </div>
        </div>
        <div class="field is-grouped">
            <p class="control">
                <button @click.prevent="onLogin" class="button is-primary">
                    Login
                </button>
            </p>
            <p class="control">
                <RouterLink to="registration" class="button is-link is-light">Registrati</RouterLink>
            </p>
        </div>
    </form>
</template>
