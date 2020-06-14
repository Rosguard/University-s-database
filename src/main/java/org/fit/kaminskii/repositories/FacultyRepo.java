package org.fit.kaminskii.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.fit.kaminskii.domain.FacultyEntity;

import java.util.List;

public interface FacultyRepo extends PagingAndSortingRepository<FacultyEntity, String> {
    @Override
    Page<FacultyEntity> findAll(Pageable pageable);

}
