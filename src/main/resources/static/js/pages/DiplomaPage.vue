<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение всех дипломных работ
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllDiplomas">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все димломные работы</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showAllDiplomas">Получить</v-btn>
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
                                                <tr v-for="all in diplomasData" :all="all">
                                                    <td>{{all.studentCode}}</td>
                                                    <td>{{all.name}}</td>
                                                    <td>{{all.theme}}</td>
                                                    <td>{{all.theDepartment}}</td>
                                                    <td>{{all.scientificDirectorCode}}</td>
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
                    <v-text-field v-model="studentCode" placeholder="Код студента"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="name" placeholder="Название работы"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="theme" placeholder="Тема работы"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="theDepartment" placeholder="Кафедра"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="scientificDirectorCode"
                                  placeholder="Код научного руководителя"></v-text-field>
                </v-col>


                <v-col>
                    <v-btn color="primary" dark @click="createDiploma">Добавить диплом</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Удаление-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Удаление диплома
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="studentCode1" placeholder="Введите код студента"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="deleteDiplomaById" color="secondary">Удалить диплом</v-btn>
                </v-col>
            </v-row>

        </v-container>
    </v-content>
</template>

<script>
    export default {
        name: "DiplomaPage",
        data() {
            return {
                totalElements: null,
                size: 50,
                page: 0,
                pageCount: null,
                diplomasData: [{
                    studentCode: null,
                    name: "",
                    theme: "",
                    theDepartment: "",
                    scientificDirectorCode: null,
                }],
                studentCode: null,
                studentCode1: null,
                name: null,
                theme: null,
                theDepartment: null,
                scientificDirectorCode: null,
                dialogAll: false,
                headers: [
                    {text: "Код студента", value: "studentCode"},
                    {text: "Номер группы", value: "name"},
                    {text: "Тема", value: "theme"},
                    {text: "Кафедра", value: "theDepartment"},
                    {text: "Код научного руководителя", value: "scientificDirectorCode"},
                ],
            }
        },

        methods: {
            showAllDiplomas() {
                const size = this.size;
                const page = this.page;
                this.$resource("/diplomas/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.diplomasData = data.content;
                    })

                })
            },
            deleteDiplomaById() {
                const id = this.studentCode1;
                this.$resource("/diplomas/deleteDiplomaById").delete({id}).then(result => {
                    alert("Done");
                })

            },
            createDiploma() {
                let diploma = {
                    studentCode: this.studentCode,
                    name: this.name,
                    theme: this.theme,
                    theDepartment: this.theDepartment,
                    scientificDirectorCode: this.scientificDirectorCode,
                };
                this.$resource("/diplomas/createDiploma").save(diploma).then(result => {
                    alert("Done");
                })
            },
        }
    }
</script>

<style scoped>

</style>