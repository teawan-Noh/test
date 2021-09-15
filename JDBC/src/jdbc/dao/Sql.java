package jdbc.dao;

public class Sql {

	//Dept 테이블
	public static final String DEPT_INSERT_SQL = 
			"insert into dept (deptno, dname, loc) values (?, ?, ?)";
	
	public static final String DEPT_SELECT_ALL_SQL = 
			"select deptno, dname, loc from dept";
	
	public static final String DEPT_DELETE_SQL = 
			"delete from dept where deptno = ?";
	
	public static final String DEPT_SELECT_BY_DEPTNO_SQL = 
			"select deptno, dname, loc from dept where deptno = ?";
	
	public static final String DEPT_UPDATE_SQL = 
			"update dept set dname = ?, loc = ? WHERE deptno = ?";
	
	//emp 테이블
	public static final String EMP_INSERT_SQL = 
			"insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?, ?, ?, ? ,? ,? ,? ,?)";
	
	public static final String EMP_SELECT_ALL_SQL = 
			"select * from emp";
	
	public static final String EMP_DELETE_SQL = 
			"delete from emp where deptno = ?";
	
	public static final String EMP_UPDATE_SQL = 
			"update emp set ename = ?, sal = ? WHERE empno = ?";
	
	public static final String EMP_SELECT_BY_DEPTNO_SQL = 
			"select * from emp where deptno = ?";
	//Customer 테이블
	
}
