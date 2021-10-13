package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.db.JDBCUtil;
import com.dto.Book;

import sql.Sql;

//jdbc를 사용한 DAO
//com.db.conn 패키지에 있는 클래스와 Sql 클래스를 이용해서 구현하시오.
public class OracleBookDataAccessDaoImpl implements BookDataAccessDao {

	@Override
	public boolean saveBook(Book book) {
		Connection connection = null;
		PreparedStatement pStatemnet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatemnet = connection.prepareStatement(Sql.BOOK_INSERT);

			pStatemnet.setInt(1, book.getNo());
			pStatemnet.setString(2, book.getName());
			pStatemnet.setString(3, book.getAuthor());
			pStatemnet.setString(4, book.getPublisher());

			pStatemnet.executeUpdate();
		}
		catch (Exception e) {
			e.getStackTrace();

		}
		finally {

			JDBCUtil.close(null, pStatemnet, connection);
		}
		return false;
	}

	@Override
	public ArrayList<Book> selectAll() {
		ArrayList<Book> bookList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOOK_SELECT_ALL);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();

				book.setNo(resultSet.getInt("no"));
				book.setName(resultSet.getString("name"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));

				bookList.add(book);
			}

		}
		catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return bookList;
	}

	@Override
	public Book selectByNo(int no) {
		Book book = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOOK_SELECT_BY_NO);

			pStatement.setInt(1, no);
			resultSet = pStatement.executeQuery();

			if (resultSet.next()) {
				book = new Book();
				book.setNo(resultSet.getInt("no"));
				book.setName(resultSet.getString("name"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
			}

		}
		catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}

		return book;
	}

	@Override
	public boolean updateBook(int bookNo, Map<Integer, String> updateContent) {
		Connection connection = null;
		PreparedStatement pStatemnet = null;
		Book book = selectByNo(bookNo);

		try {
			connection = JDBCUtil.getConnection();
			pStatemnet = connection.prepareStatement(Sql.BOOK_UPDATE);
			
			if (updateContent.get(1) == null) {
				pStatemnet.setString(1, book.getName());
			}
			else {
				pStatemnet.setString(1, updateContent.get(1));
			}

			if (updateContent.get(2) == null) {
				pStatemnet.setString(2, book.getAuthor());
			}
			else {
				pStatemnet.setString(2, updateContent.get(2));;
			}

			if (updateContent.get(3) == null) {
				pStatemnet.setString(3, book.getPublisher());
			}
			else {
				pStatemnet.setString(3, updateContent.get(3));
			}
			pStatemnet.setInt(4, bookNo);

			pStatemnet.executeUpdate();
		}
		catch (Exception e) {
			e.getStackTrace();

		}
		finally {

			JDBCUtil.close(null, pStatemnet, connection);
		}
		return false;
	}

	@Override
	public boolean deleteBook(int no) {
		Connection connection = null;
		PreparedStatement pStatement = null;

		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOOK_DELETE);

			pStatement.setInt(1, no);
			// insert, delete, update에 사용
			pStatement.executeUpdate();

		} catch (Exception e) {
			e.getStackTrace();

		} finally {

			JDBCUtil.close(null, pStatement, connection);
		}
		return false;
	}

	@Override
	public ArrayList<Book> searchBookByName(String subName) {
		ArrayList<Book> searchedBookList = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOOK_SELECT_BY_NAME);
			pStatement.setString(1, subName);
			resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();

				book.setNo(resultSet.getInt("no"));
				book.setName(resultSet.getString("name"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));

				searchedBookList.add(book);
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("예외" + e);
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		return searchedBookList;
	}
}
