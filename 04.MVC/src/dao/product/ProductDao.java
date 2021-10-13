package dao.product;

import java.util.List;

import model.product.Product;

public interface ProductDao {
	void insert(Product product);
	void update(Product product);
	void delete(int productid);
	
	List<Product> selectAll();
	Product selectByProductid(int productid);
}
