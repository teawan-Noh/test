package jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.basic.model.Dept;

public class Test {

	public static void main(String[] args) throws SQLException {

		DeptDao deptDao = new DeptDaoImpl();
		Dept dept = new Dept();
		//insert
//		
//		dept.setDeptno(90);
//		dept.setDname("펀드투자");
//		dept.setLoc("인천");
		
//		deptDao.insert(dept);
		
		//selectAll
//		List<Dept> deptList = deptDao.selectAll();
//		
//		for (Dept dept2 : deptList) {
//			System.out.println(dept2);
//		}
//		deptDao.update(dept);
		
		//delete
//		deptDao.delete(60);
		
		//selectByDeptno
		dept = deptDao.selectByDeptno(10);
		
		dept.toString();
		
	}

}
