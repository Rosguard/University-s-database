package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class StudentRecordEntityPK implements Serializable {
    @Column(name = "subject", nullable = false, length = -1)
    @Id
    private String subject;
    @Column(name = "student_code", nullable = false)
    @Id
    private int studentCode;
}