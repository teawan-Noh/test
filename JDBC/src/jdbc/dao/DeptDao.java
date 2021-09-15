package jdbc.dao;

import java.util.List;

import jdbc.basic.model.Dept;

public interface DeptDao {
	
	void insert(Dept dept);
	void update(Dept dept);
	void delete(int deptno);

	List<Dept> selectAll();
	Dept selectByDeptno(int deptno);
	
	
}
