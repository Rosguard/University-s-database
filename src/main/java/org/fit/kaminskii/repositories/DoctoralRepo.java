package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.DoctoralEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface DoctoralRepo extends PagingAndSortingRepository<DoctoralEntity, String> {
    @Override
    Page<DoctoralEntity> findAll(Pageable pageable);

    @Query("select c from DoctoralEntity c join TeacherEntity t on t.doctoral = c " +
            "where t.theDepartment.name = :department")
    Page<DoctoralEntity> findDoctoralByTheDepartment(@Param("department") String department, Pageable pageable);

    @Query("select c from DoctoralEntity c join TeacherEntity t on t.doctoral = c " +
            "where t.faculty.name = :faculty")
    Page<DoctoralEntity> findDoctoralByFaculty(@Param("faculty") String faculty, Pageable pageable);
}