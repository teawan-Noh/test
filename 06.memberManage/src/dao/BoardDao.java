package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	void insert(Board board);
	
//	void update(Emp emp);
//	void delete(int empno);
//
	List<Board> selectAll();
//	Emp selectByEmpno(int empno);
}
