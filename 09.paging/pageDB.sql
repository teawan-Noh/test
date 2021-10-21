--메모테이블의 모든 줄수
select * from memo;

--메모 테이블의 모든 줄수 
select count(*) as cnt from memo;

--요청페이지에 해당되는 데이터
select memoid, name, age
from (select rownum as rn, memos.* from (SELECT * from memo order by memoid desc) memos)
where rn between ? and ?