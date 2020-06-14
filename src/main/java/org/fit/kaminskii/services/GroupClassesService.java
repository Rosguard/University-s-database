package org.fit.kaminskii.services;


import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.*;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.model.LessonType;
import org.fit.kaminskii.repositories.*;
import org.fit.kaminskii.views.GroupClassesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class GroupClassesService {
    @Autowired
    private GroupClassesRepo groupClassesRepo;
    @Autowired
    private Mapper4database mapper4database;
    @Autowired
    private TheDepartmentRepo theDepartmentRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private GroupRepo groupRepo;

    public Page<GroupClassesView> showAll(int page, int size) {
        Page<GroupClassesEntity> groupClassesPage = groupClassesRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toGroupClassesPage(groupClassesPage);
    }

    public boolean create(GroupClassesView groupClasses) {
        GroupClassesEntity groupClassesEntity = new GroupClassesEntity();
        mapper4database.toGroupClassesEntity(groupClasses, groupClassesEntity);
        TheDepartmentEntity theDepartmentEntity = theDepartmentRepo.findById(groupClasses.getTheDepartment()).orElse(null);
        if (theDepartmentEntity == null)
            return false;
        TeacherEntity teacherEntity = teacherRepo.findById(groupClasses.getTeacherCode()).orElse(null);
        if (teacherEntity == null)
            return false;
        GroupEntity groupEntity = groupRepo.findById(groupClasses.getGroup()).orElse(null);
        if (groupEntity == null)
            return false;
        groupClassesEntity.setGroupNumber(groupEntity);
        groupClassesEntity.setTeacherCode(teacherEntity);
        groupClassesEntity.setTheDepartment(theDepartmentEntity);
        groupClassesRepo.save(groupClassesEntity);
        return true;
    }

    public void deleteById(int group, String name, LessonType type) {
        groupClassesRepo.deleteById(new GroupClassesEntityPK(group, type, name));
    }
}

