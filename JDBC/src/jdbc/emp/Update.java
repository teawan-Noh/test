package jdbc.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

	private static final String EMP_UPDATE_SQL =
			"update emp set ename = ?, sal = ? WHERE ename = ?";

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
			pStatement = connection.prepareStatement(EMP_UPDATE_SQL);
			
			pStatement.setString(1, "말리부");
			pStatement.setInt(2, 5500);
			pStatement.setString(3, "스마");
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
