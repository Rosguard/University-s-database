package org.fit.kaminskii.services;

import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.FacultyView;
import org.fit.kaminskii.repositories.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FacultyService {
    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private Mapper4database mapper4database;

    public Page<FacultyView> showAll(int page, int size) {
//        Iterable<FacultyEntity> facultylist = facultyRepo.findAll();
//        List<FacultyView> faculty = new ArrayList<>();
//        for (FacultyEntity facultyEntity : facultylist) {
//            faculty.add(mapper4database.toFacultyView(facultyEntity));
//        }
//        return faculty;
        Page<FacultyEntity> facultyPage = facultyRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toFacultyPage(facultyPage);
    }

    public boolean create(FacultyView faculty) {
        FacultyEntity facultyEntity = new FacultyEntity();
        mapper4database.toFacultyEntity(faculty, facultyEntity);
        facultyRepo.save(facultyEntity);
        return true;
    }

    public void deleteById(String id) {
        facultyRepo.deleteById(id);
    }
}
