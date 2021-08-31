insert into userInfo values ('admin','1234','1');
insert into post values('0','admin','��������','���������׽�Ʈ�Դϴ�.',sysdate);

select * from all_tables;
select * from post;
select * from userInfo;


create table userInfo(
	id varchar(20) primary key,
	pw varchar(40) not null,
	admin char(1) default '0'
	constraint userinfo_admin_CK
	CHECK(admin in('0','1')) --0�̸� false 1�̸� true
);


create table post(
	postNum	int primary key,
	id varchar(20),
	title varchar(100),
	content varchar(1000),
	postDate date default sysdate,
	foreign key (id) references userInfo(id) on delete cascade
);