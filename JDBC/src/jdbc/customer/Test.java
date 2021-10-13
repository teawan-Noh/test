package jdbc.customer;

import java.util.List;

import jdbc.basic.model.Customer;

public class Test {

	
	
	public static void main(String[] args) {
		
		CustomerDao customerDao = new CustomerDaoImpl();
		Customer customer = new Customer();
		
		customer.setId("∫œ¿Ã");
		customer.setName("æÓ¥œ∫œ");
		customer.setPassword("∞≈∫œø’");
		customer.setAddress("≈¬√ ∏∂");
		customer.setPhone("777-1111-1111");
		
		customerDao.insert(customer);
		
		List<Customer> customerList = customerDao.selectAll();
		
		for (Customer customer2 : customerList) {
			System.out.println(customer2);
		}
		
		System.out.println("==========insert===============");
		System.out.println("");
		
		customerDao.update(customer);
		
		customerList = customerDao.selectAll();
		
		for (Customer customer2 : customerList) {
			System.out.println(customer2);
		}
		
		System.out.println("==========update===============");
		System.out.println("");
		
		customerDao.delete(1);
		
		

	}

}
