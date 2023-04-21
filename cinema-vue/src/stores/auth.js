import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import { config } from '@/app.config.js';
import { post } from "@/helpers";

const baseUrl = `${config.baseUrl}/utenti/login`;

export const useAuthStore = defineStore('auth', () => {
  const token = ref(null);
  const errore = ref(null);

  const isLogged = computed(() => token.value !== null);

  async function login(credential) {
    const data = await post(`${baseUrl}`, credential);
    token.value = data.jwt;
  }

  function logout() {
    token.value = null;
  }
  return { token, errore, isLogged, login, logout };
})
