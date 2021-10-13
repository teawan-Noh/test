package dao;

import java.sql.SQLException;
import java.util.List;

import model.Emp;



public class Test {

	public static void main(String[] args) throws SQLException {
		EmpDao dao = new EmpDaoImpl();
		
//		void insert(Emp emp);
//		Emp emp = new Emp("가제트", "만능팔", 3000, "1111-11-11", 500, 500, 20);
//		
//		dao.insert(emp);
		
//		void update(Emp emp);
		Emp emp2 = new Emp(1024,"가제트","만팔", 3000, "1111-10-11", 5000, 500, 20);
		dao.update(emp2);
//		void delete(int empno);
//
//		List<Emp> selectAll();
//		Emp selectByEmpno(int empno);
		
	}

}
