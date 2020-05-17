package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.model.TeacherCategory;
import org.fit.kaminskii.services.TeacherService;
import org.fit.kaminskii.views.TeacherView;
import org.fit.kaminskii.views.TeacherView;
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
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/showAll")
    @ApiOperation("Show all teachers")
    @ResponseBody
    public List<TeacherView> showTeachers() {
        return teacherService.showAll();
    }

    @GetMapping("/teacherById")
    @ApiOperation("Show teacher by id")
    @ResponseBody
    public ResponseEntity<TeacherView> teacherByName(int id) {
        TeacherView answer = teacherService.findById(id);
        if(answer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @PostMapping("/createTeacher")
    @ApiOperation("Create teacher")
    public ResponseEntity<String> createTeacher(@Valid @RequestBody TeacherView teacher){
        teacherService.create(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body("TeacherView added");
    }

    @DeleteMapping("/deleteTeacherById")
    @ApiOperation("Delete teacher")
    public ResponseEntity<String> deleteTeacherById(int id){
        teacherService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("TeacherView deleted");
    }
    @GetMapping("/teachersBySex")
    @ApiOperation("Show teachers by sex")
    @ResponseBody
    public ResponseEntity<List<TeacherView>> showTeachersBySex(Sex sex) {
        List<TeacherView> teachers = teacherService.findBySex(sex);
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }
    @GetMapping("/teachersByCategory")
    @ApiOperation("Show teachers by category")
    @ResponseBody
    public ResponseEntity<List<TeacherView>> showTeachersByCategory(TeacherCategory category) {
        List<TeacherView> teachers = teacherService.findByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }

    @GetMapping("/teachersByName")
    @ApiOperation("Show teachers by name")
    @ResponseBody
    public ResponseEntity<List<TeacherView>> showTeachersByName(String secondName, String firstName, String thirdName) {
        List<TeacherView> teachers = teacherService.findByName(secondName, firstName, thirdName);
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }

    @GetMapping("/teachersByBirthday")
    @ApiOperation("Show teachers by birthday")
    @ResponseBody
    public ResponseEntity<List<TeacherView>> showTeachersByBirthday(Date birthday) {
        List<TeacherView> teachers = teacherService.findByBirthday(birthday);
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }

    @GetMapping("/teachersByAge")
    @ApiOperation("Show teachers by age")
    @ResponseBody
    public ResponseEntity<List<TeacherView>> showTeachersByAge(int age) {
        List<TeacherView> teachers = teacherService.findByAge(age);
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }
    @GetMapping("/teachersByChildren")
    @ApiOperation("Show teachers by children")
    @ResponseBody
    public ResponseEntity<List<TeacherView>> showTeachersByChildren(int numberOfChildren) {
        List<TeacherView> teachers = teacherService.findByChildren(numberOfChildren);
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }
    @GetMapping("/teachersWithChildren")
    @ApiOperation("Show teachers with children")
    @ResponseBody
    public ResponseEntity<List<TeacherView>> showTeachersByChildrenIsNotNull() {
        List<TeacherView> teachers = teacherService.findByChildrenIsNotNull();
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }
    @GetMapping("/teachersBySalary")
    @ApiOperation("Show teachers by salary")
    @ResponseBody
    public ResponseEntity<List<TeacherView>> showTeachersBySalary(BigDecimal salary) {
        List<TeacherView> teachers = teacherService.findBySalary(salary);
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }
    
}