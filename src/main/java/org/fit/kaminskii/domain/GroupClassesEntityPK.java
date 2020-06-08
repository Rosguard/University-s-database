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
public class GroupClassesEntityPK implements Serializable {
    @Column(name = "group_number", nullable = false)
    private int groupNumber;
    @Column(name = "lesson_type", nullable = false, length = -1)
    private String lessonType;
    @Column(name = "lesson_name", nullable = false, length = -1)
    private String name;
}