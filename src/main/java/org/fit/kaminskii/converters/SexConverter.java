package org.fit.kaminskii.converters;

import org.fit.kaminskii.model.Sex;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SexConverter implements AttributeConverter<Sex, String> {

    @Override
    public String convertToDatabaseColumn(Sex value) {
        if (value == null) {
            return null;
        }
        return value.getSex();
    }

    @Override
    public Sex convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Sex.findBySex(value);
    }
}