select "Second name", "First name", "Third name", "Name", "Lesson type", "Group", "Group"."Faculty", "Semester", "Start date", "Finish date"
from "Group_classes"
         join "Teacher" on "Teacher"."Teacher code" = "Group_classes"."Teacher code"
         join "Group" on "Group_classes"."Group" = "Group"."Number of group"
where "Group_classes"."Group" = 17205;

select count(*)
from "Group_classes"
         join "Teacher" on "Teacher"."Teacher code" = "Group_classes"."Teacher code"
         join "Group" on "Group_classes"."Group" = "Group"."Number of group"
where "Group_classes"."Group" = 17205;