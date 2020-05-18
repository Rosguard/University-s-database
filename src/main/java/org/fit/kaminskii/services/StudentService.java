package org.fit.kaminskii.services;

import lombok.AllArgsConstructor;
import org.fit.kaminskii.domain.StudentEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.views.StudentView;
import org.fit.kaminskii.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final Mapper4database mapper4database;


    public List<StudentView> showAll() {
        Iterable<StudentEntity> studentlist = studentRepo.findAll();
        List<StudentView> student = new ArrayList<>();
        for (StudentEntity studentEntity : studentlist) {
            student.add(mapper4database.toStudentView(studentEntity));
        }
        return student;
    }

    public void create(StudentView student) {
        StudentEntity studentEntity = new StudentEntity();
        mapper4database.toStudentEntity(student, studentEntity);
        studentRepo.save(studentEntity);
    }

    public void deleteById(int id) {
        studentRepo.deleteById(id);
    }

    public StudentView findById(int id) {
        Optional<StudentEntity> studentEntity = studentRepo.findById(id);
        return studentEntity.map(mapper4database::toStudentView).orElse(null);
    }

    public boolean update(StudentView student) {
        StudentEntity studentInBd = studentRepo.findById(student.getStudentCode()).orElse(null);
        if (studentInBd == null) {
            return false;
        }
        mapper4database.toStudentEntity(student, studentInBd);
        studentRepo.save(studentInBd);
        return true;
    }

    public List<StudentView> findByGroup(int group) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesByStudentGroup_NumberOfGroup(group);
        return mapper4database.toStudentListView(students);
    }

    public List<StudentView> findByCourse(int course) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesByStudentGroup_Course(course);
        return mapper4database.toStudentListView(students);
    }

    public List<StudentView> findBySex(Sex sex) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesBySex(sex);
        return mapper4database.toStudentListView(students);
    }

    public List<StudentView> findByName(String SN, String FN, String TN) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesBySecondNameAndFirstNameAndThirdName(SN, FN, TN);
        return mapper4database.toStudentListView(students);
    }

    public List<StudentView> findByBirthday(Date birthday) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesByBirthday(birthday);
        return mapper4database.toStudentListView(students);
    }

    public List<StudentView> findByAge(int age) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesByAge(age);
        return mapper4database.toStudentListView(students);
    }

    public List<StudentView> findByChildren(int numberOfChildren) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesByNumberOfChildren(numberOfChildren);
        return mapper4database.toStudentListView(students);
    }


    public List<StudentView> findByGrants(BigDecimal grants) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesByGrants(grants);
        return mapper4database.toStudentListView(students);
    }

    public List<StudentView> findByFaculty(String faculty) {
        List<StudentEntity> students =
                studentRepo.findStudentEntitiesByStudentGroup_Faculty(faculty);
        return mapper4database.toStudentListView(students);
    }

    public List<StudentView> findStudentByGroupNumberAndSubjectAndMark(int groupNumber, String subject, int mark) {
        List<StudentEntity> departments = studentRepo.findStudentByGroupNumberAndSubjectAndMark(groupNumber, subject, mark);
        return mapper4database.toStudentListView(departments);
    }

    public List<StudentView> findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(int groupNumber, int teacherCode, String subject, int mark) {
        List<StudentEntity> departments = studentRepo.findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(groupNumber, teacherCode, subject, mark);
        return mapper4database.toStudentListView(departments);
    }

    public List<StudentView> findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(int groupNumber, String firstName, String secondName, String thirdName, String subject, int mark) {
        List<StudentEntity> departments = studentRepo.findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(groupNumber, firstName, secondName, thirdName, subject, mark);
        return mapper4database.toStudentListView(departments);
    }

}
