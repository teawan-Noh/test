package app01.httpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="HttpServletEx04", urlPatterns= {"/request04"})
public class HttpServletEx04 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		System.out.println("HttpServletEx04:" + request.getParameter("lego"));
		
//		response.sendRedirect("request05");  //리다이렉트 : 정보를 들고가지 않음
		RequestDispatcher dispatcher = request.getRequestDispatcher("request05");
		dispatcher.forward(request, response); //디스패치 : 정보를 가지고 넘어감
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
//		response.sendRedirect("request05");  //리다이렉트 -> 5번 get으로 간다 , 
		RequestDispatcher dispatcher = request.getRequestDispatcher("request05");
		dispatcher.forward(request, response);  // 디스패치 -> 5번 post로 간다
		
	}

}
