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
@Table(name = "Student_record", schema = "public", catalog = "postgres")
public class StudentRecordEntity {
    @EmbeddedId
    private StudentRecordEntityPK studentRecordEntityPK;

    @Basic
    @Column(name = "type_of_exam", nullable = true, length = -1)
    private String typeOfExam;
    @Basic
    @Column(name = "mark", nullable = true, length = -1)
    private Integer mark;
    @Basic
    @Column(name = "date_of_exam", nullable = true)
    private Date dateOfExam;
    @MapsId("studentCode")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_code", referencedColumnName = "student_code", nullable = false, insertable = false, updatable = false)
    private StudentEntity studentByStudentCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_code", referencedColumnName = "teacher_code", insertable = false, updatable = false)
    private TeacherEntity teacherByTeacherCode;
}
