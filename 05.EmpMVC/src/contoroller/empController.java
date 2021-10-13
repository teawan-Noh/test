package contoroller;

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
	urlPatterns= {"/emp_input", "/emp_save", "/emp_search", "/emp_detail", "/emp_update", "/emp_delete", "/emp_modify"})
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
		System.out.println(uri);
		
		int lastIndex = uri.lastIndexOf("/");
		System.out.println(lastIndex);
		
		String action = uri.substring(lastIndex+1);
		System.out.println(action);
		
		if(action.equals("emp_input")) {
//			dept dao 만들기
			DeptDao deptdao = new DeptDaoImpl();
			List<Dept> deptList = deptdao.selectAll();
			
//			셋어트리뷰트해서 화면으로 리스트를 보낸다 
			req.setAttribute("deptList", deptList);
		}
		else if(action.equals("emp_save")) {
			
			String name = req.getParameter("ename");
			String job = req.getParameter("job");
			int mgr = Integer.parseInt(req.getParameter("mgr"));
			String hiredate = req.getParameter("hiredate");
			int sal = Integer.parseInt(req.getParameter("sal"));
			int comm = Integer.parseInt(req.getParameter("comm"));
			String dname = req.getParameter("dname");
			int deptno = 0;
			if(dname == "개발팀") {
				deptno = 10;
			}
			else if(dname == "인사팀") {
				deptno = 20;
			}
			else {
				deptno = 30;
			}
			Emp emp = new Emp(name, job, mgr, hiredate, sal, comm, deptno);
			
			EmpDao dao = new EmpDaoImpl();
			dao.insert(emp);
			
		}
		else if(action.equals("emp_search")) {
			
			EmpDao dao = new EmpDaoImpl();
			List<Emp> empList = dao.selectAll();
			
			req.setAttribute("empList", empList);
			
		}
		else if(action.equals("emp_detail")) {
			
			int empno = Integer.parseInt(req.getParameter("empno")); //화면에서 가져와
			
			EmpDao dao = new EmpDaoImpl();
			
			Emp emp = dao.selectByEmpno(empno);
			
			emp.setHiredate(emp.getHiredate().substring(0, 10));
			
			req.setAttribute("empDetail", emp);
		}
		else if(action.equals("emp_modify")) {
			
			int empno = Integer.parseInt(req.getParameter("empno")); //화면에서 가져와
			
			EmpDao dao = new EmpDaoImpl();
			
			Emp emp = dao.selectByEmpno(empno);
			
			emp.setHiredate(emp.getHiredate().substring(0, 10));
			
			req.setAttribute("empDetail", emp);
		}
		else if(action.equals("emp_update")) {
			
			int empno = Integer.parseInt(req.getParameter("empno"));
			String ename = req.getParameter("ename");
			String job = req.getParameter("job");
			int mgr = Integer.parseInt(req.getParameter("mgr"));
			String hiredate = req.getParameter("hiredate");
			int sal = Integer.parseInt(req.getParameter("sal"));
			int comm = Integer.parseInt(req.getParameter("comm"));
			int deptno = Integer.parseInt(req.getParameter("deptno"));
//			if(deptnoFormat == "개발팀") {
//				deptno = 10;
//			}
//			else if(deptnoFormat == "인사팀") {
//				deptno = 20;
//			}
//			else if(deptnoFormat == "재무팀") {
//				deptno = 30;
//			}
			
			Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			
			EmpDao dao = new EmpDaoImpl();
			dao.update(emp);
			
			req.setAttribute("empDetail", emp);
		}
		else if(action.equals("emp_delete")) {
			
			int empno = Integer.parseInt(req.getParameter("empno")); //화면에서 가져와
			
			EmpDao dao = new EmpDaoImpl();
			dao.delete(empno);
			
			List<Emp> empList = dao.selectAll();
			
			req.setAttribute("empList", empList);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("emp_input")) {
			dispatcherUrl = "jsp/emp/empSave.jsp";
		}
		else if(action.equals("emp_save")) {
			
			dispatcherUrl = "jsp/emp/result.jsp";
		}
		else if(action.equals("emp_search")) {
			
			dispatcherUrl = "jsp/emp/list.jsp";
		}
		else if(action.equals("emp_detail")) {
			
			dispatcherUrl = "jsp/emp/detail2.jsp";
		}
		else if(action.equals("emp_modify")) {
			
			dispatcherUrl = "jsp/emp/modify.jsp";
		}
		else if(action.equals("emp_update")) {
			
			dispatcherUrl = "jsp/emp/detail2.jsp";
		}
		else if(action.equals("emp_delete")) {
			
			dispatcherUrl = "jsp/emp/list.jsp"; 
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
