package org.fit.kaminskii.mapper;

import org.fit.kaminskii.domain.*;
import org.fit.kaminskii.views.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

    @Mapping(ignore = true, target = "groupNumber")
    @Mapping(ignore = true, target = "theDepartment")
    @Mapping(ignore = true, target = "teacherCode")
    @Mapping(source = "group", target = "groupClassesEntityPK.groupNumber")
    @Mapping(source = "lessonType", target = "groupClassesEntityPK.lessonType")
    @Mapping(source = "name", target = "groupClassesEntityPK.lessonName")
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
    @Mapping(source = "studentCode", target = "studentRecordEntityPK.studentCode")
    @Mapping(source = "subject", target = "studentRecordEntityPK.subject")
    public abstract void toStudentRecordEntity(StudentRecordView studentRecord, @MappingTarget StudentRecordEntity studentRecordEntity);

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

    @Mapping(source = "theDepartmentByTheDepartment.name", target = "theDepartment")
    @Mapping(source = "teacherByScientificDirectorCode.teacherCode", target = "scientificDirectorCode")
    public abstract DiplomaView toDiplomaView(DiplomaEntity diplomaEntity);

    public abstract DoctoralView toDoctoralView(DoctoralEntity doctoralEntity);

    public abstract List<DoctoralView> toDoctoralListView(Iterable<DoctoralEntity> doctoralEntity);

    public abstract FacultyView toFacultyView(FacultyEntity facultyEntity);

    @Mapping(source = "groupClassesEntityPK.groupNumber", target = "group")
    @Mapping(source = "theDepartment.name", target = "theDepartment")
    @Mapping(source = "teacherCode.teacherCode", target = "teacherCode")
    @Mapping(source = "groupClassesEntityPK.lessonType", target = "lessonType")
    @Mapping(source = "groupClassesEntityPK.lessonName", target = "name")
    public abstract GroupClassesView toGroupClassesView(GroupClassesEntity groupclassesEntity);

//    @Mapping(ignore = true, target = "faculty")
    @Mapping(source = "facultyByFaculty.name", target = "faculty")
    public abstract GroupView toGroupView(GroupEntity groupEntity);

    @Mapping(source = "studentGroup.numberOfGroup", target = "group")
    public abstract StudentView toStudentView(StudentEntity studentEntity);

    public abstract List<StudentView> toStudentListView(Iterable<StudentEntity> studentEntity);
    public abstract List<StudentRecordView> toStudentRecordListView(Iterable<StudentRecordEntity> studentRecordEntity);

    @Mapping(source = "studentByStudentCode.studentCode", target = "studentCode")
    @Mapping(source = "studentRecordEntityPK.subject", target = "subject")
    @Mapping(source = "teacherByTeacherCode.teacherCode", target = "teacherCode")
    public abstract StudentRecordView toStudentRecordView(StudentRecordEntity studentrecordEntity);

    @Mapping(source = "doctoral.name", target = "doctoral")
    @Mapping(source = "candidate.name", target = "candidate")
    @Mapping(source = "faculty.name", target = "faculty")
    @Mapping(source = "theDepartment.name", target = "theDepartment")
    public abstract TeacherView toTeacherView(TeacherEntity teacherEntity);

    public abstract List<TeacherView> toTeacherListView(Iterable<TeacherEntity> teacherEntity);
    public abstract List<GroupView> toGroupListView(Iterable<GroupEntity> groupEntity);
    public abstract List<GroupClassesView> toGroupClassesListView(Iterable<GroupClassesEntity> groupClassesEntity);
    public abstract List<FacultyView> toFacultyListView(Iterable<FacultyEntity> facultyEntity);
    public abstract List<DiplomaView> toDiplomaListView(Iterable<DiplomaEntity> diplomaEntity);

    @Mapping(source = "faculty.name", target = "faculty")
    public abstract TheDepartmentView toTheDepartmentView(TheDepartmentEntity thedepartmentEntity);

    public abstract List<TheDepartmentView> toTheDepartmentListView(Iterable<TheDepartmentEntity> theDepartmentEntity);

    public Page<StudentView> toStudentPage(Page<StudentEntity> studentEntity){
        return new PageImpl<>(toStudentListView(studentEntity.toList()), studentEntity.getPageable(), studentEntity.getTotalElements());
    }
    public Page<TeacherView> toTeacherPage(Page<TeacherEntity> teacherEntity){
        return new PageImpl<>(toTeacherListView(teacherEntity.toList()), teacherEntity.getPageable(), teacherEntity.getTotalElements());
    }
    public Page<GroupView> toGroupPage(Page<GroupEntity> groupEntity){
        return new PageImpl<>(toGroupListView(groupEntity.toList()), groupEntity.getPageable(), groupEntity.getTotalElements());
    }
    public Page<GroupClassesView> toGroupClassesPage(Page<GroupClassesEntity> groupClassesEntity){
        return new PageImpl<>(toGroupClassesListView(groupClassesEntity.toList()), groupClassesEntity.getPageable(), groupClassesEntity.getTotalElements());
    }
    public Page<FacultyView> toFacultyPage(Page<FacultyEntity> facultyEntity){
        return new PageImpl<>(toFacultyListView(facultyEntity.toList()), facultyEntity.getPageable(), facultyEntity.getTotalElements());
    }
    public Page<CandidateView> toCandidatePage(Page<CandidateEntity> candidateEntity){
        return new PageImpl<>(toCandidateListView(candidateEntity.toList()), candidateEntity.getPageable(), candidateEntity.getTotalElements());
    }
    public Page<DoctoralView> toDoctoralPage(Page<DoctoralEntity> doctoralEntity){
        return new PageImpl<>(toDoctoralListView(doctoralEntity.toList()), doctoralEntity.getPageable(), doctoralEntity.getTotalElements());
    }
    public Page<DiplomaView> toDiplomaPage(Page<DiplomaEntity> diplomaEntity){
        return new PageImpl<>(toDiplomaListView(diplomaEntity.toList()), diplomaEntity.getPageable(), diplomaEntity.getTotalElements());
    }
    public Page<TheDepartmentView> toTheDepartmentPage(Page<TheDepartmentEntity> theDepartmentEntity){
        return new PageImpl<>(toTheDepartmentListView(theDepartmentEntity.toList()), theDepartmentEntity.getPageable(), theDepartmentEntity.getTotalElements());
    }
    public Page<StudentRecordView> toStudentRecordPage(Page<StudentRecordEntity> studentRecordEntity){
        return new PageImpl<>(toStudentRecordListView(studentRecordEntity.toList()), studentRecordEntity.getPageable(), studentRecordEntity.getTotalElements());
    }
}
