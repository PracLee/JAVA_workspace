select * from all_tables;
create table test(
name varchar(20),
email varchar(30)
);
insert into test values('lee','spsbsc@naver.com');
insert into test values('ari','ari@naver.com');
insert into test values('timo','timo@naver.com');
select * from REPLY;
select * from CTABLE;
drop table cTable;

create table cTable(
cnum int primary key,
com varchar(300) not null,
ID varchar(30) not null,
PW varchar(30) not null
);
create table reply(
rnum int primary key,
rid varchar(30) not null,
cnum int not null,
rom varchar(200) not null
);
select * from reply where cnum = 1 and rid = 'admin' and rom='하하하하';
insert into ctable values(1, '테스트입니다', 'admin','1234');
insert into REPLY values(1,'admin',1,'1번 대댓글');
insert into REPLY values(2,'admin',1,'2번 대댓글');
select * from ctable order by cNum;
