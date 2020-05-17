package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Faculty", schema = "public", catalog = "postgres")
public class FacultyEntity {
    @Id
    @Column(name = "faculty_name", nullable = false, length = -1)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultyByFaculty")
    private Collection<GroupEntity> groupsByName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
    private Collection<TeacherEntity> teachersByName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
    private Collection<TheDepartmentEntity> theDepartmentsByName;


}
