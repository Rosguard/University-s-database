package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.CandidateService;
import org.fit.kaminskii.views.CandidateView;
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
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/showAll")
    @ApiOperation("Show all candidates")
    @ResponseBody
    public List<CandidateView> showCandidates() {
        return candidateService.showAll();
    }

    @GetMapping("/candidateByFaculty")
    @ApiOperation("Show candidates by the Faculty")
    @ResponseBody
    public ResponseEntity<List<CandidateView>> showCandidatesByFaculty(String Faculty) {
        List<CandidateView> candidates = candidateService.findCandidateByFaculty(Faculty);
        return ResponseEntity.status(HttpStatus.OK).body(candidates);
    }


    @GetMapping("/candidateByTheDepartment")
    @ApiOperation("Show candidates by the department")
    @ResponseBody
    public ResponseEntity<List<CandidateView>> showCandidatesByTheDepartment(String department) {
        List<CandidateView> candidates = candidateService.findCandidateByTheDepartment(department);
        return ResponseEntity.status(HttpStatus.OK).body(candidates);
    }

    @PostMapping("/createCandidate")
    @ApiOperation("Create candidate")
    public ResponseEntity<String> createCandidate(@Valid @RequestBody CandidateView candidate) {
        candidateService.create(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body("CandidateView added");
    }

    @DeleteMapping("/deleteCandidateById")
    @ApiOperation("Delete candidate")
    public ResponseEntity<String> deleteCandidateById(String id) {
        candidateService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("CandidateView deleted");
    }
}