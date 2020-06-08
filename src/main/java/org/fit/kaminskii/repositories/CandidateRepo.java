package org.fit.kaminskii.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.fit.kaminskii.domain.CandidateEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepo extends CrudRepository<CandidateEntity, String> {
    @Override
    List<CandidateEntity> findAll();

    @Query("select c from CandidateEntity c join TeacherEntity t on t.candidate = c " +
            "where t.theDepartment = :department")
    List<CandidateEntity> findCandidateByTheDepartment(@Param("department") String department);

    @Query("select c from CandidateEntity c join TeacherEntity t on t.candidate = c " +
            "where t.faculty = :faculty")
    List<CandidateEntity> findCandidateByFaculty(@Param("faculty") String faculty);

}
