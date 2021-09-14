insert into userInfo values ('admin','1234','1');
insert into userInfo(ID,PW) values ('test01','1234');
insert into post values('0','admin','공지사항','공지사항테스트입니다.',sysdate);
insert into post values('1','admin','a','공지사항테스트입니다.',sysdate);
insert into post values('2','admin','bbb','공지사항테스트입니다.',sysdate);
select * from post where ID='admin' order by postnum desc;
select * from post where title like '공%';
select * from all_tables;
select * from post;
select * from userInfo;
drop table userinfo;
drop table post;
drop table reply;
create table userInfo(
	id varchar(20) primary key,
	pw varchar(40) not null,
	admin char(1) default '0'
	constraint userinfo_admin_CK
	CHECK(admin in('0','1')) --0이면 false 1이면 true
);


create table post(
	postNum	int primary key,
	id varchar(20),
	title varchar(100),
	content varchar(1000),
	postDate date default sysdate,
	foreign key (id) references userInfo(id) on delete cascade
);

create table reply(
	rNum int primary key,
	postNum int,
	reply varchar(300),
	replydate date default sysdate,
	foreign key (postNum) references post(postNum) on delete cascade
);