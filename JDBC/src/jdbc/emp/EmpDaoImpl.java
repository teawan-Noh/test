package jdbc.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Emp;
import jdbc.dao.JDBCUtil;
import jdbc.dao.Sql;

public class EmpDaoImpl implements EmpDao {
	
	

	@Override
	public void insert(Emp emp) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.EMP_INSERT_SQL);
			
			pStatement.setInt(1, emp.getEmpno());
			pStatement.setString(2, emp.getEname());
			pStatement.setString(3, emp.getJob());
			pStatement.setInt(4, emp.getMgr());
			pStatement.setString(5, emp.getHiredate());
			pStatement.setInt(6, emp.getSal());
			pStatement.setInt(7, emp.getComm());
			pStatement.setInt(8, emp.getDeptno());
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public void update(Emp emp) {
			
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.EMP_UPDATE_SQL);
			
			pStatement.setString(1, "노태완");
			pStatement.setString(2, "개발자");
			pStatement.setInt(3, 1111);
			pStatement.setString(4, "21-09-15");
			pStatement.setInt(5, 5000);
			pStatement.setInt(6, 500);
			pStatement.setInt(7, 10);
			pStatement.setInt(8, 1010);
			
			pStatement.executeUpdate();
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int empno) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.EMP_DELETE_SQL);
			
			pStatement.setInt(1, empno);
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public List<Emp> selectAll() {
		
		List<Emp> empList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.EMP_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Emp emp = new Emp();
				emp.setEmpno(resultSet.getInt("empno"));
				emp.setEname(resultSet.getString("ename"));
				emp.setJob(resultSet.getString("job"));
				emp.setMgr(resultSet.getInt("mgr"));
				emp.setHiredate(resultSet.getString("hiredate"));
				emp.setSal(resultSet.getInt("sal"));
				emp.setComm(resultSet.getInt("comm"));
				emp.setDeptno(resultSet.getInt("deptno"));
				
				empList.add(emp);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return empList;
	}

	@Override
	public Emp selectByEmpno(int empno) {
		Emp emp = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.EMP_SELECT_BY_EMPNO_SQL);
			
			pStatement.setInt(1, empno);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				emp = new Emp();
				emp.setEmpno(resultSet.getInt("empno"));
				emp.setEname(resultSet.getString("ename"));
				emp.setJob(resultSet.getString("job"));
				emp.setMgr(resultSet.getInt("mgr"));
				emp.setHiredate(resultSet.getString("hiredate"));
				emp.setSal(resultSet.getInt("sal"));
				emp.setComm(resultSet.getInt("comm"));
				emp.setDeptno(resultSet.getInt("deptno"));
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return emp;
	}

	@Override
	public void transaction(int sal01, int sal02) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		
		try {
			connection = JDBCUtil.getConnection();
			connection.setAutoCommit(false);
			pStatement = connection.prepareStatement(Sql.EMP_UPDATE_BY_DEPTNO_10_SQL); //sql문 준비
			//select일 경우 사용
			pStatement.setInt(1, sal01);
			pStatement.executeUpdate();
			
			pStatement = connection.prepareStatement(Sql.EMP_UPDATE_BY_DEPTNO_20_SQL); //sql문 준비
			//select일 경우 사용
			pStatement.setInt(1, sal02);
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
