<template>
    <v-content>
        <!--        Все-->
        <v-container>
            <v-row>
                <p class="operationName">
                    Получение всех занятий
                </p>
            </v-row>
            <v-row>
                <v-col></v-col>
                <v-col>
                    <template>
                        <v-row justify="center">
                            <v-dialog v-model="dialogAll" fullscreen hide-overlay transition="dialog-bottom-transition">
                                <template v-slot:activator="{ on }">
                                    <v-btn color="primary" dark v-on="on" @click="showAllGroupClasses">
                                        Получить
                                    </v-btn>
                                </template>
                                <v-card>
                                    <v-toolbar dark color="primary">
                                        <v-btn icon dark @click="dialogAll = false">
                                            <v-icon>mdi-close</v-icon>
                                        </v-btn>
                                        <v-toolbar-title>Все занятия</v-toolbar-title>
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
                                        <v-btn color="primary" dark v-on="on" @click="showAllGroupClasses">Получить
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
                                                <tr v-for="c in groupClassesData" :c="c">
                                                    <td>{{c.group}}</td>
                                                    <td>{{c.theDepartment}}</td>
                                                    <td>{{c.startDate}}</td>
                                                    <td>{{c.finishDate}}</td>
                                                    <td>{{c.teacherCode}}</td>
                                                    <td>{{c.lessonType}}</td>
                                                    <td>{{c.semester}}</td>
                                                    <td>{{c.volume}}</td>
                                                    <td>{{c.name}}</td>

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
                    <v-text-field v-model="group" placeholder="Номер группы"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="theDepartment" placeholder="Кафедра"></v-text-field>
                </v-col>
            </v-row>
            <v-row>
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
                                    label="Дата начала"
                                    hint="MM/DD/YYYY format"
                                    persistent-hint
                                    @blur="startDate = parseDate(dateFormatted)"
                                    v-on="on"
                            ></v-text-field>
                        </template>
                        <v-date-picker v-model="startDate" no-title @input="menu1 = false"></v-date-picker>
                    </v-menu>
                </v-col>
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
                                    v-model="dateFormatted2"
                                    label="Дата завершения"
                                    hint="MM/DD/YYYY format"
                                    persistent-hint
                                    @blur="finishDate = parseDate(dateFormatted2)"
                                    v-on="on"
                            ></v-text-field>
                        </template>
                        <v-date-picker v-model="finishDate" no-title @input="menu2 = false"></v-date-picker>
                    </v-menu>
                </v-col>
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="teacherCode" placeholder="Код преподавателя"></v-text-field>
                </v-col>
                <v-col>
                    <v-overflow-btn
                            v-model="lessonType"
                            :items="lessonTypeTest"
                            label="Тип предмета"
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
            </v-row>
            <v-row>
                <v-col>
                    <v-text-field v-model="volume" placeholder="Объем"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="name" placeholder="Название"></v-text-field>
                </v-col>
                <v-col>
                    <v-btn color="primary" dark @click="createGroupClasses">Добавить</v-btn>
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
                    <v-text-field v-model="group1" placeholder="Номер группы"></v-text-field>
                </v-col>
                <v-col>
                    <v-text-field v-model="name1" placeholder="Название предмета"></v-text-field>
                </v-col>
                <v-col>
                    <v-overflow-btn
                            v-model="lessonType1"
                            :items="lessonTypeTest"
                            label="Тип предмета"
                            item-value="text"
                    ></v-overflow-btn>
                </v-col>
                <v-col>
                    <v-btn @click="deleteGroupClassesById" color="secondary">Удалить</v-btn>
                </v-col>
            </v-row>

        </v-container>
    </v-content>
</template>

<script>
    export default {
        name: "GroupClassesPage",
        data() {
            return {
                totalElements: null,
                size: 50,
                page: 0,
                pageCount: null,
                picker: new Date().toISOString().substr(0, 10), //Для календаря
                date: new Date().toISOString().substr(0, 10),
                startDate: new Date().toISOString().substr(0, 10),
                finishDate: new Date().toISOString().substr(0, 10),
                dateFormatted: this.formatDate(new Date().toISOString().substr(0, 10)),
                dateFormatted2: this.formatDate(new Date().toISOString().substr(0, 10)),
                menu1: false,
                menu2: false,
                groupClassesData: [{
                    group: null,
                    theDepartment: "",
                    startDate: null,
                    finishDate: null,
                    teacherCode: null,
                    lessonType: null,
                    semester: null,
                    volume: null,
                    name: "",
                }],
                group: null,
                group1: null,
                theDepartment: "",
                // startDate: null,
                // finishDate: null,
                teacherCode: null,
                lessonType: null,
                lessonType1: null,
                semester: null,
                volume: null,
                dialogAll: false,
                name: "",
                name1: "",
                lessonTypeTest: [
                    {text: "Лекция"},
                    {text: "Семинар"},
                    {text: "Лабораторная"},
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
                headers: [
                    {text: "Номер группы", value: "group"},
                    {text: "Кафедра", value: "theDepartment"},
                    {text: "Дата начала", value: "startDate"},
                    {text: "Дата завершения", value: "finishDate"},
                    {text: "Код преподавателя", value: "teacherCode"},
                    {text: "Тип", value: "lessonType"},
                    {text: "Семестр", value: "semester"},
                    {text: "Объем", value: "volume"},
                    {text: "Название", value: "name"},
                ],
            }
        },
        watch: {
            startDate(val) {
                this.dateFormatted = this.formatDate(this.startDate)
            },
            finishDate(val) {
                this.dateFormatted2 = this.formatDate(this.finishDate)
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
            showAllGroupClasses() {
                const size = this.size;
                const page = this.page;
                this.$resource("/groupClasses/showAll").get({"page": page, "size": size}).then(result => {
                    result.json().then(data => {
                        this.pageCount = data.totalPages;
                        this.totalElements = data.totalElements;
                        this.groupClassesData = data.content;
                    })

                })
            },
            deleteGroupClassesById() {
                const groupNumber = this.group1;
                const lessonType = this.lessonType1;
                const lessonName = this.name1;
                this.$resource("/groupClasses/deleteGroupClassesById").delete({
                    "group": groupNumber,
                    "name": lessonName,
                    "type": lessonType
                }).then(result => {
                    alert("Done");
                })

            },
            createGroupClasses() {
                let groupClasses = {
                    group: this.group,
                    theDepartment: this.theDepartment,
                    startDate: this.startDate,
                    finishDate: this.finishDate,
                    teacherCode: this.teacherCode,
                    lessonType: this.lessonType,
                    semester: this.semester,
                    volume: this.volume,
                    name: this.name,
                };
                this.$resource("/groupClasses/createGroupClasses").save(groupClasses).then(result => {
                    alert("Done");
                })
            },
        }
    }
</script>

<style scoped>

</style>