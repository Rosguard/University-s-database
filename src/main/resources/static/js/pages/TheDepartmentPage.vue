<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение всех кафедр
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllTheDepartments">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все кафедры</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showAllTheDepartments">Получить
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
                                                <tr v-for="c in theDepartmentsData" :c="c">
                                                    <td>{{c.name}}</td>
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
            <form>
                <v-row>
                    <v-col>
                        <v-text-field v-model="theDepartmentName" placeholder="Название"
                                      :error-messages="nameErrors"
                                      @input="$v.theDepartmentName.$touch()"
                                      @blur="$v.theDepartmentName.$touch()"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-overflow-btn
                                v-model="theDepartmentFaculty"
                                :items="facultiesData.map(f=>f.name)"
                                label="Факультет"
                                item-value="name"
                                :error-messages="theDepartmentFacultyErrors"
                                @input="$v.theDepartmentFaculty.$touch()"
                                @blur="$v.theDepartmentFaculty.$touch()"
                        ></v-overflow-btn>
                    </v-col>
                    <v-col>
                        <v-dialog
                                v-model="dialogNewFaculty"
                                width="500"
                        >
                            <template v-slot:activator="{ on, attrs }">
                                <v-btn icon v-bind="attrs"
                                       v-on="on">
                                    <v-icon>{{mdiPlus}}</v-icon>
                                </v-btn>
                            </template>
                            <v-card>
                                <v-card-title
                                        class="headline grey lighten-2"
                                        primary-title
                                >
                                    Новый факультет
                                </v-card-title>
                                <v-card-text>
                                    <v-text-field label="Факультет" required v-model="facultyName">Название факультета
                                    </v-text-field>
                                </v-card-text>
                                <v-divider></v-divider>
                                <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn
                                            color="red"
                                            text
                                            @click="dialogNewFaculty = false"
                                    >
                                        Отмена
                                    </v-btn>
                                    <v-btn
                                            color="green"
                                            text
                                            @click="dialogNewFaculty = false; createFaculty();"
                                    >
                                        Добавить
                                    </v-btn>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                    </v-col>

                    <v-col>
                        <v-btn color="primary" @click="createTheDepartment" :disabled="$v.$invalid">Добавить
                            кафедру
                        </v-btn>
                    </v-col>
                </v-row>
            </form>
        </v-container>
        <!--        Удаление-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Удаление кафедры
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="theDepartmentName1" placeholder="Название кафедры"
                                  required></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="deleteTheDepartmentById" color="secondary" :disabled="theDepartmentName1.length===0">
                        Удалить кафедру
                    </v-btn>
                </v-col>
            </v-row>

        </v-container>
    </v-content>
</template>

<script>
    import {mdiPlus} from '@mdi/js'
    import {validationMixin} from 'vuelidate'
    import {required, minLength} from 'vuelidate/lib/validators'

    export default {
        mixins: [validationMixin],

        validations: {
            theDepartmentName: {required, minLength: minLength(1)},
            theDepartmentFaculty: {required},
        },


        name: "TheDepartmentPage",

        data() {
            return {
                mdiPlus,
                totalElements: null,
                size: 50,
                page: 0,
                pageCount: null,
                theDepartmentsData: [{
                    name: "",
                    faculty: "",
                }],
                facultiesData: [{
                    name: "",
                }],
                dialogAll: false,
                theDepartmentName: "",
                theDepartmentName1: "",
                facultyName: "",
                theDepartmentFaculty: "",
                dialogFaculty: false,
                dialogNewFaculty: false,
                dialogTheDepartment: false,
                headers: [
                    {text: "Кафедра", value: "theDepartmentName"},
                    {text: "Факультет", value: "theDepartmentFaculty"},
                ],

            }
        },
        computed: {
            nameErrors() {
                const errors = []
                if (!this.$v.theDepartmentName.$dirty) return errors
                !this.$v.theDepartmentName.minLength && errors.push('Минимальная длина должна быть 1 символ')
                !this.$v.theDepartmentName.required && errors.push('Поле не может быть пустым')
                return errors
            },
            theDepartmentFacultyErrors() {
                const errors = []
                if (!this.$v.theDepartmentFaculty.$dirty) return errors
                !this.$v.theDepartmentFaculty.required && errors.push('Поле не может быть пустым')
                return errors
            },
        },
        mounted() {
            this.showAllFaculties()
        },
        methods: {
            clearData() {
                this.totalElements = null;
                this.size = 50;
                this.page = 0;
                this.pageCount = null;
                this.theDepartmentName = "";
                this.theDepartmentName1 = "";
                this.facultyName = "";
                this.theDepartmentFaculty = "";
            },
            showAllTheDepartments() {
                const size = this.size;
                const page = this.page;
                this.$resource("/thedepartments/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.theDepartmentsData = data.content;
                    })

                })
            },
            deleteTheDepartmentById() {
                const name = this.theDepartmentName1;
                this.$resource("/thedepartments/deleteTheDepartmentById").delete({"name": name}).then(result => {
                    alert("Done");
                    this.clearData();
                })

            },
            createTheDepartment() {
                let theDepartment = {
                    name: this.theDepartmentName,
                    faculty: this.theDepartmentFaculty,
                };
                this.$resource("/thedepartments/createTheDepartment").save(theDepartment).then(result => {
                    alert("Done");
                    this.clearData();
                })
            },
            showAllFaculties() {
                const size = 100;
                const page = 0;
                this.$resource("/faculties/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        // this.pageCount = data.totalPages;
                        // this.totalElements = data.totalElements;
                        this.facultiesData = data.content;
                        // alert('koko')
                    })
                })
            },
            createFaculty() {
                let faculty = {
                    name: this.facultyName,
                };
                this.$resource("/faculties/createFaculty").save(faculty).then(result => {

                    // alert('lhl')
                    this.showAllFaculties();
                    // console.log(data);
                })

            },

        }
    }
</script>

<style scoped>

</style>