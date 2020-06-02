package org.fit.kaminskii.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.fit.kaminskii.domain.CandidateEntity;
import org.fit.kaminskii.domain.DiplomaEntity;
import org.fit.kaminskii.domain.DoctoralEntity;
import org.fit.kaminskii.domain.FacultyEntity;
import org.fit.kaminskii.domain.GroupClassesEntity;
import org.fit.kaminskii.domain.GroupEntity;
import org.fit.kaminskii.domain.StudentEntity;
import org.fit.kaminskii.domain.StudentRecordEntity;
import org.fit.kaminskii.domain.TeacherEntity;
import org.fit.kaminskii.domain.TheDepartmentEntity;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.model.TeacherCategory;
import org.fit.kaminskii.views.CandidateView;
import org.fit.kaminskii.views.DiplomaView;
import org.fit.kaminskii.views.DoctoralView;
import org.fit.kaminskii.views.FacultyView;
import org.fit.kaminskii.views.GroupClassesView;
import org.fit.kaminskii.views.GroupView;
import org.fit.kaminskii.views.StudentRecordView;
import org.fit.kaminskii.views.StudentView;
import org.fit.kaminskii.views.TeacherView;
import org.fit.kaminskii.views.TheDepartmentView;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-25T08:21:44+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class Mapper4databaseImpl extends Mapper4database {

    @Override
    public void toCandidateEntity(CandidateView candidate, CandidateEntity candidateEntity) {
        if ( candidate == null ) {
            return;
        }

        if ( candidate.getName() != null ) {
            candidateEntity.setName( candidate.getName() );
        }
        if ( candidate.getDate() != null ) {
            candidateEntity.setDate( candidate.getDate() );
        }
        if ( candidate.getTheme() != null ) {
            candidateEntity.setTheme( candidate.getTheme() );
        }
    }

    @Override
    public void toDiplomaEntity(DiplomaView diploma, DiplomaEntity diplomaEntity) {
        if ( diploma == null ) {
            return;
        }

        diplomaEntity.setStudentCode( diploma.getStudentCode() );
        if ( diploma.getName() != null ) {
            diplomaEntity.setName( diploma.getName() );
        }
        if ( diploma.getTheme() != null ) {
            diplomaEntity.setTheme( diploma.getTheme() );
        }
        if ( diploma.getTheDepartment() != null ) {
            diplomaEntity.setTheDepartment( diploma.getTheDepartment() );
        }
        if ( diploma.getScientificDirectorCode() != null ) {
            diplomaEntity.setScientificDirectorCode( diploma.getScientificDirectorCode() );
        }
    }

    @Override
    public void toDoctoralEntity(DoctoralView doctoral, DoctoralEntity doctoralEntity) {
        if ( doctoral == null ) {
            return;
        }

        if ( doctoral.getName() != null ) {
            doctoralEntity.setName( doctoral.getName() );
        }
        if ( doctoral.getDate() != null ) {
            doctoralEntity.setDate( doctoral.getDate() );
        }
        if ( doctoral.getTheme() != null ) {
            doctoralEntity.setTheme( doctoral.getTheme() );
        }
    }

    @Override
    public void toFacultyEntity(FacultyView faculty, FacultyEntity facultyEntity) {
        if ( faculty == null ) {
            return;
        }

        if ( faculty.getName() != null ) {
            facultyEntity.setName( faculty.getName() );
        }
    }

    @Override
    public void toGroupClassesEntity(GroupClassesView groupClasses, GroupClassesEntity groupClassesEntity) {
        if ( groupClasses == null ) {
            return;
        }

        if ( groupClasses.getStartDate() != null ) {
            groupClassesEntity.setStartDate( groupClasses.getStartDate() );
        }
        if ( groupClasses.getFinishDate() != null ) {
            groupClassesEntity.setFinishDate( groupClasses.getFinishDate() );
        }
        if ( groupClasses.getLessonType() != null ) {
            groupClassesEntity.setLessonType( groupClasses.getLessonType() );
        }
        if ( groupClasses.getSemester() != null ) {
            groupClassesEntity.setSemester( groupClasses.getSemester() );
        }
        if ( groupClasses.getVolume() != null ) {
            groupClassesEntity.setVolume( groupClasses.getVolume() );
        }
        if ( groupClasses.getName() != null ) {
            groupClassesEntity.setName( groupClasses.getName() );
        }
    }

    @Override
    public void toGroupEntity(GroupView group, GroupEntity groupEntity) {
        if ( group == null ) {
            return;
        }

        groupEntity.setNumberOfGroup( group.getNumberOfGroup() );
        if ( group.getCourse() != null ) {
            groupEntity.setCourse( group.getCourse() );
        }
        if ( group.getFaculty() != null ) {
            groupEntity.setFaculty( group.getFaculty() );
        }
    }

    @Override
    public void toStudentEntity(StudentView student, StudentEntity studentEntity) {
        if ( student == null ) {
            return;
        }

        studentEntity.setStudentCode( student.getStudentCode() );
        if ( student.getSecondName() != null ) {
            studentEntity.setSecondName( student.getSecondName() );
        }
        if ( student.getFirstName() != null ) {
            studentEntity.setFirstName( student.getFirstName() );
        }
        if ( student.getThirdName() != null ) {
            studentEntity.setThirdName( student.getThirdName() );
        }
        if ( student.getSex() != null ) {
            studentEntity.setSex( Enum.valueOf( Sex.class, student.getSex() ) );
        }
        if ( student.getBirthday() != null ) {
            studentEntity.setBirthday( student.getBirthday() );
        }
        if ( student.getAge() != null ) {
            studentEntity.setAge( student.getAge() );
        }
        if ( student.getNumberOfChildren() != null ) {
            studentEntity.setNumberOfChildren( student.getNumberOfChildren() );
        }
        if ( student.getGrants() != null ) {
            studentEntity.setGrants( student.getGrants() );
        }
    }

    @Override
    public void toStudentRecordEntity(StudentRecordView studentrecord, StudentRecordEntity studentRecordEntity) {
        if ( studentrecord == null ) {
            return;
        }

        if ( studentrecord.getSubject() != null ) {
            studentRecordEntity.setSubject( studentrecord.getSubject() );
        }
        studentRecordEntity.setStudentCode( studentrecord.getStudentCode() );
        if ( studentrecord.getTypeOfExam() != null ) {
            studentRecordEntity.setTypeOfExam( studentrecord.getTypeOfExam() );
        }
        if ( studentrecord.getMark() != null ) {
            studentRecordEntity.setMark( studentrecord.getMark() );
        }
        if ( studentrecord.getDateOfExam() != null ) {
            studentRecordEntity.setDateOfExam( studentrecord.getDateOfExam() );
        }
        if ( studentrecord.getTeacherCode() != null ) {
            studentRecordEntity.setTeacherCode( studentrecord.getTeacherCode() );
        }
    }

    @Override
    public void toTeacherEntity(TeacherView teacher, TeacherEntity teacherEntity) {
        if ( teacher == null ) {
            return;
        }

        teacherEntity.setTeacherCode( teacher.getTeacherCode() );
        if ( teacher.getSecondName() != null ) {
            teacherEntity.setSecondName( teacher.getSecondName() );
        }
        if ( teacher.getFirstName() != null ) {
            teacherEntity.setFirstName( teacher.getFirstName() );
        }
        if ( teacher.getThirdName() != null ) {
            teacherEntity.setThirdName( teacher.getThirdName() );
        }
        if ( teacher.getCategory() != null ) {
            teacherEntity.setCategory( Enum.valueOf( TeacherCategory.class, teacher.getCategory() ) );
        }
        if ( teacher.getSex() != null ) {
            teacherEntity.setSex( Enum.valueOf( Sex.class, teacher.getSex() ) );
        }
        if ( teacher.getBirthday() != null ) {
            teacherEntity.setBirthday( teacher.getBirthday() );
        }
        if ( teacher.getAge() != null ) {
            teacherEntity.setAge( teacher.getAge() );
        }
        if ( teacher.getNumberOfChildren() != null ) {
            teacherEntity.setNumberOfChildren( teacher.getNumberOfChildren() );
        }
        if ( teacher.getSalary() != null ) {
            teacherEntity.setSalary( teacher.getSalary() );
        }
    }

    @Override
    public void toTheDepartmentEntity(TheDepartmentView theDepartment, TheDepartmentEntity theDepartmentEntity) {
        if ( theDepartment == null ) {
            return;
        }

        if ( theDepartment.getName() != null ) {
            theDepartmentEntity.setName( theDepartment.getName() );
        }
    }

    @Override
    public CandidateView toCandidateView(CandidateEntity candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        CandidateView candidateView = new CandidateView();

        candidateView.setName( candidateEntity.getName() );
        candidateView.setDate( candidateEntity.getDate() );
        candidateView.setTheme( candidateEntity.getTheme() );

        return candidateView;
    }

    @Override
    public List<CandidateView> toCandidateListView(Iterable<CandidateEntity> candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        List<CandidateView> list = new ArrayList<CandidateView>();
        for ( CandidateEntity candidateEntity1 : candidateEntity ) {
            list.add( toCandidateView( candidateEntity1 ) );
        }

        return list;
    }

    @Override
    public DiplomaView toDiplomaView(DiplomaEntity diplomaEntity) {
        if ( diplomaEntity == null ) {
            return null;
        }

        DiplomaView diplomaView = new DiplomaView();

        diplomaView.setStudentCode( diplomaEntity.getStudentCode() );
        diplomaView.setName( diplomaEntity.getName() );
        diplomaView.setTheme( diplomaEntity.getTheme() );
        diplomaView.setTheDepartment( diplomaEntity.getTheDepartment() );
        diplomaView.setScientificDirectorCode( diplomaEntity.getScientificDirectorCode() );

        return diplomaView;
    }

    @Override
    public DoctoralView toDoctoralView(DoctoralEntity doctoralEntity) {
        if ( doctoralEntity == null ) {
            return null;
        }

        DoctoralView doctoralView = new DoctoralView();

        doctoralView.setName( doctoralEntity.getName() );
        doctoralView.setDate( doctoralEntity.getDate() );
        doctoralView.setTheme( doctoralEntity.getTheme() );

        return doctoralView;
    }

    @Override
    public List<DoctoralView> toDoctoralListView(Iterable<DoctoralEntity> doctoralEntity) {
        if ( doctoralEntity == null ) {
            return null;
        }

        List<DoctoralView> list = new ArrayList<DoctoralView>();
        for ( DoctoralEntity doctoralEntity1 : doctoralEntity ) {
            list.add( toDoctoralView( doctoralEntity1 ) );
        }

        return list;
    }

    @Override
    public FacultyView toFacultyView(FacultyEntity facultyEntity) {
        if ( facultyEntity == null ) {
            return null;
        }

        FacultyView facultyView = new FacultyView();

        facultyView.setName( facultyEntity.getName() );

        return facultyView;
    }

    @Override
    public GroupClassesView toGroupClassesView(GroupClassesEntity groupclassesEntity) {
        if ( groupclassesEntity == null ) {
            return null;
        }

        GroupClassesView groupClassesView = new GroupClassesView();

        groupClassesView.setTheDepartment( groupclassesEntityTheDepartmentName( groupclassesEntity ) );
        groupClassesView.setStartDate( groupclassesEntity.getStartDate() );
        groupClassesView.setFinishDate( groupclassesEntity.getFinishDate() );
        groupClassesView.setLessonType( groupclassesEntity.getLessonType() );
        groupClassesView.setSemester( groupclassesEntity.getSemester() );
        groupClassesView.setVolume( groupclassesEntity.getVolume() );
        groupClassesView.setName( groupclassesEntity.getName() );

        return groupClassesView;
    }

    @Override
    public GroupView toGroupView(GroupEntity groupEntity) {
        if ( groupEntity == null ) {
            return null;
        }

        GroupView groupView = new GroupView();

        groupView.setNumberOfGroup( groupEntity.getNumberOfGroup() );
        groupView.setCourse( groupEntity.getCourse() );
        groupView.setFaculty( groupEntity.getFaculty() );

        return groupView;
    }

    @Override
    public StudentView toStudentView(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentView studentView = new StudentView();

        studentView.setGroup( studentEntityStudentGroupNumberOfGroup( studentEntity ) );
        studentView.setStudentCode( studentEntity.getStudentCode() );
        studentView.setSecondName( studentEntity.getSecondName() );
        studentView.setFirstName( studentEntity.getFirstName() );
        studentView.setThirdName( studentEntity.getThirdName() );
        studentView.setSex( studentEntity.getSex() );
        studentView.setBirthday( studentEntity.getBirthday() );
        studentView.setAge( studentEntity.getAge() );
        studentView.setNumberOfChildren( studentEntity.getNumberOfChildren() );
        studentView.setGrants( studentEntity.getGrants() );

        return studentView;
    }

    @Override
    public List<StudentView> toStudentListView(Iterable<StudentEntity> studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        List<StudentView> list = new ArrayList<StudentView>();
        for ( StudentEntity studentEntity1 : studentEntity ) {
            list.add( toStudentView( studentEntity1 ) );
        }

        return list;
    }

    @Override
    public StudentRecordView toStudentRecordView(StudentRecordEntity studentrecordEntity) {
        if ( studentrecordEntity == null ) {
            return null;
        }

        StudentRecordView studentRecordView = new StudentRecordView();

        studentRecordView.setSubject( studentrecordEntity.getSubject() );
        studentRecordView.setStudentCode( studentrecordEntity.getStudentCode() );
        studentRecordView.setTypeOfExam( studentrecordEntity.getTypeOfExam() );
        studentRecordView.setMark( studentrecordEntity.getMark() );
        studentRecordView.setDateOfExam( studentrecordEntity.getDateOfExam() );
        studentRecordView.setTeacherCode( studentrecordEntity.getTeacherCode() );

        return studentRecordView;
    }

    @Override
    public TeacherView toTeacherView(TeacherEntity teacherEntity) {
        if ( teacherEntity == null ) {
            return null;
        }

        TeacherView teacherView = new TeacherView();

        teacherView.setCandidate( teacherEntityCandidateName( teacherEntity ) );
        teacherView.setDoctoral( teacherEntityDoctoralName( teacherEntity ) );
        teacherView.setTheDepartment( teacherEntityTheDepartmentName( teacherEntity ) );
        teacherView.setFaculty( teacherEntityFacultyName( teacherEntity ) );
        teacherView.setTeacherCode( teacherEntity.getTeacherCode() );
        teacherView.setSecondName( teacherEntity.getSecondName() );
        teacherView.setFirstName( teacherEntity.getFirstName() );
        teacherView.setThirdName( teacherEntity.getThirdName() );
        teacherView.setCategory( teacherEntity.getCategory() );
        teacherView.setSex( teacherEntity.getSex() );
        teacherView.setBirthday( teacherEntity.getBirthday() );
        teacherView.setAge( teacherEntity.getAge() );
        teacherView.setNumberOfChildren( teacherEntity.getNumberOfChildren() );
        teacherView.setSalary( teacherEntity.getSalary() );

        return teacherView;
    }

    @Override
    public List<TeacherView> toTeacherListView(Iterable<TeacherEntity> teacherEntity) {
        if ( teacherEntity == null ) {
            return null;
        }

        List<TeacherView> list = new ArrayList<TeacherView>();
        for ( TeacherEntity teacherEntity1 : teacherEntity ) {
            list.add( toTeacherView( teacherEntity1 ) );
        }

        return list;
    }

    @Override
    public TheDepartmentView toTheDepartmentView(TheDepartmentEntity thedepartmentEntity) {
        if ( thedepartmentEntity == null ) {
            return null;
        }

        TheDepartmentView theDepartmentView = new TheDepartmentView();

        theDepartmentView.setFaculty( thedepartmentEntityFacultyName( thedepartmentEntity ) );
        theDepartmentView.setName( thedepartmentEntity.getName() );

        return theDepartmentView;
    }

    @Override
    public List<TheDepartmentView> toTheDepartmentListView(Iterable<TheDepartmentEntity> theDepartmentEntity) {
        if ( theDepartmentEntity == null ) {
            return null;
        }

        List<TheDepartmentView> list = new ArrayList<TheDepartmentView>();
        for ( TheDepartmentEntity theDepartmentEntity1 : theDepartmentEntity ) {
            list.add( toTheDepartmentView( theDepartmentEntity1 ) );
        }

        return list;
    }

    private String groupclassesEntityTheDepartmentName(GroupClassesEntity groupClassesEntity) {
        if ( groupClassesEntity == null ) {
            return null;
        }
        TheDepartmentEntity theDepartment = groupClassesEntity.getTheDepartment();
        if ( theDepartment == null ) {
            return null;
        }
        String name = theDepartment.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Integer studentEntityStudentGroupNumberOfGroup(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }
        GroupEntity studentGroup = studentEntity.getStudentGroup();
        if ( studentGroup == null ) {
            return null;
        }
        int numberOfGroup = studentGroup.getNumberOfGroup();
        return numberOfGroup;
    }

    private String teacherEntityCandidateName(TeacherEntity teacherEntity) {
        if ( teacherEntity == null ) {
            return null;
        }
        CandidateEntity candidate = teacherEntity.getCandidate();
        if ( candidate == null ) {
            return null;
        }
        String name = candidate.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String teacherEntityDoctoralName(TeacherEntity teacherEntity) {
        if ( teacherEntity == null ) {
            return null;
        }
        DoctoralEntity doctoral = teacherEntity.getDoctoral();
        if ( doctoral == null ) {
            return null;
        }
        String name = doctoral.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String teacherEntityTheDepartmentName(TeacherEntity teacherEntity) {
        if ( teacherEntity == null ) {
            return null;
        }
        TheDepartmentEntity theDepartment = teacherEntity.getTheDepartment();
        if ( theDepartment == null ) {
            return null;
        }
        String name = theDepartment.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String teacherEntityFacultyName(TeacherEntity teacherEntity) {
        if ( teacherEntity == null ) {
            return null;
        }
        FacultyEntity faculty = teacherEntity.getFaculty();
        if ( faculty == null ) {
            return null;
        }
        String name = faculty.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String thedepartmentEntityFacultyName(TheDepartmentEntity theDepartmentEntity) {
        if ( theDepartmentEntity == null ) {
            return null;
        }
        FacultyEntity faculty = theDepartmentEntity.getFaculty();
        if ( faculty == null ) {
            return null;
        }
        String name = faculty.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
