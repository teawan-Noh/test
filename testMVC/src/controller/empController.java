package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import dao.DeptDaoImpl;
import dao.EmpDao;
import dao.EmpDaoImpl;
import model.Dept;
import model.Emp;


@WebServlet(name="empController", 
	urlPatterns= {"/emp_input", "/emp_save", "/emp_search", "/emp_search_result"})
public class empController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		System.out.println(action);
		
		if(action.equals("emp_input")) {
			
			DeptDao deptdao = new DeptDaoImpl();
			List<Dept> deptList = deptdao.selectAll();
			
			req.setAttribute("deptList", deptList);
		}
		else if(action.equals("emp_save")) {
			
			DeptDao deptdao = new DeptDaoImpl();
			List<Dept> deptList = deptdao.selectAll();
			
			req.setAttribute("deptList", deptList);
			
			String name = req.getParameter("ename");
			String job = req.getParameter("job");
			int sal = Integer.parseInt(req.getParameter("sal"));
			String dname = req.getParameter("dname");
			
			int deptno = 0;
			if(dname.equals("°³¹ßÆÀ")) {
				deptno = 10;
			}
			else if(dname.equals("ÀÎ»çÆÀ")) {
				deptno = 20;
			}
			else if(dname.equals("Àç¹«ÆÀ")) {
				deptno = 30;
			}
			Emp emp = new Emp(name, job, sal, deptno);
			
			EmpDao dao = new EmpDaoImpl();
			dao.insert(emp);
			
		}
		else if(action.equals("emp_search")) {
			
		}
		else if(action.equals("emp_search_result")) {
			
			EmpDao dao = new EmpDaoImpl();
			
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			
			List<Emp> empList = dao.selectByHiredate(startDate, endDate);
			
			req.setAttribute("empList", empList);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("emp_input")) {
			dispatcherUrl = "jsp/empSave.jsp";
		}
		else if(action.equals("emp_save")) {
			
			dispatcherUrl = "jsp/empSave.jsp";
		}
		else if(action.equals("emp_search")) {
			
			dispatcherUrl = "jsp/list.jsp";
		}
		else if(action.equals("emp_search_result")) {
			
			dispatcherUrl = "jsp/list.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
