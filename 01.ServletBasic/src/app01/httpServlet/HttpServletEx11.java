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


//@WebServlet(name="HttpServletEx11", urlPatterns= {"/test"})
public class HttpServletEx11 extends HttpServlet{
	
	private static final long serialVersionUID = 1487239472L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		System.out.println("HttpServletEx11 호출되었습니다.");
		ServletConfig config = getServletConfig();
		System.out.println(config.getInitParameter("admin"));
		
		ServletContext context = getServletContext();
		System.out.println(context.getInitParameter("address"));
	}
		

}
