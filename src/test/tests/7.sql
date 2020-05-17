select "Second name", "First name", "Third name", "Group", "Type of exam", "Subject", "Mark"
from "Student_record"
         join "Student" on "Student_record"."Student code" = "Student"."Student code"
where "Mark" = 5;

select count(*)
from "Student_record"
         join "Student" on "Student_record"."Student code" = "Student"."Student code"
where "Mark" = 5;