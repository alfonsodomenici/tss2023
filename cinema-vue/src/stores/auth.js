import { defineStore } from 'pinia';
import { postData } from '../rest/rest.js';


export const useAuthStore = defineStore({
    id: 'auth',
    state: () => {
        return {
            token: null,
            loading: false,
            error: null
        }
    },
    getters: {

    },
    actions: {
        async login(usr, pwd) {
            this.loading = true;
            try {
                this.token = await postData('utenti/login', {usr,pwd})
                        .then(response => response.json());
            } catch (error) {
                console.log(error.toString());
                this.error = error;
            }finally{
                this.loading = false;
            }
        },
        logout() {
            this.token = null;
        }
    }
})