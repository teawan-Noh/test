package jdbc.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

	
	private static final String CUSTOMER_UPDATE_SQL = 
			"update customer set name = ? where seq = ?";

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
			
			pStatement = connection.prepareStatement(CUSTOMER_UPDATE_SQL); //sql�� �غ�
			
			pStatement.setString(1, "������"); // ?�� ����  
			pStatement.setInt(2, 1); // ?�� ����  
			//insert, delete, update�� ���
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
