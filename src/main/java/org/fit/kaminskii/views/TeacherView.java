package org.fit.kaminskii.views;

import lombok.Data;
import org.fit.kaminskii.model.Sex;
import org.fit.kaminskii.model.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@Data
public class TeacherView {
    private int teacherCode;
    @NotNull
    private String secondName;
    @NotNull
    private String firstName;
    @NotNull
    private String thirdName;
    @NotNull
    private String faculty;
    @NotNull
    private String theDepartment;
    @NotNull
    private Category category;
    @NotNull
    private Sex sex;
    @NotNull
    private Date birthday;
    private Integer age;
    private Integer numberOfChildren;
    @NotNull
    @Min(0)
    private BigDecimal salary;
    private String doctoral;
    private String candidate;

//    public String getSex() {
//        return sex.getSex();
//    }
//
//    public String getCategory() {
//        return category.getCategory();
//    }

}