package org.fit.kaminskii.services;

import org.fit.kaminskii.domain.DoctoralEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.DoctoralView;
import org.fit.kaminskii.repositories.DoctoralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DoctoralService {
    @Autowired
    private DoctoralRepo doctoralRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<DoctoralView> showAll() {
        Iterable<DoctoralEntity> doctorallist = doctoralRepo.findAll();
        List<DoctoralView> doctoral = new ArrayList<>();
        for (DoctoralEntity doctoralEntity : doctorallist) {
            doctoral.add(mapper4database.toDoctoralView(doctoralEntity));
        }
        return doctoral;
    }

    public void create(DoctoralView doctoral) {
        DoctoralEntity doctoralEntity = new DoctoralEntity();
        mapper4database.toDoctoralEntity(doctoral, doctoralEntity);
        doctoralRepo.save(doctoralEntity);
    }

    public List<DoctoralView> findDoctoralByTheDepartment(String department) {
        List<DoctoralEntity> doctorals = doctoralRepo.findDoctoralByTheDepartment(department);
        return mapper4database.toDoctoralListView(doctorals);
    }

    public List<DoctoralView> findDoctoralByFaculty(String faculty) {
        List<DoctoralEntity> doctorals = doctoralRepo.findDoctoralByFaculty(faculty);
        return mapper4database.toDoctoralListView(doctorals);
    }

    public void deleteById(int id) {
        doctoralRepo.deleteById(id);
    }
}

