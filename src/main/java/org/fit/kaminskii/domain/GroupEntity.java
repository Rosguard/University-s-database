package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "groups", schema = "public", catalog = "postgres")
public class GroupEntity {
    @Id
    @Column(name = "number_of_group", nullable = false)
    private int numberOfGroup;
    @Basic
    @Column(name = "course", nullable = true)
    private Integer course;
    @Basic
    @Column(name = "faculty", nullable = true, length = -1)
    private String faculty;
    @ManyToOne
    @JoinColumn(name = "faculty", referencedColumnName = "faculty_name", insertable = false, updatable = false)
    private FacultyEntity facultyByFaculty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupNumber")
    private Collection<GroupClassesEntity> groupClassesByNumberOfGroup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentGroup")
    private Collection<StudentEntity> studentsByNumberOfGroup;
}
