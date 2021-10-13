package dao;

import java.sql.SQLException;
import java.util.List;

import model.Emp;

public class Test {

	public static void main(String[] args) throws SQLException {
		EmpDao dao = new EmpDaoImpl();
		
		//insert test
//		Emp emp = new Emp("가제트", "개발", 3000, 10);
//		
//		dao.insert(emp);
		
		//select test
		List<Emp> emplist = dao.selectByHiredate("2021-10-06", "2021-10-06");
		
		for (Emp emp2 : emplist) {
			System.out.println(emp2.getEmpno()+", "+ emp2.getEname());
		}
		
	}

}
