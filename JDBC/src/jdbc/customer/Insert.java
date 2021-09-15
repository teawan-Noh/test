package jdbc.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {

	private static final String CUSTOMER_INSERT_SQL = 
			"insert into customer (seq , id, name, password, address, phone) values (seq_seq.nextval, ?, ?, ?, ?, ?)";

	public static void main(String[] args) {
//		�Է¹����� (�Է� �޾Ҵٰ� ����)
		String id = "����";
		String name = "ȫ�浿2";
		String password = "1234";
		String address = "��⵵ �Ⱦ�";
		String phone = "010-1234-5385";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password2 = "tiger";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password2); //����
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(CUSTOMER_INSERT_SQL); //sql�� �غ�
			
			pStatement.setString(1, id); // ?�� ���� 
			pStatement.setString(2, name); // ?�� ���� 
			pStatement.setString(3, password);
			pStatement.setString(4, address); // ?�� ���� 
			pStatement.setString(5, phone); // ?�� ���� 
			
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
