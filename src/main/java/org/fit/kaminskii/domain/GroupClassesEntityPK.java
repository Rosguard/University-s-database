package org.fit.kaminskii.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fit.kaminskii.db_converters.LessonTypeConverter;
import org.fit.kaminskii.model.LessonType;

import javax.persistence.Column;
import javax.persistence.Convert;
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
    @Convert(converter = LessonTypeConverter.class)
    private LessonType lessonType;
    @Column(name = "lesson_name", nullable = false, length = -1)
    private String lessonName;
}