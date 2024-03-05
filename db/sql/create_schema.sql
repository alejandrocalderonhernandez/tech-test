create table users(
                          id    bigserial primary key,
                          username varchar(32)  not null,
                          password varchar(512)  not null,
                          email   varchar(64) not null,
                          address   varchar(128) not null,
                          user_role varchar(32) not null
);