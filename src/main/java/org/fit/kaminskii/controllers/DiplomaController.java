package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.DiplomaService;
import org.fit.kaminskii.views.DiplomaView;
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
@RequestMapping("/diplomas")
public class DiplomaController {
    @Autowired
    private DiplomaService diplomaService;

    @GetMapping("/showAll")
    @ApiOperation("Show all diplomas")
    @ResponseBody
    public List<DiplomaView> showDiplomas() {
        return diplomaService.showAll();
    }

    @PostMapping("/createDiploma")
    @ApiOperation("Create diploma")
    public ResponseEntity<String> createDiploma(@Valid @RequestBody DiplomaView diploma) {
        diplomaService.create(diploma);
        return ResponseEntity.status(HttpStatus.CREATED).body("DiplomaView added");
    }

    @DeleteMapping("/deleteDiplomaById")
    @ApiOperation("Delete diploma")
    public ResponseEntity<String> deleteDiplomaById(int id) {
        diplomaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("DiplomaView deleted");
    }
}