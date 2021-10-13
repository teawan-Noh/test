package jdbc.emp;

import jdbc.basic.model.Emp;

public class SQLExceptionTest {

	public static void main(String[] args) {
	
		EmpDao empDao = new EmpDaoImpl();
		
		//실행속도 측정
		
		long st = System.currentTimeMillis();
		Emp emp = new Emp();
//		insert
		emp.setEmpno(1010);
		emp.setEname("고양이");
		emp.setJob("집사");
		emp.setMgr(7788);
		emp.setHiredate("21/09/15");
		emp.setSal(1000);
		emp.setComm(100);
		emp.setDeptno(50);
		
		empDao.insert(emp);
		
		long et = System.currentTimeMillis();
		
		System.out.println((et - st) + "ms");
		
		long st2 = System.currentTimeMillis();
		empDao.transaction(20, 3);
		long et2 = System.currentTimeMillis();
				
		System.out.println((et - st) + "ms");

	}

}
