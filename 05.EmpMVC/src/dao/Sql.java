package dao;

public class Sql {

	//emp 테이블
	public static final String EMP_INSERT_SQL = 
			"insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (seqEmp.nextval, ?, ?, ? ,? ,? ,? ,?)";
	
	public static final String EMP_SELECT_ALL_SQL = 
			"select * from emp";
	
	public static final String EMP_DELETE_SQL = 
			"delete from emp where empno = ?";
	
	public static final String EMP_UPDATE_SQL = 
			"update emp set ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ? ,comm = ?, deptno = ? WHERE empno = ?";
	
	public static final String EMP_SELECT_BY_EMPNO_SQL = 
			"select * from emp where empno = ?";
	//dept 테이블
	public static final String DEPT_SELECT_ALL_SQL = 
			"select * from dept";
}
