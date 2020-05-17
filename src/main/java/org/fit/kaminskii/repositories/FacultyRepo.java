package org.fit.kaminskii.repositories;

import org.springframework.data.repository.CrudRepository;
import org.fit.kaminskii.domain.FacultyEntity;

public interface FacultyRepo extends CrudRepository<FacultyEntity,Integer> {
}
