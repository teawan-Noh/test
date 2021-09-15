package jdbc.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Customer;

public class SelectAll {

	private static final String CUSTOMER_SELECT_ALL_SQL = 
			"select * from customer";

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		List<Customer> customerList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password); //연결
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(CUSTOMER_SELECT_ALL_SQL); //sql문 준비
			//select일 경우 사용
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setSeq(resultSet.getInt("seq"));
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setPassword(resultSet.getString("password"));
				customer.setAddress(resultSet.getString("address"));
				customer.setPhone(resultSet.getString("phone"));
				
				customerList.add(customer);
			}
			
			resultSet.close();
			pStatement.close();
			connection.close();
			//test code
			for (Customer customer : customerList) {
				System.out.println(customer.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
