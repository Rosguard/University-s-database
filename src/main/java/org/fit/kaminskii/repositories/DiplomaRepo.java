package org.fit.kaminskii.repositories;

import org.fit.kaminskii.domain.DiplomaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiplomaRepo extends CrudRepository<DiplomaEntity, Integer> {
    @Override
    List<DiplomaEntity> findAll();

}