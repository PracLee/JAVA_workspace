select * from all_tables;

create table board (
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);
create table member(
	id varchar(15) primary key,
	pw varchar(10),
	name varchar(15),
	role varchar(15)
);

insert into member values('lee','1234','ÀÌ¾¾','User');
insert into member values('add','1234','admin','ADMIN');
select * from member;

insert into board(id, title, writer,content) values(1,'title','ÀÌ¾¾','content');
select * from board;
select * from member;