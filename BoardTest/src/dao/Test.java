package dao;

import java.sql.SQLException;
import java.util.List;

import model.Board;
import model.Customer;


public class Test {

	public static void main(String[] args) throws SQLException {
		CustomerDao dao = new CustomerDaoImpl();
		
		BoardDao boardDao = new BoardDaoImpl();
		
		String subject = "abc";
		String content = "content";
		String id = "id";
		
		Board board = new Board(subject, content, id);

		boardDao.insert(board);
	}

}
