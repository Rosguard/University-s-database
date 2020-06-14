package org.fit.kaminskii.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.fit.kaminskii.db_converters.CategoryConverter;
import org.fit.kaminskii.db_converters.SexConverter;
import org.fit.kaminskii.model.Category;
import org.fit.kaminskii.model.Sex;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Teacher", schema = "public", catalog = "postgres")
public class TeacherEntity {
    @Id
    @GeneratedValue
    @Column(name = "teacher_code", nullable = false)
    private int teacherCode;
    @Basic
    @Column(name = "second_name", nullable = true, length = -1)
    private String secondName;
    @Basic
    @Column(name = "first_name", nullable = true, length = -1)
    private String firstName;
    @Basic
    @Column(name = "third_name", nullable = true, length = -1)
    private String thirdName;
    @Basic
    @Column(name = "teacher_category", nullable = true, length = -1)
    @Convert(converter = CategoryConverter.class)
    private Category category;
    @Basic
    @Column(name = "sex", nullable = true, length = -1)
    @Convert(converter = SexConverter.class)
    private Sex sex;
    @Basic
    @Column(name = "birthday", nullable = true, length = -1)
    private Date birthday;
    @Transient
    private Integer age;
    @Basic
    @Column(name = "number_of_children", nullable = true, length = -1)
    private Integer numberOfChildren;
    @Basic
    @Column(name = "salary", nullable = true, length = -1)
    private BigDecimal salary;
    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "teacherByScientificDirectorCode")
    private Collection<DiplomaEntity> diplomasByTeacherCode;
    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "teacherCode")
    private Collection<GroupClassesEntity> groupClassesByTeacherCode;
    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "teacherByTeacherCode")
    private Collection<StudentRecordEntity> studentRecordsByTeacherCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Faculty", referencedColumnName = "faculty_name")
    private FacultyEntity faculty;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "the_department", referencedColumnName = "the_department_name")
    private TheDepartmentEntity theDepartment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Doctoral", referencedColumnName = "doctoral_name")
    private DoctoralEntity doctoral;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Candidate", referencedColumnName = "candidate_name")
    private CandidateEntity candidate;

    @PostLoad
    void post(){
        Period period = Period.between(LocalDate.parse(birthday.toString()), LocalDate.now());
        this.age = period.getYears();
    }
}
