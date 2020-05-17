select distinct "Student"."Second name", "Student"."First name", "Student"."Third name", "Student"."Group", "Mark", "Teacher"."Second name", "Teacher"."First name", "Teacher"."Third name", "Subject", "Semester","Date of exam"
from "Student"
         join "Student_record" on "Student"."Student code" = "Student_record"."Student code"
         join "Teacher" on "Teacher"."Teacher code" = "Student_record"."Teacher code"
         join "Group_classes" on "Student"."Group" = "Group_classes"."Group"
where "Student_record"."Teacher code" = 2
  and "Type of exam" = 'Экзамен'
  and "Mark" = 5
  and "Subject" = 'Базы данных'
  and "Semester" = 5
  and "Date of exam" between '2019-9-30' and '2019-11-30';