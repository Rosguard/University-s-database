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

    public String getSex() {
        return sex.getSex();
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public BigDecimal getGrants() {
        return grants;
    }

    public void setGrants(BigDecimal grants) {
        this.grants = grants;
    }
}