select * from all_tables;
drop table test;
create table userInfo(
ID varchar(20) primary key,
PW varchar(40) not null
);
create table post(
postNum int primary key,
title varchar(50),
content varchar(1000),
ID varchar(20),
postDate date default sysdate,
foreign key (id) references userInfo(id) on delete cascade
);
insert into USERINFO values ('admin','1234');
select * from USERINFO;
select * from POST;