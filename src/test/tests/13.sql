select "Second name", "First name", "Third name", "Name", "Volume"
from "Group_classes"
         join "Teacher" on "Teacher"."Teacher code" = "Group_classes"."Teacher code"
where "Teacher"."Teacher code" = 9
  and "Semester" = 5;

select "Second name", "First name", "Third name", "Name", "Volume"
from "Group_classes"
         join "Teacher" on "Teacher"."Teacher code" = "Group_classes"."Teacher code"
where "Teacher"."The department" = 'Общей информатики'
  and "Semester" = 5;

select "Second name", "First name", "Third name", sum("Volume")
from "Group_classes"
         join "Teacher" on "Teacher"."Teacher code" = "Group_classes"."Teacher code"
where "Teacher"."Teacher code" = 9
  and "Semester" = 5
group by "Teacher"."Teacher code";

select "Second name", "First name", "Third name", sum("Volume")
from "Group_classes"
         join "Teacher" on "Teacher"."Teacher code" = "Group_classes"."Teacher code"
where "Teacher"."The department" = 'Общей информатики'
  and "Semester" = 5
group by "Teacher"."Teacher code";