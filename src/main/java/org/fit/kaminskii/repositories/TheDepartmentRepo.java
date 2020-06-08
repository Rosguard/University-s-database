package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.TheDepartmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheDepartmentRepo extends CrudRepository<TheDepartmentEntity, String> {
    @Override
    List<TheDepartmentEntity> findAll();

    @Query("select d from TheDepartmentEntity d join GroupClassesEntity gc on gc.theDepartment = d " +
            "join  GroupEntity g on g = gc.groupNumber where g.numberOfGroup = :group")
    List<TheDepartmentEntity> findTheDepartmentByGroupNumber(@Param("group") int group);

    @Query("select d from TheDepartmentEntity d join GroupClassesEntity gc on gc.theDepartment = d " +
            "join  GroupEntity g on g = gc.groupNumber where g.course = :course")
    List<TheDepartmentEntity> findTheDepartmentByCourse(@Param("course") int course);

    @Query("select d from TheDepartmentEntity d join GroupClassesEntity gc on gc.theDepartment = d " +
            "join  GroupEntity g on g = gc.groupNumber where gc.semester = :semester")
    List<TheDepartmentEntity> findTheDepartmentBySemester(@Param("semester") int semester);
}