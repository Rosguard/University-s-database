package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.domain.StudentRecordEntityPK;
import org.fit.kaminskii.services.StudentRecordService;
import org.fit.kaminskii.views.StudentRecordView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api
@RestController
@RequestMapping("/studentRecords")
public class StudentRecordController {
    @Autowired
    private StudentRecordService studentRecordService;

    @GetMapping("/showAll")
    @ApiOperation("Show all studentRecords")
    @ResponseBody
    public Page<StudentRecordView> showStudentRecords(int page, int size) {
        return studentRecordService.showAll(page, size);
    }

    @PostMapping("/createStudentRecord")
    @ApiOperation("Create studentRecord")
    public String createStudentRecord(@Valid @RequestBody StudentRecordView studentRecord) {
        studentRecordService.create(studentRecord);
        return "StudentRecordView added";
    }

    @DeleteMapping("/deleteStudentRecordById")
    @ApiOperation("Delete studentRecord")
    public String deleteStudentRecordById(int studentCode, String subject) {
        studentRecordService.deleteById(studentCode, subject);
        return "StudentRecordView deleted";
    }
}