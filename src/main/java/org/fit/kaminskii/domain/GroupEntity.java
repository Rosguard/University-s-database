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
@Table(name = "groups", schema = "public", catalog = "postgres")
public class GroupEntity {
    @Id
    @Column(name = "number_of_group", nullable = false)
    private int numberOfGroup;
    @Basic
    @Column(name = "course", nullable = true)
    private Integer course;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty", referencedColumnName = "faculty_name")
    private FacultyEntity facultyByFaculty;
    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "groupNumber")
    private Collection<GroupClassesEntity> groupClassesByNumberOfGroup;
    @ToString.Exclude
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "studentGroup")
    private Collection<StudentEntity> studentsByNumberOfGroup;
}
