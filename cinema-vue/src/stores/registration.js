import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

const url = 'http://localhost:8080/cinema-wf-1.0/api/utenti';

export const useRegistrationStore = defineStore('registration', () => {
    const usr = ref(null);
    const pwd = ref(null);
    const dataNascita = ref(null);
    const success = ref(false);
    const errore = ref(null);

    async function doRegistration() {
        const data = {
            usr: usr.value,
            pwd: pwd.value,
            data_nascita: dataNascita.value,
            ruolo: 'USER'
        }
        try {
            const resp = await fetch(url, {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(data)
            })
            if (resp.ok) {
                success.value = true;
                errore.value = null;
            } else {
                success.value = false;
                errore.value = resp.statusText;
            }
        } catch (e) {
            pwd.value = null;
            success.value = false;
            errore.value = "errore nella registrazione";
        }
    }

    return { usr, pwd, dataNascita, success, errore, doRegistration }
})
