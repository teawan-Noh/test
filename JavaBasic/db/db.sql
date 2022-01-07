--������ Ÿ�� Ȯ���ϴ¹�
select * 
from ALL_TAB_COLUMNS
where TABLE_NAME = 'CUSTOMER' ;

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
insert into customer values (customerseq.nextval, 'bbq', 'ȫ�浿', '1234', '12331', '�����ٶ�', '���ٻ�', '010-2222-2222', '�̸���');

select * from tab;
create table dept as
select * from scott.dept;

select * from customer where customerseq = 3;

select * from dept;
delete from dept where deptno not in(10,20,30);
update dept set dname = '�繫��' where deptno = '30';

create sequence customerseq;

insert into customer values(customerseq.nextval, 'bbq', 'ȫ�浿', '1234', '790812', '������ ���', '���� 2��', '010-2949-3949', 'bbq@gmail.com');

select count(*) as cnt from CUSTOMER where id=?;




update emp set sal = 0;
update emp set sal = ? where deptno = ?;

select deptno, dname, loc from dept where deptno = 10;
select deptno, dname, loc from dept where deptno = ?;

select * from emp where empno = 8888;

update dept set dname = ?, loc = ? WHERE deptno = ?;

delete from dept where deptno = ?;

create table customer(

	CUSTOMERID NUMBER primary key,
	NAME VARCHAR2(40),
	ADDRESS VARCHAR2(40),
	PHONE VARCHAR2(30)
);

select * from customer;
insert into customer values (1010, 'tami', '���� �߱�', '010-0000-0000');

select * from customer where customerid = 1010;
update customer set phone = '010-1111-1111' where customerid = 1010;
delete from customer where customerid = 1010;

create table Publisher(
	publishername varchar2(40) CONSTRAINT Publisher_publishername_PK primary key,
	contactanme varchar2(40),
	phone varchar2(30)
);

create table Book(
	bookid number CONSTRAINT Book_bookid_PK primary key,
	bookname varchar2(40),
	price number,
	publishername varchar2(40) CONSTRAINT Book_publishername_FK references Publisher(publishername)
);

insert into publisher values ('�������ǻ�', 'ȫ�浿', '010-1234-1234');

select * from book
select * from publisher

insert into book values (seq_bookid.nextval, 'java', 5000, '�������ǻ�');

select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'Book';
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'publisher';

CREATE VIEW V_book as
select * from book
where price between 5000 and 10000;


8. �����̸��� JAVA�� ������ å ������ ���ǻ� ������ ��� �˻��Ͻÿ�. 

  (��, �����̸��� ��ҹ��ڸ� �������� �ʰ� ��� �˻��Ǿ�� �Ѵ�. ��, JAVA, java, Java, java ���� ������ å ��� �˻��Ǿ�� �Ѵ�.)
  
select * from book where lower(bookname) like '%java%';

drop table book;


select * from memo;

select * from memo;
delete from memo where name is not null;
create sequence memoseq;
select memoseq.nextval from dual;
insert into memo values(memoseq.nextval, 'ī��', 10);




















create sequence seq_bookid;
select seq_bookid.nextval from dual;
DROP TABLE customer
select * from EMP

update customer set name = '��浿' where seq = 1;


insert into customer (seq, id, name, password, address, phone) 
values (seq_seq.nextval, '����', '�浿', 1235, '��⵵ ����', '123-4528-1112');


CREATE TABLE DEPARTMENT(
	DNO NUMBER(2),
	DNAME VARCHAR2(14),
	LOC VARCHAR2(13)
);

--��ü ����� ��� Į�� ��ȸ
select * from EMP;

--��ü ����� ename Į�� ��ȸ
select ename from emp;

--��������� ���(+, -, *, /)
select ename, sal, sal*12 from emp;

--�ѱ޿��� ���ϱ�(�� ����, null�����ϸ� null�� �ǹ���)
--nvl(null ���� �÷�, �⺻��) -> null�� �ƴϸ� �÷��� �� ���ϰ� null�̸� 0�� ���ϱ�
select ename, sal*12+nvl(comm, 0) from emp;
--�÷��� ��Ī�� �����ϴ� ��(���� ��ȣ�ϴ� ���)
select ename, sal*12+nvl(comm, 0) as ���� from emp;
--as ���� ��ĭ ��� ��Ī �־ ��
select ename, sal*12+nvl(comm, 0) ���� from emp;
--�÷��� ������ �����ϰ� ������ ""���
select ename, sal*12+nvl(comm, 0) "�� ��" from emp;

INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-7-1987','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-7-1987','dd-mm-yyyy'),1100,NULL,20);

--�ߺ� ������ �ѹ��� ����ϱ�(distinct)
--select * from dept;
select distinct deptno from emp;

--dual: �� ������ ����� ����ϱ� ���� �����ϴ� ���̺�
--sysdate: ��¥ ��ȯ(select�� from �ڿ� ���̺��� �;� �ϴµ� ���̺��� �����Ƿ� dual�� ����ؼ� ��ȸ�� �� �ְ� �ϱ�)
select * from dual;
select sysdate from dual;

--dept�� �� 4���̱� ������ 4���� sysdate�� ����(���糯¥�� �ð��� 4���� ���� �ʿ� �����Ƿ� dual�� ���)
select sysdate from dept;

--���ǰ˻�
--sal�� 1500 �̻��� ��� �˻�
select * from emp where sal >= 1500;
--�μ���ȣ�� 10�� ��� �˻�
select * from emp where deptno = 10;
--�̸��� scott�� ��� �˻�(���ڿ��� ��ҹ��� ����, ''����ؾ� ��)
select * from emp where ename = 'SCOTT';
--�Ի����� '1981/10/01' ������ ����� ��ȸ�ϱ�
select * from emp where hiredate <= '1981-10-01';
--�μ���ȣ�� 10�̰� ������ 'MANAGER'�� ����� ��ȸ�ϱ�
select * from emp where deptno = 10 and job = 'MANAGER';
--�μ���ȣ�� 10�̰ų� ������ 'MANAGER'�� ����� ��ȸ�ϱ�
select * from emp where deptno = 10 or job = 'MANAGER';
--�μ���ȣ�� 10���� �ƴ� ��� ��ȸ�ϱ�
select * from emp where deptno != 10;
select * from emp where not deptno = 10;
select * from emp where deptno <> 10;

--�޿��� 1000���� 1500 ������ ����� �̸��� �޿� �˻��ϱ�
select ename, sal from emp where sal between 1000 and 1500;
select ename, sal from emp where sal >= 1000 and sal <= 1500;
--�޿��� 1000 �̸��̰ų� 1500 �ʰ��� ����� �̸��� �޿� �˻��ϱ�
select ename, sal from emp where sal < 1000 or sal > 1500;
-- ==> 1000���� 1500 ���̰� �ƴ� ���
select ename, sal from emp where not sal between 1000 and 1500;
--�󿩰� 300�̰ų� 500�̰ų� 1400�� ����� �̸��� �󿩸� �˻�
select ename, comm from emp where comm = 300 or comm = 500 or comm = 1400;
--1982�⿡ �Ի��� ��� ���� �˻��ϱ�
select * from emp where hiredate between '1982/01/01' and '1982/12/31';

--in ������(or�� �����ϴ� �ͺ��� �����ϰ� ��� ����)
--�󿩰� 300�̰ų� 500�� ��� �˻�
select * from emp where comm in (300, 500);
--�󿩰� 300�̳� 500�� �ƴ� ���(null ���� �ȵ�)
select * from emp where comm not in (300, 500); 
--null �����ؼ� �˻��ϴ� ���(�󿩰� ������ �� �� ��ȸ, ������ 0���� �����ؼ� ��ȸ)
select * from emp where nvl(comm, 0) not in (300, 500);

--like ������(%: �� �� ���� ������ ���ڿ�)
--�̸��� 'F'�� �����ϴ� ��� �˻��ϱ�
select * from emp where ename like 'F%';
--�̸��� 'M'�� ���ԵǾ� �ִ� ��� �˻��ϱ�
select * from emp where ename like '%M%';
--�̸��� 'N'���� ������ ��� �˻��ϱ�
select * from emp where ename like '%N';
--�̸��� �� ��° ���ڰ� 'A' �� ��� �˻��ϱ� -> JAMES, WARD, MARTIN (_:�� ���� �ǹ�)
select * from emp where ename like '_A%';
--�̸��� 'A'�� �������� �ʴ� ���
select * from emp where ename not like '%A%';

--null
--comm�� null�� ��� �˻��ϱ�
select * from emp where comm is null;
--comm�� null�� �ƴ� ��� �˻��ϱ�
select * from emp where comm is not null;


--����
--�޿��������� ��������(���������� ���� ����)
select * from emp order by sal asc;
--��������
select * from emp order by sal desc;
--�޿��� ���� �޴� ������ �����ϵ� ���� �޿� �޴� ����� ���ؼ� �̸��� ������ ���� ���
select * from emp order by sal desc, ename asc; 
--�Ի��� ������� ������� �˻�(��������: ����->����)
select * from emp order by hiredate;
--�Ի��� ������� ������� �˻�(��������: ����-> ����)
select * from emp order by hiredate desc;


--1.���� �����ڸ� �̿��Ͽ� ��� ����� ���ؼ� $300 �� �޿� �λ��� ����� �� ����� �̸�, �޿�, �λ�� �޿��� ����Ͻÿ�.
select ename, sal, sal+300 as "�λ�� �޿�" from emp;

--2.����� �̸�, �޿�, ���� �Ѽ����� �� ������ ���� �ͺ��� ���� ������ ����Ͻÿ�.
--���� �Ѽ����� ���޿� 12�� ���� ��, $100�� �󿩱��� ���ؼ� ����Ͻÿ�.
select ename, sal, sal*12+100 as "���� �Ѽ���" from emp order by "���� �Ѽ���" desc;

--3.�޿��� 2000�� �Ѵ� ����� �̸��� �޿��� �޿��� ���� �ͺ��� ���� ������ ����Ͻÿ�
select ename, sal from emp where sal > 2000 order by sal desc;

--4.�����ȣ�� 7788�� ����� �̸��� �μ���ȣ�� ����Ͻÿ�.
select ename, deptno from emp where empno = 7788;

--5.�޿��� 2000 ���� 3000 ���̿� ���Ե��� �ʴ� ����� �̸��� �޿��� ����Ͻÿ�.
select ename, sal from emp where not sal between 2000 and 3000;

--6.1981�� 2�� 20�� ���� 1981�� 5�� 1�� ���̿� �Ի��� ����� �̸�, ��� ����, �Ի����� ���
select ename, job, hiredate from emp where hiredate between '81/2/20' and '81/5/1'; 

--7.�μ� ��ȣ�� 20 �� 30 �� ���� ����� �̸��� �μ���ȣ�� ����ϵ� �̸��� ����(��������)���� �����ڼ����� ����Ͻÿ�
select ename, deptno from emp where deptno in(20, 30) order by ename desc;

--8.����� �޿��� 2000 ���� 3000 ���̿� ���Եǰ� �μ���ȣ�� 20 �Ǵ� 30 �� ����� �̸�, 
--�޿��� �μ���ȣ�� ����ϵ� �̸���(��������)���� ����Ͻÿ�.
select ename, sal, deptno from emp where sal between 2000 and 3000 and deptno in(20, 30) order by ename asc;

--9.1981�⵵�� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.(LIKE �����ڿ� ���ϵ�ī�� ���)
--1981%�� �Ұ���, ���� �����Ͱ� 81~�� �Ǿ��ֱ� �����̴�.
select ename, hiredate from emp where hiredate like '81%';

--10.�����ڰ� ���� ����� �̸��� ��� ������ ����Ͻÿ�.
select ename, job from emp where mgr is null;

--11.Ŀ�̼��� ���� �� �ִ� �ڰ��� �Ǵ� ���(Ŀ�̼� ���� �����ϴ� ���)�� �̸�, �޿�, Ŀ�̼��� ����ϵ� �޿� �� Ŀ�̼���
--�������� �������� �����Ͽ� ǥ��
select ename, sal, comm from emp where comm is not null order by sal desc, comm desc;

--12.�̸��� ����° ���ڰ� R�� ����� �̸��� ǥ��
select ename from emp where ename like '__R%';

--13.�̸��� A��E�� ��� �����ϰ� �ִ� ����� �̸� ǥ��
--select ename from emp where ename like "%A%E%" �̷��� �ϸ� a�� e�� ������ �¾ƾ� ��ȸ�� �ȴ�.
select ename from emp where ename like '%A%' and ename like '%E%';

--14.�������� �繫��(CLERK) �Ǵ� �������(SALESMAN)�̸鼭 �޿��� 
  -- $1600, $950 �Ǵ� $1300�� �ƴ� ����� �̸�, ������, �޿��� ����Ͻÿ�.
select ename, job, sal from emp where job in('CLERK', 'SALESMAN') and sal not in (1600, 950, 1300);

--15 
select ename, comm from emp where comm >= 500;
------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------
--[�Լ�]
--1.�����Լ�
--1)��ҹ��� ��ȯ �Լ�
select 'Oracle', upper('Oracle'), lower('Oracle'), initcap('oracle oracle') from dual;

--2)����̸�, ������ ��ȸ�Ͻÿ�. ��, ����̸��� �ҹ��ڷ�, job�� ù���ڸ� �빮�ڷ� �˻��Ͻÿ�.
select lower(ename), initcap(job) from emp;

select * from emp where ename = 'scott'; --��ҹ��ڰ� ��ġ�����ʾ� �˻��ȵȴ�
select * from emp where lower(ename) = 'scott';
select * from emp where ename = upper('scott'); -- �̰͵� �����ϱ� ��

--2)���� ���̸� ��ȯ�ϴ� �Լ�
select length('Oracle'), length('����Ŭ') from dual;

--���� ���� �Լ�
--concat : ��ġ��
select concat('oracle','����Ŭ') from dual;

--substr : (���, �����ڸ�, �����ڸ����� ����)
select substr('Oracle mania', 4, 3), substr('Oracle mania', -4, 3) from dual;

--951111-2345678
select substr('951111-2345678', 8, 1) from dual;

--substr�� �̿��ؼ� �̸��� N���� ������ ��� �˻�
select * from emp where substr(ename, -1) = 'N';

--substr�� �̿��ؼ� 87�⵵�� �Ի��� ��� �˻�
select * from emp where substr(hiredate, 1 , 2) = '87';

--instr(���, ã������, ������ġ, ���° �߰�)
select instr('Oracle mania', 'a') from dual;
select instr('Oracle mania', 'a', 1, 1) from dual;
select instr('Oracle mania', 'a', 5, 2) from dual;

--�̸��� ����° �ڸ� 'R'�� ����� �˻�
select * from emp where instr(ename, 'R', 3, 1) = 3;

--Ư�� ��ȣ�� ä��� (���, �ڸ���, ä���ȣ)
select lpad(sal, 10, '*') from emp;
select rpad(sal, 10, '*') from emp;
--��� ���� : 961111-******* 

--��������  ,  -- || : ���� ���� ������
select rtrim(' Oracle mania ') || 'end', ltrim(' Oracle mania ') || 'end', trim(' Oracle mania ') || 'end' from dual;

--Ư�����ڰ� ù��° �Ǵ� ������ �����̸� �߶󳻰� ���� ���ڿ��� ��ȯ
select trim('a' from 'aaaaOraclec Maniaaaa') from dual;

--2.���� �Լ�
--1)round(���, �ڸ���) : �ݿø�
select 98.7654, round(98.7654), round(98.7654, 2), round(98.7654, -1) from dual;

--2)trunc(���, �ڸ���) : ����
select 98.7654, trunc(98.7654), trunc(98.7654, 2), trunc(98.7654, -1) from dual;

--3)mod(ù��° ��, �ι�° ��) : ù��° ������ �ι�° �� ������ �������� ��ȯ
select mod(31, 2), mod(31, 5), mod(31, 8) from dual; 

--4)��� ����� �޿��� 500���� ���� �������� ���
select ename, sal, mod(sal, 500) as ������ from emp;

--3.��¥�Լ� 
--1)sysdate : ���糯¥ ��ȯ
select sysdate from dual;

--2)��¥��� (��������� ��밡��)
select sysdate-1 as ����, sysdate as ����, sysdate+1 as ����, sysdate+10 as 10�ϵ� from dual;

--�ٹ��ϼ� �˻� : ������ �����Ҷ� ��� 
select ename, hiredate, round(sysdate-hiredate) as �ٹ��ϼ� from emp;
select ename, hiredate, sysdate-hiredate as �ٹ��ϼ� from emp;

--�״��� 1�� ���� (���� �������� ���� ������ ��¥)
select hiredate, trunc(hiredate, 'MONTH') from emp;
select hiredate, trunc(sysdate, 'MONTH') from emp;

--�ٹ��� ���� ��
select ename, sysdate, hiredate, months_between(sysdate, hiredate) from emp;
select ename, sysdate, hiredate, trunc(months_between(sysdate, hiredate)) from emp order by hiredate;

--�Ի����� 12���� �� ��¥ ���ϱ�
select ename, hiredate, hiredate+365 from emp;
select ename, hiredate, add_months(hiredate, 12) from emp;
--�ֱ� 6����
select ename, hiredate, add_months(hiredate, -6) from emp;

--���� �������� ���ʷ� �����ϴ� x���� ���ϱ�
select sysdate, next_day(sysdate, '��') from dual;
select sysdate, next_day(sysdate, 'ȭ') from dual;
select sysdate, next_day(sysdate, 1) from dual; --1:�Ͽ���
select sysdate, next_day(sysdate, 5) from dual; --5:�����

--�Ի��� ���� �������� ���ϱ�
select ename, hiredate, last_day(hiredate) from emp;

--4.����ȯ �Լ�
--1)to_char
--varchar2(ex_ename), number(ex_sal), date(ex_hiredate) : ��������

--��¥ -> ����
--������� �Ի��Ͽ��� �Ի�⵵�� ���� ���
select ename, hiredate, to_char(hiredate, 'YY/MM') from emp; 
select ename, hiredate, to_char(hiredate, 'YY-MM') from emp; 
select ename, hiredate, to_char(hiredate, 'YYYY/MM/DD DAY') from emp;

--���� -> ���� : ȸ�迡�� ����ϴ� ����ó���� ����
select ename, sal, to_char(sal, '9,999') from emp;
select ename, sal, to_char(sal, '9,999,999') from emp;
--8�ڸ��� ����
select ename, empno, to_char(empno, '00000000') from emp;

--2)to_date
--1981�� 2�� 20�Ͽ� �Ի��� ��� �˻�
select ename, hiredate from emp where hiredate = '19810220';
select ename, hiredate from emp where hiredate = '1981-02-20';
select ename, hiredate from emp where hiredate = '81/02/20';
--�����͸� �޾Ƽ� DB�� ������ ��Ŀ� �°� �ٲ� �־��ٶ� ���
select ename, hiredate from emp where hiredate = to_date(19810220, 'YYYYMMDD');

--3)to_number
select '100,000' -'50,000' from dual;
select to_number('100,000', '999,999') - to_number('50,000', '999,999') from dual;

--5.�Ϲ� �Լ�
--1)nvl
select ename, sal, comm, nvl(comm, 0) from emp;

--2)nvl2(expr1, expr2, expr3) : expr1���� null�� �ƴϸ� expr2 ����, expr1���� null�̸� expr3 ����
select ename, nvl2(comm, sal*12+comm, sal*12) from emp

--3)nullif(expr1, expr2) : ���� ������ ��� null ����, �������� ���� ��� expr1 ����
select nullif('A', 'A'), nullif('C', 'B') from dual;

--4)coalesce(expr1..n) n������ �ִ� : �μ��߿��� null�� �ƴ� ù��° �μ��� ��ȯ
select ename, sal, comm, coalesce(comm, sal) from emp;

--5)decode(ǥ����, ����1, ���1
--               ����2, ���2
--                   �⺻���)
--table�� ���°�� (�ڵ常 �ִ°��)
select ename, deptno, decode(deptno, 10, 'ȸ����', 20, '��������', 30, '������', 40, '���', '��Ÿ') as dname from emp;

--6)case expr
--		when ����1 then ���1
--		when ����2 then ���2
--		else ���N
--	end
select ename, deptno,
		case when deptno = 10 then 'ȸ����'
			 when deptno = 20 then '������'
			 when deptno = 30 then '������'
			 when deptno = 40 then '���'
			 else '��Ÿ'
		end as dname
from emp;

--1.SUBSTR �Լ��� ����Ͽ� ������� �Ի��� �⵵�� �Ի��� �޸� ���
select ename, hiredate, substr(hiredate, 1, 5) as �Ի翬�� from emp;
select ename, hiredate, substr(hiredate, 1, 2) as �⵵, substr(hiredate, 4, 2) as �� from emp;

--2.SUBSTR �Լ��� ����Ͽ� 4���� �Ի��� ����� ���
select * from emp where substr(hiredate, 4, 2) = 04;
select * from emp where substr(hiredate, 5, 1) = 4;

--3.MOD �Լ��� ����Ͽ� �����ȣ�� ¦���� ����� ���
select * from emp where mod(empno, 2) = 0;

--4.�Ի����� ������ 2�ڸ�(YY), ���� ����(MON)�� ǥ���ϰ� ������ ���(DY)�� �����Ͽ� ���
select ename, hiredate, to_char(hiredate, 'YY/MON/DY') as ���� from emp;

--5.���� ��¥�� �̿��Ͽ� ���� ��ĥ�� �������� ���
select trunc(sysdate) - trunc(sysdate, 'YEAR') as day from dual;

--6.������� �Ŵ��� ����� ����ϵ� �Ŵ����� ���� ����� ���ؼ��� NULL �� ��� 0���� ����Ͻÿ�.
select ename, mgr, nvl(mgr, 0) as �Ŵ��� from emp;

--7.DECODE �Լ��� ���޿� ���� �޿��� �λ��ϵ��� �Ͻÿ�. ������ 'ANALYST'�� ����� 200,
-- 'SALESMAN'�� ����� 180, 'MANAGER'�� ����� 150, 'CLERK'�� ����� 100�� �λ��Ͻÿ�.
select ename, job, sal, decode(job,'ANALYST', sal+200, 'SALESMAN', sal+180, 'MANAGER', sal+150, 'CLERK', sal+100) as �޿��λ� from emp;

--�׷��Լ� ���
--1.�׷��Լ�
--1)sum, avg, max, min
select sum(sal) as �ѱ޿���, avg(sal) as ��ձ޿�, max(sal) as ����޿�, min(sal) as �ּұ޿� from emp;

select max(hiredate), min(hiredate) from emp;

--2)�׷��Լ��� null��
select sum(comm) as ���Ѿ� from emp;

--3)count
--��� �� ���� ���ϱ�
select count(*) from emp;

--�� �޴� �����
select count(comm) from emp;
select count(*) from emp where comm is not null;

--���� ������ ������ �˻��غ�����
select count(job) from emp;
select count(distinct job) from emp;
select * from emp;

--4)�׷��Լ� �߸� ����� ��
select ename, max(sal) from emp; ---xxxx

--��������
select ename from emp where sal = (select max(sal) from emp);

--2.������ �׷�
--�Ҽ� �μ��� ��� �޿��� �μ���ȣ�� �Բ� ���
select deptno, avg(sal) as avg_sal
from emp
group by deptno;

--���� �÷��� �̿��Ͽ� �׷캰�� �˻��ϱ�
--�׷��� ������ �Ŀ� job�ξְ� count�� 
select deptno, job, count(*), sum(sal)
from emp
group by deptno, job
order by deptno, job

--3.�׷� ��� ���� : having ���� �׷��ռ��� ��� ���� ������ ���ǿ� true�� �׷����� �����Ѵ�.
--�μ��� �ִ� �޿��� 3000 �̻��� �μ���ȣ�� �μ��� �ִ� �޿� ���Ͻÿ�
select deptno, max(sal)
from emp
group by deptno
having max(sal) >= 3000;

--Manager�� �����ϰ� �޿� �Ѿ��� 5000 �̻��� ���޺� �Ѿ�
select job, count(*), sum(sal)
from emp
where job != 'MANAGER'
group by job
having sum(sal) >= 5000
order by job;

--�μ��� �ְ� ��� �޿� ���ϱ�
select max(avg(sal))
from emp
group by deptno;

-----------------------------------------------------------------------------------------------------------
--1.��� ����� �޿� �ְ��, ������, �Ѿ� �� ��� �޿��� ���
--	Į���� ��Ī�� �Ʒ��� �����ϰ� �����ϰ� ��տ� ���ؼ��� ������ �ݿø��Ͻÿ�.
--	Maximum	Minimum 	Sum        Average
select max(sal) as Maximum, min(sal) as Minimum, sum(sal) as Sum, round(avg(sal)) as Average
from emp;

--2.�� ��� ���� �������� �޿� �ְ��, ������, �Ѿ� �� ��վ��� ���
--	Į���� ��Ī�� �Ʒ��� �����ϰ� �����ϰ� ��տ� ���ؼ��� ������ �ݿø��Ͻÿ�.
select job, max(sal) as Maximum, min(sal) as Minimum, sum(sal) as Sum, round(avg(sal)) as Average
from emp
group by job;

--3.count(*) �Լ��� �̿��Ͽ� ��� ������ ������ ��� ���� ���
select job, count(*)
from emp
group by job;

--4.������ ������ ���� ����. Į���� ��Ī�� �Ʒ��� ���� �����Ͻÿ�.
--	COUNT(MANAGER)
select count(mgr) as "COUNT(MANAGER)"
from emp

select job, count(mgr) as "COUNT(MANAGER)"
from emp
group by job;

--5.�޿� �ְ��, �޿� �������� ������ ���
select max(sal), min(sal), (max(sal) - min(sal)) as �ִ��ּұ޿�����
from emp

--6.���޺� ����� ���� �޿��� ���
--  �����ڸ� �� �� ���� ��� �� ���� �޿��� 2000 �̸��� �׷��� ���ܽ�Ű��
--  ����� �޿��� ���� ������������ �����Ͽ� ���
select job, min(sal)
from emp
where mgr is not null
group by job
having min(sal) > 2000 
order by min(sal) desc

--7.�� �μ��� ���� �μ���ȣ, �����, �μ� ���� ��� ����� ��� �޿��� ���
--  ��� �޿��� �Ҽ��� ��° �ڸ��� �ݿø�
select deptno, count(*) as �����, round(avg(sal), 2) as ��ձ޿�
from emp
group by deptno

--8.���������� ����

--9.������ ǥ���� ���� �ش� ������ ���� �μ���ȣ�� �޿� �� �μ� 10,20,30�� �޿� �Ѿ��� ���� ���  --��� Ʋ�� �ٽ� Ǯ��
select job, deptno, sum(sal), count(*)
from emp
group by deptno, job
order by job

select job, deptno, sum(sal), count(*), decode(deptno, 10, sum(sal)), decode(deptno, 20, sum(sal)), decode(deptno, 30, sum(sal))
from emp
group by deptno, job
order by job

------------------------------------------------------------------------------------------------------------------
--����
select * from emp;
select * from dept;

--�����
select * from emp, dept
where emp.deptno = dept.deptno
order by empno;

--���̺� �̸��� ��Ī���� ǥ���ϱ� 
select * from emp e, dept d
where e.deptno = d.deptno
order by empno;

select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno;

select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno and sal >= 3000;

--emp, dept ������� ��, �޿��� 2500 ���ϰ�, �����ȣ�� 9999 ������ ����� ������ �˻��Ͻÿ�.
select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
	and e.sal <= 2500
	and e.empno <= 9999;

select * from SALGRADE;

--�� ����
select *
from emp e, salgrade s 
where e.sal between s.losal and s.hisal;

--��ü ����(���� ����)
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr = e2.empno;

--�ܺ� ����
--���� �ܺ� ����
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr = e2.empno(+);

--������ �ܺ� ����
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr(+) = e2.empno;
--------------------------------------------------------------------------------------
--ǥ�� sql  : �����ϱ��� ������ ��Ŵ�
--� ����
select e.empno, e.ename, e.job, deptno, d.dname
from emp e natural join dept d;

--join ~ using 
select e.empno, e.ename, e.job, deptno, d.dname
from emp e natural join dept d using (deptno)
where ...
group by..
having ..
order by..

--join ~ on
select e.empno, e.ename, e.job, deptno, d.dname
from emp e natural join dept d on (e.deptno = d.deptno);

--�ܺ�����
--���� �ܺ� ����
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1 LEFT OUTER JOIN emp e2 on (e1.mgr = e2.empno);

--������ �ܺ� ����
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1 RIGHT OUTER JOIN emp e2 on (e1.mgr = e2.empno);

--��ü �ܺ� ����
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1 FULL OUTER JOIN emp e2 on (e1.mgr = e2.empno);

--���̺� ����
DROP TABLE TOYS;
DROP TABLE BOYS;

CREATE TABLE TOYS (
	TOY_ID NUMBER(2), 
	TOY VARCHAR2(20)
);

CREATE TABLE BOYS(
	BOY_ID NUMBER(2),
	BOY VARCHAR2(20),
	TOY_ID NUMBER(2)
);

INSERT INTO TOYS VALUES (1,'���̳�����');
INSERT INTO TOYS VALUES (2,'�Ǻ�');
INSERT INTO TOYS VALUES (3,'�̴�Ư����');
INSERT INTO TOYS VALUES (4,'Ĳ��');
INSERT INTO TOYS VALUES (5,'����');

INSERT INTO BOYS VALUES (1,'�㼼��', 2);
INSERT INTO BOYS VALUES (2,'������', 5);
INSERT INTO BOYS VALUES (3,'���', 1);
INSERT INTO BOYS VALUES (4,'���', 7);
INSERT INTO BOYS VALUES (5,'�ָ�', 2);

select * from toys;
select * from boys;

select * from toys t, boys b
order by b.boy;

--��������
--inner join : ������  on: ����
select *
from toys t inner join boys b
on t.toy_id = b.toy_id;

--emp, dept table inner join
select *
from emp e inner join dept d 
on e.deptno = d.deptno
where e.ename = 'ADAMS';

--on ���� �ȿ��ִ� �͵��� ���� �ʴ°�� <> : !=  ���� ���� ǥ��
select *
from toys t inner join boys b on t.toy_id <> b.toy_id;

select * from toys natural join boys;

--�ܺ� ����
--���� ����
select b.boy, t.toy
from boys b left outer join toys t
on b.toy_id = t.toy_id;

select b.boy, t.toy
from boys b left outer join toys t
on b.toy_id = t.toy_id
where t.toy_id is not null

--������ ����
select b.boy, t.toy
from boys b right outer join toys t
on b.toy_id = t.toy_id;

select b.boy, t.toy
from boys b right outer join toys t
on b.toy_id = t.toy_id
where b.toy_id is not null

--���� �ܺ� ����
select b.boy, t.toy
from boys b full outer join toys t
on b.toy_id = t.toy_id;

------------------------------------------------------------------------------------------------------------
--1.���� ������ ����Ͽ� SCOTT ����� �μ���ȣ�� �μ��̸� ���
select e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno and e.ename = 'SCOTT';

select e.ename, deptno, d.dname
from emp e natural join dept d
where e.ename = 'SCOTT';

--2.��� �̸��� �Բ� �� ����� �Ҽӵ� �μ��̸��� ������ ���(*INNER JOIN)
select e.ename, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno;

select e.ename, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno;

--3.10�� �μ��� ���ϴ� ��� ��� ������ ���� ���(�� ������ ǥ��)�� �μ��� �������� �����Ͽ� ���(*INNER JOIN)
select e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno and e.deptno = 10;

select e.ename, e.deptno, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno
where e.deptno = 10;

--4.Ŀ�̼��� �޴� ����� �̸�, �μ��̸�, ������ ���(*NATURAL JOIN)
select e.ename, d.dname, d.loc, e.comm
from emp e, dept d
where e.deptno = d.deptno and comm is not null and comm != 0;

select e.ename, d.dname, d.loc, e.comm
from emp e natural join dept d 
where comm is not null and comm != 0

--5.�̸��� A�� ���Ե� ��� ������̸��� �μ��̸� ���
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno and ename like '%A%';

select e.ename, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
where ename like '%A%';

--6.NEW YORK�� �ٹ��ϴ� ��� ����� �̸�, ����, �μ���ȣ �� �μ����� ���(NATURAL JOIN)
select e.ename, e.job, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno and d.loc ='NEW YORK';

select e.ename, e.job, deptno, d.dname, d.loc
from emp e natural join dept d 
where d.loc = 'NEW YORK';

select e.ename, e.job, deptno, d.dname, d.loc
from emp e inner join dept d 
on e.deptno = d.deptno
where d.loc = 'NEW YORK'; -----�����غ���

--7.����� �̸� �� �����ȣ�� �������̸� �� �����ڹ�ȣ�� �Բ� ��� 
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr = e2.empno;

select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1 inner join emp e2
on e1.mgr = e2.empno;

--8.�����ڰ� ���� ����� �����Ͽ� �����ȣ�� �������� ������������ ��� (OUTER JOIN, SELF JOIN)
select e1.ename, e1.empno, e1.mgr, e2.ename as mgr_name, e2.empno as mgr_no
from emp e1, emp e2
where e1.mgr = e2.empno(+)
order by empno desc;

select e1.ename, e1.empno, e1.mgr, e2.ename as mgr_name, e2.empno as mgr_no
from emp e1 left outer join emp e2
on e1.mgr = e2.empno
order by empno desc;

--9.SCOTT ����� �μ���ȣ�� �� ������ �μ��� �ٹ��ϴ� ����� ���(SELF JOIN)
select e1.ename, e1.deptno, e2.ename, e2.deptno
from emp e1, emp e2
where e1.deptno = e2.deptno and e2.ename = 'SCOTT';

select e1.ename, e1.deptno, e2.ename, e2.deptno
from emp e1 inner join emp e2
on e1.deptno = e2.deptno 
where e2.ename = 'SCOTT';

--10.WARD ������� �ʰ� �Ի��� ����� �̸��� �Ի����� ���(SELF JOIN)
select e1.ename, e1.hiredate, e2.ename, e2.hiredate
from emp e1, emp e2
where e1.hiredate < e2.hiredate and e1.ename = 'WARD';

select e1.ename, e1.hiredate, e2.ename, e2.hiredate
from emp e1 inner join emp e2 
on e1.hiredate < e2.hiredate
where e1.ename = 'WARD';  ??????

select e2.ename, e2.hiredate
from emp e1 inner join emp e2
on e1.hiredate < e2.hiredate
where e1.ename = 'WARD';

--11.�����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ���(SELF JOIN)
select e1.ename, e1.hiredate, e1.mgr, e2.ename as mgr_name, e2.hiredate
from emp e1, emp e2
where e1.mgr = e2.empno and e1.hiredate < e2.hiredate;

select e1.ename, e1.hiredate, e1.mgr, e2.ename as mgr_name, e2.hiredate
from emp e1 inner join emp e2
on e1.mgr = e2.empno
where e1.hiredate < e2.hiredate
-----------------------------------------------------------------------------------------------------------------------
select * from tab;

--������ ��������
--1.SCOTT ���� �޿��� ���� �޴� ���
select e1.ename, e1.sal, e2.ename, e2.sal
from emp e1, emp e2
where e1.sal < e2.sal and e1.ename= 'SCOTT'

select sal from emp where ename = 'SCOTT'; --3000
select ename, sal from emp where sal > 3000;

select ename, sal from emp where sal > (select sal from emp where ename = 'SCOTT');

--SCOTT�� ������ �μ����� �ٹ��ϴ� ���
select ename, deptno from emp where deptno = (select deptno from emp where ename = 'SCOTT');

--�ּ� �޿��� �޴� ����� �̸�, ������, �޿� ����ϱ�
select ename, job, sal from emp where sal = (select min(sal) from emp);

--30�� �μ����� �ּұ޿��� ���� ��, �μ��� �ּ� �޿��� 30���μ��� �ּұ޿����� ū �μ��� ���
select min(sal) from emp where deptno = 30;

select deptno, min(sal) from emp 
group by deptno
having min(sal) > (select min(sal) from emp where deptno = 30);


--������ �������� -- ���������� ����� �������϶� in ���
--�μ��� �ּ� �޿��� �޴� ����� �����ȣ�� �̸��� ���
select min(sal) from emp group by deptno;

select ename, empno, sal from emp where sal in (select min(sal) from emp group by deptno); 

-- ������ SALEMAN�� �ƴϸ鼭 �޿��� ������ SALEMAN ���� ���� ����� ���
select ename, job, sal from emp where job != 'SALESMAN';
select max(sal) from emp where job = 'SALESMAN';

--�񱳰� < any() : �񱳰��� �������� ����� �ִ밪���� ����   any�� ��������
--�񱳰� > any() : �񱳰��� �������� ����� �ּҰ����� ŭ
--�������� ����� � �ϳ��� �������� �Ѱ��� ���̿��� select�ȴ�
--any�� or ó�� ���

select ename, job, sal from emp where job != 'SALESMAN' and sal < (select max(sal) from emp where job = 'SALESMAN');
select ename, job, sal from emp where job != 'SALESMAN' and sal < any (select sal from emp where job = 'SALESMAN');

-- ������ SALEMAN�� �ƴϸ鼭 ������ SALEMAN�� ������� �޿��� ���� ����� ��� ���
select ename, job, sal from emp where job != 'SALESMAN';

--all���� � ������ �۾ƾ���
--all�� and�� ���
select ename, job, sal from emp 
where job != 'SALESMAN' and sal < all(select sal from emp where job = 'SALESMAN');
--all���� � ������ Ŀ����
select ename, job, sal from emp 
where job != 'SALESMAN' and sal > all(select sal from emp where job = 'SALESMAN');

---------------------------------------------------------------------------------------------------------------
--quiz
--1.�����ȣ�� 7788�� ����� ��� ������ ���� ����� �̸��� ������ ����Ͻÿ�.
select job from emp where empno = 7788;
select ename, job, empno from emp where job = 'ANALYST';

select ename, job, empno from emp where job = (select job from emp where empno = 7788);

--2.�����ȣ�� 7499�� ������� �޿��� ���� ����� �̸��� ������ ����Ͻÿ�.
select sal from emp where empno = 7499;

select ename, job, sal from emp where sal > (select sal from emp where empno = 7499);

--3.�ּ� �޿��� �޴� ����� �̸�, ��� ���� �� �޿��� ����Ͻÿ�.(�׷��Լ� ���)
select min(sal) from emp;

select ename, job, sal from emp where sal = (select min(sal) from emp);

--4.�������� �޿��� ���� ���� ����� ��� ������ ã�� ���ް� �޿��� ���

select min(sal) from emp

select job, avg(sal) from emp 
group by job 
having avg(sal) = (select min(avg(sal)) from emp group by job);
--�������� �ٽ�Ǯ�� �����ٲ�


--5.�� �μ��� �ּ� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ ���
select ename, sal, deptno from emp where sal in (select min(sal) from emp group by deptno);

--6. �������� �м���(ANALYST)�� ������� �޿��� �����鼭 ������ �м��� �ƴ� ����� �����ȣ, �̸�, ����, �޿� ���
select ename, job, sal from emp where job = 'ANALYST';

select empno, ename, job, sal from emp 
where sal < all (select sal from emp where job = 'ANALYST') and job <> 'ANALYST';

--7.���������� ���� ����� �̸��� ���
select ename from emp where empno not in (select e1.empno from emp e1, emp e2 where e1.empno = e2.mgr);

--select ename from emp where empno not in (select mgr from emp where mgr is not null group by mgr)

select * from emp;
--8.���������� �ִ� ����� �̸��� ���
select ename from emp where empno in (select e1.empno from emp e1, emp e2 where e1.empno = e2.mgr);

--select ename from emp where empno in (select mgr from emp)
select * from emp where empno in (select mgr from emp where mgr is not null)

--9.BLAKE�� ������ �μ��� ���� ����� �̸��� �Ի����� ǥ���ϴ� ���Ǹ� �ۼ�(��, BLAKE�� ����)
select deptno, ename from emp where ename = 'BLAKE';

select deptno, ename, hiredate from emp where ename != 'BLAKE' and deptno = (select deptno from emp where ename = 'BLAKE');

--10.�޿��� ��� �޿� ���� ���� ������� �����ȣ�� �̸��� ǥ���ϵ� ����� �޿��� ���ؼ� ������������ ����
select avg(sal) from emp ;

select empno, ename, sal from emp where sal > (select avg(sal) from emp);

--11.�̸��� K�� ���Ե� ����� ���� �μ����� ���ϴ� ����� �����ȣ�� �̸��� ǥ���ϴ� ���� �ۼ�
select ename, job, deptno from emp where ename like '%K%';
select ename, job, deptno from emp where deptno in (10, 30);

select empno, ename from emp where deptno in (select deptno from emp where ename like '%K%');

--12.�μ���ġ�� DALLAS�� ����� �̸��� �μ���ȣ �� ��� ������ ǥ��
select loc, deptno from dept where loc = 'DALLAS';
select deptno, ename from emp where deptno = 20;

select e.ename, e.deptno, e.job, d.deptno, d.loc
from emp e, dept d
where e.deptno = d.deptno and d.loc = (select loc from dept where loc = 'DALLAS')

select ename, deptno, job from emp
where deptno = (select deptno from dept where loc = 'DALLAS');

select * from emp

--13.KING ���� �����ϴ� ����� �̸��� �޿� ǥ��
select ename from emp where mgr = 7839;

select ename, sal from emp where mgr = (select empno from emp where ename = 'KING');

--14.RESEARCH �μ��� ����� ���� �μ���ȣ, ����̸� �� ��� ������ ǥ��
select dname from dept where dname = 'RESEARCH'

select e.deptno, e.ename, e.job 
from emp e, dept d
where e.deptno = d.deptno and d.dname = (select dname from dept where dname = 'RESEARCH');

select deptno, ename, job
from emp
where deptno = (select deptno from dept where dname = 'RESEARCH')

--15.��� �޿����� ���� �޿��� �ް� �̸��� M�� ���Ե� ����� ���� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �޿� ǥ��
select avg(sal) from emp;

select empno, ename, sal, deptno
from emp 
where sal > (select avg(sal) from emp) and deptno in(select deptno from emp where ename like '%M%') ;

--16.��� �޿��� ���� ���� ������ ǥ��
select min(avg(sal)) from emp group by job;

select job, avg(sal) 
from emp 
group by job 
having avg(sal) = (select min(avg(sal)) from emp group by job);

--17.��� ������ MANAGER�� ����� �Ҽӵ� �μ��� ������ �μ��� ����� ǥ��
select deptno, job from emp where job = 'MANAGER';

select deptno, ename from emp where deptno in (select deptno from emp where job = 'MANAGER');

select * from emp where deptno in (select deptno from emp where job = 'MANAGER');

---------------------------------------------------------------------------------------------------------------------
--���̺� ����
--���̺�� Į���� �ۼ� ��Ģ
--1.���ڷ� �����ؾ� �ϸ� 30�� �̳��� �ۼ�
--2.����, ����, Ư������(_, $, #)�� ��� ����
--3.��ҹ��� ������ ����.
--4.���� ����ڰ� ������ �ٸ� ��ü�� �̸��� �ߺ����� �ʾƾ� �Ѵ�.
--����� ��ü: create�ؼ� ��������°� ��ü

CREATE TABLE DEPARTMENT(
	DNO NUMBER(2),
	DNAME VARCHAR2(14),
	LOC VARCHAR2(14)
);

select * from DEPARTMENT;

CREATE TABLE DEPT2
AS
select * from dept;

select * from dept2

--���̺� ������ �����ϱ� (where ���ǿ� �����ΰ� �ƹ��ų� ������ ������ �����Ѵ�)
CREATE TABLE emp30
as
select * 
from emp
where 0 = 1

--emp ���̺��� 20�� �μ� �Ҽ� ����� ���� ������ ������ emp20���̺� ����
--�ٸ�, sal�� ���������� �Ѵ�.
CREATE TABLE emp20
AS
select empno, ename, sal*12 as sal 
from emp 
where deptno = 20;

select * from emp20
--���̺� ����
DROP TABLE ���̺��
select * from tab

--������ ���� 
PURGE recyclebin

--���̺� ����
--1)������ ���̺� ����
CREATE TABLE emp20
AS
select empno, ename, sal*12 as sal 
from emp 
where deptno = 20;

--2)�÷� �߰�
ALTER TABLE emp20 ADD(BIRTH DATE);
select * from emp20
ALTER TABLE emp20 ADD(ADDR VARCHAR2(30) DEFAULT '����');

--3)�÷� ����
ALTER TABLE EMP20 MODIFY BIRTH VARCHAR2(10)
ALTER TABLE EMP20 MODIFY BIRTH DATE

--Į���ȿ� �����Ͱ� ���� ������ ũ���� ������ ���� �Ұ���
ALTER TABLE EMP20 MODIFY empno number(5);
--Į�� ���� �� �߰�
ALTER TABLE EMP20 MODIFY (ADDR VARCHAR2(30) DEFAULT '����');
INSERT INTO EMP20(EMPNO, ENAME, SAL, BIRTH) VALUES (8500, 'JENI', 5000, '2021/09/07');
INSERT INTO EMP20(EMPNO, ENAME, SAL, BIRTH, ADDR) VALUES (8500, 'TAMI', 5000, '2021/09/07', '�λ�');
select * from emp20

--4)�÷� ����
ALTER TABLE EMP20 DROP COLUMN ENAME;

--5)���̺�� ����
RENAME EMP20 TO EMP50

SELECT * FROM TAB
DROP TABLE EMP50
PURGE RECYCLEBIN

select TABLE_NAME from user_tables

DROP TABLE DEPARTMENT PURGE

----------------------------------------------------------------------------------------------------------------
--1.DEPARTMENT  ���̺��� �����Ͻÿ�.
--	DNO NUMBER 2
--  DNAME VARCHAR2 14
--	LOC VARCHAR2 13
CREATE TABLE DEPARTMENT(
	DNO NUMBER(2),
	DNAME VARCHAR2(14),
	LOC VARCHAR2(13)
);
select * from department

--2.EMPLOYEE ���̺��� �����Ͻÿ�.
--	ENO NUMBER 2
--	ENAME VARCHAR2 10
--	DNO NUMBER 2
CREATE TABLE EMPLOYEE(
	ENO NUMBER(2),
	ENAME VARCHAR2(10),
	DNO NUMBER(2)
);

--3.�� �̸��� ������ �� �ֵ��� EMPLOYEE���̺� ���� : ũ�� 10 - >25 ����
ALTER TABLE EMPLOYEE MODIFY ENAME VARCHAR2(25);

--4.EMP ���̺��� �����ؼ� EMPLOYEE2�� �̸��� ���̺��� �����ϵ�
--  �����ȣ, �̸�, �޿�, �μ���ȣ Į���� �����ϰ� ���� ������ ���̺��� Į������ ����
--  EMP_ID, NAME, SAL, DEPT_ID�� �����Ͻÿ�.
CREATE TABLE EMPLOYEE2
AS
select empno as EMP_ID, ename as NAME, sal as EMP_SAL, deptno as DEPT_ID
FROM EMP;

select * from EMPLOYEE

--5.EMPLOYEE ���̺� ����
DROP TABLE EMPLOYEE PURGE;

--6.EMPLOYEE2�� �̸��� EMPLOYEE �� �����Ͻÿ�.
RENAME EMPLOYEE2 TO EMPLOYEE

--7.DEPARTMENT  ���̺��� DNAME Į���� �����Ͻÿ�.
ALTER TABLE DEPARTMENT DROP COLUMN DNAME

select * from department

--------------------------------------------------------------------------
--������ ����
--���̺� �̸� : dept2
CREATE TABLE DEPT2
as
select * 
from dept
where 0 = 1

select * from dept2
--������ �߰�
insert into dept2 (deptno, dname, loc) values (10, 'ACCOUNTING', '����');
insert into dept2 (deptno, dname) values (20, 'PROGRAMING');
insert into dept2 (dname, deptno) values ('PROGRAMING', 40);

--UPDATE
UPDATE DEPT2 SET LOC = '����'
WHERE DEPTNO = 40;

UPDATE DEPT2 SET LOC = '�λ�', DNAME = 'PROGRAMIN3'
WHERE DEPTNO = 40;

UPDATE DEPT2 SET LOC = '���ѹα�'
WHERE DEPTNO = 20 

--DELETE
DELETE FROM DEPT2
WHERE DEPTNO = 40;

DELETE FROM DEPT2
WHERE DNAME = 'ACCOUNT';

select * from tab
drop table dept2
purge recyclebin

-----------------------------------------------------------------------------
--quiz
--1.EMP ���̺��� ������ �����Ͽ� EMP_INSERT�� �̸��� �� ���̺� ����ÿ�
CREATE TABLE EMP_INSERT
AS
select * from emp
where 1=0

select * from emp_insert
--2.������ EMP_INSERT ���̺� �߰��ϵ� SYSDATE�� �̿��ؼ� �Ի����� ���÷� �Է�
insert into emp_insert (empno, ename, job, hiredate, sal) values (1, '���¿�', 'PROGRAMER', sysdate, 350);

--3.EMP_INSERT ���̺� �� ����� �߰��ϵ� TO_DATE �Լ��� �̿��ؼ� �Ի����� ������ �Է�
insert into emp_insert (empno, ename, job, hiredate, sal) values (2, '������', 'PROGRAMER', to_date(sysdate - 1), 350);

--4.EMP ���̺��� ������ ������ �����Ͽ� EMP_COPY�� �̸��� ���̺� ����ÿ�
CREATE TABLE EMP_COPY
AS
SELECT * FROM EMP;

select * from emp_copy

--5.�����ȣ�� 7788�� ����� �μ���ȣ�� 10������ �����Ͻÿ�.
UPDATE emp_copy SET deptno = 10
where empno = 7788

--6.�����ȣ 7788�� ������ �� �޿��� �����ȣ 7499�� ������ �� �޿��� ��ġ�ϵ��� ����
UPDATE EMP_COPY 
SET sal = (select sal from emp_copy where empno = 7499), job = (select job from emp_copy where empno = 7499)
where empno = 7788

UPDATE emp_copy set (job, sal) = (select job, sal from emp_copy where empno = 7499)
where empno = 7788

--7.�����ȣ 7369�� ������ ������ ��� ����� �μ���ȣ�� 7369�� ���� �μ���ȣ�� ����
UPDATE EMP_COPY
SET deptno = (select deptno from emp_copy where empno = 7369)
where job = (select job from emp_copy where empno = 7369)



--8.DEPT ���̺��� ������ ������ �����Ͽ� DEPT_COPY�� �̸��� ���̺��� ����ÿ�.
CREATE TABLE DEPT_COPY
AS
SELECT * FROM DEPT;

SELECT * FROM DEPT_COPY;

--9.DEPT_COPY ���̺��� �μ����� RESEARCH �� �μ��� �����Ͻÿ�.
DELETE FROM DEPT_COPY
WHERE DNAME = 'RESEARCH';

--10.DEPT_COPY ���̺��� �μ���ȣ�� 10 �̰ų� 40 �� �μ��� �����Ͻÿ�.
DELETE FROM DEPT_COPY
WHERE DEPTNO in (10,40)

--------------------------------------------
--[Ʈ�����]
--����)Ʈ������� �� ������ ���� �����ϴ� �Ϸ��� SQL ��
--�Ѳ����� ����Ǿ��ϴ� SQL���� �����̴� 
--�Ѳ����� ����Ǿ� �ǹ̰� �ִ� 

insert into dept_copy values (10, 'RESEARCH', '����')

select * from dept_copy

--allen�� comm�� scott �ְ�;�
--cmdâ���� ��ɾ �Է��� ��� commit; �� ���־�� �ݿ���
--rollback; : ������ commit �ߴ� ������ ���ư� 
update emp_copy set COMM = 0 WHERE ENAME = 'ALLEN';
update emp_copy set COMM = 300 WHERE ENAME = 'SCOTT';
--����Ŭ Ʈ����� ���۽���
insert, update, delete ����� ��
--����Ŭ Ʈ����� �������
1.commit; rollback;
2.create, alter, drop : �ڵ� commit

update emp_copy set COMM = 700 WHERE ENAME = 'SCOTT';
create table emp_copy2 as select * from emp;
select * from emp_copy;
--3.����Ŭ ����: �ڵ� rollback;

--����) Ʈ����� ���� ��� �ܰ�(insert, update, delete)�� ���ؾ��� �Ϸ�� �� ���ٸ�
--� �͵� �Ϸ���� ���ƾ� �Ѵ�. all or nothing

--����) ACID : Ʈ������� ����� �� Ư¡
--ATOMICITY(���ڼ�) : all or nothing
--CONSISTENCY(�ϰ���)
--ISOLATION(������) 
--DURABBILITY(���Ӽ�)
---------------------------------------------------------------------------------------------------------
--[��������]
--1.not null : �÷��� null���� �������� ���ϵ��� ����
--2.nuique : ���̺��� ��� �࿡ ���� ������ ���� ������ �Ѵ�. ������ ���̿��� �ϳ�, null�� �����
--3.primary key : ���̺� �� ���� �ĺ��ϱ� ���� ��, null�� �ߺ��� ���� ��� ������� ����, �ݵ�� �־���Ѵ�
--4.foreing key : �����Ǵ� ���̺� Į�� ���� �׻� �����ؾ� �Ѵ�.
--5.check : ���� ������ �������� ���� ������ ������ �����Ͽ� ������ ������ ����Ѵ�.

create table dept_test(
	deptno number(2) primary key,
	dname varchar2(14) unique,
	loc varchar2(14)
);

select * from dept_test;

insert into dept_test (deptno) values (10);
insert into dept_test (deptno, dname) values (20, '�繫��');
insert into dept_test (deptno, dname) values (30, '�λ���');
insert into dept_test (deptno, dname, loc) values (40, '������', '�����߾�');

create table emp_test(
	empno number(4) primary key,
	ename varchar2(20) not null,
	job varchar2(10) check (job in('�м�', '����', '������')),
	hiredate date not null,
	sal number(7),
	deptno number(2) references dept_test(deptno)
);

insert into emp_test values (1234, 'ȫ�浿', '����', '1999/09/09', 400, 40);
insert into emp_test values (2000, 'ȫ�浿2', '������', '1999/09/09', 400, 20);
insert into emp_test values (3000, 'ȫ�浿3', '������', '1999/09/09', 400, 50);

select * from emp_test

--�������� Ȯ��
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_TEST';
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_CONSTRAINT';

create table EMP_CONSTRAINT(
	empno number(4) CONSTRAINT EMP_EMPNO_PK primary key,
	ename varchar2(20) CONSTRAINT EMP_ENAME_NN not null,
	job varchar2(10) CONSTRAINT EMP_JOB_CHK check (job in('�м�', '����', '������')),
	hiredate date CONSTRAINT EMP_HIREDATE_NN not null,
	sal number(7),
	deptno number(2) CONSTRAINT EMP_DEPTNO_FK references dept_test(deptno)
);

--�������� ����(�߰� & ����)
CREATE TABLE PRODUCT(
	CODE NUMBER(2),
	NAME VARCHAR2(20),
	PRICE NUMBER
);
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'PRODUCT';

--�߰�
ALTER TABLE PRODUCT ADD CONSTRAINT PRODUCT_CODE_PK PRIMARY KEY (CODE);

--price�� 0 �̻����� üũ�ϴ����� �߰�
ALTER TABLE PRODUCT ADD CONSTRAINT PRODUCT_PRICE_CHK check (PRICE >= 0);

insert into product values (10, 'A', -1000);

--name�� null���� �� �� ���� �������� �߰�
ALTER TABLE PRODUCT MODIFY NAME CONSTRAINT PRODUCT_NAME_NN not null;

INSERT INTO PRODUCT VALUES (10, 'A', 1000);
INSERT INTO PRODUCT VALUES (20, 'B', 2000);

SELECT * FROM PRODUCT

--����
ALTER TABLE PRODUCT DROP CONSTRAINT PRODUCT_CODE_PK;
ALTER TABLE PRODUCT DROP CONSTRAINT PRODUCT_PRICE_CHK;
ALTER TABLE PRODUCT DROP CONSTRAINT PRODUCT_NAME_NN;

--DEPT_TEST
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'DEPT_TEST';
--EMP_TEST
DROP TABLE EMP_TEST;
DROP TABLE DEPT_TEST CASCADE CONSTRAINTS;
DROP TABLE EMP_CONSTRAINT

--���Ž� ���ǻ���
create table dept_CONSTRAINT(
	deptno number(2) CONSTRAINT DEPT_DEPTNO_PK primary key,
	dname varchar2(14) CONSTRAINT DEPT_DNAME_UN unique,
	loc varchar2(14)
);

create table EMP_CONSTRAINT(
	empno number(4) CONSTRAINT EMP_EMPNO_PK primary key,
	ename varchar2(20) CONSTRAINT EMP_ENAME_NN not null,
	job varchar2(10) CONSTRAINT EMP_JOB_CHK check (job in('�м�', '����', '������')),
	hiredate date CONSTRAINT EMP_HIREDATE_NN not null,
	sal number(7),
	deptno number(2) CONSTRAINT EMP_DEPTNO_FK references dept_CONSTRAINT(deptno)
);
--references ����Ǿ������� ������ ���� �� �����ؾ��Ѵ�
ALTER TABLE EMP_CONSTRAINT DROP CONSTRAINT EMP_DEPTNO_FK;
ALTER TABLE DEPT_CONSTRAINT DROP CONSTRAINT DEPT_DEPTNO_PK;

--���߰�
ALTER TABLE DEPT_CONSTRAINT ADD CONSTRAINT DEPT_DEPTNO_PK PRIMARY KEY (DEPTNO);

ALTER TABLE EMP_CONSTRAINT ADD CONSTRAINT EMP_DEPTNO_FK
FOREIGN KEY (DEPTNO) REFERENCES DEPT_CONSTRAINT(deptno);

--������ �����
ALTER TABLE DEPT_CONSTRAINT DROP CONSTRAINT DEPT_DEPTNO_PK CASCADE;

select * from emp;

select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_SAMPLE_CONSTRAINT';

insert into emp (empno, deptno) values (9999, );
delete from emp where empno = 9999

--------------------------------------------------------------------------------------------
--1.EMP ���̺��� ������ �����Ͽ� EMP_SAMPLE�� �̸��� ���̺� ����
--  ��� ���̺��� �����ȣ Į���� PRIMARY KEY ���������� �����ϵ� 
--  �������� �̸��� EMP_SAMPLE_EMPNO_PK ����
CREATE TABLE EMP_SAMPLE
AS
SELECT * FROM EMP
WHERE 1 = 0;

ALTER TABLE EMP_SAMPLE ADD CONSTRAINT EMP_SAMPLE_EMPNO_PK PRIMARY KEY (EMPNO);

--2.DEPT ���̺��� ������ �����Ͽ� DEPT_SAMPLE�� �̸��� ���̺� ����
--  �μ� ���̺��� �μ���ȣ Į���� PRIMARY KEY ���������� �����ϵ�
--  �������� �̸��� DEPT_SAMPLE_DEPTNO_PK�� ����

CREATE TABLE DEPT_SAMPLE
AS
SELECT * FROM EMP
WHERE 1 = 0;

ALTER TABLE DEPT_SAMPLE ADD CONSTRAINT DEPT_SAMPLE_DEPTNO_PK PRIMARY KEY (DEPTNO);

--3.EMP_SAMPLE ���̺��� �μ���ȣ Į���� �������� �ʴ� �μ��� ����� �������� �ʵ��� ����  => fk �����
ALTER TABLE EMP_SAMPLE ADD CONSTRAINT DEPT_SAMPLE_DEPTNO_FK FOREIGN KEY(DEPTNO) references DEPT_SAMPLE (DEPTNO);

--4.EMP_SAMPLE ���̺��� Ŀ�̼� Į���� 0���� ū ������ �Է��� �� �ֵ��� ������ ����
ALTER TABLE EMP_SAMPLE ADD CONSTRAINT DEPT_SAMPLE_DEPTNO_CHK CHECK (COMM>0);

-----------------------------------------------------------------------------------------
--[��]
0.���� �ο� �ޱ�
-������ �������� ����
-grant create view to scott;

1.����
CREATE VIEW V_EMP as
select empno, ename, job, mgr, hiredate from emp
where hiredate between '81/01/01' and '81/12/31';

select * from v_emp
--1981�⵵�� �Ի��� ���(0000), 1981�⵵ �Ի簡 �ƴ� ���(1111)
insert into v_emp values (0000, '�ӹ̿�', '����', 7092, '81/01/01');
insert into v_emp values (1111, 'ȫ�浿', '����', 7092, '80/01/01'); -- ����� ���ǿ� �ȸ����� ����

--�䰡 ������ ����� ������ ��ü�ض�
CREATE OR REPLACE VIEW V_EMP as
select empno, ename, job, mgr, hiredate from emp
where hiredate between '81/01/01' and '81/12/31'
WITH CHECK OPTION;

insert into v_emp values (3333, '���', 'Ÿ����', 7091, '82/11/11'); --WITH CHECK OPTION -> ����� ���ǿ� ���� �ʾƼ� ���� ����
insert into v_emp values (5555, 'Ÿ��', 'Ÿ��', 7091, '81/01/02');

--VUEW�� �������Ǳ��� ����ȴ�
insert into v_emp values (5555, 'Ÿ��', 'Ÿ��', 7091, '81/01/02');

--READ ONLY
CREATE OR REPLACE VIEW V_EMP as
select empno, ename, job, mgr, hiredate from emp
where hiredate between '81/01/01' and '81/12/31'
WITH READ ONLY;

insert into v_emp values (6665, 'Ÿ��', 'Ÿ��', 7091, '81/01/02');

UPDATE v_emp SET LOC = '���ѹα�'
WHERE DEPTNO = 20 

DELETE FROM EMP
WEHRE ename is null

select * from emp

ALTER TABLE PRODUCT MODIFY NAME CONSTRAINT PRODUCT_NAME_NN not null;
ALTER TABLE EMP MODIFY ENAME CONSTRAINT NN_EMP not null;

select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP';

--VIEW ���鶧 ���ǻ��� - not null �������� �ɸ� �÷� �ʼ��� select�� ���� (read only�� ��� ����, insert �ؾ��Ҷ� not null�̸� �ȵǴ°���)
CREATE OR REPLACE VIEW V_EMP as
select empno, ename, job, mgr, hiredate from emp
where hiredate between '81/01/01' and '81/12/31'
WITH CHECK OPTION;


insert into v_emp values (7777, '����', 7091, '81/01/02'); -- select�� ename �P���� ���� ) �Է°��� null�� �Ǹ鼭 ���� �ȵ�

--VIEW ���鶧 ���ǻ���2 : �׷��Լ�(ex_sum) ���� �÷��� ��Ī ��� �ʼ�, �׷��Լ�(ex_sum, distinct)�� �� view�� insert, update,delete �ȵ�
CREATE TABLE EMP2 (
        DNO NUMBER(2),
		SALARY NUMBER(7,2)
); 

INSERT INTO EMP2 VALUES (10, 1000); 	
INSERT INTO EMP2 VALUES (30, 2000);
INSERT INTO EMP2 VALUES (10, 5000);
--�Լ��� ���� �ݵ�� ��Ī�� ����Ѵ�
CREATE OR REPLACE VIEW V_EMP2 as
select dno, sum(salary) as salary from emp2
group by dno 
having sum(salary) > 5000
WITH CHECK OPTION;

--disdinct ��÷ ���ص� ������ ���� �ȵ� (read only)
CREATE OR REPLACE VIEW V_EMP2 as
select distinct dno from emp2
WITH CHECK OPTION;

DROP VIEW V_EMP2;

----------------------------------------------------------------------------------------------------
--1. emp ���̺��� 20�� �μ��� �Ҽӵ� ����� �����ȣ�� �̸��� �μ���ȣ�� ����ϴ� 
--   SELECT ���� �ϳ��� ��� ����
create view V_EMP3 as
select empno, ename, deptno from emp
where deptno = 20
WITH CHECK OPTION;

INSERT INTO V_EMP3 VALUES (3022, '����ž', 10) -- ���ǹ��� �������� ������ ���� �Ұ�

--2.�̹� ������ �信 ���ؼ� �޿� ���� ����� �� �ֵ��� ����
create or replace view V_EMP3 as
select empno, ename, deptno, sal from emp
where deptno = 20
WITH CHECK OPTION;

--3.������ �並 �����Ͻÿ�.
DROP VIEW V_EMP3

------------------------------------------------------------------------------------------------------
--[������]
1.���̺� ���� ������ ���ڸ� �ڵ����� ����
�ַ� �⺻Ű�� ������ ���� ������ ����ڰ� ���� ���� �����س��� �δ㰨�� ���� �� �ִ�.

2.������ �����
create sequence seq_toyid;

select * from toys;

3.���� ������ ��
select seq_toyid.nextval from dual;

insert into toys values (seq_toyid.nextval, '����')
insert into toys values (seq_toyid.nextval, '����')
select * from toys

drop sequence seq_toyid;

create sequence seq_toyid;

select seq_toyid.nextval from dual;

4.���� ������ ��
--select seq_toyid.currval from dual; --���Ƕ����� sql comment������ ���� (����â)

--[�ε���]
1.Ž�� �ӵ��� ���̱� ���� ���
2.Ž��Ű�� �� ����Ű �Ǵ� �ĺ�Ű�� �ʿ�� ����.

3.�ε��� ����
create index ename_idx on emp (ename);

4.�ε��� ���� Ȯ��
select INDEX_NAME, TABLE_NAME, COLUMN_NAME
from USER_IND_COLUMNS
where TABLE_NAME in ('EMP');

5.�ε��� ���� ��ħ
1)�⺻Ű (�ڵ����� �������)
2)�ܷ�Ű �ĺ� 
3)���� ���ŵǴ� �÷��� �ε����� �������� �ʴ� ���� ����. 
4)�ĺ�Ű �ĺ�
5)���� ���ŵǴ� ���̺� �ε����� �������� �ʴ� ���� ����.

6.�˻��ӵ� ���̷���
distinct ��� �ּ�ȭ
group by, having ��� �ּ�ȭ 

7.�ε��� ���� 
drop index ename_idx;

--------------------------------------------------------------------------------------------
--quiz
--0.emp�� ������ ������ emp01 ���̺��� ����
create table emp01
as
select *
from emp
where 0 = 1;

--1.��� ���̺��� �����ȣ�� �ڵ����� �����ǵ��� ������ ����
create sequence seq_empno

select seq_empno.nextval from dual;

--2.�����ȣ�� �������κ��� �߱�
insert into emp01 values (seq_empno.nextval, 'ȫ�浿', '����', 1423, '1999/09/09', 400, 40, 10);
select *from emp01;
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'emp01';

--3.EMP01 ���̺��� �̸� Į���� �ε����� �����ϵ� �ε��� �̸��� IDX_EMP01_ENAME���� ����
create index IDX_EMP01_ENAME on EMP01 (ename);

select INDEX_NAME, TABLE_NAME, COLUMN_NAME
from USER_IND_COLUMNS
where TABLE_NAME in ('EMP');

drop index IDX_EMP01_ENAME;

--[����]
1.�� ����� �߰� - ������ �������� ����
2.�ý��� ������ �޾ƾ� ���� ���� : create SESSION, CREATE TABLE, CREATE SEQUENCE, CREATE VIEW;
GRANT CREATE TABLE, CREATE SEQUENCE, CREATE VIEW to young;
--�ý��� ������ �����ڰ� �ְ� ���̺� ���� ������ �������� �� �� �ִ� 
3.��ü ���� : insert, update, delete, select, alter...

--[�䱸����] 
-young ������ ����� �ּ���
-young �������� ���� ������ �ּ���.
-scott ������ emp ���̺��� ��� ������ young���� �ּ���.
-scott ������ emp ���̺��� ���� ������ ����� ��ο��� �ּ���.

4.���� ���
REVOKE select ON EMP FROM young;

--[role]
1.create role manager;
2.grant create session, create table to manager;
3.grant manager to young;

--[���Ǿ�: SYNONYM]
grant create synonym to young;

create synonym emp for scott.emp;
---------------------------------------------------------------
1.sbs ��� ����� ����(��ȣ�� pass)
2.�⺻���� ���� �ο��� ���� ������ �����ͺ��̽��� �α����� �Ұ����ϹǷ�
  connection, resource ������ sbs ����ڿ��� �ο�


drop table book;

create table book(
	no number primary key,
	name varchar2(30),
	author varchar2(30),
	publisher varchar2(30)
)
