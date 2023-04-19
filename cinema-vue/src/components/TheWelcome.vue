<script setup>
import WelcomeItem from './WelcomeItem.vue'
import DocumentationIcon from './icons/IconDocumentation.vue'
import ToolingIcon from './icons/IconTooling.vue'
import EcosystemIcon from './icons/IconEcosystem.vue'
import CommunityIcon from './icons/IconCommunity.vue'
import SupportIcon from './icons/IconSupport.vue'
</script>

<template>
  <WelcomeItem>
    <template #icon>
      <DocumentationIcon />
    </template>
    <template #heading>Scopri i prossimi films in programmazione</template>

    Scopri la programmazione dei prossimi mesi...
  </WelcomeItem>

  <WelcomeItem>
    <template #icon>
      <ToolingIcon />
    </template>
    <template #heading>Verifica disponibilità</template>

    Verifica la disponibilità di biglietti per le proiezioni programmate
  </WelcomeItem>

  <WelcomeItem>
    <template #icon>
      <EcosystemIcon />
    </template>
    <template #heading>Gestisci i tuoi biglietti</template>

    Gestisci la prenotazione dei tuoi biglietti per le proiezioni programmate
  </WelcomeItem>
</template>
