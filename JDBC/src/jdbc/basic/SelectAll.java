package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Dept;

public class SelectAll {
	private static final String DEPT_SELECT_ALL_SQL = 
			"select deptno, dname, loc from dept";

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		List<Dept> deptList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password); //연결
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(DEPT_SELECT_ALL_SQL); //sql문 준비
			//select일 경우 사용
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
//				System.out.print(resultSet.getInt("deptno") + ", ");
//				System.out.print(resultSet.getString("dname") +", ");
//				System.out.println(resultSet.getString("loc"));
				Dept dept = new Dept();
				dept.setDeptno(resultSet.getInt("deptno"));
				dept.setDname(resultSet.getString("dname"));
				dept.setLoc(resultSet.getString("loc"));
				
				deptList.add(dept);
			}
			
			resultSet.close();
			pStatement.close();
			connection.close();
			//test code
			for (Dept dept : deptList) {
				System.out.println(dept.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
