import Vue from 'vue'
import VueRouter from 'vue-router'
import MainPage from "../pages/MainPage.vue";
import StudentsPage from "../pages/StudentsPage.vue";
import TeachersPage from "../pages/TeachersPage.vue";


Vue.use(VueRouter);

const routes = [
    { path: '/', component: MainPage},
    { path: '/students', component: StudentsPage},
    { path: '/teachers', component: TeachersPage},

    { path: '*', component: MainPage},
];

export default new VueRouter({
    mode: 'history',
    routes: routes
});