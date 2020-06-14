package org.fit.kaminskii.views;

import lombok.Data;
import org.fit.kaminskii.model.ExamType;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class StudentRecordView {
    @NotNull
    private String subject;
    @NotNull
    private int studentCode;
    @NotNull
    private ExamType typeOfExam;
    @NotNull
    private Integer mark;
    @NotNull
    private Date dateOfExam;
    @NotNull
    private Integer teacherCode;


//    public String getExamType() {
//        return typeOfExam.getExamType();
//    }
}