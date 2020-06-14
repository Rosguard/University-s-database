package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.GroupClassesEntity;
import org.fit.kaminskii.domain.GroupClassesEntityPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupClassesRepo extends PagingAndSortingRepository<GroupClassesEntity, GroupClassesEntityPK> {
    @Override
    Page<GroupClassesEntity> findAll(Pageable pageable);
}