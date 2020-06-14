package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.model.Category;
import org.fit.kaminskii.model.LessonType;
import org.fit.kaminskii.model.Sex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Date;

public interface TeacherRepo extends PagingAndSortingRepository<TeacherEntity, Integer> {
    @Override
    Page<TeacherEntity> findAll(Pageable pageable);

    Page<TeacherEntity> findTeacherEntitiesBySecondNameAndFirstNameAndThirdName(String SN, String FN, String TH, Pageable pageable);

    Page<TeacherEntity> findTeacherEntitiesBySex(Sex sex, Pageable pageable);

    Page<TeacherEntity> findTeacherEntitiesByCategory(Category category, Pageable pageable);

    Page<TeacherEntity> findTeacherEntitiesByBirthday(Date birthday, Pageable pageable);

    Page<TeacherEntity> findTeacherEntitiesByBirthdayBetween(Date date1, Date date2, Pageable pageable);

    Page<TeacherEntity> findTeacherEntitiesByNumberOfChildren(int numberOfChildren, Pageable pageable);

    Page<TeacherEntity> findTeacherEntitiesBySalary(BigDecimal salary, Pageable pageable);

    @Query("select distinct t from TeacherEntity t join GroupClassesEntity gc on gc.teacherCode = t " +
            "join  GroupEntity g on g = gc.groupNumber where g.numberOfGroup = :group and gc.groupClassesEntityPK.lessonName = :lessonName")
    Page<TeacherEntity> findTeacherByLessonNameAndGroupNumber(@Param("lessonName") String lessonName, @Param("group") int group, Pageable pageable);

    @Query("select distinct t from TeacherEntity t join GroupClassesEntity gc on gc.teacherCode = t " +
            "join  GroupEntity g on g = gc.groupNumber join FacultyEntity f on f = g.facultyByFaculty where f.name = :faculty and g.course=:course")
    Page<TeacherEntity> findTeacherByCourseAndFaculty(@Param("course") int course, @Param("faculty") String faculty, Pageable pageable);

    @Query("select distinct t from TeacherEntity t join GroupClassesEntity gc on gc.teacherCode = t " +
            "join  GroupEntity g on g = gc.groupNumber where g.numberOfGroup = :group and gc.groupClassesEntityPK.lessonType = :lessonType")
    Page<TeacherEntity> findTeacherByLessonTypeAndGroupNumber(@Param("lessonType") LessonType lessonType, @Param("group") int group, Pageable pageable);

    @Query("select distinct t from TeacherEntity t join GroupClassesEntity gc on gc.teacherCode = t " +
            "join  GroupEntity g on g = gc.groupNumber join FacultyEntity f on f = g.facultyByFaculty where f.name = :faculty and g.course=:course and gc.semester=:semester")
    Page<TeacherEntity> findTeacherByCourseAndFacultyAndSemester(@Param("course") int course, @Param("faculty") String faculty, @Param("semester") int semester, Pageable pageable);

    @Query("select distinct t from TeacherEntity t join StudentRecordEntity sr on sr.teacherByTeacherCode = t " +
            "join StudentEntity s on s=sr.studentByStudentCode join GroupEntity g on g = s.studentGroup join GroupClassesEntity gc on gc.groupClassesEntityPK.lessonName = sr.studentRecordEntityPK.subject " +
            "where g.numberOfGroup=:groupNumber and sr.studentRecordEntityPK.subject=:subject and gc.semester=:semester")
    Page<TeacherEntity> findTeacherByGroupAndSubjectAndSemester(@Param("groupNumber") int groupNumber, @Param("subject") String subject, @Param("semester") int semester, Pageable pageable);


}

