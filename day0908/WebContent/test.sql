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
insert into ctable values(1, '�׽�Ʈ�Դϴ�', 'admin','1234');
select * from ctable order by cNum;


create table bank1(
   bid int primary key,
    name varchar(20),
    balance int
);
create table bank2(
   bid int primary key,
    name varchar(20),
    balance int
);
insert into bank1 values(1001,'�ƹ���',5000);
insert into bank2 values(2001,'Ƽ��',1000);
select * from bank1;
select * from bank2;