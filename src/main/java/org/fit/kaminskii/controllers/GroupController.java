package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.GroupService;
import org.fit.kaminskii.views.GroupView;
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
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/showAll")
    @ApiOperation("Show all groups")
    @ResponseBody
    public List<GroupView> showGroups() {
        return groupService.showAll();
    }

    @PostMapping("/createGroup")
    @ApiOperation("Create group")
    public ResponseEntity<String> createGroup(@Valid @RequestBody GroupView group) {
        groupService.create(group);
        return ResponseEntity.status(HttpStatus.CREATED).body("GroupView added");
    }

    @DeleteMapping("/deleteGroupById")
    @ApiOperation("Delete group")
    public ResponseEntity<String> deleteGroupById(int id) {
        groupService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("GroupView deleted");
    }
}