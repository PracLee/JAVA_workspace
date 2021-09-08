select * from all_tables;
create table test(
name varchar(20),
email varchar(30)
);
insert into test values('lee','spsbsc@naver.com');
insert into test values('ari','ari@naver.com');
insert into test values('timo','timo@naver.com');
select * from test;
drop table cTable;

create table cTable(
cnum int primary key,
com varchar(300) not null,
ID varchar(30) not null,
PW varchar(30) not null
);
insert into ctable values(1, '테스트입니다', 'admin','1234');
select * from ctable order by cNum;