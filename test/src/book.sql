--TODO
--1.book ���̺��� �����.

create table Book(
	bookid number CONSTRAINT Book_bookid_PK primary key,
	bookname varchar2(40),
	price number
);

--2.bookid�� �Է��� sequence�� �����.
create sequence seq_bookid;
