package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Emp;


public class EmpDaoImpl implements EmpDao {
	
	@Override
	public void insert(Emp emp) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		System.out.println("2" + emp.toString());
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.EMP_INSERT_SQL);
			
			pStatement.setString(1, emp.getEname());
			pStatement.setString(2, emp.getJob());
			pStatement.setInt(3, emp.getMgr());
			pStatement.setString(4, emp.getHiredate());
			pStatement.setInt(5, emp.getSal());
			pStatement.setInt(6, emp.getComm());
			pStatement.setInt(7, emp.getDeptno());
			
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
			
			pStatement.setString(1, emp.getEname());
			pStatement.setString(2, emp.getJob());
			pStatement.setInt(3, emp.getMgr());
			pStatement.setString(4, emp.getHiredate());
			pStatement.setInt(5, emp.getSal());
			pStatement.setInt(6, emp.getComm());
			pStatement.setInt(7, emp.getDeptno());
			pStatement.setInt(8, emp.getEmpno());
			
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
}
