package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "Student_record", schema = "public", catalog = "postgres")
@IdClass(StudentRecordEntityPK.class)
public class StudentRecordEntity {
    @Id
    @Column(name = "Subject", nullable = false, length = -1)
    private String subject;
    @Id
    @Column(name = "student_code", nullable = false)
    private int studentCode;
    @Basic
    @Column(name = "type_of_exam", nullable = true, length = -1)
    private String typeOfExam;
    @Basic
    @Column(name = "mark", nullable = true, length = -1)
    private Integer mark;
    @Basic
    @Column(name = "date_of_exam", nullable = true)
    private Date dateOfExam;
    @Basic
    @Column(name = "teacher_code", nullable = true)
    private Integer teacherCode;
    @ManyToOne
    @JoinColumn(name = "student_code", referencedColumnName = "student_code", nullable = false, insertable = false, updatable = false)
    private StudentEntity studentByStudentCode;
    @ManyToOne
    @JoinColumn(name = "teacher_code", referencedColumnName = "teacher_code", insertable = false, updatable = false)
    private TeacherEntity teacherByTeacherCode;
}
