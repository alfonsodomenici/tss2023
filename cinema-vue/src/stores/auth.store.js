import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import { config } from '@/app.config.js';
import { request } from "@/helpers";
import { isAuthenticated, loggedUserId, loggedUsername, isUserInRole, readToken, storeToken, removeToken } from '@/helpers';
import { router } from '@/router';

const url = `${config.baseUrl}/utenti/login`;


export const useAuthStore = defineStore('auth', () => {

  const refresh = ref(0);
  const isLogged = computed(() => {
    refresh.value;
    return isAuthenticated();
  });
  const loggedId = computed(() => {
    refresh.value;
    return loggedUserId();
  });
  const loggedUser = computed(() => {
    refresh.value;
    return loggedUsername();
  });
  const isAdmin = computed(() => {
    refresh.value;
    return isUserInRole('ADMIN');
  });
  const isUser = computed(() => {
    refresh.value;
    return isUserInRole('USER');
  });
  const token = computed(() => {
    refresh.value;
    return readToken()
  });

  async function login(credential) {
    const data = await request('POST', url, credential);
    storeToken(data.jwt);
    refresh.value++;
  }

  function logout() {
    removeToken();
    refresh.value++;
    router.push("/accounts/login")
  }

  return { isLogged, loggedId, loggedUser, isAdmin, isUser, token, login, logout };

})
