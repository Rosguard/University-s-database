package org.fit.kaminskii.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
@Data
public class GroupClassesEntityPK implements Serializable {
    @Column(name = "group_number", nullable = false)
    @Id
    private int groupNumber;
    @Column(name = "lesson_type", nullable = false, length = -1)
    @Id
    private String lessonType;
    @Column(name = "lesson_name", nullable = false, length = -1)
    @Id
    private String name;
}