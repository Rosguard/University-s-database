<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение всех групп
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllGroups">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все группы</v-toolbar-title>
                                        <v-tab></v-tab>
                                        <v-tab>
                                            Всего элементов: {{totalElements}}
                                        </v-tab>
                                        <v-tab>
                                            Элементов на странице
                                        </v-tab>
                                        <v-text-field v-model="size" placeholder="Количество элементов"></v-text-field>
                                        <v-tab> Номер страницы</v-tab>
                                        <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                        <v-tab></v-tab>
                                        <v-btn color="primary" dark v-on="on" @click="showAllGroups">Получить</v-btn>
                                    </v-toolbar>
                                    <template>
                                        <v-simple-table>
                                            <template v-slot:default>
                                                <thead>
                                                <tr>
                                                    <th class="text-left" v-for="header in headers" :header="header">
                                                        {{header.text}}
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr v-for="c in groupsData" :c="c">
                                                    <td>{{c.numberOfGroup}}</td>
                                                    <td>{{c.course}}</td>
                                                    <td>{{c.faculty}}</td>
                                                </tr>
                                                </tbody>
                                            </template>
                                        </v-simple-table>
                                    </template>
                                </v-card>
                            </v-dialog>
                        </v-row>
                    </template>
                </v-col>
            </v-row>
        </v-container>
        <!--        Создание-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Создание
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="groupNumber" placeholder="Номер группы"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="groupCourse" placeholder="Курс"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="groupFaculty" placeholder="Факультет"></v-text-field>
                </v-col>
                

                <v-col>
                    <v-btn color="primary" dark @click="createGroup">Добавить группу</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Удаление-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Удаление группы
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="groupNumber1" placeholder="Введите номер группы"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="deleteGroupById" color="secondary">Удалить группу</v-btn>
                </v-col>
            </v-row>

        </v-container>
    </v-content>
</template>

<script>
    export default {
        name: "GroupPage",
        data() {
            return {
                totalElements: null,
                size: 50,
                page: 0,
                pageCount: null,
                groupsData: [{
                    numberOfGroup: "",
                    course: "",
                    faculty: "",
                }],
                numberOfGroup: null,
                course: null,
                faculty: null,
                dialogAll: false,
                groupNumber: null,
                groupNumber1: null,
                groupCourse: null,
                groupFaculty: null,
                // createGroup: null,
                headers: [
                    {text: "Номер группы", value: "numberOfGroup"},
                    {text: "Курс", value: "course"},
                    {text: "Факультет", value: "faculty"},
                ],
            }
        },

        methods: {
            showAllGroups() {
                const size = this.size;
                const page = this.page;
                this.$resource("/groups/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.groupsData = data.content;
                    })

                })
            },
            deleteGroupById() {
                const id = this.groupNumber1;
                this.$resource("/groups/deleteGroupById").delete({id}).then(result => {
                    alert("Done");
                })

            },
            createGroup() {
                let group = {
                    numberOfGroup: this.groupNumber,
                    course: this.groupCourse,
                    faculty: this.groupFaculty,
                };
                this.$resource("/groups/createGroup").save(group).then(result => {

                        alert("Done");

                })
            },
        }
    }
</script>

<style scoped>

</style>