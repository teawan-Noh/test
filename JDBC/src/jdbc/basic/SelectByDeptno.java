package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Dept;

public class SelectByDeptno {
	private static final String DEPT_SELECT_BY_DEPTNO_SQL = 
			"select deptno, dname, loc from dept where deptno = ?";

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password); //연결
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(DEPT_SELECT_BY_DEPTNO_SQL); //sql문 준비
			//select일 경우 사용
			pStatement.setInt(1, 99);
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				Dept dept = new Dept();
				dept.setDeptno(resultSet.getInt("deptno"));
				dept.setDname(resultSet.getString("dname"));
				dept.setLoc(resultSet.getString("loc"));
				
				//test code
				System.out.println(dept.toString());
			}
				
			resultSet.close();
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
