package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Dept;
import jdbc.basic.model.Emp;

public class SelectByLoc {
	private static final String EMP_SELECT_BY_LOC_SQL = 
		"select deptno, dname, loc from dept where loc = ?";

	public static void main(String[] args) {
		
//		System.out.println("지역을 입력하세요");
//		int loc = sc.nextLine();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		List<Dept> deptList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password); //연결
			
			System.out.println(connection);
			
			pStatement = connection.prepareStatement(EMP_SELECT_BY_LOC_SQL); //sql문 준비
			//select일 경우 사용
			pStatement.setString(1, "서울");
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Dept dept = new Dept();
				dept.setDeptno(resultSet.getInt("deptno"));
				dept.setDname(resultSet.getString("dname"));
				dept.setLoc(resultSet.getString("loc"));
				
				deptList.add(dept);
			}
			
			resultSet.close();
			pStatement.close();
			connection.close();
			//test code
			for (Dept dept : deptList) {
				System.out.println(dept.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
