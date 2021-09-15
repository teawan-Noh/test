package jdbc.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
			pStatement.setString(1, "¸»¸®ºÎ");
			pStatement.setInt(2, 5500);
			pStatement.setInt(3, 5757);
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
		// TODO Auto-generated method stub
		return null;
	}


}
