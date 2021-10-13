package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	void insert(Customer customer);
	
	//아이디 중복체크시 필요한 메소드
	int selectCntById(String id);
	
	Customer selectByCustomerseq(long customerseq);
	Customer loging(String id, String password);
}
