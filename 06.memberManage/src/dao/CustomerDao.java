package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	void insert(Customer customer);
	
	//���̵� �ߺ�üũ�� �ʿ��� �޼ҵ�
	int selectCntById(String id);
	
	Customer selectByCustomerseq(long customerseq);
	Customer loging(String id, String password);
}
