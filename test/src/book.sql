--TODO
--1.book 테이블을 만든다.

create table Book(
	bookid number CONSTRAINT Book_bookid_PK primary key,
	bookname varchar2(40),
	price number
);

--2.bookid로 입력할 sequence를 만든다.
create sequence seq_bookid;
