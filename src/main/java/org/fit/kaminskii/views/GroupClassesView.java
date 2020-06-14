package org.fit.kaminskii.views;

import lombok.Data;
import org.fit.kaminskii.domain.GroupClassesEntity;
import org.fit.kaminskii.model.LessonType;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class GroupClassesView {
    @NotNull
    private int group;
    @NotNull
    private String theDepartment;
    @NotNull
    private Date startDate;
    @NotNull
    private Date finishDate;
    @NotNull
    private Integer teacherCode;
    @NotNull
    private LessonType lessonType;
    @NotNull
    private Integer semester;
    @NotNull
    private Integer volume;
    @NotNull
    private String name;

//    public String getLessonType(){
//        return lessonType.getLessonType();
//    }
}