package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.services.StudentService;
import org.fit.kaminskii.views.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;


@Api
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/showAll")
    @ApiOperation("Show all students")
    @ResponseBody
    public Page<StudentView> showStudents(int page, int size) {
        return studentService.showAll(page, size);
    }

    @GetMapping("/studentById")
    @ApiOperation("Show student by id")
    @ResponseBody
    public StudentView studentById(@RequestParam int id) {
        return studentService.findById(id);
//        return answer;
    }

    @GetMapping("/studentsByGroup")
    @ApiOperation("Show students by group")
    @ResponseBody
    public Page<StudentView> showStudentsByGroup(@RequestParam int group, int page, int size) {
//        Page<StudentView> students = studentService.findByGroup(group);
//        return students;
        return studentService.findByGroup(group, page, size);
    }

    @GetMapping("/studentsByCourse")
    @ApiOperation("Show students by course")
    @ResponseBody
    public Page<StudentView> showStudentsByCourse(@RequestParam int course, int page, int size) {
        return studentService.findByCourse(course, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsBySex")
    @ApiOperation("Show students by sex")
    @ResponseBody
    public Page<StudentView> showStudentsBySex(@RequestParam Sex sex, int page, int size) {
        return studentService.findBySex(sex, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByName")
    @ApiOperation("Show students by name")
    @ResponseBody
    public Page<StudentView> showStudentsByName(@RequestParam String secondName, @RequestParam String firstName, @RequestParam String thirdName, int page, int size) {
        return studentService.findByName(secondName, firstName, thirdName, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByBirthday")
    @ApiOperation("Show students by birthday")
    @ResponseBody
    public Page<StudentView> showStudentsByBirthday(@RequestParam Date birthday, int page, int size) {
        return studentService.findByBirthday(birthday, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByAge")
    @ApiOperation("Show students by age")
    @ResponseBody
    public Page<StudentView> showStudentsByAge(@RequestParam int age, int page, int size) {
        return studentService.findByAge(age, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByChildren")
    @ApiOperation("Show students by children")
    @ResponseBody
    public Page<StudentView> showStudentsByChildren(@RequestParam int numberOfChildren, int page, int size) {
        return studentService.findByChildren(numberOfChildren, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByGrants")
    @ApiOperation("Show students by grants")
    @ResponseBody
    public Page<StudentView> showStudentsByGrants(@RequestParam BigDecimal grants, int page, int size) {
        return studentService.findByGrants(grants, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/studentsByFaculty")
    @ApiOperation("Show students by faculty")
    @ResponseBody
    public Page<StudentView> showStudentsByFaculty(@RequestParam String faculty, int page, int size) {
        return studentService.findByFaculty(faculty, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @PostMapping("/createStudent")
    @ApiOperation("Create student")
    public String createStudent(@Valid @RequestBody StudentView student) {
        studentService.create(student);
//        return ResponseEntity.status(HttpStatus.CREATED).body("StudentView added");
        return "StudentView added";
    }

    @DeleteMapping("/deleteStudentById")
    @ApiOperation("Delete student")
    public ResponseEntity<String> deleteStudentById(int id) {
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("StudentView deleted");
    }

    @GetMapping("/studentByGroupNumberAndSubjectAndMark")
    @ApiOperation("Show students by the group number and subject and mark")
    @ResponseBody
    public Page<StudentView> findStudentByGroupNumberAndSubjectAndMark(@RequestParam int groupNumber,
                                                                       @RequestParam String subject,
                                                                       @RequestParam int mark, int page, int size) {
        return studentService.findStudentByGroupNumberAndSubjectAndMark(groupNumber, subject, mark, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    @GetMapping("/studentByGroupAndTeacherAndMarkAndSubjectAndSemester")
    @ApiOperation("Show students by the group number and teacher code and subject and mark and semester")
    @ResponseBody
    public Page<StudentView> findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(@RequestParam int groupNumber,
                                                                                          @RequestParam int teacherCode,
                                                                                          @RequestParam String subject,
                                                                                          @RequestParam int mark,
                                                                                          @RequestParam int semester, int page, int size) {
        return studentService.findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(groupNumber, teacherCode, subject, mark, semester, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }

    @GetMapping("/studentByGroupAndTeacherNameAndMarkAndSubjectAndSemester")
    @ApiOperation("Show students by the group number and teacher name and subject and semester")
    @ResponseBody
    public Page<StudentView> findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(@RequestParam int groupNumber,
                                                                                          @RequestParam String firstName,
                                                                                          @RequestParam String secondName,
                                                                                          @RequestParam String thirdName,
                                                                                          @RequestParam String subject,
                                                                                          @RequestParam int semester, int page, int size) {
        return studentService.findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(groupNumber, firstName, secondName, thirdName, subject, semester, page, size);
//        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }
}