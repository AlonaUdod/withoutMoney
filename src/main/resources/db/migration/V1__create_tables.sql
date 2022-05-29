create table users (
    id       bigserial not null constraint  users_pk primary key,
    email     varchar (255) not null unique,
    firstName varchar (50) not null,
    lastName  varchar (50) not null,
    password  varchar (255) not null,
    role      varchar (20) default 'USER'
);

insert into users values (1, 'Аліса', 'Герольд', 'alica@gmail.com', '111', 'ADMIN')

-- insert into users values (2,'Том','Тіщенко','tom@gmail.com','222','USER')
--
-- insert into users values (3,'Аліна','Дивнич','alina@gmail.com','333','GUEST')
