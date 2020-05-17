select "Teacher"."Second name", "Teacher"."First name", "Teacher"."Third name", "Student"."Group", "Type of exam", "Subject", "Semester"
from "Student_record"
join "Teacher" on "Teacher"."Teacher code" = "Student_record"."Teacher code"
join "Student" on "Student"."Student code" = "Student_record"."Student code"
join "Group_classes" on "Group_classes"."Name" = "Student_record"."Subject"
where "Semester" = 5;
