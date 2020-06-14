package org.fit.kaminskii.services;

import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.domain.GroupEntity;
import org.fit.kaminskii.domain.TheDepartmentEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.repositories.FacultyRepo;
import org.fit.kaminskii.views.TheDepartmentView;
import org.fit.kaminskii.repositories.TheDepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class TheDepartmentService {
    @Autowired
    private TheDepartmentRepo thedepartmentRepo;
    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private Mapper4database mapper4database;

    public Page<TheDepartmentView> showAll(int page, int size) {
//        Iterable<TheDepartmentEntity> thedepartmentlist = thedepartmentRepo.findAll();
//        Page<TheDepartmentView> thedepartment = new ArrayPage<>();
//        for (TheDepartmentEntity thedepartmentEntity : thedepartmentlist) {
//            thedepartment.add(mapper4database.toTheDepartmentView(thedepartmentEntity));
//        }
//        return thedepartment;
        Page<TheDepartmentEntity> theDepartmentPage = thedepartmentRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toTheDepartmentPage(theDepartmentPage);
    }

    public boolean create(TheDepartmentView thedepartment) {
        TheDepartmentEntity thedepartmentEntity = new TheDepartmentEntity();
        mapper4database.toTheDepartmentEntity(thedepartment, thedepartmentEntity);
        FacultyEntity facultyEntity = facultyRepo.findById(thedepartment.getFaculty()).orElse(null);
        if (facultyEntity == null)
            return false;
        thedepartmentEntity.setFaculty(facultyEntity);
        thedepartmentRepo.save(thedepartmentEntity);
        return true;
    }

    public Page<TheDepartmentView> findTheDepartmentByGroupNumber(int groupNumber, int page, int size) {
        Page<TheDepartmentEntity> departments = thedepartmentRepo.findTheDepartmentByGroupNumber(groupNumber, PageRequest.of(page, size));
        return mapper4database.toTheDepartmentPage(departments);
    }

    public Page<TheDepartmentView> findTheDepartmentByCourse(int course, int page, int size) {
        Page<TheDepartmentEntity> departments = thedepartmentRepo.findTheDepartmentByCourse(course, PageRequest.of(page, size));
        return mapper4database.toTheDepartmentPage(departments);
    }

    public Page<TheDepartmentView> findTheDepartmentBySemester(int semester, int page, int size) {
        Page<TheDepartmentEntity> departments = thedepartmentRepo.findTheDepartmentBySemester(semester, PageRequest.of(page, size));
        return mapper4database.toTheDepartmentPage(departments);
    }

    public void deleteByName(String name) {
        thedepartmentRepo.deleteById(name);
    }
}
