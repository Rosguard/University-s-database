<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение всех факультетов
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllFaculties">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все факультеты</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showAllFaculties">Получить</v-btn>
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
                                                <tr v-for="c in facultiesData" :c="c">
                                                    <td>{{c.name}}</td>
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
                    <v-text-field v-model="facultyName" placeholder="Название факультета"></v-text-field>
                </v-col>


                <v-col>
                    <v-btn color="primary" dark @click="createFaculty">Добавить факультет</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Удаление-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Удаление факультета
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="facultyName" placeholder="Название факультета"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="deleteFacultyById" color="secondary">Удалить факультет</v-btn>
                </v-col>
            </v-row>

        </v-container>
    </v-content>
</template>

<script>
    export default {
        name: "FacultyPage",
        data() {
            return {
                totalElements: null,
                size: 50,
                page: 0,
                pageCount: null,
                facultiesData: [{
                    name: "",
                }],
                facultyName: "",
                dialogAll: false,
                // createFaculty: null,
                headers: [
                    {text: "Название факультета", value: "faculty"},
                ],
            }
        },

        methods: {
            showAllFaculties() {
                const size = this.size;
                const page = this.page;
                this.$resource("/faculties/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.facultiesData = data.content;
                    })

                })
            },
            deleteFacultyById() {
                const id = this.facultyName;
                this.$resource("/faculties/deleteFacultyById").delete({id}).then(result => {
                    alert("Done");
                })

            },
            createFaculty() {
                let faculty = {
                    name: this.facultyName,
                };
                this.$resource("/faculties/createFaculty").save(faculty).then(result => {
                    result.json().then(data => {
                        console.log(data);
                    })
                })
            },

        }
    }
</script>

<style scoped>

</style>