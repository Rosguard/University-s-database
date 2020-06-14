package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.FacultyService;
import org.fit.kaminskii.views.FacultyView;
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
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/showAll")
    @ResponseBody
    public Page<FacultyView> showFaculties(int page, int size) {
        return facultyService.showAll(page, size);
    }

    @PostMapping("/createFaculty")
    @ApiOperation("Create faculty")
    public String createFaculty(@Valid @RequestBody FacultyView faculty) {
        facultyService.create(faculty);
        return "FacultyView added";
    }

    @DeleteMapping("/deleteFacultyById")
    @ApiOperation("Delete faculty")
    public String deleteFacultyById(@RequestParam String id) {
        facultyService.deleteById(id);
        return "FacultyView deleted";
    }
}