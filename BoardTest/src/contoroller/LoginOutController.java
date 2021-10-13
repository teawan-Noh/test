package contoroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import model.Customer;

@WebServlet(name="LoginOutController",
	urlPatterns= {"/login_input", "/login", "/logout"})
public class LoginOutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		int lastIndext = uri.lastIndexOf("/");
		String action = uri.substring(lastIndext+1);
		
		if(action.equals("login_input")) {
			
		}
		else if(action.equals("login")) {
			//ȭ�鿡�� id�� �޾ƿ���
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			CustomerDao dao = new CustomerDaoImpl();
			Customer customer = dao.loging(id, password);
			
			if(customer != null) {
				HttpSession session = req.getSession();
				session.setAttribute("member", customer.getCustomerseq());
				System.out.println("���� Ȯ��"+customer.getCustomerseq());
				System.out.println("���� Ȯ��"+customer.getName());
			}
			else {
				req.setAttribute("message", "�������� �ʴ� ���̵�ų� �����ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}
		String dispatcherUrl = null;
		
		if(action.equals("login_input")) 
		{
			dispatcherUrl = "/member/login.jsp";
		}
		else if(action.equals("login")) {
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("member") != null) {
//				dispatcherUrl = "/board/list.jsp";
				dispatcherUrl = "board_list";
			}
			else {
				dispatcherUrl = "/member/login.jsp";
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
