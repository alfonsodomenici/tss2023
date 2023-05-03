import { Layout, List, AddEdit, ListProgrammazione, AddProgrammazione } from '@/views/films';

export default {
    path: '/films',
    component: Layout,
    children: [
        { path: '', component: List },
        { path: 'add', component: AddEdit },
        { path: 'edit/:id', component: AddEdit },
        { path: ':id/programmazione', component: ListProgrammazione },
        { path: ':id/programmazione/add/', component: AddProgrammazione }
    ]
};
