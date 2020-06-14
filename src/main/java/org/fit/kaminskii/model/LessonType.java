package org.fit.kaminskii.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LessonType {
    LECTURE("Лекция"),
    SEMINAR("Семинар"),
    Laboratory("Лабораторная");

    private final String lessonType;

    LessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    @JsonValue
    public String getLessonType() {
        return lessonType;
    }

    @JsonCreator
    public static LessonType findByLessonType(String lessonType) {
        for (LessonType one : values()) {
            if (one.lessonType.equals(lessonType))
                return one;
        }
        throw new IllegalArgumentException(String.format("Error lessonType for %s", lessonType));
    }
}