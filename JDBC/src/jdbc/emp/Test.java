package jdbc.emp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Emp;
import jdbc.dao.JDBCUtil;

public class Test {

	public static void main(String[] args) {
		EmpDao empDao = new EmpDaoImpl();
		Emp emp = new Emp();
		//insert
//		
//		emp.setEmpno(5758);
//		emp.setEname("°­¾ÆÁö");
//		emp.setJob("Æê2");
//		emp.setMgr(7788);
//		emp.setHiredate("21/09/15");
//		emp.setSal(1000);
//		emp.setComm(100);
//		emp.setDeptno(50);
//		
//		empDao.insert(emp);
		
		//selectAll
//		List<Emp> empList = new ArrayList<>();
//		
//		empList = empDao.selectAll();
//		
//		for (Emp emp : empList) {
//			System.out.println(emp);
//		}
		
		//delete
//		empDao.delete(50);
		
		//update
		empDao.update(emp);
	}

}
