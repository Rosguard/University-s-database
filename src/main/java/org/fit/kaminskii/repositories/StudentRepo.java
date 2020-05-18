package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.StudentEntity;
import org.fit.kaminskii.model.Sex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface StudentRepo extends CrudRepository<StudentEntity, Integer> {
    @Override
    List<StudentEntity> findAll();

    List<StudentEntity> findStudentEntitiesBySecondNameAndFirstNameAndThirdName(String SN, String FN, String TH);

    List<StudentEntity> findStudentEntitiesByStudentGroup_NumberOfGroup(int numberOfGroup);

    List<StudentEntity> findStudentEntitiesByStudentGroup_Course(int numberOfCourse);

    List<StudentEntity> findStudentEntitiesBySex(Sex sex);

    List<StudentEntity> findStudentEntitiesByBirthday(Date birthday);

    List<StudentEntity> findStudentEntitiesByAge(int age);

    List<StudentEntity> findStudentEntitiesByNumberOfChildren(int numberOfChildren);


    List<StudentEntity> findStudentEntitiesByGrants(BigDecimal grants);

    List<StudentEntity> findStudentEntitiesByStudentGroup_Faculty(String faculty);

    @Query("select s from StudentEntity s join StudentRecordEntity sr on sr.studentCode = s.studentCode " +
            "join GroupEntity g on g = s.studentGroup where g.numberOfGroup=:groupNumber and sr.subject=:subject and sr.mark = :mark")
    List<StudentEntity> findStudentByGroupNumberAndSubjectAndMark(@Param("groupNumber") int groupNumber, @Param("subject") String subject, @Param("mark") int mark);

    @Query("select s from StudentEntity s join StudentRecordEntity sr on sr.studentCode = s.studentCode " +
            "join GroupEntity g on g = s.studentGroup join GroupClassesEntity gc on gc.name=sr.subject where g.numberOfGroup=:groupNumber and sr.teacherCode=:teacherCode and sr.subject=:subject and sr.mark = :mark")
    List<StudentEntity> findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(@Param("groupNumber") int groupNumber, @Param("teacherCode") int teacherCode, @Param("subject") String subject, @Param("mark") int mark);

    @Query("select s from StudentEntity s join StudentRecordEntity sr on sr.studentCode = s.studentCode " +
            "join GroupEntity g on g = s.studentGroup join GroupClassesEntity gc on gc.name=sr.subject join TeacherEntity t on t.teacherCode=sr.teacherCode where g.numberOfGroup=:groupNumber and t.firstName=:firstName and t.secondName=:secondName and t.thirdName=:thirdName and sr.subject=:subject and sr.mark = :mark")
    List<StudentEntity> findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(@Param("groupNumber") int groupNumber, @Param("firstName") String firstName, @Param("secondName") String secondName, @Param("thirdName") String thirdName, @Param("subject") String subject, @Param("mark") int mark);

    @Query("select s from StudentEntity s join DiplomaEntity d on d.studentCode = s.studentCode " +
            "join TheDepartmentEntity td on td = d.theDepartment where d.theDepartment=:theDepartment")
    List<StudentEntity> findStudentAndDiplomaByTheDepartment(@Param("theDepartment") String theDepartment);

}