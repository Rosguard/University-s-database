package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.GroupClassesService;
import org.fit.kaminskii.views.GroupClassesView;
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
@RequestMapping("/groupClassess")
public class GroupClassesController {
//    @Autowired
//    private GroupClassesService groupClassesService;
//
//    @GetMapping("/showAll")
//    @ApiOperation("Show all groupClassess")
//    @ResponseBody
//    public List<GroupClassesView> showGroupClassess() {
//        return groupClassesService.showAll();
//    }
//
//    @PostMapping("/createGroupClasses")
//    @ApiOperation("Create groupClasses")
//    public ResponseEntity<String> createGroupClasses(@Valid @RequestBody GroupClassesView groupClasses) {
//        groupClassesService.create(groupClasses);
//        return ResponseEntity.status(HttpStatus.CREATED).body("GroupClassesView added");
//    }
//
//    @DeleteMapping("/deleteGroupClassesById")
//    @ApiOperation("Delete groupClasses")
//    public ResponseEntity<String> deleteGroupClassesById(int id) {
//        groupClassesService.deleteById(id);
//        return ResponseEntity.status(HttpStatus.OK).body("GroupClassesView deleted");
//    }
}