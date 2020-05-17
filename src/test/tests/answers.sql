delete
from clients
where char_length(name) = (select max(char_length(name)) from clients);

update orders
set discount = discount + 10
where discount<90;

select name from cakes order by name;

select clients.name, cakes.name
from orders
         join clients on clients.id = orders.client_id
         join cakes on cakes.id = orders.cake_id
order by cakes.name;

select orders.id, c.name
from orders
         left join confictioners c on orders.confictioner_id = c.id
where discount between 10 and 90
order by orders.id;

select distinct c.name
from orders
         join confictioners c on orders.confictioner_id = c.id
         join cakes c2 on orders.cake_id = c2.id
where c2.name in ('Наполеон', 'Королевский');

select clients.name, avg(execution_date-order_date)
from clients
         join orders kek
              on kek.client_id=clients.id
group by clients.id
having avg(execution_date-order_date) > 10;

select distinct on(clients.id) clients.name, c.name
from clients
         left join (select clients.id, cake_id, count(o.id) as cnt
                    from clients
                             left join orders o on clients.id = o.client_id
                    group by (clients.id, o.cake_id)
                    order by cnt desc, clients.id) as kek
                   on kek.id=clients.id
         left join cakes c on kek.cake_id=c.id
group by clients.id, c.name;
