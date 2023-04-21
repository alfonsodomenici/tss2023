import { Layout, Login, Registration } from '@/views/account';

export default {
    path: '/account',
    component: Layout,
    children: [
        { path: '', redirect: 'login' },
        { path: 'login', component: Login },
        { path: 'registration', component: Registration }
    ]
};
