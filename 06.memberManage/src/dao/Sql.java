package dao;

public class Sql {

	//Customer 테이블
	public static final String CUSTOMER_INSERT_SQL 
		= "insert into customer values(customerseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String CUSTOMER_LOGIN_SQL 
		= "select * from customer where id = ? and password = ?";
	
	public static final String CUSTOMER_SELECT_BY_CUSTOMERSEQ_SQL 
	= "select * from customer where customerseq = ?";
	
	public static final String CUSTOMER_BY_ID_CNT_SQL 
		= "select count(*) as cnt from CUSTOMER where id=?";
	
	//Board 테이블
	public static final String BOARD_SELECT_ALL_SQL 
		= "select * from board order by empno desc";
	
	public static final String BOARD_INSERT_SQL 
		= "insert into customer values(customerseq.nextval, ?)";
}
