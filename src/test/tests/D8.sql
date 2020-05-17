select "Second name", "First name", "Third name", avgmark
from (select "Student code" as scode, avg("Mark") as avgmark
      from "Student_record"
      group by "Student_record"."Student code"
      having avg("Mark") > 4.75) as foo
         join "Student"
              on foo.scode = "Student"."Student code"
