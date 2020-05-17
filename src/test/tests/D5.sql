select "Group", count(*) as lol
from "Student"
group by "Group"
having count(*) = (select max(con) from (select count(*) as con from "Student"group by "Group") as foo);

