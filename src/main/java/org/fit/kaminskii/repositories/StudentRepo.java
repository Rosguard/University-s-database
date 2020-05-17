package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.StudentEntity;
import org.fit.kaminskii.model.Sex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface StudentRepo extends CrudRepository<StudentEntity,Integer> {
    @Override
    List<StudentEntity> findAll();
    List<StudentEntity> findStudentEntitiesBySecondNameAndFirstNameAndThirdName(String SN, String FN, String TH);


    List<StudentEntity> findStudentEntitiesByStudentGroup_NumberOfGroup(int numberOfGroup);
    List<StudentEntity> findStudentEntitiesByStudentGroup_Course(int numberOfCourse);
    List<StudentEntity> findStudentEntitiesBySex(Sex sex);
    List<StudentEntity> findStudentEntitiesByBirthday(Date birthday);
    List<StudentEntity> findStudentEntitiesByAge(int age);
    List<StudentEntity> findStudentEntitiesByNumberOfChildren(int numberOfChildren);
    List<StudentEntity> findStudentEntitiesByNumberOfChildrenIsNotNull(); // не работает что ли...
    List<StudentEntity> findStudentEntitiesByGrants(BigDecimal grants);
    List<StudentEntity> findStudentEntitiesByStudentGroup_Faculty(String faculty);



    @Query("select e from StudentEntity e GROUP BY e.studentCode, e.sex")
    List<StudentEntity> groupBySex();
    @Query("select e from StudentEntity e join GroupEntity g on g = e.studentGroup GROUP BY e.studentCode, g.numberOfGroup")
    List<StudentEntity> groupByGroup();
    @Query("select e from StudentEntity e GROUP BY e.studentCode, e.birthday")
    List<StudentEntity> groupByBirthday();
    @Query("select e from StudentEntity e GROUP BY e.studentCode, e.age")
    List<StudentEntity> groupByAge();
    @Query("select e from StudentEntity e GROUP BY e.studentCode, e.numberOfChildren")
    List<StudentEntity> groupByNumberOfChildren();
    @Query("select e from StudentEntity e GROUP BY e.studentCode, e.grants")
    List<StudentEntity> groupByGrants();

}