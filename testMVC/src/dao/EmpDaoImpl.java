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
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.EMP_INSERT_SQL);
			
			pStatement.setString(1, emp.getEname());
			pStatement.setString(2, emp.getJob());
			pStatement.setInt(3, emp.getSal());
			pStatement.setInt(4, emp.getDeptno());
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
	}

	@Override
	public List<Emp> selectByHiredate(String startDate, String endDate) {
		
		List<Emp> empList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.EMP_SELECT_BY_HIREDATE_SQL);
			
			pStatement.setString(1, startDate);
			pStatement.setString(2, endDate);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Emp emp = new Emp();
				emp.setEmpno(resultSet.getInt("empno"));
				emp.setEname(resultSet.getString("ename"));
				emp.setJob(resultSet.getString("job"));
				emp.setHiredate(resultSet.getString("hiredate"));
				emp.setSal(resultSet.getInt("sal"));
				emp.setDeptno(resultSet.getInt("deptno"));
				
				empList.add(emp);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return empList;
	}

}
