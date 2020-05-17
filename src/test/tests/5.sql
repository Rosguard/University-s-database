select "Second name", "First name", "Third name", "Name", "Group", "Group"."Faculty"
from "Group_classes"
         join "Teacher" on "Teacher"."Teacher code" = "Group_classes"."Teacher code"
         join "Group" on "Group_classes"."Group" = "Group"."Number of group"
where "Group_classes"."Name" = 'Базы данных';

select count(*)
from "Group_classes"
         join "Teacher" on "Teacher"."Teacher code" = "Group_classes"."Teacher code"
         join "Group" on "Group_classes"."Group" = "Group"."Number of group"
where "Group_classes"."Name" = 'Базы данных';