package org.fit.kaminskii.converters;


import org.fit.kaminskii.model.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String, Category> {
    @Override
    public Category convert(String source) {
        return Category.findByCategory(source);
    }
}