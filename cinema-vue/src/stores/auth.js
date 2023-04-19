import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

const url = 'http://localhost:8080/cinema-wf-1.0/api/utenti/login';

export const useAuthStore = defineStore('auth', () => {
    const token = ref(null);
    const errore = ref(null);

    const isLogged = computed(() => token.value !== null);

    async function doLogin(data) {
        try {
            const resp = await fetch(url, {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(data)
            });
            if (resp.ok) {
                const data = await resp.json();
                this.token = data.jwt;
                errore.value = null;
            } else {
                errore.value = resp.statusText;
            }
        } catch (e) {
            errore.value = "errore nella login"
        }
    }

    function doLogout() {
        token.value = null;
        errore.value = null;
    }
    return { token, errore, isLogged, doLogin, doLogout };
})
