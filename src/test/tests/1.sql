select count(*) from "Student" where "Group"=17205;
select * from "Student" where "Group"=17205;

select count(*) from "Student" where "Sex"='м';
select * from "Student" where "Sex"='м';

select count(*) from "Student" where "Birthday"='1999.08.07';
select * from "Student" where "Birthday"='1999.08.07';

select count(*) from "Student" where "Age"=20;
select * from "Student" where "Age"=20;

select count(*) from "Student" where "Number of children"=0;
select * from "Student" where "Number of children"=0;

select count(*) from "Student" where "Grants"='2500';
select * from "Student" where "Grants"='2500';

select count(*) from "Student", "Group" where "Student"."Group"="Group"."Number of group" AND  "Course" = 3;
select * from "Student", "Group" where "Student"."Group"="Group"."Number of group" AND  "Course" = 3;

select count(*) from "Student", "Group" where "Student"."Group"="Group"."Number of group" AND  "Faculty" = 'ФИТ';
select * from "Student", "Group" where "Student"."Group"="Group"."Number of group" AND  "Faculty" = 'ФИТ';


