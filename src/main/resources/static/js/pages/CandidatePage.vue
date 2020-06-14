<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение всех кандидатских работ
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllCandidates">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все кандидатские</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showAllCandidates">Получить</v-btn>
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
                                                <tr v-for="c in candidatesData" :c="c">
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
                    <v-text-field v-model="candidateName" placeholder="Название"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="candidateDate" placeholder="Дата"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="candidateTheme" placeholder="Тема"></v-text-field>
                </v-col>


                <v-col>
                    <v-btn color="primary" dark @click="createCandidate">Добавить кандидатскую</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Удаление-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Удаление кандидатской работы
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="candidateName1" placeholder="Название кандидатской"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="deleteCandidateById" color="secondary">Удалить кандидатскую</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Факультет-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение кандидатских работ на факультете
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="candidateFaculty" placeholder="Введите факультет"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogFaculty" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showCandidatesByFaculty">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogFaculty = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Кандидатские с факультета {{studentFaculty}}</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showCandidatesByFaculty">Получить
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
                                                <tr v-for="f in candidatesData" :f="f">
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
                    Получение кандидатских работ на кафедре
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="candidateTheDepartment" placeholder="Введите кафедру"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogTheDepartment" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showCandidatesByTheDepartment">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogTheDepartment = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Кандидатские с кафедры {{studentFaculty}}</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showCandidatesByTheDepartment">Получить
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
                                                <tr v-for="td in candidatesData" :td="td">
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
        name: "CandidatePage",
        data() {
            return {
                totalElements: null,
                size: 50,
                page: 0,
                pageCount: null,
                candidatesData: [{
                    name: "",
                    date: "",
                    theme: "",
                }],
                dialogAll: false,
                candidateName: "",
                candidateName1: "",
                candidateDate: null,
                candidateTheme: "",
                candidateFaculty: "",
                candidateTheDepartment: "",
                dialogFaculty: false,
                dialogTheDepartment: false,
                // createCandidate: null,
                headers: [
                    {text: "Название", value: "candidateName"},
                    {text: "Дата", value: "candidateDate"},
                    {text: "Тема", value: "candidateTheme"},
                ],
            }
        },

        methods: {
            showAllCandidates() {
                const size = this.size;
                const page = this.page;
                this.$resource("/candidates/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.candidatesData = data.content;
                    })

                })
            },
            deleteCandidateById() {
                const id = this.candidateName1;
                this.$resource("/candidates/deleteCandidateById").delete({id}).then(result => {
                    alert("Done");
                })

            },
            createCandidate() {
                let candidate = {
                    name: this.candidateName,
                    date: this.candidateDate,
                    theme: this.candidateTheme,
                };
                this.$resource("/candidates/createCandidate").save(candidate).then(result => {
                   alert("Done");
                })
            },
            showCandidatesByFaculty() {
                const size = this.size;
                const page = this.page;
                const faculty = this.candidateFaculty;
                alert(faculty);
                this.$resource("/candidates/candidateByFaculty").get({
                    "faculty": faculty,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.candidatesData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showCandidatesByTheDepartment() {
                const size = this.size;
                const page = this.page;
                const theDepartment = this.candidateTheDepartment;
                this.$resource("/candidates/candidateByTheDepartment").get({
                    "theDepartment": theDepartment,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.candidatesData = data.content;
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