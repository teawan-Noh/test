package dao.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.memo.Memo;
import page.PageManager;
import page.PageRowResult;

public class MemoDaoImpl implements MemoDao{

	private static final String MEMO_SELECT_PAGE_SQL
		= "select memoid, name, age" 
			+ " from (select rownum as rn, memos.* from (SELECT * from memo order by memoid desc) memos)" 
			+ " where rn between ? and ?";
	@Override
	public List<Memo> selectAll(int requestPage) {
		
		List<Memo> memoList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(MEMO_SELECT_PAGE_SQL);
			
			//? ¼ÂÆÃ
			PageManager pm = new PageManager(requestPage);
			PageRowResult prr = pm.getPageRowResult();
			
			pStatement.setInt(1, prr.getRowStartNumber());
			pStatement.setInt(2, prr.getRowEndNumber());
			
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
	
//	@Override
//	public List<Memo> selectAll() {
//		
//		List<Memo> memoList = new ArrayList<>();
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = JDBCUtil.getConnection();
//			pStatement = connection.prepareStatement(Sql.MEMO_SELECT_ALL_SQL);
//			resultSet = pStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				
//				Memo memo = new Memo();
//				
//				memo.setMemoid(resultSet.getInt("memoid"));
//				memo.setName(resultSet.getString("name"));
//				memo.setAge(resultSet.getInt("age"));
//				
//				memoList.add(memo);
//			}
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//		} finally {
//			JDBCUtil.close(resultSet, pStatement, connection);
//		}
//		
//		return memoList;
//	}

	
}
