package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.services.StudentService;
import org.fit.kaminskii.views.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


@Api
@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/showAll")
    @ApiOperation("Show all students")
    @ResponseBody
    public List<StudentView> showStudents() {
        return studentService.showAll();
    }

    @GetMapping("/studentById")
    @ApiOperation("Show student by id")
    @ResponseBody
    public ResponseEntity<StudentView> studentByName(int id) {
        StudentView answer = studentService.findById(id);
        if (answer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @PostMapping("/createStudent")
    @ApiOperation("Create student")
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentView student) {
        studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("StudentView added");
    }


    @GetMapping("/studentsByGroup")
    @ApiOperation("Show students by group")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsByGroup(int group) {
        List<StudentView> students = studentService.findByGroup(group);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByCourse")
    @ApiOperation("Show students by course")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsByCourse(int course) {
        List<StudentView> students = studentService.findByCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsBySex")
    @ApiOperation("Show students by sex")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsBySex(Sex sex) {
        List<StudentView> students = studentService.findBySex(sex);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByName")
    @ApiOperation("Show students by name")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsByName(String secondName, String firstName, String thirdName) {
        List<StudentView> students = studentService.findByName(secondName, firstName, thirdName);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByBirthday")
    @ApiOperation("Show students by birthday")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsByBirthday(Date birthday) {
        List<StudentView> students = studentService.findByBirthday(birthday);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByAge")
    @ApiOperation("Show students by age")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsByAge(int age) {
        List<StudentView> students = studentService.findByAge(age);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByChildren")
    @ApiOperation("Show students by children")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsByChildren(int numberOfChildren) {
        List<StudentView> students = studentService.findByChildren(numberOfChildren);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByGrants")
    @ApiOperation("Show students by grants")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsByGrants(BigDecimal grants) {
        List<StudentView> students = studentService.findByGrants(grants);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByFaculty")
    @ApiOperation("Show students by faculty")
    @ResponseBody
    public ResponseEntity<List<StudentView>> showStudentsByFaculty(String faculty) {
        List<StudentView> students = studentService.findByFaculty(faculty);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }


    @DeleteMapping("/deleteStudentById")
    @ApiOperation("Delete student")
    public ResponseEntity<String> deleteStudentById(int id) {
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("StudentView deleted");
    }

    @GetMapping("/StudentByGroupNumberAndSubjectAndMark")
    @ApiOperation("Show students by the group number and subject and mark")
    @ResponseBody
    public ResponseEntity<List<StudentView>> findStudentByGroupNumberAndSubjectAndMark(int groupNumber, String subject, int mark) {
        List<StudentView> departments = studentService.findStudentByGroupNumberAndSubjectAndMark(groupNumber, subject, mark);
        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    @GetMapping("/StudentByGroupAndTeacherAndMarkAndSubjectAndSemester")
    @ApiOperation("Show students by the group number and teacher code and subject and mark")
    @ResponseBody
    public ResponseEntity<List<StudentView>> findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(int groupNumber, int teacherCode, String subject, int mark) {
        List<StudentView> departments = studentService.findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(groupNumber, teacherCode, subject, mark);
        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    @GetMapping("/StudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester")
    @ApiOperation("Show students by the group number and teacher name and subject and mark")
    @ResponseBody
    public ResponseEntity<List<StudentView>> findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(int groupNumber, String firstName, String secondName, String thirdName, String subject, int mark) {
        List<StudentView> departments = studentService.findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(groupNumber, firstName, secondName, thirdName, subject, mark);
        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }
}