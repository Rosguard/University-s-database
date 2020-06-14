package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.CandidateService;
import org.fit.kaminskii.views.CandidateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api
@RestController
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/showAll")
    @ApiOperation("Show all candidates")
    @ResponseBody
    public Page<CandidateView> showCandidates(int page, int size) {
        return candidateService.showAll(page, size);
    }

    @GetMapping("/candidateByFaculty")
    @ApiOperation("Show candidates by the Faculty")
    @ResponseBody
    public Page<CandidateView> showCandidatesByFaculty(String faculty, int page, int size) {
        return candidateService.findCandidateByFaculty(faculty, page, size);
    }


    @GetMapping("/candidateByTheDepartment")
    @ApiOperation("Show candidates by the department")
    @ResponseBody
    public Page<CandidateView> showCandidatesByTheDepartment(String theDepartment, int page, int size) {
        return candidateService.findCandidateByTheDepartment(theDepartment, page, size);
    }

    @PostMapping("/createCandidate")
    @ApiOperation("Create candidate")
    public String createCandidate(@Valid @RequestBody CandidateView candidate) {
        candidateService.create(candidate);
        return "CandidateView added";
    }

    @DeleteMapping("/deleteCandidateById")
    @ApiOperation("Delete candidate")
    public String deleteCandidateById(String id) {
        candidateService.deleteById(id);
        return "CandidateView deleted";
    }
}