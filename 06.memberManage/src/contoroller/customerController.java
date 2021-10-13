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

@WebServlet(name="customerController", urlPatterns= {"/customer_join", "/idcheck", "/customer_save", "/customer_detail", "/customer_update", "/customer_delete"})
public class customerController extends HttpServlet{
	
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
		
		if(action.equals("customer_join")) {
		}
		else if(action.equals("idcheck")) {
			
			String id = req.getParameter("id_value");
			CustomerDao dao = new CustomerDaoImpl();
			int cnt = dao.selectCntById(id);
			if(cnt > 0) {
				req.setAttribute("useTF", false); //이미 아이디가 존재할 때
			}else {
				req.setAttribute("useTF", true); //존재하지 않을때
				
			}
		}
		else if(action.equals("customer_save")) {
			
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String postcode = req.getParameter("postcode");
			String address = req.getParameter("address");
			String address2 = req.getParameter("address2");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			Customer customer = new Customer(id, name, password, postcode, address, address2, phone, email);
			
			CustomerDao dao = new CustomerDaoImpl();
			dao.insert(customer);
		}
		else if(action.equals("customer_detail")) {
			HttpSession session = req.getSession();
			Object value = session.getAttribute("member");
			long customerSeq = (long)value;
			CustomerDao dao = new CustomerDaoImpl();
			Customer customer = dao.selectByCustomerseq(customerSeq);
			
			req.setAttribute("customerInfo", customer);
		}
		else if(action.equals("customer_update")) {
			
			HttpSession session = req.getSession();
			CustomerDao dao = new CustomerDaoImpl();
//			Customer customer = dao.
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("customer_join")) {
			dispatcherUrl = "member/join.jsp";
		}
		else if(action.equals("idcheck")) {
			dispatcherUrl = "/ajax/idcheck.jsp";
		}
		else if(action.equals("customer_save")) {
			dispatcherUrl = "member/join.jsp";
		}
		else if(action.equals("customer_detail")) {
			dispatcherUrl = "member/detail.jsp";
		}
		else if(action.equals("customer_update")) {
			dispatcherUrl = "index.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
