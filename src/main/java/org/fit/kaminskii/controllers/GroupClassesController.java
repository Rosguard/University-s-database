package org.fit.kaminskii.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.fit.kaminskii.domain.GroupClassesEntityPK;
import org.fit.kaminskii.model.LessonType;
import org.fit.kaminskii.services.GroupClassesService;
import org.fit.kaminskii.services.GroupService;
import org.fit.kaminskii.views.GroupClassesView;
import org.fit.kaminskii.views.GroupView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api
@RestController
@AllArgsConstructor
@RequestMapping("/groupClasses")
public class GroupClassesController {
    private final GroupClassesService groupClassesService;

    @GetMapping("/showAll")
    @ApiOperation("Show all group classes")
    @ResponseBody
    public Page<GroupClassesView> showGroups(int page, int size) {
        return groupClassesService.showAll(page, size);
    }

    @PostMapping("/createGroupClasses")
    public String createGroup(@Valid @RequestBody GroupClassesView group) {
        groupClassesService.create(group);
        return "GroupView added";
    }

    @DeleteMapping("/deleteGroupClassesById")
    @ApiOperation("Delete group")
    public String deleteGroupById(int group, String name, LessonType type) {
        groupClassesService.deleteById(group, name, type);
        return "GroupView deleted";
    }
}