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
    private GroupClassesRepo groupclassesRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<GroupClassesView> showAll(){
        Iterable<GroupClassesEntity> groupclasseslist = groupclassesRepo.findAll();
        List<GroupClassesView> groupclasses = new ArrayList<>();
        for(GroupClassesEntity groupclassesEntity:groupclasseslist){
            groupclasses.add(mapper4database.toGroupClassesView(groupclassesEntity));
        }
        return groupclasses;
    }
    public void createGroupClasses(GroupClassesView groupclasses){
        GroupClassesEntity groupclassesEntity = new GroupClassesEntity();
        mapper4database.toGroupClassesEntity(groupclasses, groupclassesEntity);
        groupclassesRepo.save(groupclassesEntity);
    }

    public void deleteGroupClassesById(int id){
        groupclassesRepo.deleteById(id);
    }
}
