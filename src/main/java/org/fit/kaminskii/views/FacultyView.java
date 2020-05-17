package org.fit.kaminskii.views;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FacultyView {
    @NotNull
    private String name;
}
