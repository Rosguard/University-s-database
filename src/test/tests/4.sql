select "Name","The department", "Group", "Course", "Faculty", "Semester", "Start date", "Finish date"
from "Group_classes"
         join "Group" on "Group_classes"."Group" = "Number of group"
where "Group_classes"."Group" = 17205;

