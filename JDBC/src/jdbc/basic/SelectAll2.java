package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Dept;
import jdbc.basic.model.Emp;

public class SelectAll2 {
	private static final String EMP_SELECT_ALL_SQL = 
			"select * from emp";

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		List<Emp> empList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password); //연결
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(EMP_SELECT_ALL_SQL); //sql문 준비
			//select일 경우 사용
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Emp emp = new Emp();
				emp.setEmpno(resultSet.getInt("empno"));
				emp.setEname(resultSet.getString("ename"));
				emp.setJob(resultSet.getString("job"));
				emp.setMgr(resultSet.getInt("mgr"));
				emp.setHiredate(resultSet.getString("hiredate"));
				emp.setSal(resultSet.getInt("sal"));
				emp.setComm(resultSet.getInt("comm"));
				emp.setDeptno(resultSet.getInt("deptno"));
				
				empList.add(emp);
			}
			
			
			
			resultSet.close();
			pStatement.close();
			connection.close();
			//test code
			for (Emp emp : empList) {
				System.out.println(emp.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
