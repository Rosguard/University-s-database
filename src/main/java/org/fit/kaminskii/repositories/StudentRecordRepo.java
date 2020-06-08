package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.domain.StudentRecordEntity;
import org.fit.kaminskii.domain.StudentRecordEntityPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRecordRepo extends CrudRepository<StudentRecordEntity, StudentRecordEntityPK> {
    @Override
    List<StudentRecordEntity> findAll();
}