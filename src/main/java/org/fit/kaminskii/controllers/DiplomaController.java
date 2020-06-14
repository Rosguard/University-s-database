package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.DiplomaService;
import org.fit.kaminskii.views.DiplomaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api
@RestController
@RequestMapping("/diplomas")
public class DiplomaController {
    @Autowired
    private DiplomaService diplomaService;

    @GetMapping("/showAll")
    @ApiOperation("Show all diplomas")
    @ResponseBody
    public Page<DiplomaView> showDiplomas(int page, int size) {
        return diplomaService.showAll(page, size);
    }

    @PostMapping("/createDiploma")
    @ApiOperation("Create diploma")
    public String createDiploma(@Valid @RequestBody DiplomaView diploma) {
        diplomaService.create(diploma);
        return "DiplomaView added";
    }

    @DeleteMapping("/deleteDiplomaById")
    @ApiOperation("Delete diploma")
    public String deleteDiplomaById(int id) {
        diplomaService.deleteById(id);
        return "DiplomaView deleted";
    }
}