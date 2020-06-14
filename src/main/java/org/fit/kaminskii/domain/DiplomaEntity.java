package org.fit.kaminskii.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "the_department", referencedColumnName = "the_department_name")
    private TheDepartmentEntity theDepartmentByTheDepartment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scientific_director_code", referencedColumnName = "teacher_code")
    private TeacherEntity teacherByScientificDirectorCode;

}
