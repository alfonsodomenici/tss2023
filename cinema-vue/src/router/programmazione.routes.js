import { Layout, List, AddEdit } from '@/views/programmazione';

export default {
    path: '/programmazione',
    component: Layout,
    children: [
        { path: '', component: List },
        { path: 'add', component: AddEdit },
        { path: 'edit/:id', component: AddEdit }
    ]
};
