package org.fit.kaminskii.repositories;

import org.springframework.data.repository.CrudRepository;
import org.fit.kaminskii.domain.FacultyEntity;

import java.util.List;

public interface FacultyRepo extends CrudRepository<FacultyEntity, Integer> {
    @Override
    List<FacultyEntity> findAll();

}
