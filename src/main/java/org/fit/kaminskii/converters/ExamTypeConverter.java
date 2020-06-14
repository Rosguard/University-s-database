package org.fit.kaminskii.converters;


import org.fit.kaminskii.model.ExamType;
import org.springframework.core.convert.converter.Converter;

public class ExamTypeConverter implements Converter<String, ExamType> {
    @Override
    public ExamType convert(String source) {
        return ExamType.findByExamType(source);
    }
}
