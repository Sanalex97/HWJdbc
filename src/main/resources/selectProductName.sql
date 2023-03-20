select productname
from ddl.CUSTOMERS
         left join ddl.ORDERS o on CUSTOMERS.id = o.customerid
where lower(ddl.CUSTOMERS.name) = lower(:name);
