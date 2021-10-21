package dao.memo;

import java.util.List;

import model.memo.Memo;

public interface MemoDao {
	
//	List<Memo> selectAll();
	List<Memo> selectAll(int requestPage);
}
