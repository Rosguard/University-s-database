package org.fit.kaminskii.views;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DiplomaView {
    private int studentCode;
    @NotNull
    private String name;
    @NotNull
    private String theme;
    @NotNull
    private String theDepartment;
    @NotNull
    private Integer scientificDirectorCode;
}