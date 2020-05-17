package org.fit.kaminskii.views;

import lombok.Data;
import org.fit.kaminskii.model.Sex;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@Data
public class StudentView {
    private int studentCode;
    @NotNull
    private String secondName;
    @NotNull
    private String firstName;
    @NotNull
    private String thirdName;
    @NotNull
    private Integer group;
    @NotNull
    private Sex sex;
    @NotNull
    private Date birthday;
    @NotNull
    private Integer age;
    @NotNull
    @Min(0)
    private Integer numberOfChildren;
    @NotNull
    @Min(0)
    private BigDecimal grants;

    public String getSex(){
        return sex.getSex();
    }

}