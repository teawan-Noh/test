package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	void insert(Board board);
	
	void update(Board board);
	void cntUpdate(Board board);
	void delete(int boardNo);
//
	List<Board> selectAll();
	List<Board> selectBySubject(String searchValue);
	Board selectByNo(int no);
}
