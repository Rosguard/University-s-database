package org.fit.kaminskii.converters;


import org.fit.kaminskii.model.LessonType;
import org.springframework.core.convert.converter.Converter;

public class LessonTypeConverter implements Converter<String, LessonType> {
    @Override
    public LessonType convert(String source) {
        return LessonType.findByLessonType(source);
    }
}
