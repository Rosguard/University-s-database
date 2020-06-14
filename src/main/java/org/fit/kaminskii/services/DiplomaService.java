package org.fit.kaminskii.services;

import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.*;
import org.fit.kaminskii.domain.DiplomaEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.repositories.DiplomaRepo;
import org.fit.kaminskii.repositories.TeacherRepo;
import org.fit.kaminskii.repositories.TheDepartmentRepo;
import org.fit.kaminskii.views.DiplomaView;
import org.fit.kaminskii.repositories.DiplomaRepo;
import org.fit.kaminskii.views.DiplomaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class DiplomaService {
    @Autowired
    private DiplomaRepo diplomaRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private TheDepartmentRepo theDepartmentRepo;
    @Autowired
    private Mapper4database mapper4database;

    public Page<DiplomaView> showAll(int page, int size) {
        Page<DiplomaEntity> diplomaPage = diplomaRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toDiplomaPage(diplomaPage);
//        Iterable<DiplomaEntity> diplomalist = diplomaRepo.findAll();
//        Page<DiplomaView> diploma = new ArrayList<>();
//        for (DiplomaEntity diplomaEntity : diplomalist) {
//            diploma.add(mapper4database.toDiplomaView(diplomaEntity));
//        }
//        return diploma;
    }

    public boolean create(DiplomaView diploma) {
        DiplomaEntity diplomaEntity = new DiplomaEntity();
        mapper4database.toDiplomaEntity(diploma, diplomaEntity);
        TheDepartmentEntity theDepartmentEntity = theDepartmentRepo.findById(diploma.getTheDepartment()).orElse(null);
        if (theDepartmentEntity == null)
            return false;
        TeacherEntity teacherEntity = teacherRepo.findById(diploma.getScientificDirectorCode()).orElse(null);
        if (teacherEntity == null)
            return false;
        diplomaEntity.setTeacherByScientificDirectorCode(teacherEntity);
        diplomaEntity.setTheDepartmentByTheDepartment(theDepartmentEntity);
        diplomaRepo.save(diplomaEntity);
        return true;
    }

    public void deleteById(int id) {
        diplomaRepo.deleteById(id);
    }
}
