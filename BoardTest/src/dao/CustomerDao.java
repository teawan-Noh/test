package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	
	Customer selectByCustomerseq(long customerseq);
	Customer loging(String id, String password);
}
