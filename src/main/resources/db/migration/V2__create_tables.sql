create table goods (
    id          bigserial   not null
        constraint goods_pk primary key,
    user_id        bigint not null,
    name        varchar(150) not null,
    description varchar  (255)   not null,
    type        varchar (20) not null
);

insert into goods values (1, 2, 'Марка "руский военый корабль. Всьо"',
                          'Комплект марок серия F. В хорошому стані. Нові.', 'PRODUCT');

insert into goods values (2, 2, 'Поштовий конверт "руский военый корабль. Всьо"', 'В хорошому стані.', 'PRODUCT');

insert into goods values (3, 2, 'Поштова листівка "руский военый корабль пошол, ІДІ...!"', 'В хорошому стані.', 'PRODUCT');