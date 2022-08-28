create table customer
(
    id          bigint auto_increment,
    username    varchar(50) null,
    grade       varchar(50) null,
    user_status int         null,
    constraint customer_pk
        primary key (id)
);

create unique index customer_id_uindex
    on customer (id);
