import { Layout, List, ListBiglietti, PrenotaBiglietti } from '@/views/proiezioni';

export default {
    path: '/proiezioni',
    component: Layout,
    children: [
        { path: '', component: List },
        { path: ':id/biglietti', component: ListBiglietti },
        { path: ':id/biglietti/add', component: PrenotaBiglietti }
    ]
};
