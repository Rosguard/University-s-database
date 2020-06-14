package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.model.LessonType;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.model.Category;
import org.fit.kaminskii.services.TeacherService;
import org.fit.kaminskii.views.TeacherView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;



@Api
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/showAll")
    @ApiOperation("Show all teachers")
    @ResponseBody
    public Page<TeacherView> showTeachers(int page, int size) {
        return teacherService.showAll(page, size);
    }

    @GetMapping("/teacherById")
    @ApiOperation("Show teacher by id")
    @ResponseBody
    public TeacherView teacherById(int id) {
        return teacherService.findById(id);
    }

    @PostMapping("/createTeacher")
    @ApiOperation("Create teacher")
    public String createTeacher(@Valid @RequestBody TeacherView teacher) {
        teacherService.create(teacher);
        return "TeacherView added";
    }

    @DeleteMapping("/deleteTeacherById")
    @ApiOperation("Delete teacher")
    public String deleteTeacherById(@RequestParam int id) {
        teacherService.deleteById(id);
        return "TeacherView deleted";
    }

    @GetMapping("/teachersBySex")
    @ApiOperation("Show teachers by sex")
    @ResponseBody
    public Page<TeacherView> showTeachersBySex(@RequestParam Sex sex, int page, int size) {
        return teacherService.findBySex(sex, page, size);
    }

    @GetMapping("/teachersByCategory")
    @ApiOperation("Show teachers by category")
    @ResponseBody
    public Page<TeacherView> showTeachersByCategory(Category category, int page, int size) {
        return teacherService.findByCategory(category, page, size);
    }

    @GetMapping("/teachersByName")
    @ApiOperation("Show teachers by name")
    @ResponseBody
    public Page<TeacherView> showTeachersByName(String secondName, String firstName, String thirdName, int page, int size) {
        return teacherService.findByName(secondName, firstName, thirdName, page, size);
    }

    @GetMapping("/teachersByBirthday")
    @ApiOperation("Show teachers by birthday")
    @ResponseBody
    public Page<TeacherView> showTeachersByBirthday(Date birthday, int page, int size) {
        return teacherService.findByBirthday(birthday, page, size);
    }

    @GetMapping("/teachersByAge")
    @ApiOperation("Show teachers by age")
    @ResponseBody
    public Page<TeacherView> showTeachersByAge(int age, int page, int size) {
        return teacherService.findByAge(age, page, size);
    }

    @GetMapping("/teachersByChildren")
    @ApiOperation("Show teachers by children")
    @ResponseBody
    public Page<TeacherView> showTeachersByChildren(int numberOfChildren, int page, int size) {
        return teacherService.findByChildren(numberOfChildren, page, size);
    }


    @GetMapping("/teachersBySalary")
    @ApiOperation("Show teachers by salary")
    @ResponseBody
    public Page<TeacherView> showTeachersBySalary(BigDecimal salary, int page, int size) {
        return teacherService.findBySalary(salary, page, size);
    }

    @GetMapping("/TeacherByLessonNameAndGroupNumber")
    @ApiOperation("Show teachers by lesson name and group number")
    @ResponseBody
    public Page<TeacherView> findTeacherByLessonNameAndGroupNumber(String lessonName, int groupNumber, int page, int size) {
        return teacherService.findTeacherByLessonNameAndGroupNumber(lessonName, groupNumber, page, size);
    }

    @GetMapping("/TeacherCourseAndFaculty")
    @ApiOperation("Show teachers by the course and faculty")
    @ResponseBody
    public Page<TeacherView> showTeacherByCourseAndFaculty(int course, String faculty, int page, int size) {
        return teacherService.findTeacherByCourseAndFaculty(course, faculty, page, size);
    }

    @GetMapping("/TeacherByLessonTypeAndGroupNumber")
    @ApiOperation("Show teachers by lesson type and group number")
    @ResponseBody
    public Page<TeacherView> findTeacherByLessonTypeAndGroupNumber(LessonType lessonType, int groupNumber, int page, int size) {
        return teacherService.findTeacherByLessonTypeAndGroupNumber(lessonType, groupNumber, page, size);
    }

    @GetMapping("/TeacherCourseAndFacultyAndSemester")
    @ApiOperation("Show teachers by the course and faculty and semester")
    @ResponseBody
    public Page<TeacherView> showTeacherByCourseAndFacultyAndSemester(int course, String faculty, int semester, int page, int size) {
        return teacherService.findTeacherByCourseAndFacultyAndSemester(course, faculty, semester, page, size);
    }

    @GetMapping("/TeacherByGroupAndSubjectAndSemester")
    @ApiOperation("Show teachers by the group and subject and semester")
    @ResponseBody
    public Page<TeacherView> findTeacherByGroupAndSubjectAndSemester(int groupNumber, String subject, int semester, int page, int size) {
        return teacherService.findTeacherByGroupAndSubjectAndSemester(groupNumber, subject, semester, page, size);
    }
}