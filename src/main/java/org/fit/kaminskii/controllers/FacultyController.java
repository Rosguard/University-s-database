package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.FacultyService;
import org.fit.kaminskii.views.FacultyView;
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
@RequestMapping("/facultys")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/showAll")
    @ApiOperation("Show all facultys")
    @ResponseBody
    public List<FacultyView> showFacultys() {
        return facultyService.showAll();
    }

    @PostMapping("/createFaculty")
    @ApiOperation("Create faculty")
    public ResponseEntity<String> createFaculty(@Valid @RequestBody FacultyView faculty) {
        facultyService.create(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).body("FacultyView added");
    }

    @DeleteMapping("/deleteFacultyById")
    @ApiOperation("Delete faculty")
    public ResponseEntity<String> deleteFacultyById(int id) {
        facultyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("FacultyView deleted");
    }
}