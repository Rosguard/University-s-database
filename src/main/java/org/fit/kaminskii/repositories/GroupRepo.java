package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.GroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface GroupRepo extends PagingAndSortingRepository<GroupEntity, Integer> {
    @Override
    Page<GroupEntity> findAll(Pageable pageable);
}