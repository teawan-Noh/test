package jdbc.customer;

import java.util.List;

import jdbc.basic.model.Customer;

public interface CustomerDao {
	
	void insert(Customer customer);
	void update(Customer customer);
	void delete(int seq);
	
	List<Customer> selectAll();
	Customer selectBySql(int sql);

}
