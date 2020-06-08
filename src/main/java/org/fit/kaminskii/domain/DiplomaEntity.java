package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "diploma", schema = "public", catalog = "postgres")
public class DiplomaEntity {
    @Id
    @Column(name = "student_code", nullable = false)
    private int studentCode;
    @Basic
    @Column(name = "diploma_name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "theme", nullable = true, length = -1)
    private String theme;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "the_department", referencedColumnName = "the_department_name", insertable = false, updatable = false)
    private TheDepartmentEntity theDepartmentByTheDepartment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scientific_director_code", referencedColumnName = "teacher_code", insertable = false, updatable = false)
    private TeacherEntity teacherByScientificDirectorCode;

}
