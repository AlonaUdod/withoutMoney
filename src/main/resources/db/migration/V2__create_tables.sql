create table goods (
    id          bigserial   not null
        constraint users_pk primary key,
    user_id        bigint not null,
    name        varchar(50) not null,
    description varchar  (500)   not null,
    type        varchar varchar (20) not null
);

insert into goods values (1, 2, 'Марка "руский военый корабль. Всьо"',
                          'Комплект марок серия F. В хорошому стані. Нові.', PRODUCT);

insert into goods values (2, 2, 'Поштовий конверт "руский военый корабль. Всьо", в хорошому стані.', PRODUCT);

insert into goods values (3, 2, 'Поштова листівка "руский военый корабль пошол, ІДІ...!", в хорошому стані.', PRODUCT);