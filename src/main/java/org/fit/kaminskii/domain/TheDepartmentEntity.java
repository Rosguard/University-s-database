package org.fit.kaminskii.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "The_department", schema = "public", catalog = "postgres")
public class TheDepartmentEntity {
    @Id
    @Column(name = "the_department_name", nullable = false, length = -1)
    private String name;
    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "theDepartmentByTheDepartment")
    private Collection<DiplomaEntity> diplomasByName;
    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "theDepartment")
    private Collection<GroupClassesEntity> groupClassesByName;
    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "theDepartment")
    private Collection<TeacherEntity> teachersByName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Faculty", referencedColumnName = "faculty_name")
    private FacultyEntity faculty;
}