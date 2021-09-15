package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert2 {
	private static final String EMP_INSERT_SQL = 
			"insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) values (?, ?, ?, ?, ?, ?, ?, ?)";

	public static void main(String[] args) {
//		입력받은값 (입력 받았다고 가정)
		int empno = 8889;
		String ename = "스마";
		String job = "개발";
		int mgr = 1234;
		String hiredate = "81/01/01";
		int sal = 500;
		int comm = 500;
		int deptno = 10;
		
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
			
			pStatement = connection.prepareStatement(EMP_INSERT_SQL); //sql문 준비
			
			pStatement.setInt(1, empno); // ?값 셋팅  
			pStatement.setString(2, ename); // ?값 셋팅 
			pStatement.setString(3, job); // ?값 셋팅 
			pStatement.setInt(4, mgr);
			pStatement.setString(5, hiredate); // ?값 셋팅 
			pStatement.setInt(6, sal);
			pStatement.setInt(7, comm);
			pStatement.setInt(8, deptno);
			
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
