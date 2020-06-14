package org.fit.kaminskii.services;

import lombok.RequiredArgsConstructor;
import org.fit.kaminskii.domain.*;
import org.fit.kaminskii.mapper.Mapper4database;
import org.fit.kaminskii.model.Category;
import org.fit.kaminskii.model.LessonType;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.repositories.*;
import org.fit.kaminskii.views.TeacherView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;

import java.time.LocalDate;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TeacherService {
    @Autowired
    private final TeacherRepo teacherRepo;
    @Autowired
    private final Mapper4database mapper4database;
    @Autowired
    private final FacultyRepo facultyRepo;
    @Autowired
    private final TheDepartmentRepo theDepartmentRepo;
    @Autowired
    private final CandidateRepo candidateRepo;
    @Autowired
    private final DoctoralRepo doctoralRepo;

    public Page<TeacherView> showAll(int page, int size) {
//        Iterable<TeacherEntity> teacherlist = teacherRepo.findAll();
//        Page<TeacherView> teacher = new ArrayList<>();
//        for (TeacherEntity teacherEntity : teacherlist) {
//            teacher.add(mapper4database.toTeacherView(teacherEntity));
//        }
//        return teacher;
        Page<TeacherEntity> teacherPage = teacherRepo.findAll(PageRequest.of(page, size));
        return mapper4database.toTeacherPage(teacherPage);
    }

    public boolean create(TeacherView teacher) {
        TeacherEntity teacherEntity = new TeacherEntity();
        mapper4database.toTeacherEntity(teacher, teacherEntity);
        FacultyEntity facultyEntity = facultyRepo.findById(teacher.getFaculty()).orElse(null);
        if (facultyEntity == null)
            return false;
        TheDepartmentEntity theDepartmentEntity = theDepartmentRepo.findById(teacher.getTheDepartment()).orElse(null);
        if (theDepartmentEntity == null)
            return false;
        CandidateEntity candidateEntity = candidateRepo.findById(teacher.getCandidate()).orElse(null);
//        if (candidateEntity == null)
//            return false;
        DoctoralEntity doctoralEntity = doctoralRepo.findById(teacher.getDoctoral()).orElse(null);
//        if (doctoralEntity == null)
//            return false;

        teacherEntity.setFaculty(facultyEntity);
        teacherEntity.setTheDepartment(theDepartmentEntity);
        teacherEntity.setCandidate(candidateEntity);
        teacherEntity.setDoctoral(doctoralEntity);
        teacherRepo.save(teacherEntity);
        return true;
    }

    public TeacherView findById(int id) {
        Optional<TeacherEntity> teacherEntity = teacherRepo.findById(id);
        return teacherEntity.map(mapper4database::toTeacherView).orElse(null);
    }

    public boolean update(TeacherView teacher) {
        TeacherEntity teacherInBd = teacherRepo.findById(teacher.getTeacherCode()).orElse(null);
        if (teacherInBd == null) {
            return false;
        }
        mapper4database.toTeacherEntity(teacher, teacherInBd);
        teacherRepo.save(teacherInBd);
        return true;
    }

    public void deleteById(int id) {
        teacherRepo.deleteById(id);
    }

    public Page<TeacherView> findBySex(Sex sex, int page, int size) {
        Page<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesBySex(sex,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(teachers);
    }

    public Page<TeacherView> findByCategory(Category category, int page, int size) {
        Page<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByCategory(category,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(teachers);
    }

    public Page<TeacherView> findByName(String SN, String FN, String TN, int page, int size) {
        Page<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesBySecondNameAndFirstNameAndThirdName(SN, FN, TN,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(teachers);
    }

    public Page<TeacherView> findByBirthday(Date birthday, int page, int size) {
        Page<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByBirthday(birthday,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(teachers);
    }

    public Page<TeacherView> findByAge(int age, int page, int size) {
        Date begin = Date.valueOf(LocalDate.now().minusYears(age+1).plusDays(1));
        Date end = Date.valueOf(LocalDate.now().minusYears(age));
        Page<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByBirthdayBetween(begin, end, PageRequest.of(page, size));
        return mapper4database.toTeacherPage(teachers);
    }

    public Page<TeacherView> findByChildren(int numberOfChildren, int page, int size) {
        Page<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesByNumberOfChildren(numberOfChildren,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(teachers);
    }

    public Page<TeacherView> findBySalary(BigDecimal salary, int page, int size) {
        Page<TeacherEntity> teachers =
                teacherRepo.findTeacherEntitiesBySalary(salary,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(teachers);
    }

    public Page<TeacherView> findTeacherByLessonNameAndGroupNumber(String lessonName, int groupNumber, int page, int size) {
        Page<TeacherEntity> departments = teacherRepo.findTeacherByLessonNameAndGroupNumber(lessonName, groupNumber,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(departments);
    }

    public Page<TeacherView> findTeacherByCourseAndFaculty(int course, String faculty, int page, int size) {
        Page<TeacherEntity> departments = teacherRepo.findTeacherByCourseAndFaculty(course, faculty,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(departments);
    }

    public Page<TeacherView> findTeacherByLessonTypeAndGroupNumber(LessonType lessonType, int groupNumber, int page, int size) {
        Page<TeacherEntity> departments = teacherRepo.findTeacherByLessonTypeAndGroupNumber(lessonType, groupNumber,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(departments);
    }

    public Page<TeacherView> findTeacherByCourseAndFacultyAndSemester(int course, String faculty, int semester, int page, int size) {
        Page<TeacherEntity> departments = teacherRepo.findTeacherByCourseAndFacultyAndSemester(course, faculty, semester,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(departments);
    }

    public Page<TeacherView> findTeacherByGroupAndSubjectAndSemester(int groupNumber, String subject, int semester, int page, int size) {
        Page<TeacherEntity> departments = teacherRepo.findTeacherByGroupAndSubjectAndSemester(groupNumber, subject, semester,PageRequest.of(page, size));
        return mapper4database.toTeacherPage(departments);
    }
}
