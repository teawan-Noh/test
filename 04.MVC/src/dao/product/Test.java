package dao.product;

import java.sql.SQLException;
import java.util.List;

import model.product.Product;


public class Test {

	public static void main(String[] args) throws SQLException {
		ProductDao dao = new ProductDaoImpl();
		
//		void insert(Product product);
//		Product product = new Product("가제트", "만능팔", 3000);
//		
//		dao.insert(product);
		
//		void update(Product product);
//		void delete(int productid);
		
//		List<Product> selectAll();
		List<Product> list = dao.selectAll();
		
		for (Product product2 : list) {
			System.out.print(product2.getName() + ", ");
			System.out.println(product2.getDescription());
		}
		
//		Product selectByProductid(int productid);

		
	}

}
