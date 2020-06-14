<template>
    <v-content>
        <form>
            <!--        Все-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных всех студентов
                    </p>
                </v-row>
                <v-row>
                    <v-col></v-col>
                    <v-col>
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogAll" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
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
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showAllStudents">Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
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
                        ></v-text-field>
                    </v-col>
                    <v-col>
                        <!--                    <v-btn @click="showStudentById">Получить студента</v-btn>-->
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogId" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentById"
                                        >Получить
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
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>{{studentsData.studentCode}}</td>
                                                        <td>{{studentsData.secondName}}</td>
                                                        <td>{{studentsData.firstName}}</td>
                                                        <td>{{studentsData.thirdName}}</td>
                                                        <td>{{studentsData.group}}</td>
                                                        <td>{{studentsData.sex}}</td>
                                                        <td>{{studentsData.birthday}}</td>
                                                        <td>{{studentsData.age}}</td>
                                                        <td>{{studentsData.numberOfChildren}}</td>
                                                        <td>{{studentsData.grants}}</td>
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
            <!--        Группа-->
            <v-container>

                <v-row>
                    <p class="operationName">
                        Получение данных студентов по группе
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentGroup" placeholder="Введите номер группы"
                                      :error-messages="groupNumberErrors"
                                      @input="$v.studentGroup.$touch()"
                                      @blur="$v.studentGroup.$touch()"
                        ></v-text-field>
                    </v-col>
                    <v-col>
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogGroup" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" v-on="on" @click="showStudentsByGroup">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogGroup = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты группы {{studentGroup}}</v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" v-on="on" @click="showStudentsByGroup"
                                            >Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="g in studentsData" :g="g">
                                                        <td>{{g.studentCode}}</td>
                                                        <td>{{g.secondName}}</td>
                                                        <td>{{g.firstName}}</td>
                                                        <td>{{g.thirdName}}</td>
                                                        <td>{{g.group}}</td>
                                                        <td>{{g.sex}}</td>
                                                        <td>{{g.birthday}}</td>
                                                        <td>{{g.age}}</td>
                                                        <td>{{g.numberOfChildren}}</td>
                                                        <td>{{g.grants}}</td>
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
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogCourse" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentsByCourse">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogCourse = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты {{studentCourse}} курса</v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showStudentsByCourse">Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="co in studentsData" :co="co">
                                                        <td>{{co.studentCode}}</td>
                                                        <td>{{co.secondName}}</td>
                                                        <td>{{co.firstName}}</td>
                                                        <td>{{co.thirdName}}</td>
                                                        <td>{{co.group}}</td>
                                                        <td>{{co.sex}}</td>
                                                        <td>{{co.birthday}}</td>
                                                        <td>{{co.age}}</td>
                                                        <td>{{co.numberOfChildren}}</td>
                                                        <td>{{co.grants}}</td>
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
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogChildren" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentsByChildren">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogChildren = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты у которых {{studentChildren}} детей
                                            </v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showStudentsByChildren">
                                                Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="ch in studentsData" :ch="ch">
                                                        <td>{{ch.studentCode}}</td>
                                                        <td>{{ch.secondName}}</td>
                                                        <td>{{ch.firstName}}</td>
                                                        <td>{{ch.thirdName}}</td>
                                                        <td>{{ch.group}}</td>
                                                        <td>{{ch.sex}}</td>
                                                        <td>{{ch.birthday}}</td>
                                                        <td>{{ch.age}}</td>
                                                        <td>{{ch.numberOfChildren}}</td>
                                                        <td>{{ch.grants}}</td>
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
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogFaculty" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentsByFaculty">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogFaculty = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты с факультета {{studentFaculty}}</v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showStudentsByFaculty">
                                                Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="f in studentsData" :f="f">
                                                        <td>{{f.studentCode}}</td>
                                                        <td>{{f.secondName}}</td>
                                                        <td>{{f.firstName}}</td>
                                                        <td>{{f.thirdName}}</td>
                                                        <td>{{f.group}}</td>
                                                        <td>{{f.sex}}</td>
                                                        <td>{{f.birthday}}</td>
                                                        <td>{{f.age}}</td>
                                                        <td>{{f.numberOfChildren}}</td>
                                                        <td>{{f.grants}}</td>
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
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogGrants" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentsByGrants">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogGrants = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты со степендией {{studentGrants}}</v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showStudentsByGrants">Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="gr in studentsData" :gr="gr">
                                                        <td>{{gr.studentCode}}</td>
                                                        <td>{{gr.secondName}}</td>
                                                        <td>{{gr.firstName}}</td>
                                                        <td>{{gr.thirdName}}</td>
                                                        <td>{{gr.group}}</td>
                                                        <td>{{gr.sex}}</td>
                                                        <td>{{gr.birthday}}</td>
                                                        <td>{{gr.age}}</td>
                                                        <td>{{gr.numberOfChildren}}</td>
                                                        <td>{{gr.grants}}</td>
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
            <!--        ДР-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по дате рождения
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-menu
                                ref="menu2"
                                v-model="menu2"
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
                            <v-date-picker v-model="date" no-title @input="menu2 = false"></v-date-picker>
                        </v-menu>
                    </v-col>
                    <v-col>
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogBirthday" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentsByBirthday">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogBirthday = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты родившиеся {{studentBirthday}}</v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showStudentsByBirthday">
                                                Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="bir in studentsData" :bir="bir">
                                                        <td>{{bir.studentCode}}</td>
                                                        <td>{{bir.secondName}}</td>
                                                        <td>{{bir.firstName}}</td>
                                                        <td>{{bir.thirdName}}</td>
                                                        <td>{{bir.group}}</td>
                                                        <td>{{bir.sex}}</td>
                                                        <td>{{bir.birthday}}</td>
                                                        <td>{{bir.age}}</td>
                                                        <td>{{bir.numberOfChildren}}</td>
                                                        <td>{{bir.grants}}</td>
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
            <!--        Возраст-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по указанному возрасту
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentAge" placeholder="Возраст"></v-text-field>
                    </v-col>
                    <v-col>
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogAge" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentsByAge">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogAge = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты с возрастом: {{studentAge}}
                                            </v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showStudentsByAge">Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="age in studentsData" :age="age">
                                                        <td>{{age.studentCode}}</td>
                                                        <td>{{age.secondName}}</td>
                                                        <td>{{age.firstName}}</td>
                                                        <td>{{age.thirdName}}</td>
                                                        <td>{{age.group}}</td>
                                                        <td>{{age.sex}}</td>
                                                        <td>{{age.birthday}}</td>
                                                        <td>{{age.age}}</td>
                                                        <td>{{age.numberOfChildren}}</td>
                                                        <td>{{age.grants}}</td>
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
            <!--        Пол-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студентов по полу
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-overflow-btn
                                v-model="studentSex"
                                :items="sexTest"
                                label="Пол"
                                item-value="text"
                        ></v-overflow-btn>
                    </v-col>
                    <v-col>
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogSex" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentsBySex">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogSex = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты с указанным полом</v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showStudentsBySex">Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="sex in studentsData" :sex="sex">
                                                        <td>{{sex.studentCode}}</td>
                                                        <td>{{sex.secondName}}</td>
                                                        <td>{{sex.firstName}}</td>
                                                        <td>{{sex.thirdName}}</td>
                                                        <td>{{sex.group}}</td>
                                                        <td>{{sex.sex}}</td>
                                                        <td>{{sex.birthday}}</td>
                                                        <td>{{sex.age}}</td>
                                                        <td>{{sex.numberOfChildren}}</td>
                                                        <td>{{sex.grants}}</td>
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
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogName" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on" @click="showStudentsByName">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogName = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Студенты с именем: {{studentSecondName}}
                                                {{studentFirstName}}
                                                {{studentThirdName}}
                                            </v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on" @click="showStudentsByName">Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="name in studentsData" :name="name">
                                                        <td>{{name.studentCode}}</td>
                                                        <td>{{name.secondName}}</td>
                                                        <td>{{name.firstName}}</td>
                                                        <td>{{name.thirdName}}</td>
                                                        <td>{{name.group}}</td>
                                                        <td>{{name.sex}}</td>
                                                        <td>{{name.birthday}}</td>
                                                        <td>{{name.age}}</td>
                                                        <td>{{name.numberOfChildren}}</td>
                                                        <td>{{name.grants}}</td>
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
            <!--        Группа, предмет, оценка-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студента по номеру группы, предмету, оценке
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentGroup1" placeholder="Введите группу"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="subject" placeholder="Введите предмет"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-overflow-btn
                                v-model="mark"
                                :items="markTest"
                                label="Оценка"
                                item-value="text"
                        ></v-overflow-btn>
                    </v-col>
                    <v-col>
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogGSM" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on"
                                               @click="showStudentsByGroupAndSubjectAndMark">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogGSM = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Результаты запроса</v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on"
                                                   @click="showStudentsByGroupAndSubjectAndMark">Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="gsm in studentsData" :gsm="gsm">
                                                        <td>{{gsm.studentCode}}</td>
                                                        <td>{{gsm.secondName}}</td>
                                                        <td>{{gsm.firstName}}</td>
                                                        <td>{{gsm.thirdName}}</td>
                                                        <td>{{gsm.group}}</td>
                                                        <td>{{gsm.sex}}</td>
                                                        <td>{{gsm.birthday}}</td>
                                                        <td>{{gsm.age}}</td>
                                                        <td>{{gsm.numberOfChildren}}</td>
                                                        <td>{{gsm.grants}}</td>
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
            <!--        Группа, код препода, предмет, оценка, семестр-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Получение данных студента по номеру группы, коду преподавателя, предмету, оценке, семестру
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentGroup2" placeholder="Введите группу"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="teacherId" placeholder="Введите код учителя"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="subject1" placeholder="Введите предмет"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-overflow-btn
                                v-model="mark1"
                                :items="markTest"
                                label="Оценка"
                                item-value="text"
                        ></v-overflow-btn>
                    </v-col>
                    <v-col>
                        <v-overflow-btn
                                v-model="semester"
                                :items="semesterTest"
                                label="Семестр"
                                item-value="text"
                        ></v-overflow-btn>
                    </v-col>
                    <v-col>
                        <template>
                            <v-row justify="center">
                                <v-dialog v-model="dialogGTMSS" fullscreen hide-overlay
                                          transition="dialog-bottom-transition">
                                    <template v-slot:activator="{ on }">
                                        <v-btn color="primary" dark v-on="on"
                                               @click="showStudentsByGroupAndTeacherAndMarkAndSubjectAndSemester">
                                            Получить
                                        </v-btn>
                                    </template>
                                    <v-card>
                                        <v-toolbar dark color="primary">
                                            <v-btn icon dark @click="dialogGTMSS = false; clearData()">
                                                <v-icon>mdi-close</v-icon>
                                            </v-btn>
                                            <v-toolbar-title>Результаты запроса</v-toolbar-title>
                                            <v-tab></v-tab>
                                            <v-tab>
                                                Всего элементов: {{totalElements}}
                                            </v-tab>
                                            <v-tab>
                                                Элементов на странице
                                            </v-tab>
                                            <v-text-field v-model="size"
                                                          placeholder="Количество элементов"></v-text-field>
                                            <v-tab> Номер страницы</v-tab>
                                            <v-text-field v-model="page" placeholder="Номер страницы"></v-text-field>
                                            <v-tab></v-tab>
                                            <v-btn color="primary" dark v-on="on"
                                                   @click="showStudentsByGroupAndTeacherAndMarkAndSubjectAndSemester">
                                                Получить
                                            </v-btn>
                                        </v-toolbar>
                                        <template>
                                            <v-simple-table>
                                                <template v-slot:default>
                                                    <thead>
                                                    <tr>
                                                        <th class="text-left" v-for="header in headers"
                                                            :header="header">
                                                            {{header.text}}
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr v-for="gstmss in studentsData" :gstmss="gstmss">
                                                        <td>{{gstmss.studentCode}}</td>
                                                        <td>{{gstmss.secondName}}</td>
                                                        <td>{{gstmss.firstName}}</td>
                                                        <td>{{gstmss.thirdName}}</td>
                                                        <td>{{gstmss.group}}</td>
                                                        <td>{{gstmss.sex}}</td>
                                                        <td>{{gstmss.birthday}}</td>
                                                        <td>{{gstmss.age}}</td>
                                                        <td>{{gstmss.numberOfChildren}}</td>
                                                        <td>{{gstmss.grants}}</td>
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
                        <v-text-field v-model="studentSecondName0" placeholder="Введите фамилию"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentFirstName0" placeholder="Введите имя"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentThirdName0" placeholder="Введите отчество"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentGroup0" placeholder="Введите группу"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-overflow-btn
                                v-model="studentSex0"
                                :items="sexTest"
                                label="Пол"
                                item-value="text"
                        ></v-overflow-btn>
                    </v-col>
                    <v-col>
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
                                        v-model="dateFormatted0"
                                        label="Date"
                                        hint="MM/DD/YYYY format"
                                        persistent-hint
                                        @blur="date0 = parseDate(dateFormatted0)"
                                        v-on="on"
                                ></v-text-field>
                            </template>
                            <v-date-picker v-model="date0" no-title @input="menu1 = false"></v-date-picker>
                        </v-menu>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentChildren0" placeholder="Введите кол-во детей"></v-text-field>
                    </v-col>
                    <v-col>
                        <v-text-field v-model="studentGrants0" placeholder="Введите деньги"></v-text-field>
                    </v-col>

                    <v-col>
                        <v-btn color="primary" dark @click="createStudent">Добавить студента</v-btn>
                    </v-col>
                </v-row>

            </v-container>
            <!--        Удаление-->
            <v-container>
                <v-row>
                    <p class="operationName">
                        Удаление студента по коду студента
                    </p>
                </v-row>
                <v-row>
                    <v-col>
                        <v-text-field v-model="studentIdDel" placeholder="Введите код студента" required
                        ></v-text-field>
                    </v-col>
                    <v-col>
                        <v-btn @click="deleteStudentById" color="secondary">Удалить студента</v-btn>
                    </v-col>
                </v-row>

            </v-container>
        </form>
    </v-content>
</template>

<script>
    import {validationMixin} from 'vuelidate'
    import {required, maxLength, minValue, alpha, integer} from 'vuelidate/lib/validators'

    export default {
        mixins: [validationMixin],

        validations: {
            course: {required, integer},
            studentGroup: {required, integer, minValue: minValue(0)},
            studentCode: {required, integer},
        },
        computed: {
            groupNumberErrors() {
                const errors = []
                if (!this.$v.studentGroup.$dirty) return errors
                !this.$v.studentGroup.integer && errors.push('Значение должно быть целым числом')
                !this.$v.studentGroup.required && errors.push('Поле не может быть пустым')
                !this.$v.studentGroup.minValue && errors.push('Значение не может быть отрицательным')
                return errors
            },

        },
        watch: {
            date(val) {
                this.dateFormatted = this.formatDate(this.date);
                // this.dateFormatted0 = this.formatDate(this.date0);
            },
            date0(val) {
                // this.dateFormatted = this.formatDate(this.date);
                this.dateFormatted0 = this.formatDate(this.date0);
            },
        },
        data() {
            return {
                // // elemCounter: 0,
                // IdRules: [
                //     v => !!v || 'Student code is required',
                // ],
                // GroupRules: [
                //     v => !!v || 'Group is required',
                //     v => /^\d+$/.test(v) || 'Group should be a number',
                // ],
                // // studentData: null,
                studentsData: [{
                    studentCode: "",
                    secondName: "",
                    firstName: "",
                    thirdName: "",
                    group: "",
                    sex: null,
                    birthday: null,
                    age: "",
                    numberOfChildren: null,
                    grants: "",
                }],
                sexTest: [
                    {text: "мужской"},
                    {text: "женский"},
                ],
                markTest: [
                    {text: "5"},
                    {text: "4"},
                    {text: "3"},
                    {text: "2"}
                ],
                semesterTest: [ //При условии, что у нас всего 4 года обучение идет
                    {text: "1"},
                    {text: "2"},
                    {text: "3"},
                    {text: "4"},
                    {text: "5"},
                    {text: "6"},
                    {text: "7"},
                    {text: "8"},
                ],
                studentId: null,
                studentIdDel: null,
                studentGroup: null,
                studentGroup1: null,
                studentGroup2: null,
                studentGroup0: null,
                studentCourse: null,
                studentSex: null,
                studentSex0: null,
                studentBirthday: null,
                studentBirthday0: null,
                studentAge: null,
                studentChildren: null,
                studentChildren0: null,
                studentGrants: null,
                studentGrants0: null,
                studentFaculty: null,
                studentSecondName: "",
                studentFirstName: "",
                studentThirdName: "",
                studentSecondName0: "",
                studentFirstName0: "",
                studentThirdName0: "",
                teacherSecondName: "",
                teacherFirstName: "",
                teacherThirdName: "",
                teacherId: null,
                subject: null,
                subject1: null,
                mark: null,
                mark1: null,
                semester: null,
                dialogAll: false,
                dialogAge: false,
                dialogGroup: false,
                dialogId: false,
                dialogCourse: false,
                dialogChildren: false,
                dialogFaculty: false,
                dialogGrants: false,
                dialogBirthday: false,
                dialogSex: false,
                dialogName: false,
                dialogGSM: false,
                dialogGTMSS: false,

                page: 0, //Страница
                pageCount: 0,//Кол-во страниц
                size: 7, //Размер страницы (кол-во элементов на ней)
                totalElements: 0,
                date: new Date().toISOString().substr(0, 10),
                date0: new Date().toISOString().substr(0, 10),
                dateFormatted: this.formatDate(new Date().toISOString().substr(0, 10)),
                dateFormatted0: this.formatDate(new Date().toISOString().substr(0, 10)),
                menu1: false,
                menu2: false,
                menu0: false,
                headers: [
                    {text: "Код студента", value: "studentCode"},
                    {text: "Фамилия", value: "secondName"},
                    {text: "Имя", value: "firstName"},
                    {text: "Отчество", value: "thirdName"},
                    {text: "Группа", value: "group"},
                    {text: "Пол", value: "sex"},
                    {text: "Дата рождения", value: "birthday"},
                    {text: "Возраст", value: "age"},
                    {text: "Кол-во детей", value: "numberOfChildren"},
                    {text: "Степендия", value: "grants"},
                ],
            };
        },


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
            clearData() {
                // this.$v.clear();
                this.studentId = null;
                this.studentIdDel = null;
                this.studentGroup = null;
                this.studentGroup1 = null;
                this.studentGroup2 = null;
                this.studentGroup0 = null;
                this.studentCourse = null;
                this.studentSex = null;
                this.studentSex0 = null;
                this.studentBirthday = null;
                this.studentBirthday0 = null;
                this.studentAge = null;
                this.studentChildren = null;
                this.studentChildren0 = null;
                this.studentGrants = null;
                this.studentGrants0 = null;
                this.studentFaculty = null;
                this.studentSecondName = "";
                this.studentFirstName = "";
                this.studentThirdName = "";
                this.studentSecondName0 = "";
                this.studentFirstName0 = "";
                this.studentThirdName0 = "";
                this.teacherSecondName = "";
                this.teacherFirstName = "";
                this.teacherThirdName = "";
                this.teacherId = null;
                this.subject = null;
                this.subject1 = null;
                this.mark = null;
                this.mark1 = null;
                this.semester = null;
                this.page = 0;
                this.pageCount = 0;
                this.size = 10;
                this.totalElements = 0;
            },
            showAllStudents() {
                const size = this.size;
                const page = this.page;
                this.$resource("/students/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.studentsData = data.content;
                    })
                })
            },
            showStudentById() {
                const id = this.studentId;
                this.$resource("/students/studentById").get({id}).then(result => {
                    result.json().then(data => {
                        this.studentsData = data;
                    })
                    this.clearData();
                })

            },
            deleteStudentById() {
                const id = this.studentIdDel;
                this.$resource("/students/deleteStudentById").delete({id}).then(result => {
                    alert("Done");
                    this.clearData();
                })

            },
            createStudent() {
                let student = {
                    // studentCode: this.studentId,
                    secondName: this.studentSecondName0,
                    firstName: this.studentFirstName0,
                    thirdName: this.studentThirdName0,
                    group: this.studentGroup0,
                    sex: this.studentSex0,
                    // birthday: this.studentBirthday,
                    birthday: this.date0,
                    // age: this.studentAge,
                    numberOfChildren: this.studentChildren0,
                    grants: this.studentGrants0,
                };
                this.$resource("/students/createStudent").save(student).then(result => {
                        alert(result.bodyText);
                    this.clearData();
                })
            },
            showStudentsByGroup() {
                const size = this.size;
                const page = this.page;
                const group = this.studentGroup;
                this.$resource("/students/studentsByGroup").get({
                    "group": group,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.studentsData = data.content
                    })
                })
            },
            showStudentsByCourse() {
                const size = this.size;
                const page = this.page;
                const course = this.studentCourse;
                this.$resource("/students/studentsByCourse").get({
                    "course": course,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.studentsData = data.content;
                    })
                })
            },
            showStudentsByFaculty() {
                const size = this.size;
                const page = this.page;
                const faculty = this.studentFaculty;
                this.$resource("/students/studentsByFaculty").get({
                    "faculty": faculty,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showStudentsByAge() {
                const size = this.size;
                const page = this.page;
                const age = this.studentAge;
                this.$resource("/students/studentsByAge").get({
                    "age": age,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showStudentsByGrants() {
                const size = this.size;
                const page = this.page;
                const grants = this.studentGrants;
                this.$resource("/students/studentsByGrants").get({
                    "grants": grants,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showStudentsByChildren() {
                const size = this.size;
                const page = this.page;
                const numberOfChildren = this.studentChildren;
                this.$resource("/students/studentsByChildren").get({
                    "numberOfChildren": numberOfChildren,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showStudentsByBirthday() {
                const size = this.size;
                const page = this.page;
                const birthday = this.date;
                this.$resource("/students/studentsByBirthday").get({
                    "birthday": birthday,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showStudentsBySex() {
                const size = this.size;
                const page = this.page;
                const sex = this.studentSex;
                this.$resource("/students/studentsBySex").get({
                    "sex": sex,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showStudentsByName() {
                const size = this.size;
                const page = this.page;
                const secondName = this.studentSecondName;
                const firstName = this.studentFirstName;
                const thirdName = this.studentThirdName;
                this.$resource("/students/studentsByName").get({
                    "secondName": secondName,
                    "firstName": firstName,
                    "thirdName": thirdName,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showStudentsByGroupAndSubjectAndMark() {
                const size = this.size;
                const page = this.page;
                const group = this.studentGroup1;
                const subject = this.subject;
                const mark = this.mark;
                this.$resource("/students/studentByGroupNumberAndSubjectAndMark").get({
                    "groupNumber": group,
                    "subject": subject,
                    "mark": mark,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showStudentsByGroupAndTeacherAndMarkAndSubjectAndSemester() {
                const size = this.size;
                const page = this.page;
                const group = this.studentGroup2;
                const subject = this.subject1;
                const mark = this.mark1;
                const teacherId = this.teacherId;
                const semester = this.semester;
                this.$resource("/students/studentByGroupAndTeacherAndMarkAndSubjectAndSemester").get({
                    "groupNumber": group,
                    "teacherCode": teacherId,
                    "subject": subject,
                    "mark": mark,
                    "semester": semester,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.studentsData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
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