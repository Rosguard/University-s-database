package org.fit.kaminskii.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ExamType {
    EXAM("Экзамен"),
    CREDIT("Зачет");

    private final String examType;

    ExamType(String examType) {
        this.examType = examType;
    }

    @JsonValue
    public String getExamType() {
        return examType;
    }

    @JsonCreator
    public static ExamType findByExamType(String examType) {
        for (ExamType one : values()) {
            if (one.examType.equals(examType))
                return one;
        }
        throw new IllegalArgumentException(String.format("Error examType for %s", examType));
    }
}