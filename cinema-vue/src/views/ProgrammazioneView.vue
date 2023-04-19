<script setup>
import { ref } from 'vue';

    const items = ref(['ciao','saluti','salve']);

    function onAdd(){
        items.value.push('asasasasas');
    }
</script>

<template>
    <h1>Programmazione films</h1>
    <button @click="onAdd">Add</button>
    <p v-for="item in items">{{ item }}</p>
</template>