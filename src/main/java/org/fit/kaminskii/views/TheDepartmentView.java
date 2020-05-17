package org.fit.kaminskii.views;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data

public class TheDepartmentView {
    @NotNull
    private String name;
    @NotNull
    private String faculty;
}