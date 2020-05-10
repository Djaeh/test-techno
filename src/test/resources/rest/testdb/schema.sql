drop table book if exists;
drop table author if exists;
create table author (id bigint not null, first_name varchar(255), name varchar(255), primary key (id));
create table book (id bigint not null, isbn varchar(255), author_id bigint, primary key (id));