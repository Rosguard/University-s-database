package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "group_classes", schema = "public", catalog = "postgres")
@IdClass(GroupClassesEntityPK.class)
public class GroupClassesEntity {

    @Basic
    @Column(name = "start_date", nullable = true)
    private Date startDate;
    @Basic
    @Column(name = "finish_date", nullable = true)
    private Date finishDate;
    @Id
    @Column(name = "lesson_type", nullable = false, length = -1)
    private String lessonType;
    @Basic
    @Column(name = "semester", nullable = true)
    private Integer semester;
    @Basic
    @Column(name = "volume", nullable = true)
    private Integer volume;
    @Id
    @Column(name = "lesson_name", nullable = false, length = -1)
    private String name;
    @Id
    @ManyToOne
    @JoinColumn(name = "group_number", referencedColumnName = "number_of_group", nullable = false, insertable = false, updatable = false)
    private GroupEntity groupNumber;
    @ManyToOne
    @JoinColumn(name = "the_department", referencedColumnName = "the_department_name", nullable = false, insertable = false, updatable = false)
    private TheDepartmentEntity theDepartment;
    @ManyToOne
    @JoinColumn(name = "teacher_code", referencedColumnName = "teacher_code", insertable = false, updatable = false)
    private TeacherEntity teacherCode;
}
