package org.fit.kaminskii.db_converters;

import org.fit.kaminskii.model.ExamType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ExamTypeConverter implements AttributeConverter<ExamType, String> {

    @Override
    public String convertToDatabaseColumn(ExamType value) {
        if (value == null) {
            return null;
        }
        return value.getExamType();
    }

    @Override
    public ExamType convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return ExamType.findByExamType(value);
    }
}