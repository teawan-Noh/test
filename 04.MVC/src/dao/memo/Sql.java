package dao.memo;

public class Sql {

	//Memo Å×ÀÌºí
	public static final String MEMO_INSERT_SQL 
		= "insert into memo values (seqMemo.nextval, ?, ?)";
	
	public static final String DEPT_UPDATE_SQL 
		= "update memo set name = ?, age = ? where memoid = ?";
	
	public static final String MEMO_DELETE_SQL 
		= "delete from memo where memoid = ?";
	
	public static final String MEMO_SELECT_ALL_SQL 
		= "select memoid, name, age from memo";
	
	public static final String MEMO_SELECT_BY_MEMOID_SQL 
		= "select memoid, name, age from memo where memoid=?";
	
	public static final String MEMO_UPDATE_BY_MEMOID_SQL 
		= "select memoid = ?, name = ?, age from memo where memoid = ?";
}
