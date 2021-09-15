package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
	private static final String DEPT_INSERT_SQL = 
			"insert into dept (deptno, dname, loc) values (?, ?, ?)";

	public static void main(String[] args) {
		//입력받은값 (입력 받았다고 가정)
//		int deptno = 60;
//		String dname = "영업팀";
//		String loc = "진주";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("부서번호를 입력하세요");
		int deptno = Integer.parseInt(sc.nextLine());
		System.out.println("부서명을 입력하세요");
		String dname = sc.nextLine();
		System.out.println("부서지역명을 입력하세요");
		String loc = sc.nextLine();
		
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
			
			pStatement = connection.prepareStatement(DEPT_INSERT_SQL); //sql문 준비
			
			pStatement.setInt(1, deptno); // ?값 셋팅  //60
			pStatement.setString(2, dname); // ?값 셋팅 // 영업팀
			pStatement.setString(3, loc); // ?값 셋팅 // 진주
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
