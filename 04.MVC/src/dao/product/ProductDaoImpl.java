package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.product.Product;

public class ProductDaoImpl implements ProductDao{

	@Override
	public void insert(Product product) {
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.PRODUCT_INSERT_SQL);
	         //insert into product values (seqProduct.nextval, ?, ?, ?)
	         
	         pStatement.setString(1, product.getName());
	         pStatement.setString(2, product.getDescription());
	         pStatement.setInt(3, product.getPrice());
	         
	         pStatement.executeUpdate(); 
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(null, pStatement, connection); 
	      }
	   }

	@Override
	public void update(Product product) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PRODUCT_UPDATE_SQL);
			//update product set name = ?, description = ?, price = ? where productid = ?
			pStatement.setString(1, product.getName());
	        pStatement.setString(2, product.getDescription());
	        pStatement.setInt(3, product.getPrice());
	        pStatement.setInt(4, product.getProductid());
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void delete(int productid) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PRODUCT_DELETE_SQL);
			//delete from product where productid = ?
			pStatement.setInt(1, productid); 
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public List<Product> selectAll() {
		List<Product> productList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PRODUCT_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Product product = new Product();
				
				product.setProductid(resultSet.getInt("productid"));
				product.setName(resultSet.getString("name"));
				product.setDescription(resultSet.getString("description"));
				product.setPrice(resultSet.getInt("price"));
				
				productList.add(product);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return productList;
	}

	@Override
	public Product selectByProductid(int productid) {
		Product product = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.PRODUCT_SELECT_BY_PRODUCTID_SQL);
			
			//select * from memo where productid=?
			pStatement.setInt(1, productid);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				product = new Product();
				
				product.setProductid(resultSet.getInt("productid"));
				product.setName(resultSet.getString("name"));
				product.setDescription(resultSet.getString("description"));
				product.setPrice(resultSet.getInt("price"));
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return product;
	}
	
}
