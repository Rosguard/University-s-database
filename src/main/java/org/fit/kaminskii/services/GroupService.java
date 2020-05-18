package org.fit.kaminskii.services;

import org.fit.kaminskii.domain.GroupEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.GroupView;
import org.fit.kaminskii.repositories.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<GroupView> showAll() {
        Iterable<GroupEntity> grouplist = groupRepo.findAll();
        List<GroupView> group = new ArrayList<>();
        for (GroupEntity groupEntity : grouplist) {
            group.add(mapper4database.toGroupView(groupEntity));
        }
        return group;
    }

    public void create(GroupView group) {
        GroupEntity groupEntity = new GroupEntity();
        mapper4database.toGroupEntity(group, groupEntity);
        groupRepo.save(groupEntity);
    }

    public void deleteById(int id) {
        groupRepo.deleteById(id);
    }
}
