package org.fit.kaminskii.services;


import org.fit.kaminskii.domain.GroupClassesEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.GroupClassesView;
import org.fit.kaminskii.repositories.GroupClassesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GroupClassesService {
    @Autowired
    private GroupClassesRepo groupClassesRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<GroupClassesView> showAll() {
        Iterable<GroupClassesEntity> groupClassesList = groupClassesRepo.findAll();
        List<GroupClassesView> groupClasses = new ArrayList<>();
        for (GroupClassesEntity groupclassesEntity : groupClassesList) {
            groupClasses.add(mapper4database.toGroupClassesView(groupclassesEntity));
        }
        return groupClasses;
    }

    public void create(GroupClassesView groupClasses) {
        GroupClassesEntity groupclassesEntity = new GroupClassesEntity();
        mapper4database.toGroupClassesEntity(groupClasses, groupclassesEntity);
        groupClassesRepo.save(groupclassesEntity);
    }

    public void deleteById(int id) {
        groupClassesRepo.deleteById(id);
    }
}
