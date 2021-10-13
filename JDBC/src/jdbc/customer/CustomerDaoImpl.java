package jdbc.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.basic.model.Customer;
import jdbc.dao.JDBCUtil;
import jdbc.dao.Sql;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void insert(Customer customer) {
		
		Connection connection = null;
		PreparedStatement pStatemnet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatemnet = connection.prepareStatement(Sql.CUSTOMER_INSERT_SQL);
			
			pStatemnet.setString(1, customer.getId());
			pStatemnet.setString(2, customer.getName());
			pStatemnet.setString(3, customer.getPassword());
			pStatemnet.setString(4, customer.getAddress());
			pStatemnet.setString(5, customer.getPhone());

			pStatemnet.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatemnet, connection);
		}

	}

	@Override
	public void update(Customer customer) {
		Connection connection = null;
		PreparedStatement pStatemnet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatemnet = connection.prepareStatement(Sql.CUSTOMER_UPDATE_SQL);
			
			pStatemnet.setString(1, "ÇÇÄ«Ãò");
			pStatemnet.setString(2, "¶óÀÌÃò");
			pStatemnet.setInt(3, 5555);
			pStatemnet.setString(4, "Áö¿ì¸¶À»");
			pStatemnet.setString(5, "557-5554-1234");

			pStatemnet.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatemnet, connection);
		}

	}

	@Override
	public void delete(int seq) {
		Connection connection = null;
		PreparedStatement pStatemnet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatemnet = connection.prepareStatement(Sql.CUSTOMER_DELETE_SQL);
			
			pStatemnet.setInt(1, seq);

			pStatemnet.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatemnet, connection);
		}

	}

	@Override
	public List<Customer> selectAll() {
		
		List<Customer> customerList = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CUSTOMER_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Customer customer = new Customer();
				
				customer.setSeq(resultSet.getInt("seq"));
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setPassword(resultSet.getString("password"));
				customer.setAddress(resultSet.getString("address"));
				customer.setPhone(resultSet.getString("phone"));
				
				customerList.add(customer);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return customerList;
	}

	@Override
	public Customer selectBySql(int sql) {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.CUSTOMER_SELECT_BY_SEQ_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				customer = new Customer();
				
				customer.setSeq(resultSet.getInt("seq"));
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setPassword(resultSet.getString("password"));
				customer.setAddress(resultSet.getString("address"));
				customer.setPhone(resultSet.getString("phone"));
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return customer;
	}

}
