package org.fit.kaminskii.services;

import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.*;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.repositories.StudentRepo;
import org.fit.kaminskii.repositories.TeacherRepo;
import org.fit.kaminskii.views.StudentRecordView;
import org.fit.kaminskii.repositories.StudentRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class StudentRecordService {
    @Autowired
    private StudentRecordRepo studentRecordRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private Mapper4database mapper4database;

    public Page<StudentRecordView> showAll(int page, int size) {
        Page<StudentRecordEntity> studentRecordPage = studentRecordRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toStudentRecordPage(studentRecordPage);
//        Iterable<StudentRecordEntity> studentRecordlist = studentRecordRepo.findAll();
//        Page<StudentRecordView> studentRecord = new ArrayList<>();
//        for (StudentRecordEntity studentRecordEntity : studentRecordlist) {
//            studentRecord.add(mapper4database.toStudentRecordView(studentRecordEntity));
//        }
//        return studentRecord;
    }

    public boolean create(StudentRecordView studentRecord) {
        StudentRecordEntity studentRecordEntity = new StudentRecordEntity();
        mapper4database.toStudentRecordEntity(studentRecord, studentRecordEntity);

        TeacherEntity teacherEntity = teacherRepo.findById(studentRecord.getTeacherCode()).orElse(null);
        if (teacherEntity == null)
            return false;
        StudentEntity studentEntity = studentRepo.findById(studentRecord.getStudentCode()).orElse(null);
        if (studentEntity == null)
            return false;

        studentRecordEntity.setTeacherByTeacherCode(teacherEntity);
        studentRecordEntity.setStudentByStudentCode(studentEntity);
        studentRecordRepo.save(studentRecordEntity);
        return true;
    }

    public void deleteById(int studentCode, String subject) {
        studentRecordRepo.deleteById(new StudentRecordEntityPK(subject, studentCode));
    }
}
