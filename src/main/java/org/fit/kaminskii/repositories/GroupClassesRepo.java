package org.fit.kaminskii.repositories;


import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.domain.GroupClassesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupClassesRepo extends CrudRepository<GroupClassesEntity, Integer> {
    @Override
    List<GroupClassesEntity> findAll();
}