package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
	
	private static final String DEPT_UPDATE_SQL = 
			"update dept set dname = ?, loc = ? WHERE deptno = ?";

	public static void main(String[] args) {
		//입력받은값 (입력 받았다고 가정)
//		int deptno = 60;
//		String dname = "영업팀";
//		String loc = "진주";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password); //연결
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(DEPT_UPDATE_SQL); //sql문 준비
			
			pStatement.setString(1, "주식영업"); // ?값 셋팅  
			pStatement.setString(2, "부산"); // ?값 셋팅 
			pStatement.setInt(3, 70); // ?값 셋팅 
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
