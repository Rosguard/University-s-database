package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.model.LessonType;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.model.TeacherCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface TeacherRepo extends CrudRepository<TeacherEntity, Integer> {
    @Override
    List<TeacherEntity> findAll();

    List<TeacherEntity> findTeacherEntitiesBySecondNameAndFirstNameAndThirdName(String SN, String FN, String TH);

    List<TeacherEntity> findTeacherEntitiesBySex(Sex sex);

    List<TeacherEntity> findTeacherEntitiesByCategory(TeacherCategory category);

    List<TeacherEntity> findTeacherEntitiesByBirthday(Date birthday);

    List<TeacherEntity> findTeacherEntitiesByAge(int age);

    List<TeacherEntity> findTeacherEntitiesByNumberOfChildren(int numberOfChildren);

    List<TeacherEntity> findTeacherEntitiesBySalary(BigDecimal salary);

    @Query("select t from TeacherEntity t join GroupClassesEntity gc on gc.teacherCode = t " +
            "join  GroupEntity g on g = gc.groupNumber where g.numberOfGroup = :group and gc.groupClassesEntityPK.name = :lessonName")
    List<TeacherEntity> findTeacherByLessonNameAndGroupNumber(@Param("lessonName") String lessonName, @Param("group") int group);

    @Query("select t from TeacherEntity t join GroupClassesEntity gc on gc.teacherCode = t " +
            "join  GroupEntity g on g = gc.groupNumber join FacultyEntity f on f = g.facultyByFaculty where f.name = :faculty and g.course=:course")
    List<TeacherEntity> findTeacherByCourseAndFaculty(@Param("course") int course, @Param("faculty") String faculty);

    @Query("select t from TeacherEntity t join GroupClassesEntity gc on gc.teacherCode = t " +
            "join  GroupEntity g on g = gc.groupNumber where g.numberOfGroup = :group and gc.groupClassesEntityPK.lessonType = :lessonType")
    List<TeacherEntity> findTeacherByLessonTypeAndGroupNumber(@Param("lessonType") String lessonType, @Param("group") int group);

    @Query("select t from TeacherEntity t join GroupClassesEntity gc on gc.teacherCode = t " +
            "join  GroupEntity g on g = gc.groupNumber join FacultyEntity f on f = g.facultyByFaculty where f.name = :faculty and g.course=:course and gc.semester=:semester")
    List<TeacherEntity> findTeacherByCourseAndFacultyAndSemester(@Param("course") int course, @Param("faculty") String faculty, @Param("semester") int semester);

    @Query("select t from TeacherEntity t join StudentRecordEntity sr on sr.teacherByTeacherCode = t " +
            "join StudentEntity s on s=sr.studentByStudentCode join GroupEntity g on g = s.studentGroup join GroupClassesEntity gc on gc.groupClassesEntityPK.name = sr.studentRecordEntityPK.subject " +
            "where g.numberOfGroup=:groupNumber and sr.studentRecordEntityPK.subject=:subject and gc.semester=:semester")
    List<TeacherEntity> findTeacherByGroupAndSubjectAndSemester(@Param("groupNumber") int groupNumber, @Param("subject") String subject, @Param("semester") int semester);


}

