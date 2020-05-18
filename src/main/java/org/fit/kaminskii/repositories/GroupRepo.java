package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.domain.GroupEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepo extends CrudRepository<GroupEntity, Integer> {
    @Override
    List<GroupEntity> findAll();
}