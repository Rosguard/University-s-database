package org.fit.kaminskii.views;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class StudentRecordView {
    @NotNull
    private String subject;
    @NotNull
    private int studentCode;
    @NotNull
    private String typeOfExam;
    @NotNull
    private Integer mark;
    @NotNull
    private Date dateOfExam;
    @NotNull
    private Integer teacherCode;
}