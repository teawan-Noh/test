package dao.memo;

import java.sql.SQLException;
import java.util.List;

import model.memo.Memo;
import page.PageDao;
import page.PageDaoImpl;
import page.PageSql;


public class Test {

	public static void main(String[] args) throws SQLException {
//		MemoDao dao = new MemoDaoImpl();
		
//		List<Memo> selectAll();
//		List<Memo> list = dao.selectAll();
//		
//		for (Memo memo : list) {
//			System.out.println(memo.getName() + ", " + memo.getAge());
//		}
		
		PageDao pageDao = new PageDaoImpl();
		
		System.out.println(pageDao.getCount(PageSql.MEMO_COUNT_SQL));
	}
}
