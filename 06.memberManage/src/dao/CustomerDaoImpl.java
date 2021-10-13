package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void insert(Customer customer) {
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.CUSTOMER_INSERT_SQL);
	         //insert into customer values(customerseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)
	         
	         pStatement.setString(1, customer.getId());
	         pStatement.setString(2, customer.getName());
	         pStatement.setString(3, customer.getPassword());
	         pStatement.setString(4, customer.getPostcode());
	         pStatement.setString(5, customer.getAddress());
	         pStatement.setString(6, customer.getAddress2());
	         pStatement.setString(7, customer.getPhone());
	         pStatement.setString(8, customer.getEmail());
	         
	         pStatement.executeUpdate(); 
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(null, pStatement, connection); 
	      }
	   }

	@Override
	public int selectCntById(String id) {
			int cnt=0;
		
			Connection connection = null;
			PreparedStatement pStatement = null;
			ResultSet resultSet = null;
	      
			try {
				connection = JDBCUtil.getConnection();
				pStatement = connection.prepareStatement(Sql.CUSTOMER_BY_ID_CNT_SQL);
				pStatement.setString(1, id);
				resultSet = pStatement.executeQuery();
	         
				if(resultSet.next()) {
					
					cnt = resultSet.getInt("cnt");
				}
	         
		        pStatement.executeUpdate(); 
	         
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(resultSet, pStatement, connection); 
			}
		
			return cnt;
	}

	@Override
	public Customer loging(String id, String password) {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
      
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CUSTOMER_LOGIN_SQL);
			
			pStatement.setString(1, id);
			pStatement.setString(2, password);
			resultSet = pStatement.executeQuery();
         
			if(resultSet.next()) {
				
				customer = new Customer();
				
				customer.setCustomerseq(resultSet.getLong("customerseq"));
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setPassword(resultSet.getString("password"));
				customer.setPostcode(resultSet.getString("postcode"));
				customer.setAddress(resultSet.getString("address"));
				customer.setAddress2(resultSet.getString("address2"));
				customer.setPhone(resultSet.getString("phone"));
				customer.setEmail(resultSet.getString("email"));
			}
         
         
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection); 
		}
	
		return customer;
	}

	@Override
	public Customer selectByCustomerseq(long customerseq) {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
      
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CUSTOMER_SELECT_BY_CUSTOMERSEQ_SQL);
			
			pStatement.setLong(1, customerseq);
			resultSet = pStatement.executeQuery();
         
			if(resultSet.next()) {
				
				customer = new Customer();
				
				customer.setCustomerseq(resultSet.getLong("customerseq"));
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setPassword(resultSet.getString("password"));
				customer.setPostcode(resultSet.getString("postcode"));
				customer.setAddress(resultSet.getString("address"));
				customer.setAddress2(resultSet.getString("address2"));
				customer.setPhone(resultSet.getString("phone"));
				customer.setEmail(resultSet.getString("email"));
			}
         
         
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection); 
		}
	
		return customer;
	}
	

//	@Override
//	public void update(Customer customer) {
//		
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		
//		try {
//			connection = JDBCUtil.getConnection();
//			pStatement = connection.prepareStatement(Sql.DEPT_UPDATE_SQL);
//			//update memo set name = ?, age = ? where memoid = ?
//			pStatement.setString(1, customer.getName()); // ?값 셋팅 
//			pStatement.setInt(2, customer.getAge()); // ?값 셋팅  
//			pStatement.setInt(3, customer.getMemoid()); // ?값 셋팅  
//			//insert, delete, update에 사용
//			pStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//			
//		} finally {
//			
//			JDBCUtil.close(null, pStatement, connection);
//		}
//		
//	}
//
//	@Override
//	public void delete(int customerseq) {
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		
//		try {
//			connection = JDBCUtil.getConnection();
//			pStatement = connection.prepareStatement(Sql.MEMO_DELETE_SQL);
//			//delete from memo where memoid = ?
//			pStatement.setInt(1, memoid); // ?값 셋팅 
//			//insert, delete, update에 사용
//			pStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//			
//		} finally {
//			
//			JDBCUtil.close(null, pStatement, connection);
//		}
//		
//	}
//
//	@Override
//	public List<Customer> selectAll() {
//		List<Customer> customerList = new ArrayList<>();
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = JDBCUtil.getConnection();
//			pStatement = connection.prepareStatement(Sql.MEMO_SELECT_ALL_SQL);
//			resultSet = pStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				
//				Customer customer = new Customer();
//				
//				customer.setMemoid(resultSet.getInt("memoid"));
//				customer.setName(resultSet.getString("name"));
//				customer.setAge(resultSet.getInt("age"));
//				
//				customerList.add(customer);
//			}
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//		} finally {
//			JDBCUtil.close(resultSet, pStatement, connection);
//		}
//		
//		return customerList;
//	}
//
//	@Override
//	public Customer selectByCustomerseq(int customerseq) {
//		Customer customer = null;
//		
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = JDBCUtil.getConnection();
//			pStatement = connection.prepareStatement(Sql.MEMO_SELECT_BY_MEMOID_SQL);
//			
//			//select memoid, name, age from memo where memoid=?
//			pStatement.setInt(1, memoid);
//			resultSet = pStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				
//				Customer customer = new Customer();
//				
//				customer.setMemoid(resultSet.getInt("memoid"));
//				customer.setName(resultSet.getString("name"));
//				customer.setAge(resultSet.getInt("age"));
//				
//			}
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//		} finally {
//			JDBCUtil.close(resultSet, pStatement, connection);
//		}
//		
//		return customer;
//	}
	
}
