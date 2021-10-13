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
//		//insert
//		emp.setEmpno(1010);
//		emp.setEname("고양이");
//		emp.setJob("집사");
//		emp.setMgr(7788);
//		emp.setHiredate("21/09/15");
//		emp.setSal(1000);
//		emp.setComm(100);
//		emp.setDeptno(50);
//		
//		empDao.insert(emp);
//		
////		selectAll
//		List<Emp> empList = new ArrayList<>();
//		
//		empList = empDao.selectAll();
//		
//		for (Emp emp1 : empList) {
//			System.out.println(emp1);
//		}
//		
//		System.out.println("===========insert 종료=================");
//		System.out.println("");
//		
//		emp = empDao.selectByEmpno(1010);
//		System.out.println(emp.toString());
//		
//		System.out.println("===========selectByEmpno 종료=================");
//		System.out.println("");
//		
//		//update
//		empDao.update(emp);
////		selectAll
//		empList = empDao.selectAll();
//		
//		emp = empDao.selectByEmpno(1010);
//		System.out.println(emp.toString());
//		
//		System.out.println("============update 종료================");
//		System.out.println("");
//		
//		//delete
//		empDao.delete(1010);
//		
//		emp = empDao.selectByEmpno(1010);
//		System.out.println(emp.toString());
//		
//		System.out.println("============delete 종료================");
//		System.out.println("");
		
		
	}

}
