package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@Table(name = "doctoral", schema = "public", catalog = "postgres")
public class DoctoralEntity {
    @Id
    @Column(name = "doctoral_name", nullable = false, length = -1)
    private String name;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;
    @Basic
    @Column(name = "theme", nullable = true, length = -1)
    private String theme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctoral")
    private Collection<TeacherEntity> teachersByName;
}
