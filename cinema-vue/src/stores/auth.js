import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
import { config } from '@/app.config.js';
import { post } from "@/helpers";
import { isAuthenticated, loggedUserId, loggedUsername, isUserInRole, readToken, storeToken, removeToken } from '@/helpers';

const baseUrl = `${config.baseUrl}/utenti/login`;

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
    const data = await post(`${baseUrl}`, credential);
    storeToken(data.jwt);
    refresh.value++;
  }

  function logout() {
    removeToken();
    refresh.value++;
  }

  return { isLogged, loggedId, loggedUser, isAdmin, isUser, token, login, logout };

})
