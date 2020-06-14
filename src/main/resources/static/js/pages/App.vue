<template>
    <v-app>
        <left-menu></left-menu>
        <v-content>
            <router-view></router-view>
        </v-content>
    </v-app>

</template>

<script>
    import LeftMenu from "../components/LeftMenu.vue";
    export default {
        components: {LeftMenu}
    }
</script>

<style scoped>

</style>