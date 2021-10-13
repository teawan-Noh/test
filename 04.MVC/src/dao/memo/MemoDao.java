package dao.memo;

import java.util.List;

import model.memo.Memo;

public interface MemoDao {
	void insert(Memo memo);
	void update(Memo memo);
	void delete(int memoid);
	
	List<Memo> selectAll();
	Memo selectByMemoid(int memoid);
}
