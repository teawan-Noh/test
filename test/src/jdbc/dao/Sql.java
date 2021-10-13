package jdbc.dao;

public class Sql {
	
	public static final String BOOK_INSERT_SQL = 
			"insert into book (bookid, bookname, price) values (seq_bookid.nextval,  ?, ?)";
	
	public static final String BOOK_SELECT_ALL_SQL = 
			"select * from book";
	
	public static final String BOOK_UPDATE_SQL = 
			"update book set bookname = ?, price = ? WHERE bookid = ?";
	
	public static final String BOOK_SELECT_BY_BOOKID_SQL = 
			"select * from book where bookid = ?";
}
