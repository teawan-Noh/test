package dao.product;

public class Sql {

	//Memo Å×ÀÌºí
	public static final String PRODUCT_INSERT_SQL 
		= "insert into product values (seqProduct.nextval, ?, ?, ?)";
	
	public static final String PRODUCT_UPDATE_SQL 
		= "update product set name = ?, description = ?, price = ? where productid = ?";
	
	public static final String PRODUCT_DELETE_SQL 
		= "delete from product where productid = ?";
	
	public static final String PRODUCT_SELECT_ALL_SQL 
		= "select * from product";
	
	public static final String PRODUCT_SELECT_BY_PRODUCTID_SQL 
		= "select * from product where productid=?";
	
}
