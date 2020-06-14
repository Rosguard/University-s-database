<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение всех зачеток
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllStudentRecords">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все зачетки</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showAllStudentRecords">Получить</v-btn>
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
                                                <tr v-for="all in studentRecordsData" :all="all">
                                                    <td>{{all.subject}}</td>
                                                    <td>{{all.studentCode}}</td>
                                                    <td>{{all.typeOfExam}}</td>
                                                    <td>{{all.mark}}</td>
                                                    <td>{{all.dateOfExam}}</td>
                                                    <td>{{all.teacherCode}}</td>
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
                    <v-text-field v-model="subject" placeholder="Предмет"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="studentCode" placeholder="Код студента"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="typeOfExam" placeholder="Тип"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="mark" placeholder="Оценка"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="dateOfExam" placeholder="Дата"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherCode" placeholder="Код преподавателя"></v-text-field>
                </v-col>

                <v-col>
                    <v-btn color="primary" dark @click="createStudentRecord">Добавить</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Удаление-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Удаление
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="subject" placeholder="Предмет"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="studentCode" placeholder="Номер студента"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="deleteStudentRecordById" color="secondary">Удалить</v-btn>
                </v-col>
            </v-row>

        </v-container>
    </v-content>
</template>

<script>
    export default {
        name: "StudentRecordPage",
        data() {
            return {
                totalElements: null,
                size: 50,
                page: 0,
                pageCount: null,
                studentRecordsData: [{
                    subject: "",
                    studentCode: null,
                    typeOfExam: null,
                    mark: "",
                    dateOfExam: null,
                    teacherCode: "",
                }],
                subject: "",
                studentCode: null,
                typeOfExam: null,
                mark: "",
                dateOfExam: null,
                teacherCode: "",
                dialogAll: false,
                headers: [
                    {text: "Предмет", value: "subject"},
                    {text: "Код студента", value: "studentCode"},
                    {text: "Тип", value: "typeOfExam"},
                    {text: "Оценка", value: "mark"},
                    {text: "Дата", value: "dateOfExam"},
                    {text: "Код преподавателя", value: "teacherCode"},
                ],
            }
        },

        methods: {
            showAllStudentRecords() {
                const size = this.size;
                const page = this.page;
                this.$resource("/studentRecords/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.studentRecordsData = data.content;
                    })

                })
            },
            deleteStudentRecordById() {
                const subject = this.subject;
                const studentCode = this.studentCode;
                this.$resource("/studentRecords/deleteStudentRecordById").delete({"studentCode":studentCode, "subject":subject}).then(result => {
                    alert("Done");
                })

            },
            createStudentRecord() {
                let studentRecord = {
                    subject: this.subject,
                    studentCode: this.studentCode,
                    course: this.course,
                    typeOfExam: this.typeOfExam,
                    mark: this.mark,
                    dateOfExam: this.dateOfExam,
                    teacherCode: this.teacherCode,
                };
                this.$resource("/studentRecords/createStudentRecord").save(studentRecord).then(result => {
                    alert("Done");
                })
            },
        }
    }
</script>

<style scoped>

</style>