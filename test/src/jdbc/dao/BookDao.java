package jdbc.dao;

import java.util.List;

import jdbc.model.Book;

public interface BookDao {
	
	void insert(Book book);
	
	Book selectByBookid(int bookid);
	
	List<Book> selectAll();

}
