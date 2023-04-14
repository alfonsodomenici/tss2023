<script setup >
    import { storeToRefs } from 'pinia'
    import { useAuthStore } from '../stores/auth.js'
    const { token, loading, error } = storeToRefs(useAuthStore())
    const { login } = useAuthStore()

    const onLogin = (e) => {
        e.preventDefault();
        console.log('onlogin...');
    }
</script>

<template>
    <form method="POST">
        <p v-if="loading">loading...</p>
        <p v-if="error">{{ error.message }}</p>
        <input type="text" ref="usr" >
        <input type="password" ref="pwd">
        <button @click="onLogin">Invia</button>
    </form>
</template>



