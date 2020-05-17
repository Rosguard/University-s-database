package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "The_department", schema = "public", catalog = "postgres")
public class TheDepartmentEntity {
    @Id
    @Column(name = "the_department_name", nullable = false, length = -1)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theDepartmentByTheDepartment")
    private Collection<DiplomaEntity> diplomasByName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theDepartment")
    private Collection<GroupClassesEntity> groupClassesByName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theDepartment")
    private Collection<TeacherEntity> teachersByName;
    @ManyToOne
    @JoinColumn(name = "Faculty", referencedColumnName = "faculty_name", insertable = false, updatable = false)
    private FacultyEntity faculty;
}