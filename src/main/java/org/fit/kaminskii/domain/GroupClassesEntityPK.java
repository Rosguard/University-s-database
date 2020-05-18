package org.fit.kaminskii.domain;

import lombok.Data;
import org.fit.kaminskii.converters.LessonTypeConverter;
import org.fit.kaminskii.model.LessonType;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Data
public class GroupClassesEntityPK implements Serializable {
    @Column(name = "group_number", nullable = false)
    @Id
    private int groupNumber;
    @Column(name = "lesson_type", nullable = false, length = -1)
    @Id
    //@Convert(converter = LessonTypeConverter.class)
    private String lessonType;
    @Column(name = "lesson_name", nullable = false, length = -1)
    @Id
    private String name;
}