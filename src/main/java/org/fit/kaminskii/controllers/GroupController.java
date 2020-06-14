package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fit.kaminskii.services.GroupService;
import org.fit.kaminskii.views.GroupView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api
@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/showAll")
    @ApiOperation("Show all groups")
    @ResponseBody
    public Page<GroupView> showGroups(int page, int size) {
        return groupService.showAll(page, size);
    }

    @PostMapping("/createGroup")
    public String createGroup(@Valid @RequestBody GroupView group) {
        groupService.create(group);
        return "GroupView added";
    }

    @DeleteMapping("/deleteGroupById")
    @ApiOperation("Delete group")
    public String deleteGroupById(@RequestParam int id) {
        groupService.deleteById(id);
        return "GroupView deleted";
    }
}