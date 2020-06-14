package org.fit.kaminskii.services;

import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.DoctoralEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.DoctoralView;
import org.fit.kaminskii.repositories.DoctoralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DoctoralService {
    @Autowired
    private DoctoralRepo doctoralRepo;
    @Autowired
    private Mapper4database mapper4database;

    public Page<DoctoralView> showAll(int page, int size) {
//        Iterable<DoctoralEntity> doctorallist = doctoralRepo.findAll();
//        Page<DoctoralView> doctoral = new ArrayPage<>();
//        for (DoctoralEntity doctoralEntity : doctorallist) {
//            doctoral.add(mapper4database.toDoctoralView(doctoralEntity));
//        }
//        return doctoral;
        Page<DoctoralEntity> doctoralPage = doctoralRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toDoctoralPage(doctoralPage);
    }

    public void create(DoctoralView doctoral) {
        DoctoralEntity doctoralEntity = new DoctoralEntity();
        mapper4database.toDoctoralEntity(doctoral, doctoralEntity);
        doctoralRepo.save(doctoralEntity);
    }

    public Page<DoctoralView> findDoctoralByTheDepartment(String theDepartment, int page, int size) {
        Page<DoctoralEntity> doctorals = doctoralRepo.findDoctoralByTheDepartment(theDepartment,PageRequest.of(page, size));
        return mapper4database.toDoctoralPage(doctorals);
    }

    public Page<DoctoralView> findDoctoralByFaculty(String faculty, int page, int size) {
        Page<DoctoralEntity> doctorals = doctoralRepo.findDoctoralByFaculty(faculty,PageRequest.of(page, size));
        return mapper4database.toDoctoralPage(doctorals);
    }

    public void deleteById(String id) {
        doctoralRepo.deleteById(id);
    }
}

