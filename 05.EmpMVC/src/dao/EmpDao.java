package dao;

import java.util.List;

import model.Emp;


public interface EmpDao {
	
	void insert(Emp emp);
	void update(Emp emp);
	void delete(int empno);

	List<Emp> selectAll();
	Emp selectByEmpno(int empno);
	
}
