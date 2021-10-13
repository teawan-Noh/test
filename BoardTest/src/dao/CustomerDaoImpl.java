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
	
}
