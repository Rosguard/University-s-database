package org.fit.kaminskii.views;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GroupView {
    @NotNull
    private int numberOfGroup;
    @NotNull
    private Integer course;
    @NotNull
    private String faculty;
}