package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.TheDepartmentService;
import org.fit.kaminskii.views.CandidateView;
import org.fit.kaminskii.views.TheDepartmentView;
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
@RequestMapping("/thedepartments")
public class TheDepartmentController {
    @Autowired
    private TheDepartmentService thedepartmentService;

    @GetMapping("/showAll")
    @ApiOperation("Show all thedepartments")
    @ResponseBody
    public List<TheDepartmentView> showTheDepartments() {
        return thedepartmentService.showAll();
    }

    @PostMapping("/createTheDepartment")
    @ApiOperation("Create thedepartment")
    public ResponseEntity<String> create(@Valid @RequestBody TheDepartmentView thedepartment){
        thedepartmentService.create(thedepartment);
        return ResponseEntity.status(HttpStatus.CREATED).body("TheDepartmentView added");
    }

    @DeleteMapping("/deleteTheDepartmentById")
    @ApiOperation("Delete thedepartment")
    public ResponseEntity<String> deleteByName(int name){
        thedepartmentService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).body("TheDepartmentView deleted");
    }


    @GetMapping("/TheDepartmentByGroupNumber")
    @ApiOperation("Show candidates by the group number")
    @ResponseBody
    public ResponseEntity<List<TheDepartmentView>> showTheDepartmentByGroupNumber(int groupNumber) {
        List<TheDepartmentView> departments = thedepartmentService.findTheDepartmentByGroupNumber(groupNumber);
        return ResponseEntity.status(HttpStatus.OK).body(departments);
    }
}