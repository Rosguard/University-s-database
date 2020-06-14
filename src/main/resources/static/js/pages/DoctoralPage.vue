<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение всех докторских работ
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllDoctorals">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все докторские</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showAllDoctorals">Получить</v-btn>
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
                                                <tr v-for="c in doctoralsData" :c="c">
                                                    <td>{{c.name}}</td>
                                                    <td>{{c.date}}</td>
                                                    <td>{{c.theme}}</td>
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
                    <v-text-field v-model="doctoralName" placeholder="Название"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="doctoralDate" placeholder="Дата"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="doctoralTheme" placeholder="Тема"></v-text-field>
                </v-col>


                <v-col>
                    <v-btn color="primary" dark @click="createDoctoral">Добавить докторскую</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Удаление-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Удаление докторской работы
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="doctoralName" placeholder="Название кандидатской"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="deleteDoctoralById" color="secondary">Удалить докторскую</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Факультет-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение докторских работ на факультете
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="doctoralFaculty" placeholder="Введите факультет"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogFaculty" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showDoctoralsByFaculty">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogFaculty = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Докторские с факультета {{studentFaculty}}</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showDoctoralsByFaculty">Получить
                                        </v-btn>
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
                                                <tr v-for="f in doctoralsData" :f="f">
                                                    <td>{{f.name}}</td>
                                                    <td>{{f.date}}</td>
                                                    <td>{{f.theme}}</td>
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
        <!--        Кафедра-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение Докторских работ на кафедре
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="doctoralTheDepartment" placeholder="Введите кафедру"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogTheDepartment" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showDoctoralsByTheDepartment">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogTheDepartment = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Докторские с кафедры {{studentFaculty}}</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showDoctoralsByTheDepartment">Получить
                                        </v-btn>
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
                                                <tr v-for="td in doctoralsData" :td="td">
                                                    <td>{{td.name}}</td>
                                                    <td>{{td.date}}</td>
                                                    <td>{{td.theme}}</td>
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
    </v-content>
</template>

<script>
    export default {
        name: "DoctoralPage",
        data() {
            return {
                totalElements: null,
                size: 50,
                page: 0,
                pageCount: null,
                doctoralsData: [{
                    name: "",
                    date: "",
                    theme: "",
                }],
                dialogAll: false,
                doctoralName: "",
                doctoralDate: null,
                doctoralTheme: "",
                doctoralFaculty: "",
                doctoralTheDepartment: "",
                dialogFaculty: false,
                dialogTheDepartment: false,
                // createDoctoral: null,
                headers: [
                    {text: "Название", value: "doctoralName"},
                    {text: "Дата", value: "doctoralDate"},
                    {text: "Тема", value: "doctoralTheme"},
                ],
            }
        },

        methods: {
            showAllDoctorals() {
                const size = this.size;
                const page = this.page;
                this.$resource("/doctorals/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.doctoralsData = data.content;
                    })

                })
            },
            deleteDoctoralById() {
                const id = this.doctoralName;
                this.$resource("/doctorals/deleteDoctoralById").delete({id}).then(result => {
                    alert("Done");
                })

            },
            createDoctoral() {
                let doctoral = {
                    name: this.doctoralName,
                    date: this.doctoralDate,
                    theme: this.doctoralTheme,
                };
                this.$resource("/doctorals/createDoctoral").save(doctoral).then(result => {
                    alert("Done");
                })
            },
            showDoctoralsByFaculty() {
                const size = this.size;
                const page = this.page;
                const faculty = this.doctoralFaculty;
                this.$resource("/doctorals/doctoralByFaculty").get({
                    "faculty": faculty,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.doctoralsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showDoctoralsByTheDepartment() {
                const size = this.size;
                const page = this.page;
                const theDepartment = this.doctoralTheDepartment;
                this.$resource("/doctorals/doctoralByTheDepartment").get({
                    "theDepartment": theDepartment,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.doctoralsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
        }
    }
</script>

<style scoped>

</style>