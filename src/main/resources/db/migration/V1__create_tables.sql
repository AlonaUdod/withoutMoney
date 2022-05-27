create table users (
    id       bigserial not null constraint  users_pk primary key,
    email     varchar (255) not null unique,
    firstName varchar (50) not null,
    lastName  varchar (50) not null,
    password  varchar (255) not null,
    role      varchar (20) default 'USER'
);
