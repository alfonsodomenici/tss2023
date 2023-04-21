<script setup>
import { RouterView } from 'vue-router'
import {Alert, Nav} from '@/components'
</script>

<template>
  <section class="app-container ">
    <header>
      <Alert></Alert>
      <Nav></Nav>
    </header>
    <div class="container pt-4 pb-4">
      <RouterView />
    </div>
  </section>
</template>

