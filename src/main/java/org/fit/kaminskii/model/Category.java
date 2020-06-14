package org.fit.kaminskii.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    Postgraduate("Аспирант"),
    Candidate("Кандидат"),
    Doctoral("Доктор");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    @JsonValue
    public String getCategory() {
        return category;
    }

    @JsonCreator
    public static Category findByCategory(String category) {
        for (Category one : values()) {
            if (one.category.equals(category))
                return one;
        }
        throw new IllegalArgumentException(String.format("Error teacher category %s", category));
    }

}