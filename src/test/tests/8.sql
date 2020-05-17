select "Second name", "First name", "Third name", "Group"
from "Student"
         join (select "Student code", min("Mark") as min_mark
               from "Student_record"
               group by "Student code") as stud_mark
              on "Student"."Student code" = stud_mark."Student code"
where min_mark >= 3;
