package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
	
	private static final String DEPT_UPDATE_SQL = 
			"update dept set dname = ?, loc = ? WHERE deptno = ?";

	public static void main(String[] args) {
		//�Է¹����� (�Է� �޾Ҵٰ� ����)
//		int deptno = 60;
//		String dname = "������";
//		String loc = "����";
		
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
			
			pStatement = connection.prepareStatement(DEPT_UPDATE_SQL); //sql�� �غ�
			
			pStatement.setString(1, "�ֽĿ���"); // ?�� ����  
			pStatement.setString(2, "�λ�"); // ?�� ���� 
			pStatement.setInt(3, 70); // ?�� ���� 
			//insert, delete, update�� ���
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
