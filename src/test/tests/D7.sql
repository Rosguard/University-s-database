select "Second name", "First name", "Third name", "The department"
from "Teacher"
where "The department" in ('Общей информатики', 'Геофизики')
order by "Second name" desc;