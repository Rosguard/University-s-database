package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.domain.StudentRecordEntityPK;
import org.fit.kaminskii.services.StudentRecordService;
import org.fit.kaminskii.views.StudentRecordView;
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
import java.util.List;


@Api
@Controller
@RequestMapping("/studentRecords")
public class StudentRecordController {
    @Autowired
    private StudentRecordService studentRecordService;

    @GetMapping("/showAll")
    @ApiOperation("Show all studentRecords")
    @ResponseBody
    public List<StudentRecordView> showStudentRecords() {
        return studentRecordService.showAll();
    }

    @PostMapping("/createStudentRecord")
    @ApiOperation("Create studentRecord")
    public ResponseEntity<String> createStudentRecord(@Valid @RequestBody StudentRecordView studentRecord) {
        studentRecordService.create(studentRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body("StudentRecordView added");
    }

    @DeleteMapping("/deleteStudentRecordById")
    @ApiOperation("Delete studentRecord")
    public ResponseEntity<String> deleteStudentRecordById(StudentRecordEntityPK id) {
        studentRecordService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("StudentRecordView deleted");
    }
}