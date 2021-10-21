package page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.memo.JDBCUtil;
import dao.memo.Sql;
import model.memo.Memo;

public class PageDaoImpl implements PageDao {

	@Override
	public int getCount(String sql) {
		
		int cnt = 0;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(sql);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				cnt = resultSet.getInt("cnt");
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		PageDao pageDao = new PageDaoImpl();
		
		System.out.println(pageDao.getCount(PageSql.MEMO_COUNT_SQL));
	}
	
}
