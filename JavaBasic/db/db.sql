--데이터 타입 확인하는법
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
insert into customer values (customerseq.nextval, 'bbq', '홍길동', '1234', '12331', '가나다라', '마바사', '010-2222-2222', '이메일');

select * from tab;
create table dept as
select * from scott.dept;

select * from customer where customerseq = 3;

select * from dept;
delete from dept where deptno not in(10,20,30);
update dept set dname = '재무팀' where deptno = '30';

create sequence customerseq;

insert into customer values(customerseq.nextval, 'bbq', '홍길동', '1234', '790812', '아현로 어딘가', '가길 2층', '010-2949-3949', 'bbq@gmail.com');

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
insert into customer values (1010, 'tami', '서울 중구', '010-0000-0000');

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

insert into publisher values ('구디출판사', '홍길동', '010-1234-1234');

select * from book
select * from publisher

insert into book values (seq_bookid.nextval, 'java', 5000, '구디출판사');

select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'Book';
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'publisher';

CREATE VIEW V_book as
select * from book
where price between 5000 and 10000;


8. 도서이름에 JAVA를 포함한 책 정보와 출판사 정보를 모두 검색하시오. 

  (단, 도서이름은 대소문자를 구분하지 않고 모두 검색되어야 한다. 즉, JAVA, java, Java, java 등을 포함한 책 모두 검색되어야 한다.)
  
select * from book where lower(bookname) like '%java%';

drop table book;


select * from memo;

select * from memo;
delete from memo where name is not null;
create sequence memoseq;
select memoseq.nextval from dual;
insert into memo values(memoseq.nextval, '카미', 10);




















create sequence seq_bookid;
select seq_bookid.nextval from dual;
DROP TABLE customer
select * from EMP

update customer set name = '고길동' where seq = 1;


insert into customer (seq, id, name, password, address, phone) 
values (seq_seq.nextval, '스마', '길동', 1235, '경기도 평택', '123-4528-1112');


CREATE TABLE DEPARTMENT(
	DNO NUMBER(2),
	DNAME VARCHAR2(14),
	LOC VARCHAR2(13)
);

--전체 사원의 모든 칼럼 조회
select * from EMP;

--전체 사원의 ename 칼럼 조회
select ename from emp;

--산술연산자 사용(+, -, *, /)
select ename, sal, sal*12 from emp;

--총급여액 구하기(상여 포함, null연산하면 null이 되버림)
--nvl(null 포함 컬럼, 기본값) -> null이 아니면 컬럼의 값 더하고 null이면 0을 더하기
select ename, sal*12+nvl(comm, 0) from emp;
--컬럼에 별칭을 설정하는 법(가장 선호하는 방법)
select ename, sal*12+nvl(comm, 0) as 연봉 from emp;
--as 없이 한칸 띄고 별칭 넣어도 됨
select ename, sal*12+nvl(comm, 0) 연봉 from emp;
--컬럼명에 공백을 포함하고 싶으면 ""사용
select ename, sal*12+nvl(comm, 0) "연 봉" from emp;

INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-7-1987','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-7-1987','dd-mm-yyyy'),1100,NULL,20);

--중복 데이터 한번만 출력하기(distinct)
--select * from dept;
select distinct deptno from emp;

--dual: 한 행으로 결과를 출력하기 위해 제공하는 테이블
--sysdate: 날짜 반환(select는 from 뒤에 테이블이 와야 하는데 테이블이 없으므로 dual을 사용해서 조회할 수 있게 하기)
select * from dual;
select sysdate from dual;

--dept가 총 4줄이기 때문에 4개의 sysdate가 나옴(현재날짜와 시간을 4개씩 넣을 필요 없으므로 dual을 사용)
select sysdate from dept;

--조건검색
--sal이 1500 이상일 경우 검색
select * from emp where sal >= 1500;
--부서번호가 10일 경우 검색
select * from emp where deptno = 10;
--이름이 scott일 경우 검색(문자열은 대소문자 구분, ''사용해야 함)
select * from emp where ename = 'SCOTT';
--입사일이 '1981/10/01' 이전인 사원만 조회하기
select * from emp where hiredate <= '1981-10-01';
--부서번호가 10이고 직급이 'MANAGER'인 사원만 조회하기
select * from emp where deptno = 10 and job = 'MANAGER';
--부서번호가 10이거나 직급이 'MANAGER'인 사원만 조회하기
select * from emp where deptno = 10 or job = 'MANAGER';
--부서번호가 10번이 아닌 사원 조회하기
select * from emp where deptno != 10;
select * from emp where not deptno = 10;
select * from emp where deptno <> 10;

--급여가 1000에서 1500 사이인 사원의 이름과 급여 검색하기
select ename, sal from emp where sal between 1000 and 1500;
select ename, sal from emp where sal >= 1000 and sal <= 1500;
--급여가 1000 미만이거나 1500 초과인 사원의 이름과 급여 검색하기
select ename, sal from emp where sal < 1000 or sal > 1500;
-- ==> 1000에서 1500 사이가 아닌 사람
select ename, sal from emp where not sal between 1000 and 1500;
--상여가 300이거나 500이거나 1400인 사원의 이름과 상여를 검색
select ename, comm from emp where comm = 300 or comm = 500 or comm = 1400;
--1982년에 입사한 사원 정보 검색하기
select * from emp where hiredate between '1982/01/01' and '1982/12/31';

--in 연산자(or를 나열하는 것보다 간편하게 사용 가능)
--상여가 300이거나 500인 사원 검색
select * from emp where comm in (300, 500);
--상여가 300이나 500이 아닌 사원(null 포함 안됨)
select * from emp where comm not in (300, 500); 
--null 포함해서 검색하는 방법(상여가 있으면 그 값 조회, 없으면 0으로 생각해서 조회)
select * from emp where nvl(comm, 0) not in (300, 500);

--like 연산자(%: 알 수 없는 갯수의 문자열)
--이름이 'F'로 시작하는 사원 검색하기
select * from emp where ename like 'F%';
--이름에 'M'이 포함되어 있는 사원 검색하기
select * from emp where ename like '%M%';
--이름이 'N'으로 끝나는 사원 검색하기
select * from emp where ename like '%N';
--이름의 두 번째 글자가 'A' 인 사원 검색하기 -> JAMES, WARD, MARTIN (_:한 글자 의미)
select * from emp where ename like '_A%';
--이름에 'A'를 포함하지 않는 사원
select * from emp where ename not like '%A%';

--null
--comm이 null인 사원 검색하기
select * from emp where comm is null;
--comm이 null이 아닌 사원 검색하기
select * from emp where comm is not null;


--정렬
--급여기준으로 오름차순(오름차순은 생략 가능)
select * from emp order by sal asc;
--내림차순
select * from emp order by sal desc;
--급여를 많이 받는 순으로 정렬하되 동일 급여 받는 사원에 대해서 이름의 순서가 빠른 사람
select * from emp order by sal desc, ename asc; 
--입사일 순서대로 사원정보 검색(오름차순: 과거->현재)
select * from emp order by hiredate;
--입사일 순서대로 사원정보 검색(오름차순: 현재-> 과거)
select * from emp order by hiredate desc;


--1.덧셈 연산자를 이용하여 모든 사원에 대해서 $300 의 급여 인상을 계산한 후 사원의 이름, 급여, 인상된 급여를 출력하시오.
select ename, sal, sal+300 as "인상된 급여" from emp;

--2.사원의 이름, 급여, 연간 총수입을 총 수입이 많은 것부터 작은 순으로 출력하시오.
--연간 총수입은 월급에 12를 곱한 후, $100의 상여금을 더해서 계산하시오.
select ename, sal, sal*12+100 as "연간 총수입" from emp order by "연간 총수입" desc;

--3.급여가 2000을 넘는 사원의 이름과 급여를 급여가 많은 것부터 작은 순으로 출력하시오
select ename, sal from emp where sal > 2000 order by sal desc;

--4.사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
select ename, deptno from emp where empno = 7788;

--5.급여가 2000 에서 3000 사이에 포함되지 않는 사원의 이름과 급여를 출력하시오.
select ename, sal from emp where not sal between 2000 and 3000;

--6.1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원의 이름, 담당 업무, 입사일을 출력
select ename, job, hiredate from emp where hiredate between '81/2/20' and '81/5/1'; 

--7.부서 번호가 20 및 30 에 속한 사원의 이름과 부서번호를 출력하되 이름을 기준(내림차순)으로 영문자순으로 출력하시오
select ename, deptno from emp where deptno in(20, 30) order by ename desc;

--8.사원의 급여가 2000 에서 3000 사이에 포함되고 부서번호가 20 또는 30 인 사원의 이름, 
--급여와 부서번호를 출력하되 이름순(오름차순)으로 출력하시오.
select ename, sal, deptno from emp where sal between 2000 and 3000 and deptno in(20, 30) order by ename asc;

--9.1981년도에 입사한 사원의 이름과 입사일을 출력하시오.(LIKE 연산자와 와일드카드 사용)
--1981%는 불가능, 실제 데이터가 81~로 되어있기 때문이다.
select ename, hiredate from emp where hiredate like '81%';

--10.관리자가 없는 사원의 이름과 담당 업무를 출력하시오.
select ename, job from emp where mgr is null;

--11.커미션을 받을 수 있는 자격이 되는 사원(커미션 값이 존재하는 사원)의 이름, 급여, 커미션을 출력하되 급여 및 커미션을
--기준으로 내림차순 정렬하여 표시
select ename, sal, comm from emp where comm is not null order by sal desc, comm desc;

--12.이름의 세번째 문자가 R인 사원의 이름을 표시
select ename from emp where ename like '__R%';

--13.이름에 A와E를 모두 포함하고 있는 사원의 이름 표시
--select ename from emp where ename like "%A%E%" 이렇게 하면 a와 e의 순서가 맞아야 조회가 된다.
select ename from emp where ename like '%A%' and ename like '%E%';

--14.담당업무가 사무원(CLERK) 또는 영업사원(SALESMAN)이면서 급여가 
  -- $1600, $950 또는 $1300이 아닌 사원의 이름, 담당업무, 급여를 출력하시오.
select ename, job, sal from emp where job in('CLERK', 'SALESMAN') and sal not in (1600, 950, 1300);

--15 
select ename, comm from emp where comm >= 500;
------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------
--[함수]
--1.문자함수
--1)대소문자 변환 함수
select 'Oracle', upper('Oracle'), lower('Oracle'), initcap('oracle oracle') from dual;

--2)사원이름, 업무를 조회하시오. 단, 사원이름은 소문자로, job은 첫글자만 대문자로 검색하시오.
select lower(ename), initcap(job) from emp;

select * from emp where ename = 'scott'; --대소문자가 일치하지않아 검색안된다
select * from emp where lower(ename) = 'scott';
select * from emp where ename = upper('scott'); -- 이것도 가능하긴 함

--2)문자 길이를 반환하는 함수
select length('Oracle'), length('오라클') from dual;

--문자 조작 함수
--concat : 합치기
select concat('oracle','오라클') from dual;

--substr : (대상, 시작자리, 시작자리부터 몇자)
select substr('Oracle mania', 4, 3), substr('Oracle mania', -4, 3) from dual;

--951111-2345678
select substr('951111-2345678', 8, 1) from dual;

--substr을 이용해서 이름이 N으로 끝나는 사원 검색
select * from emp where substr(ename, -1) = 'N';

--substr을 이용해서 87년도에 입사한 사원 검색
select * from emp where substr(hiredate, 1 , 2) = '87';

--instr(대상, 찾을글자, 시작위치, 몇번째 발견)
select instr('Oracle mania', 'a') from dual;
select instr('Oracle mania', 'a', 1, 1) from dual;
select instr('Oracle mania', 'a', 5, 2) from dual;

--이름의 세번째 자리 'R'인 사원을 검색
select * from emp where instr(ename, 'R', 3, 1) = 3;

--특정 기호로 채우기 (대상, 자리수, 채울기호)
select lpad(sal, 10, '*') from emp;
select rpad(sal, 10, '*') from emp;
--사용 예시 : 961111-******* 

--공백제거  ,  -- || : 문자 연결 연산자
select rtrim(' Oracle mania ') || 'end', ltrim(' Oracle mania ') || 'end', trim(' Oracle mania ') || 'end' from dual;

--특정문자가 첫번째 또는 마지막 글자이면 잘라내고 남은 문자열만 반환
select trim('a' from 'aaaaOraclec Maniaaaa') from dual;

--2.숫자 함수
--1)round(대상, 자릿수) : 반올림
select 98.7654, round(98.7654), round(98.7654, 2), round(98.7654, -1) from dual;

--2)trunc(대상, 자릿수) : 버림
select 98.7654, trunc(98.7654), trunc(98.7654, 2), trunc(98.7654, -1) from dual;

--3)mod(첫번째 값, 두번째 값) : 첫번째 값에서 두번째 값 나누고 나머지값 반환
select mod(31, 2), mod(31, 5), mod(31, 8) from dual; 

--4)모든 사원의 급여를 500으로 나눈 나머지를 계산
select ename, sal, mod(sal, 500) as 나머지 from emp;

--3.날짜함수 
--1)sysdate : 현재날짜 반환
select sysdate from dual;

--2)날짜계산 (산술연산자 사용가능)
select sysdate-1 as 어제, sysdate as 오늘, sysdate+1 as 내일, sysdate+10 as 10일뒤 from dual;

--근무일수 검색 : 퇴직금 산정할때 사용 
select ename, hiredate, round(sysdate-hiredate) as 근무일수 from emp;
select ename, hiredate, sysdate-hiredate as 근무일수 from emp;

--그달의 1일 부터 (월을 기준으로 일을 버림한 날짜)
select hiredate, trunc(hiredate, 'MONTH') from emp;
select hiredate, trunc(sysdate, 'MONTH') from emp;

--근무한 개월 수
select ename, sysdate, hiredate, months_between(sysdate, hiredate) from emp;
select ename, sysdate, hiredate, trunc(months_between(sysdate, hiredate)) from emp order by hiredate;

--입사한지 12개월 후 날짜 구하기
select ename, hiredate, hiredate+365 from emp;
select ename, hiredate, add_months(hiredate, 12) from emp;
--최근 6개월
select ename, hiredate, add_months(hiredate, -6) from emp;

--오늘 기준으로 최초로 도래하는 x요일 구하기
select sysdate, next_day(sysdate, '월') from dual;
select sysdate, next_day(sysdate, '화') from dual;
select sysdate, next_day(sysdate, 1) from dual; --1:일요일
select sysdate, next_day(sysdate, 5) from dual; --5:목요일

--입사한 달의 마지막날 구하기
select ename, hiredate, last_day(hiredate) from emp;

--4.형변환 함수
--1)to_char
--varchar2(ex_ename), number(ex_sal), date(ex_hiredate) : 데이터형

--날짜 -> 문자
--사원들의 입사일에서 입사년도와 월만 출력
select ename, hiredate, to_char(hiredate, 'YY/MM') from emp; 
select ename, hiredate, to_char(hiredate, 'YY-MM') from emp; 
select ename, hiredate, to_char(hiredate, 'YYYY/MM/DD DAY') from emp;

--숫자 -> 문자 : 회계에서 사용하는 숫자처리로 변경
select ename, sal, to_char(sal, '9,999') from emp;
select ename, sal, to_char(sal, '9,999,999') from emp;
--8자리로 세팅
select ename, empno, to_char(empno, '00000000') from emp;

--2)to_date
--1981년 2월 20일에 입사한 사원 검색
select ename, hiredate from emp where hiredate = '19810220';
select ename, hiredate from emp where hiredate = '1981-02-20';
select ename, hiredate from emp where hiredate = '81/02/20';
--데이터를 받아서 DB에 넣을때 양식에 맞게 바꿔 넣어줄때 사용
select ename, hiredate from emp where hiredate = to_date(19810220, 'YYYYMMDD');

--3)to_number
select '100,000' -'50,000' from dual;
select to_number('100,000', '999,999') - to_number('50,000', '999,999') from dual;

--5.일반 함수
--1)nvl
select ename, sal, comm, nvl(comm, 0) from emp;

--2)nvl2(expr1, expr2, expr3) : expr1값이 null이 아니면 expr2 선택, expr1값이 null이면 expr3 선택
select ename, nvl2(comm, sal*12+comm, sal*12) from emp

--3)nullif(expr1, expr2) : 값이 동일한 경우 null 리턴, 동일하지 않은 경우 expr1 리턴
select nullif('A', 'A'), nullif('C', 'B') from dual;

--4)coalesce(expr1..n) n개까지 있다 : 인수중에서 null이 아닌 첫번째 인수를 반환
select ename, sal, comm, coalesce(comm, sal) from emp;

--5)decode(표현식, 조건1, 결과1
--               조건2, 결과2
--                   기본결과)
--table이 없는경우 (코드만 있는경우)
select ename, deptno, decode(deptno, 10, '회계팀', 20, '마케팅팀', 30, '영업팀', 40, '운영팀', '기타') as dname from emp;

--6)case expr
--		when 조건1 then 결과1
--		when 조건2 then 결과2
--		else 결과N
--	end
select ename, deptno,
		case when deptno = 10 then '회계팀'
			 when deptno = 20 then '조사팀'
			 when deptno = 30 then '영업팀'
			 when deptno = 40 then '운영팀'
			 else '기타'
		end as dname
from emp;

--1.SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력
select ename, hiredate, substr(hiredate, 1, 5) as 입사연월 from emp;
select ename, hiredate, substr(hiredate, 1, 2) as 년도, substr(hiredate, 4, 2) as 월 from emp;

--2.SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력
select * from emp where substr(hiredate, 4, 2) = 04;
select * from emp where substr(hiredate, 5, 1) = 4;

--3.MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력
select * from emp where mod(empno, 2) = 0;

--4.입사일을 연도는 2자리(YY), 월은 숫자(MON)로 표시하고 요일은 약어(DY)로 지정하여 출력
select ename, hiredate, to_char(hiredate, 'YY/MON/DY') as 연월 from emp;

--5.현재 날짜를 이용하여 올해 며칠이 지났는지 출력
select trunc(sysdate) - trunc(sysdate, 'YEAR') as day from dual;

--6.사원들의 매니저 사번을 출력하되 매니저가 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
select ename, mgr, nvl(mgr, 0) as 매니저 from emp;

--7.DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 직급이 'ANALYST'인 사원은 200,
-- 'SALESMAN'인 사원은 180, 'MANAGER'인 사원은 150, 'CLERK'인 사원은 100을 인상하시오.
select ename, job, sal, decode(job,'ANALYST', sal+200, 'SALESMAN', sal+180, 'MANAGER', sal+150, 'CLERK', sal+100) as 급여인상 from emp;

--그룹함수 사용
--1.그룹함수
--1)sum, avg, max, min
select sum(sal) as 총급여액, avg(sal) as 평균급여, max(sal) as 쵀대급여, min(sal) as 최소급여 from emp;

select max(hiredate), min(hiredate) from emp;

--2)그룹함수와 null값
select sum(comm) as 상여총액 from emp;

--3)count
--모든 행 개수 구하기
select count(*) from emp;

--상여 받는 사원수
select count(comm) from emp;
select count(*) from emp where comm is not null;

--직업 종류의 개수를 검색해보세요
select count(job) from emp;
select count(distinct job) from emp;
select * from emp;

--4)그룹함수 잘못 사용한 예
select ename, max(sal) from emp; ---xxxx

--서브쿼리
select ename from emp where sal = (select max(sal) from emp);

--2.데이터 그룹
--소속 부서별 평균 급여를 부서번호와 함께 출력
select deptno, avg(sal) as avg_sal
from emp
group by deptno;

--다중 컬럼을 이용하여 그룹별로 검색하기
--그룹이 지어진 후에 job인애가 count명 
select deptno, job, count(*), sum(sal)
from emp
group by deptno, job
order by deptno, job

--3.그룹 결과 제한 : having 절은 그룹합수의 결과 값중 지정한 조건에 true인 그룹으로 제한한다.
--부서별 최대 급여가 3000 이상인 부서번호와 부서별 최대 급여 구하시오
select deptno, max(sal)
from emp
group by deptno
having max(sal) >= 3000;

--Manager를 제외하고 급여 총액이 5000 이상인 직급별 총액
select job, count(*), sum(sal)
from emp
where job != 'MANAGER'
group by job
having sum(sal) >= 5000
order by job;

--부서별 최고 평균 급여 구하기
select max(avg(sal))
from emp
group by deptno;

-----------------------------------------------------------------------------------------------------------
--1.모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력
--	칼럼의 별칭은 아래와 동일하게 지정하고 평균에 대해서는 정수로 반올림하시오.
--	Maximum	Minimum 	Sum        Average
select max(sal) as Maximum, min(sal) as Minimum, sum(sal) as Sum, round(avg(sal)) as Average
from emp;

--2.각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균액을 출력
--	칼럼의 별칭은 아래와 동일하게 지정하고 평균에 대해서는 정수로 반올림하시오.
select job, max(sal) as Maximum, min(sal) as Minimum, sum(sal) as Sum, round(avg(sal)) as Average
from emp
group by job;

--3.count(*) 함수를 이용하여 담당 업무가 동일한 사원 수를 출력
select job, count(*)
from emp
group by job;

--4.직업별 관리자 수를 나열. 칼럼의 별칭은 아래와 같이 지정하시오.
--	COUNT(MANAGER)
select count(mgr) as "COUNT(MANAGER)"
from emp

select job, count(mgr) as "COUNT(MANAGER)"
from emp
group by job;

--5.급여 최고액, 급여 최저액의 차액을 출력
select max(sal), min(sal), (max(sal) - min(sal)) as 최대최소급여차액
from emp

--6.직급별 사원의 최저 급여를 출력
--  관리자를 알 수 없는 사원 및 최저 급여가 2000 미만인 그룹은 제외시키고
--  결과를 급여에 대한 내림차순으로 정렬하여 출력
select job, min(sal)
from emp
where mgr is not null
group by job
having min(sal) > 2000 
order by min(sal) desc

--7.각 부서에 대해 부서번호, 사원수, 부서 내의 모든 사원의 평균 급여를 출력
--  평균 급여는 소수점 둘째 자리로 반올림
select deptno, count(*) as 사원수, round(avg(sal), 2) as 평균급여
from emp
group by deptno

--8.문제오류로 제외

--9.업무를 표시한 다음 해당 업무에 대해 부서번호별 급여 및 부서 10,20,30의 급여 총액을 각각 출력  --요거 틀림 다시 풀기
select job, deptno, sum(sal), count(*)
from emp
group by deptno, job
order by job

select job, deptno, sum(sal), count(*), decode(deptno, 10, sum(sal)), decode(deptno, 20, sum(sal)), decode(deptno, 30, sum(sal))
from emp
group by deptno, job
order by job

------------------------------------------------------------------------------------------------------------------
--조인
select * from emp;
select * from dept;

--등가조인
select * from emp, dept
where emp.deptno = dept.deptno
order by empno;

--테이블 이름을 별칭으로 표현하기 
select * from emp e, dept d
where e.deptno = d.deptno
order by empno;

select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno;

select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno and sal >= 3000;

--emp, dept 등가조인한 후, 급여가 2500 이하고, 사원번호가 9999 이하인 사원의 정보를 검색하시오.
select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
	and e.sal <= 2500
	and e.empno <= 9999;

select * from SALGRADE;

--비등가 조인
select *
from emp e, salgrade s 
where e.sal between s.losal and s.hisal;

--자체 조인(셀프 조인)
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr = e2.empno;

--외부 조인
--왼쪽 외부 조인
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr = e2.empno(+);

--오른쪽 외부 조인
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr(+) = e2.empno;
--------------------------------------------------------------------------------------
--표준 sql  : 불편하구나 생각이 들거다
--등가 조인
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

--외부조인
--왼쪽 외부 조인
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1 LEFT OUTER JOIN emp e2 on (e1.mgr = e2.empno);

--오른쪽 외부 조인
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1 RIGHT OUTER JOIN emp e2 on (e1.mgr = e2.empno);

--전체 외부 조인
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1 FULL OUTER JOIN emp e2 on (e1.mgr = e2.empno);

--테이블 삭제
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

INSERT INTO TOYS VALUES (1,'다이노포스');
INSERT INTO TOYS VALUES (2,'또봇');
INSERT INTO TOYS VALUES (3,'미니특공대');
INSERT INTO TOYS VALUES (4,'캉시');
INSERT INTO TOYS VALUES (5,'레고');

INSERT INTO BOYS VALUES (1,'허세람', 2);
INSERT INTO BOYS VALUES (2,'정다은', 5);
INSERT INTO BOYS VALUES (3,'루시', 1);
INSERT INTO BOYS VALUES (4,'대소', 7);
INSERT INTO BOYS VALUES (5,'주몽', 2);

select * from toys;
select * from boys;

select * from toys t, boys b
order by b.boy;

--내부조인
--inner join : 교집합  on: 조건
select *
from toys t inner join boys b
on t.toy_id = b.toy_id;

--emp, dept table inner join
select *
from emp e inner join dept d 
on e.deptno = d.deptno
where e.ename = 'ADAMS';

--on 조건 안에있는 것들이 맞지 않는경우 <> : !=  둘이 같은 표현
select *
from toys t inner join boys b on t.toy_id <> b.toy_id;

select * from toys natural join boys;

--외부 조인
--왼쪽 조인
select b.boy, t.toy
from boys b left outer join toys t
on b.toy_id = t.toy_id;

select b.boy, t.toy
from boys b left outer join toys t
on b.toy_id = t.toy_id
where t.toy_id is not null

--오른쪽 조인
select b.boy, t.toy
from boys b right outer join toys t
on b.toy_id = t.toy_id;

select b.boy, t.toy
from boys b right outer join toys t
on b.toy_id = t.toy_id
where b.toy_id is not null

--완전 외부 조인
select b.boy, t.toy
from boys b full outer join toys t
on b.toy_id = t.toy_id;

------------------------------------------------------------------------------------------------------------
--1.동등 조인을 사용하여 SCOTT 사원의 부서번호와 부서이름 출력
select e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno and e.ename = 'SCOTT';

select e.ename, deptno, d.dname
from emp e natural join dept d
where e.ename = 'SCOTT';

--2.사원 이름과 함께 그 사원이 소속된 부서이름과 지역명 출력(*INNER JOIN)
select e.ename, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno;

select e.ename, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno;

--3.10번 부서에 속하는 모든 담당 업무의 고유 목록(한 번씩만 표시)을 부서의 지역명을 포함하여 출력(*INNER JOIN)
select e.ename, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno and e.deptno = 10;

select e.ename, e.deptno, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno
where e.deptno = 10;

--4.커미션을 받는 사원의 이름, 부서이름, 지역명 출력(*NATURAL JOIN)
select e.ename, d.dname, d.loc, e.comm
from emp e, dept d
where e.deptno = d.deptno and comm is not null and comm != 0;

select e.ename, d.dname, d.loc, e.comm
from emp e natural join dept d 
where comm is not null and comm != 0

--5.이름에 A가 포함된 모든 사원의이름과 부서이름 출력
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno and ename like '%A%';

select e.ename, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
where ename like '%A%';

--6.NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력(NATURAL JOIN)
select e.ename, e.job, e.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno and d.loc ='NEW YORK';

select e.ename, e.job, deptno, d.dname, d.loc
from emp e natural join dept d 
where d.loc = 'NEW YORK';

select e.ename, e.job, deptno, d.dname, d.loc
from emp e inner join dept d 
on e.deptno = d.deptno
where d.loc = 'NEW YORK'; -----수정해보기

--7.사원의 이름 및 사원번호를 관리자이름 및 관리자번호와 함께 출력 
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1, emp e2
where e1.mgr = e2.empno;

select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_no, e2.ename as mgr_name
from emp e1 inner join emp e2
on e1.mgr = e2.empno;

--8.관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순으로 출력 (OUTER JOIN, SELF JOIN)
select e1.ename, e1.empno, e1.mgr, e2.ename as mgr_name, e2.empno as mgr_no
from emp e1, emp e2
where e1.mgr = e2.empno(+)
order by empno desc;

select e1.ename, e1.empno, e1.mgr, e2.ename as mgr_name, e2.empno as mgr_no
from emp e1 left outer join emp e2
on e1.mgr = e2.empno
order by empno desc;

--9.SCOTT 사원의 부서번호와 그 동일한 부서에 근무하는 사원을 출력(SELF JOIN)
select e1.ename, e1.deptno, e2.ename, e2.deptno
from emp e1, emp e2
where e1.deptno = e2.deptno and e2.ename = 'SCOTT';

select e1.ename, e1.deptno, e2.ename, e2.deptno
from emp e1 inner join emp e2
on e1.deptno = e2.deptno 
where e2.ename = 'SCOTT';

--10.WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력(SELF JOIN)
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

--11.관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력(SELF JOIN)
select e1.ename, e1.hiredate, e1.mgr, e2.ename as mgr_name, e2.hiredate
from emp e1, emp e2
where e1.mgr = e2.empno and e1.hiredate < e2.hiredate;

select e1.ename, e1.hiredate, e1.mgr, e2.ename as mgr_name, e2.hiredate
from emp e1 inner join emp e2
on e1.mgr = e2.empno
where e1.hiredate < e2.hiredate
-----------------------------------------------------------------------------------------------------------------------
select * from tab;

--단일행 서브쿼리
--1.SCOTT 보다 급여를 많이 받는 사원
select e1.ename, e1.sal, e2.ename, e2.sal
from emp e1, emp e2
where e1.sal < e2.sal and e1.ename= 'SCOTT'

select sal from emp where ename = 'SCOTT'; --3000
select ename, sal from emp where sal > 3000;

select ename, sal from emp where sal > (select sal from emp where ename = 'SCOTT');

--SCOTT과 동인한 부서에서 근무하는 사원
select ename, deptno from emp where deptno = (select deptno from emp where ename = 'SCOTT');

--최소 급여를 받는 사원의 이름, 담당업무, 급여 출력하기
select ename, job, sal from emp where sal = (select min(sal) from emp);

--30번 부서에서 최소급여를 구한 후, 부서별 최소 급여가 30번부서의 최소급여보다 큰 부서만 출력
select min(sal) from emp where deptno = 30;

select deptno, min(sal) from emp 
group by deptno
having min(sal) > (select min(sal) from emp where deptno = 30);


--다중행 서브쿼리 -- 서브쿼리의 결과가 여러줄일때 in 사용
--부서별 최소 급여를 받는 사원의 사원번호와 이름을 출력
select min(sal) from emp group by deptno;

select ename, empno, sal from emp where sal in (select min(sal) from emp group by deptno); 

-- 직급이 SALEMAN이 아니면서 급여가 임의의 SALEMAN 보다 낮은 사원을 출력
select ename, job, sal from emp where job != 'SALESMAN';
select max(sal) from emp where job = 'SALESMAN';

--비교값 < any() : 비교값이 서브쿼리 결과의 최대값보다 작음   any가 서브쿼리
--비교값 > any() : 비교값이 서브쿼리 결과의 최소값보다 큼
--서브쿼리 결과의 어떤 하나랑 비교했을때 한개만 참이여도 select된다
--any는 or 처럼 사용

select ename, job, sal from emp where job != 'SALESMAN' and sal < (select max(sal) from emp where job = 'SALESMAN');
select ename, job, sal from emp where job != 'SALESMAN' and sal < any (select sal from emp where job = 'SALESMAN');

-- 직급이 SALEMAN이 아니면서 직급이 SALEMAN인 사원보다 급여가 적은 사원을 모두 출력
select ename, job, sal from emp where job != 'SALESMAN';

--all값의 어떤 값보다 작아야함
--all은 and로 사용
select ename, job, sal from emp 
where job != 'SALESMAN' and sal < all(select sal from emp where job = 'SALESMAN');
--all값의 어떤 값보다 커야함
select ename, job, sal from emp 
where job != 'SALESMAN' and sal > all(select sal from emp where job = 'SALESMAN');

---------------------------------------------------------------------------------------------------------------
--quiz
--1.사원번호가 7788인 사원과 담당 업무가 같은 사원의 이름과 업무를 출력하시오.
select job from emp where empno = 7788;
select ename, job, empno from emp where job = 'ANALYST';

select ename, job, empno from emp where job = (select job from emp where empno = 7788);

--2.사원번호가 7499인 사원보다 급여가 많은 사원의 이름과 업무를 출력하시오.
select sal from emp where empno = 7499;

select ename, job, sal from emp where sal > (select sal from emp where empno = 7499);

--3.최소 급여를 받는 사원의 이름, 담당 업무 및 급여를 출력하시오.(그룹함수 사용)
select min(sal) from emp;

select ename, job, sal from emp where sal = (select min(sal) from emp);

--4.직업별로 급여가 가장 적은 사원의 담당 업무를 찾아 직급과 급여를 출력

select min(sal) from emp

select job, avg(sal) from emp 
group by job 
having avg(sal) = (select min(avg(sal)) from emp group by job);
--문제오류 다시풀기 문제바뀜


--5.각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호 출력
select ename, sal, deptno from emp where sal in (select min(sal) from emp group by deptno);

--6. 담당업무가 분석가(ANALYST)인 사원보다 급여가 적으면서 업무가 분석가 아닌 사원의 사원번호, 이름, 업무, 급여 출력
select ename, job, sal from emp where job = 'ANALYST';

select empno, ename, job, sal from emp 
where sal < all (select sal from emp where job = 'ANALYST') and job <> 'ANALYST';

--7.부하직원이 없는 사원의 이름을 출력
select ename from emp where empno not in (select e1.empno from emp e1, emp e2 where e1.empno = e2.mgr);

--select ename from emp where empno not in (select mgr from emp where mgr is not null group by mgr)

select * from emp;
--8.부하직원이 있는 사원의 이름을 출력
select ename from emp where empno in (select e1.empno from emp e1, emp e2 where e1.empno = e2.mgr);

--select ename from emp where empno in (select mgr from emp)
select * from emp where empno in (select mgr from emp where mgr is not null)

--9.BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성(단, BLAKE는 제외)
select deptno, ename from emp where ename = 'BLAKE';

select deptno, ename, hiredate from emp where ename != 'BLAKE' and deptno = (select deptno from emp where ename = 'BLAKE');

--10.급여가 평균 급여 보다 많은 사원들의 사원번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬
select avg(sal) from emp ;

select empno, ename, sal from emp where sal > (select avg(sal) from emp);

--11.이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원번호와 이름을 표시하는 질의 작성
select ename, job, deptno from emp where ename like '%K%';
select ename, job, deptno from emp where deptno in (10, 30);

select empno, ename from emp where deptno in (select deptno from emp where ename like '%K%');

--12.부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당 업무를 표시
select loc, deptno from dept where loc = 'DALLAS';
select deptno, ename from emp where deptno = 20;

select e.ename, e.deptno, e.job, d.deptno, d.loc
from emp e, dept d
where e.deptno = d.deptno and d.loc = (select loc from dept where loc = 'DALLAS')

select ename, deptno, job from emp
where deptno = (select deptno from dept where loc = 'DALLAS');

select * from emp

--13.KING 에게 보고하는 사원의 이름과 급여 표시
select ename from emp where mgr = 7839;

select ename, sal from emp where mgr = (select empno from emp where ename = 'KING');

--14.RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시
select dname from dept where dname = 'RESEARCH'

select e.deptno, e.ename, e.job 
from emp e, dept d
where e.deptno = d.deptno and d.dname = (select dname from dept where dname = 'RESEARCH');

select deptno, ename, job
from emp
where deptno = (select deptno from dept where dname = 'RESEARCH')

--15.평균 급여보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원번호, 이름, 급여 표시
select avg(sal) from emp;

select empno, ename, sal, deptno
from emp 
where sal > (select avg(sal) from emp) and deptno in(select deptno from emp where ename like '%M%') ;

--16.평균 급여가 가장 적은 업무를 표시
select min(avg(sal)) from emp group by job;

select job, avg(sal) 
from emp 
group by job 
having avg(sal) = (select min(avg(sal)) from emp group by job);

--17.담당 업무가 MANAGER인 사원이 소속된 부서와 동일한 부서의 사원을 표시
select deptno, job from emp where job = 'MANAGER';

select deptno, ename from emp where deptno in (select deptno from emp where job = 'MANAGER');

select * from emp where deptno in (select deptno from emp where job = 'MANAGER');

---------------------------------------------------------------------------------------------------------------------
--테이블 생성
--테이블명 칼럼명 작성 규칙
--1.문자로 시작해야 하면 30자 이내로 작성
--2.문자, 숫자, 특수문자(_, $, #)만 사용 가능
--3.대소문자 구별이 없다.
--4.동일 사용자가 소유한 다른 객체의 이름과 중복되지 않아야 한다.
--디비의 객체: create해서 만들어지는건 객체

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

--테이블 구조만 복제하기 (where 조건에 거짓인것 아무거나 넣으면 구조만 복사한다)
CREATE TABLE emp30
as
select * 
from emp
where 0 = 1

--emp 테이블의 20번 부서 소속 사원에 대한 정보를 포함한 emp20테이블 생성
--다만, sal은 연봉값으로 한다.
CREATE TABLE emp20
AS
select empno, ename, sal*12 as sal 
from emp 
where deptno = 20;

select * from emp20
--테이블 삭제
DROP TABLE 테이블명
select * from tab

--휴지통 비우기 
PURGE recyclebin

--테이블 변경
--1)변경할 테이블 생성
CREATE TABLE emp20
AS
select empno, ename, sal*12 as sal 
from emp 
where deptno = 20;

--2)컬럼 추가
ALTER TABLE emp20 ADD(BIRTH DATE);
select * from emp20
ALTER TABLE emp20 ADD(ADDR VARCHAR2(30) DEFAULT '서울');

--3)컬럼 변경
ALTER TABLE EMP20 MODIFY BIRTH VARCHAR2(10)
ALTER TABLE EMP20 MODIFY BIRTH DATE

--칼럼안에 데이터가 들어가면 더작은 크기의 형으로 변경 불가능
ALTER TABLE EMP20 MODIFY empno number(5);
--칼럼 변경 및 추가
ALTER TABLE EMP20 MODIFY (ADDR VARCHAR2(30) DEFAULT '제주');
INSERT INTO EMP20(EMPNO, ENAME, SAL, BIRTH) VALUES (8500, 'JENI', 5000, '2021/09/07');
INSERT INTO EMP20(EMPNO, ENAME, SAL, BIRTH, ADDR) VALUES (8500, 'TAMI', 5000, '2021/09/07', '부산');
select * from emp20

--4)컬럼 삭제
ALTER TABLE EMP20 DROP COLUMN ENAME;

--5)테이블명 변경
RENAME EMP20 TO EMP50

SELECT * FROM TAB
DROP TABLE EMP50
PURGE RECYCLEBIN

select TABLE_NAME from user_tables

DROP TABLE DEPARTMENT PURGE

----------------------------------------------------------------------------------------------------------------
--1.DEPARTMENT  테이블을 생성하시오.
--	DNO NUMBER 2
--  DNAME VARCHAR2 14
--	LOC VARCHAR2 13
CREATE TABLE DEPARTMENT(
	DNO NUMBER(2),
	DNAME VARCHAR2(14),
	LOC VARCHAR2(13)
);
select * from department

--2.EMPLOYEE 테이블을 생성하시오.
--	ENO NUMBER 2
--	ENAME VARCHAR2 10
--	DNO NUMBER 2
CREATE TABLE EMPLOYEE(
	ENO NUMBER(2),
	ENAME VARCHAR2(10),
	DNO NUMBER(2)
);

--3.긴 이름을 저장할 수 있도록 EMPLOYEE테이블 수정 : 크기 10 - >25 으로
ALTER TABLE EMPLOYEE MODIFY ENAME VARCHAR2(25);

--4.EMP 테이블을 복사해서 EMPLOYEE2란 이름의 테이블을 생성하되
--  사원번호, 이름, 급여, 부서번호 칼럼만 복사하고 새로 생성된 테이블의 칼럼명은 각각
--  EMP_ID, NAME, SAL, DEPT_ID로 지정하시오.
CREATE TABLE EMPLOYEE2
AS
select empno as EMP_ID, ename as NAME, sal as EMP_SAL, deptno as DEPT_ID
FROM EMP;

select * from EMPLOYEE

--5.EMPLOYEE 테이블 삭제
DROP TABLE EMPLOYEE PURGE;

--6.EMPLOYEE2란 이름을 EMPLOYEE 로 변경하시오.
RENAME EMPLOYEE2 TO EMPLOYEE

--7.DEPARTMENT  테이블에서 DNAME 칼럼을 제거하시오.
ALTER TABLE DEPARTMENT DROP COLUMN DNAME

select * from department

--------------------------------------------------------------------------
--데이터 조작
--테이블 이름 : dept2
CREATE TABLE DEPT2
as
select * 
from dept
where 0 = 1

select * from dept2
--데이터 추가
insert into dept2 (deptno, dname, loc) values (10, 'ACCOUNTING', '서울');
insert into dept2 (deptno, dname) values (20, 'PROGRAMING');
insert into dept2 (dname, deptno) values ('PROGRAMING', 40);

--UPDATE
UPDATE DEPT2 SET LOC = '제주'
WHERE DEPTNO = 40;

UPDATE DEPT2 SET LOC = '부산', DNAME = 'PROGRAMIN3'
WHERE DEPTNO = 40;

UPDATE DEPT2 SET LOC = '대한민국'
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
--1.EMP 테이블의 구조만 복사하여 EMP_INSERT란 이름의 빈 테이블 만드시오
CREATE TABLE EMP_INSERT
AS
select * from emp
where 1=0

select * from emp_insert
--2.본인을 EMP_INSERT 테이블에 추가하되 SYSDATE를 이용해서 입사일을 오늘로 입력
insert into emp_insert (empno, ename, job, hiredate, sal) values (1, '노태완', 'PROGRAMER', sysdate, 350);

--3.EMP_INSERT 테이블에 옆 사람을 추가하되 TO_DATE 함수를 이용해서 입사일을 어제로 입력
insert into emp_insert (empno, ename, job, hiredate, sal) values (2, '강구현', 'PROGRAMER', to_date(sysdate - 1), 350);

--4.EMP 테이블의 구조와 내용을 복사하여 EMP_COPY란 이름의 테이블 만드시오
CREATE TABLE EMP_COPY
AS
SELECT * FROM EMP;

select * from emp_copy

--5.사원번호가 7788인 사원의 부서번호를 10번으로 수정하시오.
UPDATE emp_copy SET deptno = 10
where empno = 7788

--6.사원번호 7788의 담당업무 및 급여를 사원번호 7499의 담당업무 및 급여와 일치하도록 갱신
UPDATE EMP_COPY 
SET sal = (select sal from emp_copy where empno = 7499), job = (select job from emp_copy where empno = 7499)
where empno = 7788

UPDATE emp_copy set (job, sal) = (select job, sal from emp_copy where empno = 7499)
where empno = 7788

--7.사원번호 7369와 업무가 동일한 모든 사원의 부서번호를 7369의 현재 부서번호로 갱신
UPDATE EMP_COPY
SET deptno = (select deptno from emp_copy where empno = 7369)
where job = (select job from emp_copy where empno = 7369)



--8.DEPT 테이블의 구조와 내용을 복사하여 DEPT_COPY란 이름의 테이블을 만드시오.
CREATE TABLE DEPT_COPY
AS
SELECT * FROM DEPT;

SELECT * FROM DEPT_COPY;

--9.DEPT_COPY 테이블에서 부서명이 RESEARCH 인 부서를 제거하시오.
DELETE FROM DEPT_COPY
WHERE DNAME = 'RESEARCH';

--10.DEPT_COPY 테이블에서 부서번호가 10 이거나 40 인 부서를 제거하시오.
DELETE FROM DEPT_COPY
WHERE DEPTNO in (10,40)

--------------------------------------------
--[트랜잭션]
--정의)트랜잭션은 한 단위의 일을 수행하는 일련의 SQL 문
--한꺼번에 실행되야하는 SQL문의 모음이다 
--한꺼번에 실행되야 의미가 있다 

insert into dept_copy values (10, 'RESEARCH', '서울')

select * from dept_copy

--allen의 comm을 scott 주고싶어
--cmd창에서 명령어를 입력할 경우 commit; 을 해주어야 반영됨
--rollback; : 마지막 commit 했던 곳으로 돌아감 
update emp_copy set COMM = 0 WHERE ENAME = 'ALLEN';
update emp_copy set COMM = 300 WHERE ENAME = 'SCOTT';
--오라클 트랜잭션 시작시점
insert, update, delete 실행될 때
--오라클 트랜잭션 종료시점
1.commit; rollback;
2.create, alter, drop : 자동 commit

update emp_copy set COMM = 700 WHERE ENAME = 'SCOTT';
create table emp_copy2 as select * from emp;
select * from emp_copy;
--3.오라클 종료: 자동 rollback;

--정리) 트랜잭션 동안 모든 단계(insert, update, delete)가 방해없이 완료될 수 없다면
--어떤 것도 완료되지 말아야 한다. all or nothing

--개념) ACID : 트랜잭션이 갖춰야 할 특징
--ATOMICITY(원자성) : all or nothing
--CONSISTENCY(일관성)
--ISOLATION(독림성) 
--DURABBILITY(지속성)
---------------------------------------------------------------------------------------------------------
--[제약조건]
--1.not null : 컬럼에 null값을 포함하지 못하도록 지정
--2.nuique : 테이블의 모든 행에 대해 유일한 값을 갖도록 한다. 유일한 값이여야 하나, null값 허용함
--3.primary key : 테이블 각 행을 식별하기 위한 것, null과 중복된 값을 모두 허용하지 않음, 반드시 넣어야한다
--4.foreing key : 참조되는 테이블에 칼럼 값이 항상 존재해야 한다.
--5.check : 저장 가능한 데이터의 값의 범위나 조건을 지정하여 설정한 값만을 허용한다.

create table dept_test(
	deptno number(2) primary key,
	dname varchar2(14) unique,
	loc varchar2(14)
);

select * from dept_test;

insert into dept_test (deptno) values (10);
insert into dept_test (deptno, dname) values (20, '재무팀');
insert into dept_test (deptno, dname) values (30, '인사팀');
insert into dept_test (deptno, dname, loc) values (40, '영업팀', '서울중앙');

create table emp_test(
	empno number(4) primary key,
	ename varchar2(20) not null,
	job varchar2(10) check (job in('분석', '영업', '돈관리')),
	hiredate date not null,
	sal number(7),
	deptno number(2) references dept_test(deptno)
);

insert into emp_test values (1234, '홍길동', '영업', '1999/09/09', 400, 40);
insert into emp_test values (2000, '홍길동2', '돈관리', '1999/09/09', 400, 20);
insert into emp_test values (3000, '홍길동3', '돈관리', '1999/09/09', 400, 50);

select * from emp_test

--제약조건 확인
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_TEST';
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_CONSTRAINT';

create table EMP_CONSTRAINT(
	empno number(4) CONSTRAINT EMP_EMPNO_PK primary key,
	ename varchar2(20) CONSTRAINT EMP_ENAME_NN not null,
	job varchar2(10) CONSTRAINT EMP_JOB_CHK check (job in('분석', '영업', '돈관리')),
	hiredate date CONSTRAINT EMP_HIREDATE_NN not null,
	sal number(7),
	deptno number(2) CONSTRAINT EMP_DEPTNO_FK references dept_test(deptno)
);

--제약조건 변경(추가 & 제거)
CREATE TABLE PRODUCT(
	CODE NUMBER(2),
	NAME VARCHAR2(20),
	PRICE NUMBER
);
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'PRODUCT';

--추가
ALTER TABLE PRODUCT ADD CONSTRAINT PRODUCT_CODE_PK PRIMARY KEY (CODE);

--price가 0 이상인지 체크하는조건 추가
ALTER TABLE PRODUCT ADD CONSTRAINT PRODUCT_PRICE_CHK check (PRICE >= 0);

insert into product values (10, 'A', -1000);

--name에 null값이 올 수 없는 제약조건 추가
ALTER TABLE PRODUCT MODIFY NAME CONSTRAINT PRODUCT_NAME_NN not null;

INSERT INTO PRODUCT VALUES (10, 'A', 1000);
INSERT INTO PRODUCT VALUES (20, 'B', 2000);

SELECT * FROM PRODUCT

--제거
ALTER TABLE PRODUCT DROP CONSTRAINT PRODUCT_CODE_PK;
ALTER TABLE PRODUCT DROP CONSTRAINT PRODUCT_PRICE_CHK;
ALTER TABLE PRODUCT DROP CONSTRAINT PRODUCT_NAME_NN;

--DEPT_TEST
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'DEPT_TEST';
--EMP_TEST
DROP TABLE EMP_TEST;
DROP TABLE DEPT_TEST CASCADE CONSTRAINTS;
DROP TABLE EMP_CONSTRAINT

--제거시 유의사항
create table dept_CONSTRAINT(
	deptno number(2) CONSTRAINT DEPT_DEPTNO_PK primary key,
	dname varchar2(14) CONSTRAINT DEPT_DNAME_UN unique,
	loc varchar2(14)
);

create table EMP_CONSTRAINT(
	empno number(4) CONSTRAINT EMP_EMPNO_PK primary key,
	ename varchar2(20) CONSTRAINT EMP_ENAME_NN not null,
	job varchar2(10) CONSTRAINT EMP_JOB_CHK check (job in('분석', '영업', '돈관리')),
	hiredate date CONSTRAINT EMP_HIREDATE_NN not null,
	sal number(7),
	deptno number(2) CONSTRAINT EMP_DEPTNO_FK references dept_CONSTRAINT(deptno)
);
--references 연결되어있으면 연결을 끊은 후 제거해야한다
ALTER TABLE EMP_CONSTRAINT DROP CONSTRAINT EMP_DEPTNO_FK;
ALTER TABLE DEPT_CONSTRAINT DROP CONSTRAINT DEPT_DEPTNO_PK;

--재추가
ALTER TABLE DEPT_CONSTRAINT ADD CONSTRAINT DEPT_DEPTNO_PK PRIMARY KEY (DEPTNO);

ALTER TABLE EMP_CONSTRAINT ADD CONSTRAINT EMP_DEPTNO_FK
FOREIGN KEY (DEPTNO) REFERENCES DEPT_CONSTRAINT(deptno);

--강제로 지우기
ALTER TABLE DEPT_CONSTRAINT DROP CONSTRAINT DEPT_DEPTNO_PK CASCADE;

select * from emp;

select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP_SAMPLE_CONSTRAINT';

insert into emp (empno, deptno) values (9999, );
delete from emp where empno = 9999

--------------------------------------------------------------------------------------------
--1.EMP 테이블의 구조를 복사하여 EMP_SAMPLE란 이름의 테이블 생성
--  사원 테이블의 사원번호 칼럼에 PRIMARY KEY 제약조건을 지정하되 
--  제약조건 이름을 EMP_SAMPLE_EMPNO_PK 지정
CREATE TABLE EMP_SAMPLE
AS
SELECT * FROM EMP
WHERE 1 = 0;

ALTER TABLE EMP_SAMPLE ADD CONSTRAINT EMP_SAMPLE_EMPNO_PK PRIMARY KEY (EMPNO);

--2.DEPT 테이블의 구조를 복사하여 DEPT_SAMPLE란 이름의 테이블 생성
--  부서 테이블의 부서번호 칼럼에 PRIMARY KEY 제약조건을 지정하되
--  제약조건 이름은 DEPT_SAMPLE_DEPTNO_PK로 지정

CREATE TABLE DEPT_SAMPLE
AS
SELECT * FROM EMP
WHERE 1 = 0;

ALTER TABLE DEPT_SAMPLE ADD CONSTRAINT DEPT_SAMPLE_DEPTNO_PK PRIMARY KEY (DEPTNO);

--3.EMP_SAMPLE 테이블의 부서번호 칼럼에 존재하지 않는 부서에 사원이 배정되지 않도록 지정  => fk 만들기
ALTER TABLE EMP_SAMPLE ADD CONSTRAINT DEPT_SAMPLE_DEPTNO_FK FOREIGN KEY(DEPTNO) references DEPT_SAMPLE (DEPTNO);

--4.EMP_SAMPLE 테이블의 커미션 칼럼에 0보다 큰 값만을 입력할 수 있도록 조건을 지정
ALTER TABLE EMP_SAMPLE ADD CONSTRAINT DEPT_SAMPLE_DEPTNO_CHK CHECK (COMM>0);

-----------------------------------------------------------------------------------------
--[뷰]
0.권한 부여 받기
-관리자 계정으로 접속
-grant create view to scott;

1.생성
CREATE VIEW V_EMP as
select empno, ename, job, mgr, hiredate from emp
where hiredate between '81/01/01' and '81/12/31';

select * from v_emp
--1981년도에 입사한 사원(0000), 1981년도 입사가 아닌 사원(1111)
insert into v_emp values (0000, '임미영', '강사', 7092, '81/01/01');
insert into v_emp values (1111, '홍길동', '강사', 7092, '80/01/01'); -- 고용일 조건에 안맞지만 들어가짐

--뷰가 없으면 만들고 있으면 교체해라
CREATE OR REPLACE VIEW V_EMP as
select empno, ename, job, mgr, hiredate from emp
where hiredate between '81/01/01' and '81/12/31'
WITH CHECK OPTION;

insert into v_emp values (3333, '흥부', '타강사', 7091, '82/11/11'); --WITH CHECK OPTION -> 고용일 조건에 맞지 않아서 들어가지 않음
insert into v_emp values (5555, '타미', '타사', 7091, '81/01/02');

--VUEW는 제약조건까지 복사된다
insert into v_emp values (5555, '타미', '타사', 7091, '81/01/02');

--READ ONLY
CREATE OR REPLACE VIEW V_EMP as
select empno, ename, job, mgr, hiredate from emp
where hiredate between '81/01/01' and '81/12/31'
WITH READ ONLY;

insert into v_emp values (6665, '타미', '타사', 7091, '81/01/02');

UPDATE v_emp SET LOC = '대한민국'
WHERE DEPTNO = 20 

DELETE FROM EMP
WEHRE ename is null

select * from emp

ALTER TABLE PRODUCT MODIFY NAME CONSTRAINT PRODUCT_NAME_NN not null;
ALTER TABLE EMP MODIFY ENAME CONSTRAINT NN_EMP not null;

select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMP';

--VIEW 만들때 주의사항 - not null 제약조건 걸린 컬럼 필수로 select에 포함 (read only는 상관 없음, insert 해야할때 not null이면 안되는거임)
CREATE OR REPLACE VIEW V_EMP as
select empno, ename, job, mgr, hiredate from emp
where hiredate between '81/01/01' and '81/12/31'
WITH CHECK OPTION;


insert into v_emp values (7777, '강사', 7091, '81/01/02'); -- select에 ename 뻇을때 예시 ) 입력값이 null이 되면서 실행 안됨

--VIEW 만들때 주의사항2 : 그룹함수(ex_sum) 사용시 컬럼명 별칭 사용 필수, 그룹함수(ex_sum, distinct)가 들어간 view는 insert, update,delete 안됨
CREATE TABLE EMP2 (
        DNO NUMBER(2),
		SALARY NUMBER(7,2)
); 

INSERT INTO EMP2 VALUES (10, 1000); 	
INSERT INTO EMP2 VALUES (30, 2000);
INSERT INTO EMP2 VALUES (10, 5000);
--함수를 쓰면 반드시 별칭을 줘야한다
CREATE OR REPLACE VIEW V_EMP2 as
select dno, sum(salary) as salary from emp2
group by dno 
having sum(salary) > 5000
WITH CHECK OPTION;

--disdinct 별첨 안해도 되지만 수정 안됨 (read only)
CREATE OR REPLACE VIEW V_EMP2 as
select distinct dno from emp2
WITH CHECK OPTION;

DROP VIEW V_EMP2;

----------------------------------------------------------------------------------------------------
--1. emp 테이블의 20번 부서에 소속된 사원의 사원번호와 이름과 부서번호를 출력하는 
--   SELECT 문을 하나의 뷰로 정의
create view V_EMP3 as
select empno, ename, deptno from emp
where deptno = 20
WITH CHECK OPTION;

INSERT INTO V_EMP3 VALUES (3022, '에펠탑', 10) -- 조건문에 부합하지 않으면 수정 불가

--2.이미 생성된 뷰에 대해서 급여 역시 출력할 수 있도록 수정
create or replace view V_EMP3 as
select empno, ename, deptno, sal from emp
where deptno = 20
WITH CHECK OPTION;

--3.생성된 뷰를 제거하시오.
DROP VIEW V_EMP3

------------------------------------------------------------------------------------------------------
--[시퀀스]
1.테이블 내의 유일한 숫자를 자동으로 생성
주로 기본키가 유일한 값을 갖도록 사용자가 직접 값을 생성해내는 부담감을 줄일 수 있다.

2.시퀀스 만들기
create sequence seq_toyid;

select * from toys;

3.다음 시퀀스 값
select seq_toyid.nextval from dual;

insert into toys values (seq_toyid.nextval, '뱅뱅뱅')
insert into toys values (seq_toyid.nextval, '라디오')
select * from toys

drop sequence seq_toyid;

create sequence seq_toyid;

select seq_toyid.nextval from dual;

4.현재 시퀀스 값
--select seq_toyid.currval from dual; --세션때문에 sql comment에서만 가능 (검은창)

--[인데스]
1.탐색 속도를 높이기 위해 사용
2.탐색키가 꼭 유일키 또는 후보키일 필요는 없다.

3.인덱스 생성
create index ename_idx on emp (ename);

4.인덱스 생성 확인
select INDEX_NAME, TABLE_NAME, COLUMN_NAME
from USER_IND_COLUMNS
where TABLE_NAME in ('EMP');

5.인덱스 선정 지침
1)기본키 (자동으로 만들어줌)
2)외래키 후보 
3)자주 갱신되는 컬럼은 인덱스로 정의하지 않는 것이 좋다. 
4)후보키 후보
5)자주 갱신되는 테이블 인덱스로 정의하지 않는 것이 좋다.

6.검색속도 높이려면
distinct 사용 최소화
group by, having 사용 최소화 

7.인덱스 삭제 
drop index ename_idx;

--------------------------------------------------------------------------------------------
--quiz
--0.emp의 구조만 가져와 emp01 테이블을 생성
create table emp01
as
select *
from emp
where 0 = 1;

--1.사원 테이블의 사원번호가 자동으로 생성되도록 시퀀스 생성
create sequence seq_empno

select seq_empno.nextval from dual;

--2.사원번호를 시퀀스로부터 발급
insert into emp01 values (seq_empno.nextval, '홍길동', '영업', 1423, '1999/09/09', 400, 40, 10);
select *from emp01;
select TABLE_NAME, CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'emp01';

--3.EMP01 테이블의 이름 칼럼을 인덱스로 설정하되 인덱스 이름을 IDX_EMP01_ENAME으로 지정
create index IDX_EMP01_ENAME on EMP01 (ename);

select INDEX_NAME, TABLE_NAME, COLUMN_NAME
from USER_IND_COLUMNS
where TABLE_NAME in ('EMP');

drop index IDX_EMP01_ENAME;

--[권한]
1.새 사용자 추가 - 관리자 계정으로 접속
2.시스템 권한을 받아야 접근 가능 : create SESSION, CREATE TABLE, CREATE SEQUENCE, CREATE VIEW;
GRANT CREATE TABLE, CREATE SEQUENCE, CREATE VIEW to young;
--시스템 권한은 관리자가 주고 테이블 접근 권한은 만든사람이 줄 수 있다 
3.객체 권한 : insert, update, delete, select, alter...

--[요구사항] 
-young 계정을 만들어 주세요
-young 계정에게 접속 권한을 주세요.
-scott 계정의 emp 테이블의 모든 권한을 young에게 주세요.
-scott 계정의 emp 테이블의 선택 권한을 사용자 모두에게 주세요.

4.권한 취소
REVOKE select ON EMP FROM young;

--[role]
1.create role manager;
2.grant create session, create table to manager;
3.grant manager to young;

--[동의어: SYNONYM]
grant create synonym to young;

create synonym emp for scott.emp;
---------------------------------------------------------------
1.sbs 라는 사용자 생성(암호는 pass)
2.기본적인 권한 부여를 하지 않으면 데이터베이스에 로그인이 불가능하므로
  connection, resource 권한을 sbs 사용자에게 부여


drop table book;

create table book(
	no number primary key,
	name varchar2(30),
	author varchar2(30),
	publisher varchar2(30)
)
