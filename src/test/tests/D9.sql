select "Second name", "First name", "Third name", Lessons, fooo."Group" from (select "Teacher code",foo."Group", max(con) as Lessons
        from (select "Group", count(*) as con, fofo."Teacher code"
              from (select "Teacher code", "Group" from "Group_classes") as fofo
              group by ("Teacher code", "Group")) as foo
        group by foo."Teacher code", "Group") as fooo join "Teacher"
on fooo."Teacher code"="Teacher"."Teacher code";
