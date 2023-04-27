import { Layout, List } from '@/views/programmazione';

export default {
    path: '/programmazione',
    component: Layout,
    children: [
        { path: '', component: List }
    ]
};
