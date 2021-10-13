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

@WebServlet(name="BoardController", urlPatterns= {"/board_list", "/board_save"})
public class BoardController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req,resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		if(action.equals("board_list")) {
			
		}
		else if(action.equals("board_save")) {
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("board_list")) {
			dispatcherUrl = "board/list.jsp";
		}
		else if(action.equals("board_save")) {
			HttpSession session = req.getSession();
			
			if(session.getAttribute("member") != null) {
				dispatcherUrl = "boardSave.jsp";
			}
			else {
				dispatcherUrl = "../index.jsp";
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
