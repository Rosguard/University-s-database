package org.fit.kaminskii.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Sex {
    MALE("мужской"),
    FEMALE("женский");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }


    @JsonValue
    public String getSex() {
        return sex;
    }

    @JsonCreator
    public static Sex findBySex(String sex) {
        for (Sex one : values()) {
            if (one.sex.equals(sex))
                return one;
        }
        throw new IllegalArgumentException(String.format("Error sex for %s", sex));
    }

}