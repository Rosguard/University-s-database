package org.fit.kaminskii.mapper;

import org.fit.kaminskii.domain.*;
import org.fit.kaminskii.views.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class Mapper4database {
    @Mapping(ignore = true, target = "teachersByName")
    public abstract void toCandidateEntity(CandidateView candidate, @MappingTarget CandidateEntity candidateEntity);

    @Mapping(ignore = true, target = "theDepartmentByTheDepartment")
    @Mapping(ignore = true, target = "teacherByScientificDirectorCode")
    public abstract void toDiplomaEntity(DiplomaView diploma, @MappingTarget DiplomaEntity diplomaEntity);

    @Mapping(ignore = true, target = "teachersByName")
    public abstract void toDoctoralEntity(DoctoralView doctoral, @MappingTarget DoctoralEntity doctoralEntity);

    @Mapping(ignore = true, target = "teachersByName")
    @Mapping(ignore = true, target = "groupsByName")
    @Mapping(ignore = true, target = "theDepartmentsByName")
    public abstract void toFacultyEntity(FacultyView faculty, @MappingTarget FacultyEntity facultyEntity);

//    @Mapping(source = "group", target = "groupNumber")
    @Mapping(ignore = true, target = "groupNumber")
    @Mapping(ignore = true, target = "theDepartment")
    @Mapping(ignore = true, target = "teacherCode")
    public abstract void toGroupClassesEntity(GroupClassesView groupClasses, @MappingTarget GroupClassesEntity groupClassesEntity);

    @Mapping(ignore = true, target = "facultyByFaculty")
    @Mapping(ignore = true, target = "groupClassesByNumberOfGroup")
    @Mapping(ignore = true, target = "studentsByNumberOfGroup")
    public abstract void toGroupEntity(GroupView group, @MappingTarget GroupEntity groupEntity);

    @Mapping(ignore = true, target = "studentGroup")
    @Mapping(ignore = true, target = "studentRecordsByStudentCode")
    public abstract void toStudentEntity(StudentView student, @MappingTarget StudentEntity studentEntity);

    @Mapping(ignore = true, target = "studentByStudentCode")
    @Mapping(ignore = true, target = "teacherByTeacherCode")
    public abstract void toStudentRecordEntity(StudentRecordView studentrecord, @MappingTarget StudentRecordEntity studentRecordEntity);

    @Mapping(ignore = true, target = "diplomasByTeacherCode")
    @Mapping(ignore = true, target = "groupClassesByTeacherCode")
    @Mapping(ignore = true, target = "studentRecordsByTeacherCode")
    @Mapping(ignore = true, target = "faculty")
    @Mapping(ignore = true, target = "theDepartment")
    @Mapping(ignore = true, target = "doctoral")
    @Mapping(ignore = true, target = "candidate")
    public abstract void toTeacherEntity(TeacherView teacher, @MappingTarget TeacherEntity teacherEntity);

    @Mapping(ignore = true, target = "diplomasByName")
    @Mapping(ignore = true, target = "groupClassesByName")
    @Mapping(ignore = true, target = "teachersByName")
    @Mapping(ignore = true, target = "faculty")
    public abstract void toTheDepartmentEntity(TheDepartmentView theDepartment, @MappingTarget TheDepartmentEntity theDepartmentEntity);

    public abstract CandidateView toCandidateView(CandidateEntity candidateEntity);

    public abstract List<CandidateView> toCandidateListView(Iterable<CandidateEntity> candidateEntity);

    public abstract DiplomaView toDiplomaView(DiplomaEntity diplomaEntity);

    public abstract DoctoralView toDoctoralView(DoctoralEntity doctoralEntity);

    public abstract List<DoctoralView> toDoctoralListView(Iterable<DoctoralEntity> doctoralEntity);

    public abstract FacultyView toFacultyView(FacultyEntity facultyEntity);

    @Mapping(ignore = true, target = "group")
    @Mapping(source = "theDepartment.name", target = "theDepartment")
    @Mapping(ignore = true, target = "teacherCode")
    public abstract GroupClassesView toGroupClassesView(GroupClassesEntity groupclassesEntity);

    public abstract GroupView toGroupView(GroupEntity groupEntity);

    @Mapping(source = "studentGroup.numberOfGroup", target = "group")
    public abstract StudentView toStudentView(StudentEntity studentEntity);

    public abstract List<StudentView> toStudentListView(Iterable<StudentEntity> studentEntity);

    public abstract StudentRecordView toStudentRecordView(StudentRecordEntity studentrecordEntity);

    @Mapping(source = "doctoral.name", target = "doctoral")
    @Mapping(source = "candidate.name", target = "candidate")
    @Mapping(source = "faculty.name", target = "faculty")
    @Mapping(source = "theDepartment.name", target = "theDepartment")
    public abstract TeacherView toTeacherView(TeacherEntity teacherEntity);

    public abstract List<TeacherView> toTeacherListView(Iterable<TeacherEntity> teacherEntity);

    @Mapping(source = "faculty.name", target = "faculty")
    public abstract TheDepartmentView toTheDepartmentView(TheDepartmentEntity thedepartmentEntity);

    public abstract List<TheDepartmentView> toTheDepartmentListView(Iterable<TheDepartmentEntity> theDepartmentEntity);

}
