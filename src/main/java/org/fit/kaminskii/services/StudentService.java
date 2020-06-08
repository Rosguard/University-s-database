package org.fit.kaminskii.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.domain.GroupEntity;
import org.fit.kaminskii.domain.StudentEntity;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.repositories.FacultyRepo;
import org.fit.kaminskii.repositories.GroupRepo;
import org.fit.kaminskii.views.StudentView;
import org.fit.kaminskii.repositories.StudentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final GroupRepo groupRepo;
    private final FacultyRepo facultyRepo;
    private final Mapper4database mapper4database;
    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    public void initJDBC(){
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("checkDate");
    }

    public Page<StudentView> showAll(int page, int size) {
        Page<StudentEntity> studentPage = studentRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toStudentPage(studentPage);
    }

    public boolean create(StudentView student) {
        StudentEntity studentEntity = new StudentEntity();
        mapper4database.toStudentEntity(student, studentEntity);
        GroupEntity groupEntity = groupRepo.findById(student.getGroup()).orElse(null);
        if (groupEntity == null)
            return false;
        studentEntity.setStudentGroup(groupEntity);
        studentRepo.save(studentEntity);
//        groupEntity.getStudentsByNumberOfGroup().add(studentEntity);
//        groupRepo.save(groupEntity);
//        FacultyEntity facultyEntity = facultyRepo.findById(groupEntity.getFacultyByFaculty().getName()).orElse(null);
//        if (facultyEntity == null)
//            return false;
//        facultyEntity.getGroupsByName().add(groupEntity);
//        facultyRepo.save(facultyEntity)
        return true;
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

    public Page<StudentView> findByGroup(int group, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesByStudentGroup_NumberOfGroup(group,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }

    public Page<StudentView> findByCourse(int course, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesByStudentGroup_Course(course,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }

    public Page<StudentView> findBySex(Sex sex, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesBySex(sex,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }

    public Page<StudentView> findByName(String SN, String FN, String TN, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesBySecondNameAndFirstNameAndThirdName(SN, FN, TN,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }

    public Page<StudentView> findByBirthday(Date birthday, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesByBirthday(birthday,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }

    public Page<StudentView> findByAge(int age, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesByAge(age,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }

    public Page<StudentView> findByChildren(int numberOfChildren, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesByNumberOfChildren(numberOfChildren,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }


    public Page<StudentView> findByGrants(BigDecimal grants, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesByGrants(grants,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }

    public Page<StudentView> findByFaculty(String faculty, int page, int size) {
        Page<StudentEntity> students =
                studentRepo.findStudentEntitiesByStudentGroup_FacultyByFaculty_Name(faculty,PageRequest.of(page, size));
        return mapper4database.toStudentPage(students);
    }

    public Page<StudentView> findStudentByGroupNumberAndSubjectAndMark(int groupNumber, String subject, int mark, int page, int size) {
        Page<StudentEntity> departments = studentRepo.findStudentByGroupNumberAndSubjectAndMark(groupNumber, subject, mark,PageRequest.of(page, size));
        return mapper4database.toStudentPage(departments);
    }

    public Page<StudentView> findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(int groupNumber, int teacherCode, String subject, int mark, int semester, int page, int size) {
        Page<StudentEntity> departments = studentRepo.findStudentByGroupAndTeacherCodeAndMarkAndSubjectAndSemester(groupNumber, teacherCode, subject, mark, semester,PageRequest.of(page, size));
        return mapper4database.toStudentPage(departments);
    }

    public Page<StudentView> findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(int groupNumber, String firstName, String secondName, String thirdName, String subject, int semester, int page, int size) {
        Page<StudentEntity> departments = studentRepo.findStudentByGroupAndTeacherNameAndMarkAndSubjectAndSemester(groupNumber, firstName, secondName, thirdName, subject, semester,PageRequest.of(page, size));
        return mapper4database.toStudentPage(departments);
    }

}
