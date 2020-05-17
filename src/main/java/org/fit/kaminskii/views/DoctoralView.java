package org.fit.kaminskii.views;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class DoctoralView {
    @NotNull
    private String name;
    @NotNull
    private Date date;
    @NotNull
    private String theme;
}