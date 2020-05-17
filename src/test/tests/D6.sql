select "Second name", "First name", "Third name", "Name"
from "Diploma"
         join "Teacher" on "Teacher code" = "Scientific director code"
where "Name" like '%Авто%';