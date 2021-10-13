package dao.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.memo.Memo;

public class MemoDaoImpl implements MemoDao{

	@Override
	public void insert(Memo memo) {
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.MEMO_INSERT_SQL);
	         //insert into memo values (seqMemo.nextval, ?, ?)
	         
	         pStatement.setString(1, memo.getName());
	         pStatement.setInt(2, memo.getAge());
	         
	         pStatement.executeUpdate(); 
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(null, pStatement, connection); 
	      }
	   }

	@Override
	public void update(Memo memo) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.DEPT_UPDATE_SQL);
			//update memo set name = ?, age = ? where memoid = ?
			pStatement.setString(1, memo.getName()); // ?값 셋팅 
			pStatement.setInt(2, memo.getAge()); // ?값 셋팅  
			pStatement.setInt(3, memo.getMemoid()); // ?값 셋팅  
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void delete(int memoid) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMO_DELETE_SQL);
			//delete from memo where memoid = ?
			pStatement.setInt(1, memoid); // ?값 셋팅 
			//insert, delete, update에 사용
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public List<Memo> selectAll() {
		List<Memo> memoList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMO_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Memo memo = new Memo();
				
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
				
				memoList.add(memo);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return memoList;
	}

	@Override
	public Memo selectByMemoid(int memoid) {
		Memo memo = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.MEMO_SELECT_BY_MEMOID_SQL);
			
			//select memoid, name, age from memo where memoid=?
			pStatement.setInt(1, memoid);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				memo = new Memo();
				
				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return memo;
	}
	
}
