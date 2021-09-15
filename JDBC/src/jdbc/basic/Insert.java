package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {
	private static final String DEPT_INSERT_SQL = 
			"insert into dept (deptno, dname, loc) values (?, ?, ?)";

	public static void main(String[] args) {
		//�Է¹����� (�Է� �޾Ҵٰ� ����)
//		int deptno = 60;
//		String dname = "������";
//		String loc = "����";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�μ���ȣ�� �Է��ϼ���");
		int deptno = Integer.parseInt(sc.nextLine());
		System.out.println("�μ����� �Է��ϼ���");
		String dname = sc.nextLine();
		System.out.println("�μ��������� �Է��ϼ���");
		String loc = sc.nextLine();
		
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
			
			pStatement = connection.prepareStatement(DEPT_INSERT_SQL); //sql�� �غ�
			
			pStatement.setInt(1, deptno); // ?�� ����  //60
			pStatement.setString(2, dname); // ?�� ���� // ������
			pStatement.setString(3, loc); // ?�� ���� // ����
			//insert, delete, update�� ���
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
