package sql;

public class Sql {
	
	//jdbc 할때 sql문만 모두 적어 놓는 클래스
	//아래 예시로 한개 써 보았음
	public static final String BOOK_INSERT 
		= "INSERT INTO Book VALUES (?, ?, ?, ?)";
	
	public static final String BOOK_SELECT_ALL 
		= "select * from book";
	
	public static final String BOOK_DELETE 
		= "delete from book where no = ?";
	
	public static final String BOOK_UPDATE 
		= "update book set name = ?, author = ?, publisher = ? where no = ?";
	
	public static final String BOOK_SELECT_BY_NO 
		= "select * from book where no = ?";
	
	public static final String BOOK_SELECT_BY_NAME 
		= "select * from book where name like '%' || ? || '%' ";
}
