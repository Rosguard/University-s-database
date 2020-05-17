select "Number of group"
from "Group"
         left join "Student" on "Student"."Group" = "Number of group"
where "Student"."Group" isnull;