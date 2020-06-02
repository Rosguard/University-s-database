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
                {{studentData}}
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
                {{studentsData}}
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
            };
        },
        // created() {
        //     this.$resource("/students/showAll").get({}).then(result => {
        //         result.json().then(data => {
        //             console.log(data);
        //             this.testParam = data;
        //         })
        //     })
        // },
        methods: {
            showStudentById() {
                this.showAllStudents();
                const id = this.testModel;
                this.$resource("/students/studentById/{id}").get({id}).then(result => {
                    result.json().then(data => {
                        // console.log(data);
                        this.studentData = data;
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