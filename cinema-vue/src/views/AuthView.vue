<script setup>
import { ref } from 'vue';
import { storeToRefs } from 'pinia'
import { useAuthStore } from '../stores/auth.js'
import { useRouter } from 'vue-router';

let usr;
let pwd;

//contiene l'oggetto form
const form = ref(null);

//router
const router = useRouter();

//authStore
const store = useAuthStore();
const { token, errore, isLogged } = storeToRefs(store);
const { doLogin } = store;

const onLogin = (e) => {
    if (form.value.checkValidity() === false) {
        form.value.reportValidity();
        return;
    }
    doLogin({ usr, pwd })
        .then(_ => {
            if (isLogged.value === true) {
                router.push("/programmazione");
            }
        });
}
</script>

<template>
    <h1>Accedi</h1>
    <p style="color:red;" v-if="errore !== null">{{ errore }}</p>
    <form method="post" ref="form">
        <input v-model="usr" type="text" placeholder="username" required>
        <input v-model="pwd" type="password" placeholder="password" required>
        <button @click.prevent="onLogin">Login</button>
    </form>
</template>
