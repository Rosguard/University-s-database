<template>
    <v-content>
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных студента по коду студента
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="testModel" placeholder="Введите код студента"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="showStudentById">Получить студента</v-btn>
                </v-col>
            </v-row>
            <v-row>
                <v-simple-table v-if="studentData">
                    <template v-slot:default>
                        <thead>
                        <tr>
                            <th class="text-left" v-for="header in headers" :header="header">{{header.text}}</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>{{student.studentCode}}</td>
                            <td>{{student.secondName}}</td>
                            <td>{{student.firstName}}</td>
                            <td>{{student.thirdName}}</td>
                            <td>{{student.group}}</td>
                            <td>{{student.sex}}</td>
                            <td>{{student.birthday}}</td>
                            <td>{{student.age}}</td>
                            <td>{{student.numberOfChildren}}</td>
                            <td>{{student.grants}}</td>
                        </tr>
                        </tbody>
                    </template>
                </v-simple-table>
            </v-row>
        </v-container>
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных всех студентов
                </p>
                <v-col>
                    <v-btn @click="showAllStudents">Получить студентов</v-btn>
                </v-col>
            </v-row>
            <v-row>
                <v-simple-table v-if="studentsData">
                    <template v-slot:default>
                        <thead>
                        <tr>
                            <th class="text-left" v-for="header in headers" :header="header">{{header.text}}</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="s in studentsData" :s="s">
                            <td>{{s.studentCode}}</td>
                            <td>{{s.secondName}}</td>
                            <td>{{s.firstName}}</td>
                            <td>{{s.thirdName}}</td>
                            <td>{{s.group}}</td>
                            <td>{{s.sex}}</td>
                            <td>{{s.birthday}}</td>
                            <td>{{s.age}}</td>
                            <td>{{s.numberOfChildren}}</td>
                            <td>{{s.grants}}</td>
                        </tr>
                        </tbody>
                    </template>
                </v-simple-table>
            </v-row>
        </v-container>

    </v-content>
</template>

<script>
    export default {
        data() {
            return {
                studentData: null,
                testModel: null,
                studentsData: null,
                student:
                    {
                        studentCode: 0,
                        secondName: "",
                        firstName: "",
                        thirdName: "",
                        group: 0,
                        sex: "",
                        birthday: null,
                        age: 0,
                        numberOfChildren: 0,
                        grants: 0,
                    },
                headers: [
                    {text: "Код студента"},
                    {text: "Фамилия"},
                    {text: "Имя"},
                    {text: "Отчество"},
                    {text: "Группа"},
                    {text: "Пол"},
                    {text: "Дата рождения"},
                    {text: "Возраст"},
                    {text: "Кол-во детей"},
                    {text: "Степендия"},
                ],
            };
        },
        // created() {
        //     this.$resource("/students/showAll").get({}).then(result => {
        //         result.json().then(data => {
        //             console.log(data);
        //             this.studentsData = data;
        //         })
        //     })
        // },
        methods: {
            showStudentById() {
                // this.showAllStudents();
                const id = this.testModel;
                this.$resource("/students/studentById/{id}").get({id}).then(result => {
                    result.json().then(data => {
                        // console.log(data);
                        this.studentData = data;
                        this.student.studentCode = data.studentCode;
                        this.student.secondName = data.secondName;
                        this.student.firstName = data.firstName;
                        this.student.thirdName = data.thirdName;
                        this.student.group = data.group;
                        this.student.sex = data.sex;
                        this.student.birthday = data.birthday;
                        this.student.age = data.age;
                        this.student.numberOfChildren = data.numberOfChildren;
                        this.student.grants = data.grants;

                    })

                })

            },
            showAllStudents() {
                this.$resource("/students/showAll").get({}).then(result => {
                    result.json().then(data => {
                        // console.log(data);
                        this.studentsData = data;


                    })
                })
            },
        }
    }
</script>

<style scoped>
    .operationName {
        text-align: center;

    }

</style>