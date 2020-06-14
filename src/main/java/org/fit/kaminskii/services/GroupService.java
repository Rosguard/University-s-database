package org.fit.kaminskii.services;

import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.domain.GroupEntity;
import org.fit.kaminskii.domain.StudentEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.repositories.FacultyRepo;
import org.fit.kaminskii.views.GroupView;
import org.fit.kaminskii.repositories.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private Mapper4database mapper4database;
    @Autowired
    private FacultyRepo facultyRepo;

    public Page<GroupView> showAll(int page, int size) {
        Page<GroupEntity> groupPage = groupRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toGroupPage(groupPage);
//        Iterable<GroupEntity> grouplist = groupRepo.findAll();
//        Page<GroupView> group = new ArrayList<>();
//        for (GroupEntity groupEntity : grouplist) {
//            group.add(mapper4database.toGroupView(groupEntity));
//        }
//        return group;
    }

    public boolean create(GroupView group) {
        GroupEntity groupEntity = new GroupEntity();
        mapper4database.toGroupEntity(group, groupEntity);
        FacultyEntity facultyEntity = facultyRepo.findById(group.getFaculty()).orElse(null);
        if (facultyEntity == null)
            return false;
        groupEntity.setFacultyByFaculty(facultyEntity);
        groupRepo.save(groupEntity);
        return true;
    }

    public void deleteById(int id) {
        groupRepo.deleteById(id);
    }
}
