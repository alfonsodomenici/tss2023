<script setup>
import { ref } from 'vue';
import { storeToRefs } from 'pinia'
import { useUsersStore } from '@/stores'
import { useAlertStore } from '@/stores';

//contiene l'oggetto form
const form = ref(null);
const MAX_DATE = new Date().toISOString().slice(0, 10)

//destrutturo lo store
const store = useUsersStore();
const alertStore = useAlertStore();

let usr, pwd, dataNascita;

const onRegistration = (e) => {
    if (form.value.checkValidity() === false) {
        form.value.reportValidity();
        return;
    }
    store.registration({ usr, pwd, data_nascita: dataNascita, ruolo: 'USER' })
        .then(json => {
            alertStore.success('Grazie per esserti registrato.');
        })
        .catch(error => {
            alertStore.error('Si è verificato un errore durante la registrazione.');
        })
}
</script>

<template>
    <p class="title has-text-centered">Registrazione</p>
    <form method="post" ref="form">
        <div class="field ">
            <label class="label">Username</label>
            <div class="control is-expanded">
                <input v-model="usr" class="input" type="text" placeholder="username" required>
            </div>
        </div>
        <div class="field">
            <label class="label">Password</label>
            <div class="control is-expanded">
                <input v-model="pwd" class="input" type="password" placeholder="password" required>
            </div>
        </div>
        <div class="field">
            <label class="label">Data di nascita</label>
            <div class="control">
                <input v-model="dataNascita" class="input" type="date" placeholder="data di nascita" :max="MAX_DATE"
                    required>
            </div>
        </div>
        <div class="field is-grouped">
            <p class="control">
                <button @click.prevent="onRegistration" class="button is-primary" :class="{ 'is-loading': alertStore.isLoading }">
                    Salva
                </button>
            </p>
            <p class="control">
                <RouterLink to="login" class="button is-link is-light">Login</RouterLink>
            </p>
        </div>
    </form>
</template>