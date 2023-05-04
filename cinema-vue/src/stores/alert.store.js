import { defineStore } from 'pinia';

export const useAlertStore = defineStore({
    id: 'alert',
    state: () => ({
        alert: null,
        isLoading: false
    }),
    actions: {
        success(message) {
            this.alert = { message, type: 'is-success' };
        },
        error(message) {
            this.alert = { message, type: 'is-danger' };
        },
        clear() {
            this.alert = null;
        },
        loading() {
            this.isLoading = true;
        },
        done() {
            this.isLoading = false;
        }
    }
});
