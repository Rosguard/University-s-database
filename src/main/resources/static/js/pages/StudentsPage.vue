<template>
    <v-content>
        <!--        Айдишник-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных студента по коду студента
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="studentId" placeholder="Введите код студента" required
                                  :rules="IdRules"></v-text-field>
                </v-col>
                <v-col>
                    <!--                    <v-btn @click="showStudentById">Получить студента</v-btn>-->
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogId" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showStudentById"
                                           :disabled="!studentId">Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogId = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Студент по указанному коду</v-toolbar-title>
                                        <v-spacer></v-spacer>
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
                                    </template>
                                </v-card>
                            </v-dialog>
                        </v-row>
                    </template>
                </v-col>
            </v-row>

        </v-container>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных всех студентов
                </p>
                <v-col>
                    <!--                    <v-btn @click="showAllStudents">Получить студентов</v-btn>-->
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllStudents">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все студенты</v-toolbar-title>
                                        <v-spacer></v-spacer>
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
                                                <tr v-for="c in studentsData" :c="c">
                                                    <td>{{c.studentCode}}</td>
                                                    <td>{{c.secondName}}</td>
                                                    <td>{{c.firstName}}</td>
                                                    <td>{{c.thirdName}}</td>
                                                    <td>{{c.group}}</td>
                                                    <td>{{c.sex}}</td>
                                                    <td>{{c.birthday}}</td>
                                                    <td>{{c.age}}</td>
                                                    <td>{{c.numberOfChildren}}</td>
                                                    <td>{{c.grants}}</td>
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
<!--        <v-container>-->
<!--            <v-row>-->
<!--                <p class="operationName">-->
<!--                    Получение данных всех студентов-->
<!--                </p>-->
<!--                <v-col>-->
<!--                    &lt;!&ndash;                    <v-btn @click="showAllStudents">Получить студентов</v-btn>&ndash;&gt;-->
<!--                    <template>-->
<!--                        <v-row justify="center">-->
<!--                            <v-dialog v-model="dialog" fullscreen hide-overlay transition="dialog-bottom-transition">-->
<!--                                <template v-slot:activator="{ on }">-->
<!--                                    <v-btn color="primary" dark v-on="on" @click="showAllStudents">-->
<!--                                        Получить-->
<!--                                    </v-btn>-->
<!--                                </template>-->
<!--                                <v-card>-->
<!--                                    <v-toolbar dark color="primary">-->
<!--                                        <v-btn icon dark @click="dialog = false">-->
<!--                                            <v-icon>mdi-close</v-icon>-->
<!--                                        </v-btn>-->
<!--                                        <v-toolbar-title>Все студенты</v-toolbar-title>-->
<!--                                        <v-spacer></v-spacer>-->
<!--                                    </v-toolbar>-->
<!--                                    <template v-for="c in studentsData">-->
<!--                                        <v-data-table :headers="headers" multi-sort-->
<!--                                                      class="elevation-1" :items="c">-->
<!--                                            &lt;!&ndash;                                            <template v-slot:default>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                <tr v-for="c in studentsData" :c="c">&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.studentCode}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.secondName}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.firstName}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.thirdName}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.group}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.sex}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.birthday}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.age}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.numberOfChildren}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                    <td>{{c.grants}}</td>&ndash;&gt;-->
<!--                                            &lt;!&ndash;                                                </tr>&ndash;&gt;-->

<!--                                            &lt;!&ndash;                                            </template>&ndash;&gt;-->
<!--                                        </v-data-table>-->
<!--                                    </template>-->
<!--                                </v-card>-->
<!--                            </v-dialog>-->
<!--                        </v-row>-->
<!--                    </template>-->
<!--                </v-col>-->
<!--            </v-row>-->
<!--        </v-container>-->

            <!--        Группа-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по группе
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentGroup" placeholder="Введите номер группы"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByGroup">Получить студентов</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        Курс-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по курсу
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentCourse" placeholder="Введите номер курса"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByCourse">Получить студентов</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        Возраст-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по возрасту
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentAge" placeholder="Введите возраст"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByAge">Получить студентов</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        Дети-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по кол-ву детей
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentChildren" placeholder="Введите кол-во детей"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByChildren">Получить студентов</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        Факультет-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по факультету
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentFaculty" placeholder="Введите факультет"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByFaculty">Получить студентов</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        Деньги-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по степухе
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentGrants" placeholder="Введите денюжку"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByGrants">Получить студентов</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        ДР-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по дате рождения
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentBirthday" placeholder="Введите дату"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByBirthday">Получить студентов</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        Пол-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по полу
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentSex" placeholder="Введите пол"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsBySex">Получить студентов</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        ФИО-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студента по ФИО
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentSecondName" placeholder="Введите фамилию"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentFirstName" placeholder="Введите имя"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentThirdName" placeholder="Введите отчество"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByName">Получить студента</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        Группа, предмет, оценка-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студента по номеру группы, предмету, оценке
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentGroup" placeholder="Введите группу"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="subject" placeholder="Введите предмет"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="mark" placeholder="Введите оценку"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByGroupAndSubjectAndMark">Получить студентов</v-btn>
                    </v-col>
                </v-row>
            </v-container>
            <!--        Группа, код препода, предмет, оценка, семестр-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студента по номеру группы, коду преподавателя, предмету, оценке, семестру
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentGroup" placeholder="Введите группу"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="teacherId" placeholder="Введите код учителя"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="subject" placeholder="Введите предмет"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="mark" placeholder="Введите оценку"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="semester" placeholder="Введите семестр"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="showStudentsByGroupAndTeacherAndMarkAndSubjectAndSemester">Получить студентов
                        </v-btn>
                    </v-col>
                </v-row>
            </v-container>
            <!--        Попытка создания-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Создание
                    </p>
                </v-row>
                <v-row>
                    <!--                <v-col>-->
                    <!--                    <v-text-field v-model="studentId" placeholder="Введите Id"></v-text-field>-->
                    <!--                </v-col>-->
                    <v-col>
                        <v-text-field v-model="studentSecondName" placeholder="Введите фамилию"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentFirstName" placeholder="Введите имя"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentThirdName" placeholder="Введите отчество"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentGroup" placeholder="Введите группу"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentSex" placeholder="Введите пол"></v-text-field>
                    </v-col>
                    <v-col>
                        <!--                    <v-text-field v-model="studentBirthday" placeholder="Введите дату рождения"></v-text-field>-->
                        <v-menu
                                ref="menu1"
                                v-model="menu1"
                                :close-on-content-click="false"
                                transition="scale-transition"
                                offset-y
                                max-width="290px"
                                min-width="290px"
                        >
                            <template v-slot:activator="{ on }">
                                <v-text-field
                                        v-model="dateFormatted"
                                        label="Date"
                                        hint="MM/DD/YYYY format"
                                        persistent-hint
                                        @blur="date = parseDate(dateFormatted)"
                                        v-on="on"
                                ></v-text-field>
                            </template>
                            <v-date-picker v-model="date" no-title @input="menu1 = false"></v-date-picker>
                        </v-menu>
                        <!--                    <p>Date in ISO format: <strong>{{ date }}</strong></p>-->
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentAge" placeholder="Введите возраст"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentChildren" placeholder="Введите кол-во детей"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentGrants" placeholder="Введите деньги"></v-text-field>
                    </v-col>

                    <v-col>
                        <v-btn @click="createStudent">Добавить студента</v-btn>
                    </v-col>
                </v-row>

            </v-container>

            <!--Отрисовка таблицы-->
            <v-container>

                <v-simple-table>
                    <template v-slot:default>
                        <thead>
                        <tr>
                            <th class="text-left" v-for="header in headers" :header="header">{{header.text}}</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="c in studentsData" :c="c">
                            <td>{{c.studentCode}}</td>
                            <td>{{c.secondName}}</td>
                            <td>{{c.firstName}}</td>
                            <td>{{c.thirdName}}</td>
                            <td>{{c.group}}</td>
                            <td>{{c.sex}}</td>
                            <td>{{c.birthday}}</td>
                            <td>{{c.age}}</td>
                            <td>{{c.numberOfChildren}}</td>
                            <td>{{c.grants}}</td>
                        </tr>
                        </tbody>
                    </template>
                </v-simple-table>

            </v-container>
    </v-content>
</template>

<script>
    export default {
        data() {
            return {
                elemCounter: 0,
                IdRules: [
                    v => !!v || 'Student code code is required',
                ],
                studentData: null,
                studentsData: null,
                studentId: null,
                studentGroup: null,
                studentCourse: null,
                studentSex: null,
                studentBirthday: null,
                studentAge: null,
                studentChildren: null,
                studentGrants: null,
                studentFaculty: null,
                studentSecondName: "",
                studentFirstName: "",
                studentThirdName: "",
                teacherSecondName: "",
                teacherFirstName: "",
                teacherThirdName: "",
                teacherId: null,
                subject: null,
                mark: null,
                semester: null,
                dialogAll: false,
                dialogId: false,

                page: 1,
                size: 5,
                picker: new Date().toISOString().substr(0, 10), //Для календаря
                date: new Date().toISOString().substr(0, 10),
                dateFormatted: this.formatDate(new Date().toISOString().substr(0, 10)),
                menu1: false,
                student:
                    {
                        studentCode: 0,
                        secondName: "",
                        firstName: "",
                        thirdName: "",
                        group: 0,
                        sex: null,
                        birthday: null,
                        age: 0,
                        numberOfChildren: null,
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
        watch: {
            date(val) {
                this.dateFormatted = this.formatDate(this.date)
            },
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

            formatDate(date) {
                if (!date) return null

                const [year, month, day] = date.split('-')
                return `${month}/${day}/${year}`
            },
            parseDate(date) {
                if (!date) return null

                const [month, day, year] = date.split('/')
                return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
            },
            showAllStudents() {
                const size = this.size;
                const page = this.page;
                this.$resource("/students/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                    })
                    this.elemCounter++;
                    console.log(this.elemCounter);
                })
            },
            showStudentById() {
                // this.showAllStudents();
                const id = this.studentId;
                this.$resource("/students/studentById").get({id}).then(result => {
                    result.json().then(data => {
                        // console.log(data);
                        // this.studentsData = data;
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
            createStudent() {
                // this.showAllStudents();
                // const id = this.studentId;
                let student = {
                    // studentCode: this.studentId,
                    secondName: this.studentSecondName,
                    firstName: this.studentFirstName,
                    thirdName: this.studentThirdName,
                    group: this.studentGroup,
                    sex: this.studentSex,
                    // birthday: this.studentBirthday,
                    birthday: this.date,
                    age: this.studentAge,
                    numberOfChildren: this.studentChildren,
                    grants: this.studentGrants,
                };
                this.$resource("/students/createStudent").save(student).then(result => {
                    result.json().then(data => {
                        console.log(data);
                        // this.studentsData = data;
                        // this.student.studentCode = data.studentCode;
                        // this.student.secondName = data.secondName;
                        // this.student.firstName = data.firstName;
                        // this.student.thirdName = data.thirdName;
                        // this.student.group = data.group;
                        // this.student.sex = data.sex;
                        // this.student.birthday = data.birthday;
                        // this.student.age = data.age;
                        // this.student.numberOfChildren = data.numberOfChildren;
                        // this.student.grants = data.grants;
                    })
                })
            },
            showStudentsByGroup() {
                const group = this.studentGroup;
                this.$resource("/students/studentsByGroup").get({group}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByCourse() {
                const course = this.studentCourse;
                this.$resource("/students/studentsByCourse").get({course}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByFaculty() {
                const faculty = this.studentFaculty;
                this.$resource("/students/studentsByFaculty").get({faculty}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByAge() {
                const age = this.studentAge;
                this.$resource("/students/studentsByAge").get({age}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByGrants() {
                const grants = this.studentGrants;
                this.$resource("/students/studentsByGrants").get({grants}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByChildren() {
                const numberOfChildren = this.studentChildren;
                this.$resource("/students/studentsByChildren").get({"numberOfChildren": numberOfChildren}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByBirthday() {
                // const birthday = this.studentBirthday;
                const birthday = this.date;
                this.$resource("/students/studentsByBirthday").get({birthday}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsBySex() {
                const sex = this.studentSex;
                this.$resource("/students/studentsBySex").get({sex}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByName() {
                const secondName = this.studentSecondName;
                const firstName = this.studentFirstName;
                const thirdName = this.studentThirdName;
                this.$resource("/students/studentsByName").get({
                    "secondName": secondName,
                    "firstName": firstName,
                    "thirdName": thirdName
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByGroupAndSubjectAndMark() {
                const group = this.studentGroup;
                const subject = this.subject;
                const mark = this.mark;
                this.$resource("/students/studentByGroupNumberAndSubjectAndMark").get({
                    "groupNumber": group,
                    "subject": subject,
                    "mark": mark
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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
            showStudentsByGroupAndTeacherAndMarkAndSubjectAndSemester() {
                const group = this.studentGroup;
                const subject = this.subject;
                const mark = this.mark;
                const teacherId = this.teacherId;
                const semester = this.semester;
                this.$resource("/students/studentByGroupAndTeacherAndMarkAndSubjectAndSemester").get({
                    "groupNumber": group,
                    "teacherCode": teacherId,
                    "subject": subject,
                    "mark": mark,
                    "semester": semester
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
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

        }
    }
</script>

<style scoped>
    .operationName {
        text-align: center;

    }

</style>