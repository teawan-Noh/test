package app01.httpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="HttpServletEx08", urlPatterns= {"/request08"})
public class HttpServletEx08 extends HttpServlet{
	
	private static final long serialVersionUID = 1487239472L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		
		//1.
		request.setAttribute("requestInfo", "Requset");
		
		//2.
		HttpSession session = request.getSession();
		session.setAttribute("sessionInfo", "Session");
		
		//3.
		ServletContext context = request.getServletContext();
		context.setAttribute("contextInfo", "Context");
		
		//request06.html 절대경로로 호출
		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmInfo"); //절대경로
		dispatcher.forward(request, response); 
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		
	}
		

}
