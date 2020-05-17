package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.StudentRecordEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRecordRepo extends CrudRepository<StudentRecordEntity,Integer> {
}