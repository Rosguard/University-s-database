package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.GroupEntity;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepo extends CrudRepository<GroupEntity,Integer> {
}