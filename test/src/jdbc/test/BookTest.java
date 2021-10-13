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
		
		book.setBookname("�ڹ�");
		book.setPrice(5000);
		
		bookDao.insert(book);
		
		book.setBookname("������");
		book.setPrice(10000);
		
		bookDao.insert(book);
		
		System.out.println("======= selectByBookid() �˻� ����Դϴ�. =======");
		book = bookDao.selectByBookid(1);
		System.out.println(book.toString());
		
		
		System.out.println("======= selectAll()�� ���� �˻� ��� �Դϴ�. =======");	
		long st = System.currentTimeMillis();
		List<Book> bookList = new ArrayList<>();
		bookList = bookDao.selectAll();
		
		for (Book book1 : bookList) {
			System.out.println(book1);
		}
		long et = System.currentTimeMillis();
		
		System.out.println("======= selectAll()�� ���� ���� �ӵ� ��� �Դϴ�. =======");		
		System.out.println((et - st) + "ms");
		
		// TODO �׽�Ʈ����
		
		// insert()�� �̿��Ͽ� å �α��� �Է��Ѵ�.
		// selectByBookid()�� �̿��Ͽ� å�� �˻��ϰ� �� ������ ����Ѵ�. 
		// selectAll()�� �̿��Ͽ� ��� å�� �˻��ϰ� �� ������ ����Ѵ�.	
		// selectAll() ���� ���� �ӵ� ���� �ð��� ����Ѵ�.
		// (��³����� �� �˼� �ֵ��� �����ڸ� ������ �ε��� �Ѵ�.)
		
		// �׽�Ʈ �ڵ带 ������ �ܼ�â�� ĸ��(book_console.png)�Ͽ� ������Ʈ�� �����Ͽ� �����Ѵ�.		
		
	}
}
