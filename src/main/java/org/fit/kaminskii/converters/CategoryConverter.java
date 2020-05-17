package org.fit.kaminskii.converters;

import org.fit.kaminskii.model.TeacherCategory;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CategoryConverter implements AttributeConverter<TeacherCategory, String>  {

    @Override
    public String convertToDatabaseColumn(TeacherCategory value) {
        if (value == null) {
            return null;
        }
        return value.getCategory();
    }

    @Override
    public TeacherCategory convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return TeacherCategory.findByCategory(value);
    }
}
