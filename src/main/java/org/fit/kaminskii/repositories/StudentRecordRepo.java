package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.StudentRecordEntity;
import org.fit.kaminskii.domain.StudentRecordEntityPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRecordRepo extends PagingAndSortingRepository<StudentRecordEntity, StudentRecordEntityPK> {
    @Override
    Page<StudentRecordEntity> findAll(Pageable pageable);
}