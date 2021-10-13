package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Dept;

public class DeptDaoImpl implements DeptDao {

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


}
