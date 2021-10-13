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

@WebServlet(name="FilterController",
	urlPatterns= {"/public", "/private/test01", "/private/test02"})

public class FilterController extends HttpServlet{
	
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
		
		if(action.equals("public")) {
		}
		else if(action.equals("test01")) {
		}
		else if(action.equals("test02")) {
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("public")) {
			dispatcherUrl="/filter/public.jsp";
		}
		else if(action.equals("test01")) {
			dispatcherUrl="/filter/private.jsp";
		}
		else if(action.equals("test02")) {
			dispatcherUrl="/filter/private2.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
