package org.fit.kaminskii.services;

import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.FacultyView;
import org.fit.kaminskii.repositories.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FacultyService {
    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<FacultyView> showAll() {
        Iterable<FacultyEntity> facultylist = facultyRepo.findAll();
        List<FacultyView> faculty = new ArrayList<>();
        for (FacultyEntity facultyEntity : facultylist) {
            faculty.add(mapper4database.toFacultyView(facultyEntity));
        }
        return faculty;
    }

    public void create(FacultyView faculty) {
        FacultyEntity facultyEntity = new FacultyEntity();
        mapper4database.toFacultyEntity(faculty, facultyEntity);
        facultyRepo.save(facultyEntity);
    }

    public void deleteById(int id) {
        facultyRepo.deleteById(id);
    }
}
