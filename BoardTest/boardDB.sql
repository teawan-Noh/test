drop table bbs;
select * from bbs;
select * from customer;
select * from bbs where subject like '%b%' order by no desc
select * from bbs where no = 22;
update bbs set subject = 'せせ', content = 'ず2ず2' where no = 23
update bbs set cnt = 2 where no = 24

create table bbs(
	no Number primary key,
	subject varchar2(100) not null,
	content varchar2(300) not null,
	wdate date not null,
	cnt number,
	id varchar2(50) CONSTRAINT BBS_ID_FK references CUSTOMER(ID) 
);

create sequence boardseq;

insert into bbs values (boardseq.nextval, 'abc', 'avcc2', sysdate, 0, 'bbq');

create table customer(
	customerseq Number,
	id varchar2(50) primary key,
	name varchar2(50) not null,
	password varchar2(50) not null,
	postcode varchar2(50),
	address varchar2(150),
	address2 varchar2(150),
	phone varchar2(50),
	email varchar2(50)
);

create sequence customerseq;