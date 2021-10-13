package jdbc.test;

import java.util.ArrayList;
import java.util.List;

import jdbc.dao.BookDao;
import jdbc.dao.BookDaoImpl;
import jdbc.model.Book;

public class BookTest {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDaoImpl();
		Book book = new Book();
		
		book.setBookname("자바");
		book.setPrice(5000);
		
		bookDao.insert(book);
		
		book.setBookname("스프링");
		book.setPrice(10000);
		
		bookDao.insert(book);
		
		System.out.println("======= selectByBookid() 검색 결과입니다. =======");
		book = bookDao.selectByBookid(1);
		System.out.println(book.toString());
		
		
		System.out.println("======= selectAll()에 대한 검색 결과 입니다. =======");	
		long st = System.currentTimeMillis();
		List<Book> bookList = new ArrayList<>();
		bookList = bookDao.selectAll();
		
		for (Book book1 : bookList) {
			System.out.println(book1);
		}
		long et = System.currentTimeMillis();
		
		System.out.println("======= selectAll()에 대한 실행 속도 결과 입니다. =======");		
		System.out.println((et - st) + "ms");
		
		// TODO 테스트순서
		
		// insert()를 이용하여 책 두권을 입력한다.
		// selectByBookid()를 이용하여 책을 검색하고 그 내용을 출력한다. 
		// selectAll()를 이용하여 모든 책을 검색하고 그 내용을 출력한다.	
		// selectAll() 대한 실행 속도 측정 시간을 출력한다.
		// (출력내용을 잘 알수 있도록 구분자를 적절히 두도록 한다.)
		
		// 테스트 코드를 실행한 콘솔창을 캡쳐(book_console.png)하여 프로젝트에 포함하여 제출한다.		
		
	}
}
