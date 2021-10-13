package dao;

import java.util.List;

import model.Emp;


public interface EmpDao {
	
	void insert(Emp emp);

	List<Emp> selectByHiredate(String startDate, String endDate);
}
