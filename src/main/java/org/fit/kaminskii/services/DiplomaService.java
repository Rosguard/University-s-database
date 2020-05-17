package org.fit.kaminskii.services;

import org.fit.kaminskii.domain.DiplomaEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.DiplomaView;
import org.fit.kaminskii.repositories.DiplomaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DiplomaService {
    @Autowired
    private DiplomaRepo diplomaRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<DiplomaView> showAll(){
        Iterable<DiplomaEntity> diplomalist = diplomaRepo.findAll();
        List<DiplomaView> diploma = new ArrayList<>();
        for(DiplomaEntity diplomaEntity:diplomalist){
            diploma.add(mapper4database.toDiplomaView(diplomaEntity));
        }
        return diploma;
    }
    public void create(DiplomaView diploma){
        DiplomaEntity diplomaEntity = new DiplomaEntity();
        mapper4database.toDiplomaEntity(diploma, diplomaEntity);
        diplomaRepo.save(diplomaEntity);
        
    }

    public void deleteById(int id){
        diplomaRepo.deleteById(id);
    }
}
