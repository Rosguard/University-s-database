<template>
    <div  class="pageClass">
<!--        <left-menu></left-menu>-->
        <v-content >
            <p>Приветствуем Вас на домашней странице!</p>

        </v-content>
    </div>
</template>

<script>
    import LeftMenu from "../components/LeftMenu.vue";

    export default {
        name: "MainPage",
        components: {LeftMenu}
    }
</script>

<style scoped>
.pageClass{
    background: rgba(128, 128, 128, 0.89);
    height: 100%;
}
</style>