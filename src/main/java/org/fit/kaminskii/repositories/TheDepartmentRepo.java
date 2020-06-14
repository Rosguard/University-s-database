package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.TheDepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheDepartmentRepo extends PagingAndSortingRepository<TheDepartmentEntity, String> {
    @Override
    Page<TheDepartmentEntity> findAll(Pageable pageable);

    @Query("select distinct d from TheDepartmentEntity d join GroupClassesEntity gc on gc.theDepartment = d " +
            "join  GroupEntity g on g = gc.groupNumber where g.numberOfGroup = :group")
    Page<TheDepartmentEntity> findTheDepartmentByGroupNumber(@Param("group") int group, Pageable pageable);

    @Query("select distinct d from TheDepartmentEntity d join GroupClassesEntity gc on gc.theDepartment = d " +
            "join  GroupEntity g on g = gc.groupNumber where g.course = :course")
    Page<TheDepartmentEntity> findTheDepartmentByCourse(@Param("course") int course, Pageable pageable);

    @Query("select distinct d from TheDepartmentEntity d join GroupClassesEntity gc on gc.theDepartment = d " +
            "join  GroupEntity g on g = gc.groupNumber where gc.semester = :semester")
    Page<TheDepartmentEntity> findTheDepartmentBySemester(@Param("semester") int semester, Pageable pageable);
}