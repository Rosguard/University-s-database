package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.TheDepartmentService;
import org.fit.kaminskii.views.TheDepartmentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api
@RestController
@RequestMapping("/thedepartments")
public class TheDepartmentController {
    private final TheDepartmentService thedepartmentService;

    public TheDepartmentController(TheDepartmentService thedepartmentService) {
        this.thedepartmentService = thedepartmentService;
    }

    @GetMapping("/showAll")
    @ResponseBody
    public Page<TheDepartmentView> showTheDepartments(int page, int size) {
        Page<TheDepartmentView> theDepartmentViews = thedepartmentService.showAll(page, size);
        return theDepartmentViews;
    }

    @PostMapping("/createTheDepartment")
    public String create(@Valid @RequestBody TheDepartmentView thedepartment) {
        thedepartmentService.create(thedepartment);
        return "TheDepartmentView added";
    }

    @DeleteMapping("/deleteTheDepartmentById")
    public String deleteByName(String name) {
        thedepartmentService.deleteByName(name);
        return "TheDepartmentView deleted";
    }


    @GetMapping("/TheDepartmentByGroupNumber")
    @ResponseBody
    public Page<TheDepartmentView> showTheDepartmentByGroupNumber(int groupNumber, int page, int size) {
        return thedepartmentService.findTheDepartmentByGroupNumber(groupNumber, page, size);
    }

    @GetMapping("/TheDepartmentByCourse")
    @ResponseBody
    public Page<TheDepartmentView> showTheDepartmentByCourse(int course, int page, int size) {
        return thedepartmentService.findTheDepartmentByCourse(course, page, size);
    }

    @GetMapping("/TheDepartmentBySemester")
    @ResponseBody
    public Page<TheDepartmentView> showTheDepartmentBySemester(int semester, int page, int size) {
        return thedepartmentService.findTheDepartmentBySemester(semester, page, size);
    }
}