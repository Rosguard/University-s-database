package org.fit.kaminskii.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "group_classes", schema = "public", catalog = "postgres")
public class GroupClassesEntity {
    @EmbeddedId
    private GroupClassesEntityPK groupClassesEntityPK;
    @Basic
    @Column(name = "start_date", nullable = true)
    private Date startDate;
    @Basic
    @Column(name = "finish_date", nullable = true)
    private Date finishDate;
    @Basic
    @Column(name = "semester", nullable = true)
    private Integer semester;
    @Basic
    @Column(name = "volume", nullable = true)
    private Integer volume;
    @MapsId("groupNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_number", referencedColumnName = "number_of_group", nullable = false)
    private GroupEntity groupNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "the_department", referencedColumnName = "the_department_name", nullable = false)
    private TheDepartmentEntity theDepartment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_code", referencedColumnName = "teacher_code")
    private TeacherEntity teacherCode;
}
