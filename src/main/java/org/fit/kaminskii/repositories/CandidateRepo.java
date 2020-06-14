package org.fit.kaminskii.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.fit.kaminskii.domain.CandidateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface CandidateRepo extends PagingAndSortingRepository<CandidateEntity, String> {
    @Override
    Page<CandidateEntity> findAll(Pageable pageable);

    @Query("select c from CandidateEntity c join TeacherEntity t on t.candidate = c " +
            "where t.theDepartment.name = :department")
    Page<CandidateEntity> findCandidateByTheDepartment(@Param("department") String department, Pageable pageable);

    @Query("select c from CandidateEntity c join TeacherEntity t on t.candidate = c " +
            "where t.faculty.name = :faculty")
    Page<CandidateEntity> findCandidateByFaculty(@Param("faculty") String faculty, Pageable pageable);

}
