package com.biz;


import com.dao.ArrayListBookDataAccessDaoImpl;
import com.dao.BookDataAccessDao;
import com.view.InputValueReader;


//도서관리 시스템 로직부분
public class BookManager
{
	//더이상 객체 변수 선언하지 마시오.
	InputValueReader reader = new InputValueReader();
	
	BookDataAccessDao dao = new ArrayListBookDataAccessDaoImpl();
	//BookDataAccessDao dao = new OracleBookDataAccessDaoImpl();
	
	public void start() {
		
	}
	
	
}
