package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.DiplomaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DiplomaRepo extends PagingAndSortingRepository<DiplomaEntity, Integer> {
    @Override
    Page<DiplomaEntity> findAll(Pageable pageable);

}