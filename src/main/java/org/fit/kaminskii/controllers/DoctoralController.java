package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.DoctoralService;
import org.fit.kaminskii.views.DoctoralView;
import org.fit.kaminskii.views.DoctoralView;
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
@RequestMapping("/doctorals")
public class DoctoralController {
    @Autowired
    private DoctoralService doctoralService;

    @GetMapping("/showAll")
    @ApiOperation("Show all doctorals")
    @ResponseBody
    public List<DoctoralView> showDoctorals() {
        return doctoralService.showAll();
    }

    @GetMapping("/doctoralByFaculty")
    @ApiOperation("Show doctorals by the Faculty")
    @ResponseBody
    public ResponseEntity<List<DoctoralView>> showDoctoralsByFaculty(String Faculty) {
        List<DoctoralView> doctorals = doctoralService.findDoctoralByFaculty(Faculty);
        return ResponseEntity.status(HttpStatus.OK).body(doctorals);
    }


    @GetMapping("/doctoralByTheDepartment")
    @ApiOperation("Show doctorals by the department")
    @ResponseBody
    public ResponseEntity<List<DoctoralView>> showDoctoralsByTheDepartment(String department) {
        List<DoctoralView> doctorals = doctoralService.findDoctoralByTheDepartment(department);
        return ResponseEntity.status(HttpStatus.OK).body(doctorals);
    }

    @PostMapping("/createDoctoral")
    @ApiOperation("Create doctoral")
    public ResponseEntity<String> createDoctoral(@Valid @RequestBody DoctoralView doctoral){
        doctoralService.create(doctoral);
        return ResponseEntity.status(HttpStatus.CREATED).body("DoctoralView added");
    }

    @DeleteMapping("/deleteDoctoralById")
    @ApiOperation("Delete doctoral")
    public ResponseEntity<String> deleteDoctoralById(int id){
        doctoralService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("DoctoralView deleted");
    }
}