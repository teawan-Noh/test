package com.dao;

import com.dto.Book;
import com.view.FormatWriter;
import com.view.Message;
import java.util.*;

//ArrayList를 이용한 DAO
public class ArrayListBookDataAccessDaoImpl implements BookDataAccessDao{
	//더이상 객체 변수 선언하지 마시오.
	ArrayList<Book> bookList = new ArrayList<Book>();

	@Override
	public boolean saveBook(Book book) {
		bookList.add(book);
		return false;
	}

	@Override
	public ArrayList<Book> selectAll() {
		FormatWriter.showBookList(bookList);
		return null;
	}

	@Override
	public Book selectByNo(int no, ArrayList<Book> serchedbookList) {
		for (Book book : serchedbookList) {
			if(Integer.toString(book.getNo()).equals(Integer.toString(no))) {
			
				return book;
			}
		}
		return null;
	}

	@Override
	public boolean updateBook(int bookNo, Map<Integer, String> updateContent) {
		for(int i = 0; i < bookList.size(); i++) {
			if(Integer.toString(bookList.get(i).getNo()).equals(Integer.toString(bookNo))) {
				if(updateContent.get(1) !=null) {
					bookList.get(i).setName(updateContent.get(1));
				}
				if(updateContent.get(2) !=null) {
					bookList.get(i).setAuthor(updateContent.get(2));
				}
				if(updateContent.get(3) !=null) {
					bookList.get(i).setPublisher(updateContent.get(3));
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteBook(int no) {
		for(int i = 0; i < bookList.size(); i++) {
			if(Integer.toString(bookList.get(i).getNo()).equals(Integer.toString(no))) {
				
				bookList.remove(bookList.get(i));
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<Book> searchBook(String subName, ArrayList<Book> serchedbookList) {
		int count = 0;
		ArrayList<Book> searchedBookList = serchedbookList;
		for (Book book : bookList) {
			if(book.getName().contains(subName) || book.getAuthor().contains(subName) || book.getPublisher().contains(subName)) {
				FormatWriter.showBookList(book);
				searchedBookList.add(book);
				count += 1;
			}
		}
		if(count != 0) {
			System.out.println("총 " + count + "권이 검색되었습니다.");
			return searchedBookList;
		}
		
		return null;
	}
}
