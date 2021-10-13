package dao.memo;

import java.sql.SQLException;
import java.util.List;

import model.memo.Memo;


public class Test {

	public static void main(String[] args) throws SQLException {
		MemoDao dao = new MemoDaoImpl();
		
//		void insert(Memo memo);
		Memo memo = new Memo();
		memo.setName("memo4");
		memo.setAge(20);
		
		dao.insert(memo);
		
////		void update(Memo memo);
//		dao.update(memo);
//		
////		void delete(int memoid);
//		dao.delete(2);
//		
////		List<Memo> selectAll();
		List<Memo> list = dao.selectAll();
		
		for (Memo memo2 : list) {
			System.out.println(memo2);
		}
//		
////		Memo selectByMemoid(int memoid);
//		Memo memo = dao.selectByMemoid(memoid);

		
	}

}
