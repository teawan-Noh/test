package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete {
	
	private static final String DEPT_DELETE_SQL = 
			"delete from dept where deptno = ?";

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password); //����
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(DEPT_DELETE_SQL); //sql�� �غ�
			
			pStatement.setInt(1, 80); // ?�� ����  
			//insert, delete, update�� ���
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
