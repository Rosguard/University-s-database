import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import Vuetify from 'vuetify'
import router from 'router/router'
import 'vuetify/dist/vuetify.min.css'
import Vuelidate from 'vuelidate'

Vue.use(Vuelidate)
Vue.use(VueResource);
Vue.use(Vuetify, {iconfont: 'mdiSvg'});

new Vue({
    el: '#app',
    vuetify: new Vuetify(),
    router: router,
    render: a => a(App),
});
