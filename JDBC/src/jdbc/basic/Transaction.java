package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Dept;
import jdbc.basic.model.Emp;

public class Transaction {
	private static final String EMP_UPDATE_BY_DEPTNO_10_SQL = 
		"update emp set sal = ? where deptno = 10";

	public static final String EMP_UPDATE_BY_DEPTNO_20_SQL = 
		"update emp set sal = ? where deptno = 20";
	
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password); //연결
			
			connection.setAutoCommit(false);
			
			pStatement = connection.prepareStatement(EMP_UPDATE_BY_DEPTNO_10_SQL); //sql문 준비
			//select일 경우 사용
			pStatement.setInt(1, 100);
			pStatement.executeUpdate();
			
			pStatement = connection.prepareStatement(EMP_UPDATE_BY_DEPTNO_20_SQL); //sql문 준비
			//select일 경우 사용
			pStatement.setInt(1, 200);
			pStatement.executeUpdate();
			
			connection.commit();
			System.out.println("commit 되었습니다");
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
				System.out.println("rollback 되었습니다");
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		

	}

}
