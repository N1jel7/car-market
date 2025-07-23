--liquibase formatted sql

--changeset n1jel:1 dbms:postgresql
create table cars
(
    price      numeric(38, 2),
    id         bigint not null,
    owner      bigint,
    brand      varchar(255),
    generation varchar(255),
    model      varchar(255),
    primary key (id)
);
create table users
(
    id   bigint not null,
    name varchar(255),
    primary key (id)
);
create table users_user_cars
(
    user_cars_id bigint not null unique,
    user_id      bigint not null
);

create sequence cars_seq start with 1 increment by 50;
create sequence users_seq start with 1 increment by 50;

alter table if exists cars
    add constraint FK6n37puiikmpdouubabtcqjclm foreign key (owner) references users;
alter table if exists users_user_cars
    add constraint FK7d3v1r7y1rjsqtpnlguxis1na foreign key (user_cars_id) references cars;
alter table if exists users_user_cars
    add constraint FK1fpqr6wnp0mymwt95056sqiav foreign key (user_id) references users;