package org.fit.kaminskii.model;

public enum LessonType {
    LECTURE("Лекция"),
    SEMINAR("Семинар"),
    Laboratory("Лабораторная");

    private final String lessonType;

    LessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getLessonType() {
        return lessonType;
    }

    public static LessonType findByLessonType(String lessonType) {
        for (LessonType one : values()) {
            if (one.lessonType.equals(lessonType))
                return one;
        }
        throw new IllegalArgumentException(String.format("Error lessonType for %s", lessonType));
    }

    @Override
    public String toString() {
        return lessonType;
    }
}