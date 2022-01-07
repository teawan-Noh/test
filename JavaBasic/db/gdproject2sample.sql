select * from patient;
select * from qna;
select * from COMMENTS
insert into comments values (6, 1, sysdate, 'Ȯ�ο���');
select * from REST
insert into rest values (1,1,sysdate,'���','�ް�',sysdate,1)

select p.pcode, p.name, p.birth, r.rcode
from patient p left outer join reservation r 
on p.pcode = r.pcode
where name like '%��%'
order by name asc
			
			
delete from subject where scode is not null;
delete from doctor where dcode is not null;
select qna_seq.nextval from dual;
create sequence comments_seq;
insert into qna values (qna_seq.nextval, 1, '����19', '�����Ϲ��Դϴ�', sysdate, 'image���1', 0);

select q.qno, q.title, p.nickname, q.writedate, q.cnt, q.img, q.content, c.content as ccontent, c.writedate as cwritedate, m.id
from qna q 
inner join patient p on q.pcode = p.pcode
inner join comments c on q.qno = c.qno
inner join manager m on c.mcode = m.mcode
where q.qno = 3;

select q.qno, q.title, p.nickname, q.writedate, q.cnt
from qna q inner join patient p
on q.pcode = p.pcode
where p.nickname like '%¡¡%'
order by q.qno desc;

SELECT a.name
     , a.tel
     , b.rsvdate
     , c.name
     , d.name
  FROM patient a
 INNER JOIN reservation b
    ON a.pcode = b.pcode
 INNER JOIN doctor c
    ON b.dcode = c.dcode
    INNER JOIN subject d
    ON c.scode = d.scode
 WHERE a.pcode = 1;
 
select d.dcode, d.name as dname, s.name as sname, d.licenseno, d.scode
from doctor d 
inner join subject s on d.scode = s.scode
where d.scode = '1';

select * from qna;
select * from patient;

select scode, name from subject


select a.acode, d.name as dname, a.approvedate, a.approved from doctor d inner join approval a
on d.dcode = a.dcode order by a.acode desc;

select q.qno, q.title, p.nickname, q.writedate, q.cnt 
from qna q inner join patient p 
on q.pcode = p.pcode order by q.qno desc;

select q.qno, q.title, p.nickname, q.writedate, q.cnt 
from qna q inner join patient p on q.pcode = p.pcode 
where q.title like ? or q.content like ?
order by q.qno desc;

alter table approval add restdate date;
alter table approval add day varchar(10);

drop table rest;
select * from qna;
insert into rest values (1, 5, sysdate, '����', '����', null, 'FRI');
insert into rest values (7, 4, sysdate, '���', '�ް�', to_date('2021-03-12','yyyy-mm-dd'), null);
insert into rest values (8, 3, sysdate, '���', '�ް�', null, 'WED');
insert into rest values (9, 2, sysdate, '���', '�ް�', to_date('2021-03-15','yyyy-mm-dd'), null);
insert into rest values (5, 1, sysdate, '����', '�Һ�', null, 'MON');

alter table approval rename to rest;
alter table rest rename column acode to rcode;
alter table rest rename column approvedate to requestdate;

select r.rcode, d.name as dname, r.requestdate, r.approved
from doctor d inner join rest r
on d.dcode = r.dcode
order by r.rcode desc;
alter table rest modify day number;
select * from rest;
delete from rest where rcode is not null
pcode, name, birth

select p.pcode, p.name, p.birth, r.rcode
from patient p left outer join reservation r
on p.pcode = r.pcode
order by p.name asc;

select * from reservation;


select q.qno, q.title, p.nickname, q.writedate, q.cnt, q.img, q.content, c.content as ccontent, c.writedate as cwritedate, m.id 
from qna q
left outer join patient p on q.pcode = p.pcode
left outer join comments c on q.qno = c.qno
left outer join manager m on c.mcode = m.mcode
where q.qno = 3;

select * from reservation;
update qna set cnt = 3 where qno = 3

insert into reservation values (13, 3, 1, sysdate, '����');
select count(*) as cnt from qna
SELECT p.pcode, p.name, p.birth, count(r.pcode) rcnt
FROM patient p 
LEFT OUTER JOIN reservation r 
ON p.pcode = r.pcode 
GROUP BY p.pcode, p.name, p.birth
order by p.name asc;

select p.pcode, p.name, p.birth, r.rcode
from patient p left outer join reservation r
on p.pcode = r.pcode
order by p.name asc;

select p.pcode, p.name, p.birth, count(r.pcode) rcnt 
from patient p
left outer join reservation r
on p.pcode = r.pcode
where name like '%��%'
GROUP BY p.pcode, p.name, p.birth
order by p.name asc;


select * from qna

select * from (select rownum as rn, qnas.* from (select q.qno, q.title, p.pcode, p.nickname, q.writedate, q.cnt from qna q left outer join patient p
on q.pcode = p.pcode order by q.qno desc) qnas)
where rn between 1 and 2
order by q.qno desc;

select memoid, name, age
from (select rownum as rn, memos.* from (SELECT * from memo order by memoid desc) memos)
where rn between 1 and 2

select * from (select ROW_NUMBER() OVER(ORDER BY n.writedate desc)
as rn, n.ncode, n.title, m.name, to_char(n.writedate,'yyyy-mm-dd') as writedate, n.cnt
from notice n inner join manager m on n.mcode = m.mcode) where rn between 1 and 5;

select * from (select rownum as rn, q.qno, q.title, p.pcode, p.nickname, q.writedate, q.cnt
from qna q left outer join patient p on q.pcode = p.pcode order by qno desc) where rn between 1 and 5;

select * from (select rownum as rn, q.qno, q.title, p.pcode, p.nickname, q.writedate, q.cnt
from qna q left outer join patient p
on q.pcode = p.pcode
where p.nickname like ?
order by q.qno desc) where rn between ? and ?;

'%��%'
select * from qna;
select * from (select rownum as rn, q.qno, q.title, p.pcode, p.nickname, q.writedate, q.cnt
from qna q left outer join patient p
on q.pcode = p.pcode
where q.title like '%��%' or q.content like '%��%'
order by rn desc) where rn between 1 and 10;

select memoid, name, age
from (select rownum as rn, memos.* from (SELECT * from memo order by memoid desc) memos)
where rn between 1 and 2

select count(*) as cnt from qna q inner join patient p on q.pcode = p.pcode where nickname like '%��%';
select * from qna 

select qno, title, pcode, nickname, writedate, cnt from (select ROW_NUMBER() OVER(ORDER BY q.qno desc) as rn, q.qno, q.title, p.pcode, p.nickname, q.writedate, q.cnt
from qna q left outer join patient p on q.pcode = p.pcode
where p.nickname like '%��%') where rn between 1 and 10;

delete from qna 

insert into qna values (1, 1, '����1', '�����Ϲ��Դϴ�', sysdate, 'image���1', 0);
insert into qna values (2, 3, '����2', '�����̹��Դϴ�', sysdate, 'image���2', 1);
insert into qna values (3, 5, '����3', '��������Դϴ�', sysdate, 'image���3', 727777);
insert into qna values (4, 7, '����4', '��������Դϴ�', sysdate, 'image���4', 1000);
insert into qna values (6, 9, '����5', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (7, 9, '����6', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (8, 9, '����7', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (9, 9, '����8', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (10, 9, '����9', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (11, 9, '����10', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (12, 9, '�����', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (13, 9, '����', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (14, 9, '������', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (15, 9, '������', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (16, 9, '������', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (17, 9, '������', '���������Դϴ�', sysdate, 'image���5', 55555);
insert into qna values (18, 9, '������', '���������Դϴ�', sysdate, 'image���5', 55555);
select * from comments;
delete from patient where pcode = 10
delete from comments

insert into rest values (6, 5, sysdate, '����', '����', sysdate, null);
insert into rest values (2, 4, sysdate, '���', '�ް�', sysdate, null);
insert into rest values (3, 3, sysdate, '���', '�ް�', sysdate, null);
insert into rest values (4, 2, sysdate, '���', '�ް�', sysdate, null);
insert into rest values (5, 1, sysdate, '����', '�Һ�', sysdate, null);

select * from (select row_number() over(order by q.qno desc) as rn, q.qno, q.title, p.pcode, p.nickname, q.writedate, q.cnt
from qna q left outer join patient p on q.pcode = p.pcode) where rn between 1 and 10;

select q.qno, q.title, p.pcode, p.nickname,m.mcode, m.name,  q.writedate, q.cnt, q.img, q.content, c.content as ccontent, c.writedate as cwritedate, m.id
from qna q
left outer join patient p on q.pcode = p.pcode
left outer join comments c on q.qno = c.qno
left outer join manager m on c.mcode = m.mcode
where q.qno = 11

select * from comment order by qno desc limit 1

select * from comments where qno = 16




