package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.StudentEntity;
import org.fit.kaminskii.model.Sex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Date;

public interface StudentRepo extends PagingAndSortingRepository<StudentEntity, Integer> {
    @Override
    Page<StudentEntity> findAll(Pageable pageable);

    Page<StudentEntity> findStudentEntitiesBySecondNameAndFirstNameAndThirdName(String SN, String FN, String TH, Pageable pageable);

    Page<StudentEntity> findStudentEntitiesByStudentGroup_NumberOfGroup(int numberOfGroup, Pageable pageable);

    Page<StudentEntity> findStudentEntitiesByStudentGroup_Course(int numberOfCourse, Pageable pageable);

    Page<StudentEntity> findStudentEntitiesBySex(Sex sex, Pageable pageable);

    Page<StudentEntity> findStudentEntitiesByBirthday(Date birthday, Pageable pageable);

    Page<StudentEntity> findStudentEntitiesByAge(int age, Pageable pageable);

    Page<StudentEntity> findStudentEntitiesByNumberOfChildren(int numberOfChildren, Pageable pageable);


    Page<StudentEntity> findStudentEntitiesByGrants(BigDecimal grants, Pageable pageable);

    Page<StudentEntity> findStudentEntitiesByStudentGroup_FacultyByFaculty_Name(String faculty, Pageable pageable);

    @Query("select s from StudentEntity s join StudentRecordEntity sr on sr.studentByStudentCode = s " +
            "join GroupEntity g on g = s.studentGroup where g.numberOfGroup=:groupNumber and sr.studentRecordEntityPK.subject=:subject and sr.mark = :mark")
    Page<StudentEntity> findStudentByGroupNumberAndSubjectAndMark(@Param("groupNumber") int groupNumber, @Param("subject") String subject, @Param("mark") int mark, Pageable pageable);

    @Query("select s from StudentEntity s join StudentRecordEntity sr on sr.studentByStudentCode = s " +
            "join GroupEntity g on g = s.studentGroup join GroupClassesEntity gc on gc.groupClassesEntityPK.name=sr.studentRecordEntityPK.subject " +
            "where g.numberOfGroup=:groupNumber and sr.teacherByTeacherCode.teacherCode=:teacherCode " +
            "and sr.studentRecordEntityPK.subject=:subject and sr.mark = :mark and gc.semester = :semester")
    Page<StudentEntity> findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(@Param("groupNumber") int groupNumber, @Param("teacherCode") int teacherCode, @Param("subject") String subject, @Param("mark") int mark, @Param("semester") int semester, Pageable pageable);

    @Query("select s from StudentEntity s join StudentRecordEntity sr on sr.studentByStudentCode = s " +
            "join GroupEntity g on g = s.studentGroup join GroupClassesEntity gc on gc.groupClassesEntityPK.name=sr.studentRecordEntityPK.subject " +
            "join TeacherEntity t on t=sr.teacherByTeacherCode " +
            "where g.numberOfGroup=:groupNumber and t.firstName=:firstName " +
            "and t.secondName=:secondName and t.thirdName=:thirdName " +
            "and sr.studentRecordEntityPK.subject=:subject and gc.semester=:semester")
    Page<StudentEntity> findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(@Param("groupNumber") int groupNumber, @Param("firstName") String firstName, @Param("secondName") String secondName, @Param("thirdName") String thirdName, @Param("subject") String subject, @Param("semester") int semester, Pageable pageable);

    @Query("select s from StudentEntity s join DiplomaEntity d on d.studentCode = s.studentCode " +
            "join TheDepartmentEntity td on td = d.theDepartmentByTheDepartment where d.theDepartmentByTheDepartment.name=:theDepartment")
    Page<StudentEntity> findStudentAndDiplomaByTheDepartment(@Param("theDepartment") String theDepartment, Pageable pageable);

}