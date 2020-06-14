package org.fit.kaminskii.db_converters;

import org.fit.kaminskii.model.Category;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category value) {
        if (value == null) {
            return null;
        }
        return value.getCategory();
    }

    @Override
    public Category convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Category.findByCategory(value);
    }
}
