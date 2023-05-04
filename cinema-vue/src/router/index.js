import { createRouter, createWebHistory } from 'vue-router';

import { useAuthStore, useAlertStore } from '@/stores';
import { Home } from '@/views';
import accountsRoutes from './accounts.routes';
import proiezioniRoutes from './proiezioni.routes';
import filmsRoutes from './films.routes.js';

export const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    linkActiveClass: 'active',
    routes: [
        { path: '/', component: Home },
        { ...accountsRoutes },
        { ...proiezioniRoutes},
        { ...filmsRoutes},
        // catch all redirect to home page
        { path: '/:pathMatch(.*)*', redirect: '/' }
    ]
});


router.beforeEach(async (to) => {
    // clear alert on route change
    const alertStore = useAlertStore();
    alertStore.clear();

    // redirect to login page if not logged in and trying to access a restricted page 
    const publicPages = ['/accounts/login', '/accounts/registration'];
    const authRequired = !publicPages.includes(to.path);
    const authStore = useAuthStore();

    if (authRequired && !authStore.isLogged) {
        authStore.returnUrl = to.fullPath;
        return '/accounts/login';
    }
});
