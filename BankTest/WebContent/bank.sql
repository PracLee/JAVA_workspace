
	private int account;
	private String name;
	private int balance;
	select * from KAKAO;
	select * from SINHAN;
	drop table kakao;
	drop table sinhan;

	create table Kakao(
	account int primary key,
	name varchar(10),
	balance int default 0
	);
	create table sinhan(
	account int primary key,
	name varchar(10),
	balance int default 0
	);
	insert into KAKAO values(1004,'æ∆∏Æ',10000);
	insert into SINHAN values(10004,'¿ËΩ∫',10000);