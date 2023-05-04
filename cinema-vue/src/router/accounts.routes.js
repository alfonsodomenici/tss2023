import { Layout, Login, Registration } from '@/views/accounts';

export default {
    path: '/accounts',
    component: Layout,
    children: [
        { path: '', redirect: 'login' },
        { path: 'login', component: Login },
        { path: 'registration', component: Registration }
    ]
};
