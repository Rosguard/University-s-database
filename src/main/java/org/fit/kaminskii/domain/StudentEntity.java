package org.fit.kaminskii.domain;

import lombok.Data;
import org.fit.kaminskii.converters.SexConverter;
import org.fit.kaminskii.model.Sex;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@Table(name = "student", schema = "public", catalog = "postgres")
public class StudentEntity {
    @Id
    @GeneratedValue
    @Column(name = "student_code", nullable = false)
    private int studentCode;
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
    @Column(name = "sex", nullable = true, length = -1)
    @Convert(converter = SexConverter.class)
    private Sex sex;
    @Basic
    @Column(name = "birthday", nullable = true)
    private Date birthday;
    @Basic
    @Column(name = "age", nullable = true)
    private Integer age;
    @Basic
    @Column(name = "number_of_children", nullable = true)
    private Integer numberOfChildren;
    @Basic
    @Column(name = "grants", nullable = true)
    private BigDecimal grants;
    @ManyToOne
    @JoinColumn(name = "student_group", referencedColumnName = "number_of_group", insertable = false, updatable = false)
    private GroupEntity studentGroup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentByStudentCode")
    private Collection<StudentRecordEntity> studentRecordsByStudentCode;
}
