select count(*)
from "Teacher"
         join "Doctoral" on "Teacher"."Faculty" = 'ФИТ';


select "Second name", "First name", "Third name", "Faculty", "Teacher"."Candidate", "Doctoral"
from "Teacher"
         join "Doctoral" on "Teacher"."Faculty" = 'ФИТ';



select count(*)
from "Teacher"
         join "Candidate" on "Teacher"."Candidate" = "Candidate"."Name"
where "Teacher"."The department" = 'Общей информатики';


select "Second name", "First name", "Third name", "The department", "Teacher"."Candidate", "Doctoral"
from "Teacher"
         join "Candidate" on "Teacher"."Candidate" = "Candidate"."Name"
where "Teacher"."The department" = 'Общей информатики';