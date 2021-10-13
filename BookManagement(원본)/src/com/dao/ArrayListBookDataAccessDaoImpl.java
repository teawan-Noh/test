package com.dao;
import java.util.*;

import com.dto.Book;

//ArrayList를 이용한 DAO
public class ArrayListBookDataAccessDaoImpl implements BookDataAccessDao
{
	//더이상 객체 변수 선언하지 마시오.
	ArrayList<Book> bookList = new ArrayList<Book>();

	@Override
	public boolean saveBook(Book b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Book> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book selectByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBook(int bookNo, Map<Integer, String> updateContent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Book> searchBookByName(String subName) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
