create table ddl.CUSTOMERS
(
    id          serial primary key,
    name        varchar(20),
    surname     varchar(30),
    age         int,
    phoneNumber varchar(11)
);

insert into ddl.CUSTOMERS (name, surname, age, phoneNumber)
values ('Alexey', 'Ivanov', '32', '89111823774'),
       ('Ivan', 'Petrov', '43', '89111823444'),
       ('Semen', 'Shunin', '36', '89111327774');


create table ddl.ORDERS
(
    id          serial primary key,
    date        date,
    customerId  integer references ddl.CUSTOMERS (id),
    productName varchar,
    amount      int
);

insert into ddl.ORDERS(date, customerid, productname, amount)
values ('11.03.2023', '1', 'orange', '130'),
       ('11.03.2023', '1', 'potato', '100'),
       ('11.03.2023', '2', 'pasta', '80'),
       ('11.03.2023', '1', 'sauce', '70'),
       ('11.03.2023', '3', 'cucumber', '150');


