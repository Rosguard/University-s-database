package org.fit.kaminskii.converters;

import org.fit.kaminskii.model.LessonType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LessonTypeConverter implements AttributeConverter<LessonType, String> {

    @Override
    public String convertToDatabaseColumn(LessonType value) {
        if (value == null) {
            return null;
        }
        return value.getLessonType();
    }

    @Override
    public LessonType convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return LessonType.findByLessonType(value);
    }
}