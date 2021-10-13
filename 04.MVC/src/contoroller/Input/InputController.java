package contoroller.Input;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.memo.MemoDao;
import dao.memo.MemoDaoImpl;
import model.memo.Memo;

@WebServlet(name="InputController", 
	urlPatterns= {"/input_element1", "/input_element2", "/input_element3", "/select_element", "/textarea_element"})
public class InputController extends HttpServlet{

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
		
		if(action.equals("input_element1")) {
			String name = req.getParameter("name"); //화면에서 가져오는거
			String pwd = req.getParameter("password"); //화면에서 가져오는거
			
			System.out.println(name+" "+pwd);
			
			req.setAttribute("name_val", name);
			req.setAttribute("pwd_val", pwd);
		}
		else if(action.equals("input_element2")) {
			String gender = req.getParameter("gender"); //화면에서 가져오는거
			
			System.out.println(gender);
			
			req.setAttribute("gender_val", gender);
		}
		else if(action.equals("input_element3")) {
			String[] vehicle = req.getParameterValues("vehicle");
			for (String string : vehicle) {
				System.out.println(string);
			}
			
			req.setAttribute("vehicle_val", vehicle);
		}
		else if(action.equals("select_element")) {
			String car = req.getParameter("cars");
			System.out.println(car);
			req.setAttribute("car_val", car);
		}
		else if(action.equals("textarea_element")) {
			String message = req.getParameter("message");
			System.out.println(message);
			req.setAttribute("message_val", message);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("01-resultForm.jsp");
		dispatcher.forward(req, resp);
	}
}
