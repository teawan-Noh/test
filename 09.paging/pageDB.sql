--�޸����̺��� ��� �ټ�
select * from memo;

--�޸� ���̺��� ��� �ټ� 
select count(*) as cnt from memo;

--��û�������� �ش�Ǵ� ������
select memoid, name, age
from (select rownum as rn, memos.* from (SELECT * from memo order by memoid desc) memos)
where rn between ? and ?