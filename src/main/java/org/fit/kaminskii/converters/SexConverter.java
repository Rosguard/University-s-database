package org.fit.kaminskii.converters;


import org.fit.kaminskii.model.Sex;
import org.springframework.core.convert.converter.Converter;

public class SexConverter implements Converter<String, Sex> {
    @Override
    public Sex convert(String source) {
        return Sex.findBySex(source);
    }
}
