import Vue from 'vue'
import VueRouter from 'vue-router'
import MainPage from "../pages/MainPage.vue";
import StudentsPage from "../pages/StudentsPage.vue";
import TeachersPage from "../pages/TeachersPage.vue";
import GroupPage from "../pages/GroupPage.vue";
import FacultyPage from "../pages/FacultyPage.vue";
import CandidatePage from "../pages/CandidatePage.vue";
import DiplomaPage from "../pages/DiplomaPage.vue";
import DoctoralPage from "../pages/DoctoralPage.vue";
import GroupClassesPage from "../pages/GroupClassesPage.vue";
import StudentRecordPage from "../pages/StudentRecordPage.vue";
import TheDepartmentPage from "../pages/TheDepartmentPage.vue";


Vue.use(VueRouter);

const routes = [
    { path: '/', component: MainPage},
    { path: '/students', component: StudentsPage},
    { path: '/teachers', component: TeachersPage},
    { path: '/groups', component: GroupPage},
    { path: '/faculties', component: FacultyPage},
    { path: '/candidate', component: CandidatePage},
    { path: '/diploma', component: DiplomaPage},
    { path: '/doctoral', component: DoctoralPage},
    { path: '/groupClasses', component: GroupClassesPage},
    { path: '/studentRecord', component: StudentRecordPage},
    { path: '/theDepartment', component: TheDepartmentPage},

    { path: '*', component: MainPage},
];

export default new VueRouter({
    mode: 'history',
    routes: routes
});