package com.dao;

import java.util.ArrayList;
import java.util.Map;

import com.dto.Book;

public interface BookDataAccessDao {

	public boolean saveBook(Book b);
	public ArrayList<Book> selectAll();
	public boolean updateBook(int bookNo, Map<Integer, String> updateContent);
	public boolean deleteBook(int no);
	
	/**
	* bookList를 반환
	* search된 책 이외의 책 선택 불가능 하도록 코드 수정
	*/
	public Book selectByNo(int no, ArrayList<Book> serchedbookList);
//	public Book selectByNo(int no);	
	
	/**
	* 통합 검색 (책이름, 저자, 출판사) : 검색기능 하나로 
	*/
	public ArrayList<Book> searchBook(String subName, ArrayList<Book> serchedbookList);
//	public ArrayList<Book> searchBookByName(String subName);
//	public void searchBookByAuthor(String subAuthor);
//	public void searchBookByPublisher(String publisher);
}
