package dao;

public class Sql {

	//emp 테이블
	public static final String EMP_INSERT_SQL 
		= "insert into emp values (seq_empno.nextval, ?, ?, sysdate, ?, ?)";
	
	public static final String EMP_SELECT_BY_HIREDATE_SQL 
		= "select * from emp where hiredate between TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD')+0.99999 order by empno desc";
	
	//dept 테이블
	public static final String DEPT_SELECT_ALL_SQL 
		= "select * from dept order by dname";
}
