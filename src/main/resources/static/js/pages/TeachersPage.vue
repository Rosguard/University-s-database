<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных всех преподавателей
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllTeachers">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все преподаватели</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showAllTeachers">Получить</v-btn>
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
                                                <tr v-for="all in teachersData" :all="all">
                                                    <td>{{all.teacherCode}}</td>
                                                    <td>{{all.secondName}}</td>
                                                    <td>{{all.firstName}}</td>
                                                    <td>{{all.thirdName}}</td>
                                                    <td>{{all.faculty}}</td>
                                                    <td>{{all.theDepartment}}</td>
                                                    <td>{{all.category}}</td>
                                                    <td>{{all.sex}}</td>
                                                    <td>{{all.birthday}}</td>
                                                    <td>{{all.age}}</td>
                                                    <td>{{all.numberOfChildren}}</td>
                                                    <td>{{all.salary}}</td>
                                                    <td>{{all.candidate}}</td>
                                                    <td>{{all.doctoral}}</td>
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
                    Получение данных преподавателя по коду
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherId" placeholder="Введите код преподавателя" required
                                  :rules="IdRules"></v-text-field>
                </v-col>
                <v-col>
                    <!--                    <v-btn @click="showTeacherById">Получить преподавателя</v-btn>-->
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogId" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeacherById"
                                    >Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogId = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватель по указанному коду</v-toolbar-title>
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
                                                    <td>{{teachersData.teacherCode}}</td>
                                                    <td>{{teachersData.secondName}}</td>
                                                    <td>{{teachersData.firstName}}</td>
                                                    <td>{{teachersData.thirdName}}</td>
                                                    <td>{{teachersData.faculty}}</td>
                                                    <td>{{teachersData.theDepartment}}</td>
                                                    <td>{{teachersData.category}}</td>
                                                    <td>{{teachersData.sex}}</td>
                                                    <td>{{teachersData.birthday}}</td>
                                                    <td>{{teachersData.age}}</td>
                                                    <td>{{teachersData.numberOfChildren}}</td>
                                                    <td>{{teachersData.salary}}</td>
                                                    <td>{{teachersData.candidate}}</td>
                                                    <td>{{teachersData.doctoral}}</td>
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
                    Получение данных преподавателей по кол-ву детей
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherChildren" placeholder="Введите кол-во детей"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogChildren" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersByChildren">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogChildren = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели у которых {{teacherChildren}} детей
                                        </v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersByChildren">Получить
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
                                                <tr v-for="ch in teachersData" :ch="ch">
                                                    <td>{{ch.teacherCode}}</td>
                                                    <td>{{ch.secondName}}</td>
                                                    <td>{{ch.firstName}}</td>
                                                    <td>{{ch.thirdName}}</td>
                                                    <td>{{ch.faculty}}</td>
                                                    <td>{{ch.theDepartment}}</td>
                                                    <td>{{ch.category}}</td>
                                                    <td>{{ch.sex}}</td>
                                                    <td>{{ch.birthday}}</td>
                                                    <td>{{ch.age}}</td>
                                                    <td>{{ch.numberOfChildren}}</td>
                                                    <td>{{ch.salary}}</td>
                                                    <td>{{ch.candidate}}</td>
                                                    <td>{{ch.doctoral}}</td>
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
                    Получение данных преподавателей по возрасту
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherAge" placeholder="Возраст"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAge" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersByAge">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAge = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели с возрастом: {{teacherAge}}
                                        </v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersByAge">Получить
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
                                                <tr v-for="ch in teachersData" :ch="ch">
                                                    <td>{{ch.teacherCode}}</td>
                                                    <td>{{ch.secondName}}</td>
                                                    <td>{{ch.firstName}}</td>
                                                    <td>{{ch.thirdName}}</td>
                                                    <td>{{ch.faculty}}</td>
                                                    <td>{{ch.theDepartment}}</td>
                                                    <td>{{ch.category}}</td>
                                                    <td>{{ch.sex}}</td>
                                                    <td>{{ch.birthday}}</td>
                                                    <td>{{ch.age}}</td>
                                                    <td>{{ch.numberOfChildren}}</td>
                                                    <td>{{ch.salary}}</td>
                                                    <td>{{ch.candidate}}</td>
                                                    <td>{{ch.doctoral}}</td>
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
                    Получение данных преподавателей по факультету
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherFaculty" placeholder="Введите факультет"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherCourse" placeholder="Введите курс"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogFaculty" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersByFaculty">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogFaculty = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели с факультета {{teacherFaculty}} и
                                            {{teacherCourse}} курса
                                        </v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersByFaculty">Получить
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
                                                <tr v-for="f in teachersData" :f="f">
                                                    <td>{{f.teacherCode}}</td>
                                                    <td>{{f.secondName}}</td>
                                                    <td>{{f.firstName}}</td>
                                                    <td>{{f.thirdName}}</td>
                                                    <td>{{f.faculty}}</td>
                                                    <td>{{f.theDepartment}}</td>
                                                    <td>{{f.category}}</td>
                                                    <td>{{f.sex}}</td>
                                                    <td>{{f.birthday}}</td>
                                                    <td>{{f.age}}</td>
                                                    <td>{{f.numberOfChildren}}</td>
                                                    <td>{{f.salary}}</td>
                                                    <td>{{f.candidate}}</td>
                                                    <td>{{f.doctoral}}</td>
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
        <!--        Название предмета и группа-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных преподавателей по названию предмета и группе
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="lessonName" placeholder="Название предмета"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherGroup" placeholder="Номер группы"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogLNameAndGroup" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersByLessonNameAndGroup">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogLNameAndGroup = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели предмета "{{lessonName}}" в группе
                                            {{teacherGroup}}
                                        </v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersByLessonNameAndGroup">
                                            Получить
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
                                                <tr v-for="lng in teachersData" :lng="lng">
                                                    <td>{{lng.teacherCode}}</td>
                                                    <td>{{lng.secondName}}</td>
                                                    <td>{{lng.firstName}}</td>
                                                    <td>{{lng.thirdName}}</td>
                                                    <td>{{lng.faculty}}</td>
                                                    <td>{{lng.theDepartment}}</td>
                                                    <td>{{lng.category}}</td>
                                                    <td>{{lng.sex}}</td>
                                                    <td>{{lng.birthday}}</td>
                                                    <td>{{lng.age}}</td>
                                                    <td>{{lng.numberOfChildren}}</td>
                                                    <td>{{lng.salary}}</td>
                                                    <td>{{lng.candidate}}</td>
                                                    <td>{{lng.doctoral}}</td>
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
        <!--        Тип предмета и группа-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных преподавателей по типу предмета и группе
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-overflow-btn
                            v-model="lessonType"
                            :items="lessonTypeTest"
                            label="Тип предмета"
                            item-value="text"
                    ></v-overflow-btn>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherGroup" placeholder="Номер группы"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogLTypeAndGroup" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersByLessonTypeAndGroup">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogLTypeAndGroup = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели предмета "{{lessonType}}" в группе
                                            {{teacherGroup}}
                                        </v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersByLessonTypeAndGroup">
                                            Получить
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
                                                <tr v-for="ltg in teachersData" :ltg="ltg">
                                                    <td>{{ltg.teacherCode}}</td>
                                                    <td>{{ltg.secondName}}</td>
                                                    <td>{{ltg.firstName}}</td>
                                                    <td>{{ltg.thirdName}}</td>
                                                    <td>{{ltg.faculty}}</td>
                                                    <td>{{ltg.theDepartment}}</td>
                                                    <td>{{ltg.category}}</td>
                                                    <td>{{ltg.sex}}</td>
                                                    <td>{{ltg.birthday}}</td>
                                                    <td>{{ltg.age}}</td>
                                                    <td>{{ltg.numberOfChildren}}</td>
                                                    <td>{{ltg.salary}}</td>
                                                    <td>{{ltg.candidate}}</td>
                                                    <td>{{ltg.doctoral}}</td>
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
        <!--        Курс, факультет, семестр-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных преподавателей по курсу, факультету и семестру
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-overflow-btn
                            v-model="course"
                            :items="courseTest"
                            label="Курс"
                            item-value="text"
                    ></v-overflow-btn>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherFaculty" placeholder="Фаультет"></v-text-field>
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
                            <v-dialog v-model="dialogCFS" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeacherByCourseAndFacultyAndSemester">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogCFS = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели на {{course}} курсе, на {{teacherFaculty}}, в {{semester}} семестре
                                        </v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeacherByCourseAndFacultyAndSemester">
                                            Получить
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
                                                <tr v-for="cfs in teachersData" :cfs="cfs">
                                                    <td>{{cfs.teacherCode}}</td>
                                                    <td>{{cfs.secondName}}</td>
                                                    <td>{{cfs.firstName}}</td>
                                                    <td>{{cfs.thirdName}}</td>
                                                    <td>{{cfs.faculty}}</td>
                                                    <td>{{cfs.theDepartment}}</td>
                                                    <td>{{cfs.category}}</td>
                                                    <td>{{cfs.sex}}</td>
                                                    <td>{{cfs.birthday}}</td>
                                                    <td>{{cfs.age}}</td>
                                                    <td>{{cfs.numberOfChildren}}</td>
                                                    <td>{{cfs.salary}}</td>
                                                    <td>{{cfs.candidate}}</td>
                                                    <td>{{cfs.doctoral}}</td>
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
        <!--        Группа, название предмета и семестр-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных преподавателей по группе, названию предмета и семестру
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherGroup" placeholder="Номер группы"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="lessonName" placeholder="Название предмета"></v-text-field>
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
                            <v-dialog v-model="dialogGSS" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeacherByGroupAndSubjectAndSemester">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogGSS = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели предмета "{{lessonName}}" в группе
                                            {{teacherGroup}} в {{semester}} семестре
                                        </v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeacherByGroupAndSubjectAndSemester">
                                            Получить
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
                                                <tr v-for="gss in teachersData" :gss="gss">
                                                    <td>{{gss.teacherCode}}</td>
                                                    <td>{{gss.secondName}}</td>
                                                    <td>{{gss.firstName}}</td>
                                                    <td>{{gss.thirdName}}</td>
                                                    <td>{{gss.faculty}}</td>
                                                    <td>{{gss.theDepartment}}</td>
                                                    <td>{{gss.category}}</td>
                                                    <td>{{gss.sex}}</td>
                                                    <td>{{gss.birthday}}</td>
                                                    <td>{{gss.age}}</td>
                                                    <td>{{gss.numberOfChildren}}</td>
                                                    <td>{{gss.salary}}</td>
                                                    <td>{{gss.candidate}}</td>
                                                    <td>{{gss.doctoral}}</td>
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
                    Получение данных преподавателей по зарплате
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherSalary" placeholder="Введите денюжку"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogSalary" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersBySalary">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogSalary = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели с зарплатой {{teacherSalary}}</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersBySalary">Получить
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
                                                <tr v-for="gr in teachersData" :gr="gr">
                                                    <td>{{gr.teacherCode}}</td>
                                                    <td>{{gr.secondName}}</td>
                                                    <td>{{gr.firstName}}</td>
                                                    <td>{{gr.thirdName}}</td>
                                                    <td>{{gr.faculty}}</td>
                                                    <td>{{gr.theDepartment}}</td>
                                                    <td>{{gr.category}}</td>
                                                    <td>{{gr.sex}}</td>
                                                    <td>{{gr.birthday}}</td>
                                                    <td>{{gr.age}}</td>
                                                    <td>{{gr.numberOfChildren}}</td>
                                                    <td>{{gr.salary}}</td>
                                                    <td>{{gr.candidate}}</td>
                                                    <td>{{gr.doctoral}}</td>
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
                    Получение данных преподавателей по дате рождения
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
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersByBirthday">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogBirthday = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели родившиеся {{teacherBirthday}}</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersByBirthday">Получить
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
                                                <tr v-for="bir in teachersData" :bir="bir">
                                                    <td>{{bir.teacherCode}}</td>
                                                    <td>{{bir.secondName}}</td>
                                                    <td>{{bir.firstName}}</td>
                                                    <td>{{bir.thirdName}}</td>
                                                    <td>{{bir.faculty}}</td>
                                                    <td>{{bir.theDepartment}}</td>
                                                    <td>{{bir.category}}</td>
                                                    <td>{{bir.sex}}</td>
                                                    <td>{{bir.birthday}}</td>
                                                    <td>{{bir.age}}</td>
                                                    <td>{{bir.numberOfChildren}}</td>
                                                    <td>{{bir.salary}}</td>
                                                    <td>{{bir.candidate}}</td>
                                                    <td>{{bir.doctoral}}</td>
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
                    Получение данных преподавателей по полу
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-overflow-btn
                            v-model="teacherSex"
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
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersBySex">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogSex = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели с указанным полом</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersBySex">Получить
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
                                                <tr v-for="sex in teachersData" :sex="sex">
                                                    <td>{{sex.teacherCode}}</td>
                                                    <td>{{sex.secondName}}</td>
                                                    <td>{{sex.firstName}}</td>
                                                    <td>{{sex.thirdName}}</td>
                                                    <td>{{sex.faculty}}</td>
                                                    <td>{{sex.theDepartment}}</td>
                                                    <td>{{sex.category}}</td>
                                                    <td>{{sex.sex}}</td>
                                                    <td>{{sex.birthday}}</td>
                                                    <td>{{sex.age}}</td>
                                                    <td>{{sex.numberOfChildren}}</td>
                                                    <td>{{sex.salary}}</td>
                                                    <td>{{sex.candidate}}</td>
                                                    <td>{{sex.doctoral}}</td>
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
        <!--        Категория-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение данных преподавателей по категории
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-overflow-btn
                            v-model="teacherCategory"
                            :items="categoryTest"
                            label="Категория"
                            item-value="text"
                    ></v-overflow-btn>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogCategory" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersByCategory">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogCategory = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели с категорией {{teacherCategory}}</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersByCategory">Получить
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
                                                <tr v-for="tc in teachersData" :tc="tc">
                                                    <td>{{tc.teacherCode}}</td>
                                                    <td>{{tc.secondName}}</td>
                                                    <td>{{tc.firstName}}</td>
                                                    <td>{{tc.thirdName}}</td>
                                                    <td>{{tc.faculty}}</td>
                                                    <td>{{tc.theDepartment}}</td>
                                                    <td>{{tc.category}}</td>
                                                    <td>{{tc.sex}}</td>
                                                    <td>{{tc.birthday}}</td>
                                                    <td>{{tc.age}}</td>
                                                    <td>{{tc.numberOfChildren}}</td>
                                                    <td>{{tc.salary}}</td>
                                                    <td>{{tc.candidate}}</td>
                                                    <td>{{tc.doctoral}}</td>
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
                    Получение данных преподавателей по ФИО
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherSecondName" placeholder="Введите фамилию"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherFirstName" placeholder="Введите имя"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherThirdName" placeholder="Введите отчество"></v-text-field>
                </v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogName" fullscreen hide-overlay
                                      transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showTeachersByName">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogName = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Преподаватели с именем: {{teacherSecondName}}
                                            {{teacherFirstName}} {{teacherThirdName}}
                                        </v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showTeachersByName">Получить
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
                                                <tr v-for="name in teachersData" :name="name">
                                                    <td>{{name.teacherCode}}</td>
                                                    <td>{{name.secondName}}</td>
                                                    <td>{{name.firstName}}</td>
                                                    <td>{{name.thirdName}}</td>
                                                    <td>{{name.faculty}}</td>
                                                    <td>{{name.theDepartment}}</td>
                                                    <td>{{name.category}}</td>
                                                    <td>{{name.sex}}</td>
                                                    <td>{{name.birthday}}</td>
                                                    <td>{{name.age}}</td>
                                                    <td>{{name.numberOfChildren}}</td>
                                                    <td>{{name.salary}}</td>
                                                    <td>{{name.candidate}}</td>
                                                    <td>{{name.doctoral}}</td>
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
                    <v-text-field v-model="teacherSecondName" placeholder="Введите фамилию"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherFirstName" placeholder="Введите имя"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherThirdName" placeholder="Введите отчество"></v-text-field>
                </v-col>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherFaculty" placeholder="Введите факультет"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherTheDepartment" placeholder="Введите кафедру"></v-text-field>
                </v-col>
                <v-col>
                    <v-overflow-btn
                            v-model="teacherCategory"
                            :items="categoryTest"
                            label="Категория"
                            item-value="text"
                    ></v-overflow-btn>
                </v-col>
                <v-col>
                    <v-overflow-btn
                            v-model="teacherSex"
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
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherChildren" placeholder="Введите кол-во детей"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherSalary" placeholder="Введите деньги"></v-text-field>
                </v-col>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherCandidate" placeholder="Введите кандидатскую"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="teacherDoctoral" placeholder="Введите докторскую"></v-text-field>
                </v-col>

                <v-col>
                    <v-btn color="primary" dark @click="createTeacher">Добавить преподавателя</v-btn>
                </v-col>
            </v-row>

        </v-container>
        <!--        Удаление-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Удаление преподавателя по коду преподавателя
                </p>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherId" placeholder="Введите код преподавателя" required
                                  :rules="IdRules"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn @click="deleteTeacherById" color="secondary">Удалить преподавателя</v-btn>
                </v-col>
            </v-row>

        </v-container>

    </v-content>
</template>

<script>
    export default {
        name: "TeachersPage",
        data() {
            return {
                // elemCounter: 0,
                IdRules: [
                    v => !!v || 'Teacher code is required',
                ],
                GroupRules: [
                    v => !!v || 'Group is required',
                    v => /^\d+$/.test(v) || 'Group should be a number',
                ],
                // teacherData: null,
                teachersData: [{
                    teacherCode: "",
                    secondName: "",
                    firstName: "",
                    thirdName: "",
                    faculty: "",
                    theDepartment: "",
                    category: null,
                    sex: null,
                    birthday: null,
                    age: "",
                    numberOfChildren: null,
                    salary: "",
                    candidate: "",
                    doctoral: "",
                }],
                sexTest: [
                    {text: "мужской"},
                    {text: "женский"},
                ],
                categoryTest: [
                    {text: "Аспирант"},
                    {text: "Кандидат"},
                    {text: "Доктор"},
                ],
                lessonTypeTest: [
                    {text: "Лекция"},
                    {text: "Семинар"},
                    {text: "Лабораторная"},
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
                courseTest: [ //При условии, что у нас всего 4 года обучение идет
                    {text: "1"},
                    {text: "2"},
                    {text: "3"},
                    {text: "4"},
                ],
                teacherId: null,
                teacherSex: null,
                teacherCategory: null,
                teacherBirthday: null,
                teacherAge: null,
                teacherChildren: null,
                teacherSalary: null,
                teacherFaculty: null,
                teacherGroup: null,
                lessonName: null,
                lessonType: null,
                teacherCourse: null,
                teacherTheDepartment: null,
                teacherCandidate: null,
                teacherDoctoral: null,
                // teacherSecondName: "",
                // teacherFirstName: "",
                // teacherThirdName: "",
                teacherSecondName: "",
                teacherFirstName: "",
                teacherThirdName: "",
                // teacherId: null,
                subject: null,
                mark: null,
                semester: null,
                course: null,
                dialogAll: false,
                dialogAge: false,
                dialogCategory: null,
                dialogGroup: false,
                dialogId: false,
                dialogCourse: false,
                dialogChildren: false,
                dialogFaculty: false,
                dialogLNameAndGroup: false,
                dialogLTypeAndGroup: false,
                dialogSalary: false,
                dialogBirthday: false,
                dialogSex: false,
                dialogName: false,
                dialogCFS: false,
                dialogGSS: false,

                page: 0, //Страница
                pageCount: 0,//Кол-во страниц
                size: 50, //Размер страницы (кол-во элементов на ней)
                totalElements: 0,
                picker: new Date().toISOString().substr(0, 10), //Для календаря
                date: new Date().toISOString().substr(0, 10),
                dateFormatted: this.formatDate(new Date().toISOString().substr(0, 10)),
                menu1: false,
                menu2: false,
                headers: [
                    {text: "Код преподавателя", value: "teacherCode"},
                    {text: "Фамилия", value: "secondName"},
                    {text: "Имя", value: "firstName"},
                    {text: "Отчество", value: "thirdName"},
                    {text: "Факультет", value: "faculty"},
                    {text: "Кафедра", value: "theDepartment"},
                    {text: "Категория", value: "category"},
                    {text: "Пол", value: "sex"},
                    {text: "Дата рождения", value: "birthday"},
                    {text: "Возраст", value: "age"},
                    {text: "Кол-во детей", value: "numberOfChildren"},
                    {text: "Зарплата", value: "salary"},
                    {text: "Кандидатская", value: "candidate"},
                    {text: "Докторская", value: "doctoral"},
                ],
            };
        },
        watch: {
            date(val) {
                this.dateFormatted = this.formatDate(this.date)
            },
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

            showAllTeachers() {
                const size = this.size;
                const page = this.page;
                this.$resource("/teachers/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.teachersData = data.content;
                    })

                })
            },
            showTeacherById() {
                const id = this.teacherId;
                this.$resource("/teachers/teacherById").get({id}).then(result => {
                    result.json().then(data => {
                        this.teachersData = data;
                    })
                })

            },
            deleteTeacherById() {
                const id = this.teacherId;
                this.$resource("/teachers/deleteTeacherById").delete({id}).then(result => {
                    alert("Done");
                })

            },
            createTeacher() {
                let teacher = {
                    secondName: this.teacherSecondName,
                    firstName: this.teacherFirstName,
                    thirdName: this.teacherThirdName,
                    faculty: this.teacherFaculty,
                    theDepartment: this.teacherTheDepartment,
                    category: this.teacherCategory,
                    sex: this.teacherSex,
                    birthday: this.date,
                    age: this.teacherAge,
                    numberOfChildren: this.teacherChildren,
                    salary: this.teacherSalary,
                    candidate: this.teacherCandidate,
                    doctoral: this.teacherDoctoral,
                };
                this.$resource("/teachers/createTeacher").save(teacher).then(result => {
                    result.json().then(data => {
                        console.log(data);
                    })
                })
            },
            showTeachersByFaculty() {
                const size = this.size;
                const page = this.page;
                const faculty = this.teacherFaculty;
                const course = this.teacherCourse;
                this.$resource("/teachers/TeacherCourseAndFaculty").get({
                    "course": course,
                    "faculty": faculty,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersByLessonNameAndGroup() {
                const size = this.size;
                const page = this.page;
                const groupNumber = this.teacherGroup;
                const lessonName = this.lessonName;
                this.$resource("/teachers/TeacherByLessonNameAndGroupNumber").get({
                    "groupNumber": groupNumber,
                    "lessonName": lessonName,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersByAge() {
                const size = this.size;
                const page = this.page;
                const age = this.teacherAge;
                this.$resource("/teachers/teachersByAge").get({
                    "age": age,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersBySalary() {
                const size = this.size;
                const page = this.page;
                const salary = this.teacherSalary;
                this.$resource("/teachers/teachersBySalary").get({
                    "salary": salary,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersByChildren() {
                const size = this.size;
                const page = this.page;
                const numberOfChildren = this.teacherChildren;
                this.$resource("/teachers/teachersByChildren").get({
                    "numberOfChildren": numberOfChildren,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersByBirthday() {
                const size = this.size;
                const page = this.page;
                const birthday = this.date;
                this.$resource("/teachers/teachersByBirthday").get({
                    "birthday": birthday,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersBySex() {
                const size = this.size;
                const page = this.page;
                const sex = this.teacherSex;
                this.$resource("/teachers/teachersBySex").get({
                    "sex": sex,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersByCategory() {
                const size = this.size;
                const page = this.page;
                const category = this.teacherCategory;
                this.$resource("/teachers/teachersByCategory").get({
                    "category": category,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersByLessonTypeAndGroup() {
                const size = this.size;
                const page = this.page;
                const groupNumber = this.teacherGroup;
                const lessonType = this.lessonType;
                this.$resource("/teachers/TeacherByLessonTypeAndGroupNumber").get({
                    "lessonType": lessonType,
                    "groupNumber": groupNumber,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeacherByCourseAndFacultyAndSemester() {
                const size = this.size;
                const page = this.page;
                const course = this.course;
                const faculty = this.teacherFaculty;
                const semester = this.semester;
                alert(course);
                alert(semester);
                this.$resource("/teachers/TeacherCourseAndFacultyAndSemester").get({
                    "course": course,
                    "faculty": faculty,
                    "semester": semester,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeacherByGroupAndSubjectAndSemester() {
                const size = this.size;
                const page = this.page;
                const groupNumber = this.teacherGroup;
                const subject = this.lessonName;
                const semester = this.semester;
                this.$resource("/teachers/TeacherByGroupAndSubjectAndSemester").get({
                    "groupNumber": groupNumber,
                    "subject": subject,
                    "semester": semester,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                    })
                })
            },
            showTeachersByName() {
                const size = this.size;
                const page = this.page;
                const secondName = this.teacherSecondName;
                const firstName = this.teacherFirstName;
                const thirdName = this.teacherThirdName;
                this.$resource("/teachers/teachersByName").get({
                    "secondName": secondName,
                    "firstName": firstName,
                    "thirdName": thirdName,
                    "page": page,
                    "size": size
                }).then(result => {
                    result.json().then(data => {
                        this.teachersData = data.content;
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