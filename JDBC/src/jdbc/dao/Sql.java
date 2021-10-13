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
	
	public static final String DEPT_UPDATE_BY_DEPTNO_10_SQL = 
			"update emp set sal = ? where deptno = ?";
	//emp 테이블
	public static final String EMP_INSERT_SQL = 
			"insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?, ?, ?, ? ,? ,? ,? ,?)";
	
	public static final String EMP_SELECT_ALL_SQL = 
			"select * from emp";
	
	public static final String EMP_DELETE_SQL = 
			"delete from emp where empno = ?";
	
	public static final String EMP_UPDATE_SQL = 
			"update emp set ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ? ,comm = ?, deptno = ? WHERE empno = ?";
	
	public static final String EMP_SELECT_BY_EMPNO_SQL = 
			"select * from emp where empno = ?";
	
	public static final String EMP_UPDATE_BY_DEPTNO_10_SQL = 
			"update emp set sal = ? where deptno = 10";

	public static final String EMP_UPDATE_BY_DEPTNO_20_SQL = 
		"update emp set sal = ? where deptno = 20";
	
	
	//Customer 테이블
	public static final String CUSTOMER_INSERT_SQL = 
			"insert into customer (seq, name, id, password, address, phone) values (seq_seq.nextval,  ?, ?, ? ,? ,? )";
	
	public static final String CUSTOMER_SELECT_ALL_SQL = 
			"select * from customer";
	
	public static final String CUSTOMER_DELETE_SQL = 
			"delete from customer where seq = ?";
	
	public static final String CUSTOMER_UPDATE_SQL = 
			"update customer set id = ?, name = ? WHERE seq = ?";
	
	public static final String CUSTOMER_SELECT_BY_SEQ_SQL = 
			"select * from customer where seq = ?";
	
	
}
