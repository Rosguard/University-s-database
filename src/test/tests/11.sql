select "Second name", "First name", "Third name", "Name"
from "Diploma"
join "Student" on "Diploma"."Student code" = "Student"."Student code"
where "The department" = 'Общей информатики';

select "Second name", "First name", "Third name", "Name"
from "Diploma"
         join "Student" on "Diploma"."Student code" = "Student"."Student code"
where "Scientific director code" = 5;