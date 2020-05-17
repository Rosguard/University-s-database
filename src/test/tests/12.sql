select "Second name", "First name", "Third name", "Category"
from "Diploma"
         join "Teacher" on "Scientific director code" = "Teacher code"
where "Diploma"."The department" = 'Общей информатики';

select "Second name", "First name", "Third name", "Category"
from "Diploma"
         join "Teacher" on "Scientific director code" = "Teacher code"
where "Teacher"."Faculty" = 'ФИЯ';

select "Second name", "First name", "Third name", "Category"
from "Diploma"
         join "Teacher" on "Scientific director code" = "Teacher code"
where "Diploma"."The department" = 'Общей информатики' and "Category" = 'Доктор';

select "Second name", "First name", "Third name", "Category"
from "Diploma"
         join "Teacher" on "Scientific director code" = "Teacher code"
where "Teacher"."Faculty" = 'ФИЯ' and "Category" = 'Кандидат';
