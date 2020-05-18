package org.fit.kaminskii.services;

import org.fit.kaminskii.domain.TheDepartmentEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.TheDepartmentView;
import org.fit.kaminskii.repositories.TheDepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TheDepartmentService {
    @Autowired
    private TheDepartmentRepo thedepartmentRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<TheDepartmentView> showAll() {
        Iterable<TheDepartmentEntity> thedepartmentlist = thedepartmentRepo.findAll();
        List<TheDepartmentView> thedepartment = new ArrayList<>();
        for (TheDepartmentEntity thedepartmentEntity : thedepartmentlist) {
            thedepartment.add(mapper4database.toTheDepartmentView(thedepartmentEntity));
        }
        return thedepartment;
    }

    public void create(TheDepartmentView thedepartment) {
        TheDepartmentEntity thedepartmentEntity = new TheDepartmentEntity();
        mapper4database.toTheDepartmentEntity(thedepartment, thedepartmentEntity);
        thedepartmentRepo.save(thedepartmentEntity);

    }

    public List<TheDepartmentView> findTheDepartmentByGroupNumber(int groupNumber) {
        List<TheDepartmentEntity> departments = thedepartmentRepo.findTheDepartmentByGroupNumber(groupNumber);
        return mapper4database.toTheDepartmentListView(departments);
    }

    public List<TheDepartmentView> findTheDepartmentByCourse(int course) {
        List<TheDepartmentEntity> departments = thedepartmentRepo.findTheDepartmentByCourse(course);
        return mapper4database.toTheDepartmentListView(departments);
    }

    public List<TheDepartmentView> findTheDepartmentBySemester(int semester) {
        List<TheDepartmentEntity> departments = thedepartmentRepo.findTheDepartmentBySemester(semester);
        return mapper4database.toTheDepartmentListView(departments);
    }

    public void deleteByName(int name) {
        thedepartmentRepo.deleteById(name);
    }
}
