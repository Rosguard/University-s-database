<template>
    <div>
        <template>
            <v-card>
                <v-navigation-drawer
                        app
                        permanent
                        expand-on-hover
                        color="light-blue"
                >

                    <v-list
                            nav
                            dense
                    >
                        <v-list-item link v-for="link in links" :to="link.route">
                            <v-list-item-icon>
                                <v-icon>{{link.icon}}</v-icon>
                            </v-list-item-icon>
                            <v-list-item-title>{{link.text}}</v-list-item-title>
                        </v-list-item>
                    </v-list>
                </v-navigation-drawer>
            </v-card>
        </template>
    </div>
</template>

<script>
    export default {
        name: "LeftMenu",
        data() {
            return {
                dialog: false,
                links: [
                    {icon: "mdi-home", text: "Домой", route: "/"},
                    {icon: "mdi-office-building", text: "Кафедры", route: "/"},
                    {icon: "mdi-office-building", text: "Факультеты", route: "/"},
                    {icon: "mdi-account-multiple", text: "Студенты", route: "/students"},
                    {icon: "mdi-book-open", text: "Зачетка студента", route: "/"},
                    {icon: "mdi-notebook", text: "Дипломные работы", route: "/"},
                    {icon: "mdi-teach", text: "Преподаватели", route: "/teachers"},
                    {icon: "mdi-book", text: "Докторские работы", route: "/"},
                    {icon: "mdi-book", text: "Кандидатские работы", route: "/"},
                    {icon: "mdi-account-group", text: "Группы", route: "/"},
                    {icon: "mdi-account-group", text: "Групповые занятия", route: "/"},
                ]
            }
        }
    }
</script>

<style scoped>

</style>