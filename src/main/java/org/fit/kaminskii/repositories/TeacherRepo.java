package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.model.TeacherCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.fit.kaminskii.domain.TeacherEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface TeacherRepo extends CrudRepository<TeacherEntity,Integer> {
    @Override
    List<TeacherEntity> findAll();
    List<TeacherEntity> findTeacherEntitiesBySecondNameAndFirstNameAndThirdName(String SN, String FN, String TH);
    List<TeacherEntity> findTeacherEntitiesBySex(Sex sex);
    List<TeacherEntity> findTeacherEntitiesByCategory(TeacherCategory category);
    List<TeacherEntity> findTeacherEntitiesByBirthday(Date birthday);
    List<TeacherEntity> findTeacherEntitiesByAge(int age);
    List<TeacherEntity> findTeacherEntitiesByNumberOfChildren(int numberOfChildren);
    List<TeacherEntity> findTeacherEntitiesByNumberOfChildrenIsNotNull(); // не работает что ли...
    List<TeacherEntity> findTeacherEntitiesBySalary(BigDecimal salary);





    @Query("select e from TeacherEntity e GROUP BY e.teacherCode, e.sex")
    List<TeacherEntity> groupBySex();
    @Query("select e from TeacherEntity e GROUP BY e.teacherCode, e.faculty")
    List<TeacherEntity> groupByFaculty();
    @Query("select e from TeacherEntity e GROUP BY e.teacherCode, e.theDepartment")
    List<TeacherEntity> groupByTheDepartment();
    @Query("select e from TeacherEntity e GROUP BY e.teacherCode, e.category")
    List<TeacherEntity> groupByCategory();
    @Query("select e from TeacherEntity e GROUP BY e.teacherCode, e.birthday")
    List<TeacherEntity> groupByBirthday();
    @Query("select e from TeacherEntity e GROUP BY e.teacherCode, e.age")
    List<TeacherEntity> groupByAge();
    @Query("select e from TeacherEntity e GROUP BY e.teacherCode, e.numberOfChildren")
    List<TeacherEntity> groupByNumberOfChildren();
    @Query("select e from TeacherEntity e GROUP BY e.teacherCode, e.salary")
    List<TeacherEntity> groupBySalary();
}

