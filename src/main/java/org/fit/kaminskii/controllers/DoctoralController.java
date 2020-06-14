package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.DoctoralService;
import org.fit.kaminskii.views.DoctoralView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api
@RestController
@RequestMapping("/doctorals")
public class DoctoralController {
    @Autowired
    private DoctoralService doctoralService;

    @GetMapping("/showAll")
    @ApiOperation("Show all doctorals")
    @ResponseBody
    public Page<DoctoralView> showDoctorals(int page, int size) {
        return doctoralService.showAll(page, size);
    }

    @GetMapping("/doctoralByFaculty")
    @ApiOperation("Show doctorals by the Faculty")
    @ResponseBody
    public Page<DoctoralView> showDoctoralsByFaculty(String faculty,int page, int size) {
        return doctoralService.findDoctoralByFaculty(faculty, page, size);
    }


    @GetMapping("/doctoralByTheDepartment")
    @ApiOperation("Show doctorals by the department")
    @ResponseBody
    public Page<DoctoralView> showDoctoralsByTheDepartment(String theDepartment,int page, int size) {
        return doctoralService.findDoctoralByTheDepartment(theDepartment, page, size);
    }

    @PostMapping("/createDoctoral")
    @ApiOperation("Create doctoral")
    public String createDoctoral(@Valid @RequestBody DoctoralView doctoral) {
        doctoralService.create(doctoral);
        return "DoctoralView added";
    }

    @DeleteMapping("/deleteDoctoralById")
    @ApiOperation("Delete doctoral")
    public String deleteDoctoralById(String id) {
        doctoralService.deleteById(id);
        return "DoctoralView deleted";
    }
}