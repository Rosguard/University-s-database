package org.fit.kaminskii.services;

import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.model.TeacherCategory;
import org.fit.kaminskii.views.TeacherView;
import org.fit.kaminskii.views.TeacherView;
import org.fit.kaminskii.views.TeacherView;
import org.fit.kaminskii.repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<TeacherView> showAll(){
        Iterable<TeacherEntity> teacherlist = teacherRepo.findAll();
        List<TeacherView> teacher = new ArrayList<>();
        for(TeacherEntity teacherEntity:teacherlist){
            teacher.add(mapper4database.toTeacherView(teacherEntity));
        }
        return teacher;
    }
    public void create(TeacherView teacher){
        TeacherEntity teacherEntity = new TeacherEntity();
        mapper4database.toTeacherEntity(teacher, teacherEntity);
        teacherRepo.save(teacherEntity);
    }
    public TeacherView findById(int id) {
        Optional<TeacherEntity> teacherEntity = teacherRepo.findById(id);
        return teacherEntity.map(mapper4database::toTeacherView).orElse(null);
    }

    public boolean update(TeacherView teacher) {
        TeacherEntity teacherInBd = teacherRepo.findById(teacher.getTeacherCode()).orElse(null);
        if (teacherInBd == null) {
            return false;
        }
        mapper4database.toTeacherEntity(teacher, teacherInBd);
        teacherRepo.save(teacherInBd);
        return true;
    }

    public void deleteById(int id){
        teacherRepo.deleteById(id);
    }

    public List<TeacherView> findBySex(Sex sex){
        List<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesBySex(sex);
        return mapper4database.toTeacherListView(teachers);
    }
    public List<TeacherView> findByCategory(TeacherCategory category){
        List<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByCategory(category);
        return mapper4database.toTeacherListView(teachers);
    }

    public List<TeacherView> findByName(String SN, String FN, String TN){
        List<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesBySecondNameAndFirstNameAndThirdName(SN, FN, TN);
        return mapper4database.toTeacherListView(teachers);
    }

    public List<TeacherView> findByBirthday(Date birthday){
        List<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByBirthday(birthday);
        return mapper4database.toTeacherListView(teachers);
    }

    public List<TeacherView> findByAge(int age){
        List<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByAge(age);
        return mapper4database.toTeacherListView(teachers);
    }

    public List<TeacherView> findByChildren(int numberOfChildren){
        List<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByNumberOfChildren(numberOfChildren);
        return mapper4database.toTeacherListView(teachers);
    }

    public List<TeacherView> findByChildrenIsNotNull(){
        List<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByNumberOfChildrenIsNotNull();
        return mapper4database.toTeacherListView(teachers);
    }

    public List<TeacherView> findBySalary(BigDecimal salary){
        List<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesBySalary(salary);
        return mapper4database.toTeacherListView(teachers);
    }
    
    
    
    
}
