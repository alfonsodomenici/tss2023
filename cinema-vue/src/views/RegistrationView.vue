<script setup>
import { ref } from 'vue';
import {storeToRefs} from 'pinia'
import { useRegistrationStore } from '../stores/registration.js'


//contiene l'oggetto form
const form = ref(null);
const MAX_DATE = new Date().toISOString().slice(0,10)

//destrutturo lo store
const store = useRegistrationStore();
const {usr,pwd,dataNascita,success,errore} = storeToRefs(store);
const {doRegistration} = store;

const onRegistration = (e) => {
    if(form.value.checkValidity() === false){
        form.value.reportValidity();
        return;
    }
    doRegistration().then(_=> {
        console.log(errore.value);
    });
}
</script>

<template>
    <h1>Registrati</h1>
    <p v-if="success">Grazie per esserti registrato.Effettua il login</p>
    <p style="color:red;" v-if="errore!==null">{{ errore }}</p>
    <form method="post" ref="form" v-if="success===false">
        <input v-model="usr"  type="text" placeholder="username" required>
        <input v-model="pwd"  type="password" placeholder="password" required>
        <input v-model="dataNascita" type="date" placeholder="data di nascita" :max="MAX_DATE" required>
        <button @click.prevent="onRegistration">Registrati</button>
    </form>
</template>