package org.fit.kaminskii.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudentRecordEntityPK implements Serializable {
    @Column(name = "subject", nullable = false, length = -1)
    private String subject;
    @Column(name = "student_code", nullable = false)
    private int studentCode;
}