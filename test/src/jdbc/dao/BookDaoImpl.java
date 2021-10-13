package jdbc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.model.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public void insert(Book book) {
		
		Connection connection = null;
		PreparedStatement pStatemnet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatemnet = connection.prepareStatement(Sql.BOOK_INSERT_SQL);
			
			pStatemnet.setString(1, book.getBookname());
			pStatemnet.setInt(2, book.getPrice());

			pStatemnet.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatemnet, connection);
		}
		
	}

	@Override
	public Book selectByBookid(int bookid) {
		Book book = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOOK_SELECT_BY_BOOKID_SQL);
			
			pStatement.setInt(1, bookid);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				book = new Book();
				book.setBookid(resultSet.getInt("bookid"));
				book.setBookname(resultSet.getString("bookname"));
				book.setPrice(resultSet.getInt("price"));
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return book;
	
	}

	@Override
	public List<Book> selectAll() {
		List<Book> bookList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOOK_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Book book = new Book();
				
				book.setBookid(resultSet.getInt("bookid"));
				book.setBookname(resultSet.getString("bookname"));
				book.setPrice(resultSet.getInt("price"));
				
				bookList.add(book);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return bookList;
	}
}
