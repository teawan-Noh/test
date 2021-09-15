package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Dept;

public class DeptDaoImpl implements DeptDao {

	@Override
	public void insert(Dept dept) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DEPT_INSERT_SQL);
			
			pStatement.setInt(1, dept.getDeptno()); // ?값 셋팅  
			pStatement.setString(2, dept.getDname()); // ?값 셋팅 
			pStatement.setString(3, dept.getLoc()); // ?값 셋팅 
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
	}

	@Override
	public void update(Dept dept) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DEPT_UPDATE_SQL);
			
			pStatement.setString(1, dept.getDname()); // ?값 셋팅 
			pStatement.setString(2, dept.getLoc()); // ?값 셋팅 
			pStatement.setInt(3, dept.getDeptno()); // ?값 셋팅  
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public void delete(int deptno) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DEPT_DELETE_SQL);
			
			pStatement.setInt(1, deptno);
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}

	}

	@Override
	public List<Dept> selectAll() {

		List<Dept> deptList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DEPT_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Dept dept = new Dept();
				
				dept.setDeptno(resultSet.getInt("deptno"));
				dept.setDname(resultSet.getString("dname"));
				dept.setLoc(resultSet.getString("loc"));
				
				deptList.add(dept);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return deptList;
	}

	@Override
	public Dept selectByDeptno(int deptno) {
		Dept dept = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DEPT_SELECT_BY_DEPTNO_SQL);
			
			pStatement.setInt(1, deptno);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
//				Dept dept = new Dept();
				dept.setDeptno(resultSet.getInt("deptno"));
				dept.setDname(resultSet.getString("dname"));
				dept.setLoc(resultSet.getString("loc"));
				
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return dept;
	}

}
