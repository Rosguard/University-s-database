package org.fit.kaminskii.services;

import org.fit.kaminskii.domain.StudentRecordEntity;
import org.fit.kaminskii.domain.StudentRecordEntityPK;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.views.StudentRecordView;
import org.fit.kaminskii.repositories.StudentRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentRecordService {
    @Autowired
    private StudentRecordRepo studentrecordRepo;
    @Autowired
    private Mapper4database mapper4database;

    public List<StudentRecordView> showAll() {
        Iterable<StudentRecordEntity> studentrecordlist = studentrecordRepo.findAll();
        List<StudentRecordView> studentrecord = new ArrayList<>();
        for (StudentRecordEntity studentrecordEntity : studentrecordlist) {
            studentrecord.add(mapper4database.toStudentRecordView(studentrecordEntity));
        }
        return studentrecord;
    }

    public void create(StudentRecordView studentrecord) {
        StudentRecordEntity studentrecordEntity = new StudentRecordEntity();
        mapper4database.toStudentRecordEntity(studentrecord, studentrecordEntity);
        studentrecordRepo.save(studentrecordEntity);
    }

    public void deleteById(StudentRecordEntityPK id) {
        studentrecordRepo.deleteById(id);
    }
}
