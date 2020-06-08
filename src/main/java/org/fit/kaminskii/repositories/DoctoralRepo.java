package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.DoctoralEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctoralRepo extends CrudRepository<DoctoralEntity, String> {
    @Override
    List<DoctoralEntity> findAll();

    @Query("select c from DoctoralEntity c join TeacherEntity t on t.doctoral = c " +
            "where t.theDepartment = :department")
    List<DoctoralEntity> findDoctoralByTheDepartment(@Param("department") String department);

    @Query("select c from DoctoralEntity c join TeacherEntity t on t.doctoral = c " +
            "where t.faculty = :faculty")
    List<DoctoralEntity> findDoctoralByFaculty(@Param("faculty") String faculty);
}