package jdbc.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {

	private static final String CUSTOMER_INSERT_SQL = 
			"insert into customer (seq , id, name, password, address, phone) values (seq_seq.nextval, ?, ?, ?, ?, ?)";

	public static void main(String[] args) {
//		입력받은값 (입력 받았다고 가정)
		String id = "스마";
		String name = "홍길동2";
		String password = "1234";
		String address = "경기도 안양";
		String phone = "010-1234-5385";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password2 = "tiger";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password2); //연결
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(CUSTOMER_INSERT_SQL); //sql문 준비
			
			pStatement.setString(1, id); // ?값 셋팅 
			pStatement.setString(2, name); // ?값 셋팅 
			pStatement.setString(3, password);
			pStatement.setString(4, address); // ?값 셋팅 
			pStatement.setString(5, phone); // ?값 셋팅 
			
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
