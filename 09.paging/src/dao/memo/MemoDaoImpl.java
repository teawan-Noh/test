package dao.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.memo.Memo;

public class MemoDaoImpl implements MemoDao{

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
}
