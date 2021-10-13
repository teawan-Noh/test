package app01.httpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="HttpServletEx02", urlPatterns= {"/request02"})
public class HttpServletEx02 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("doGet() 호출되었습니다.");
		System.out.println(request.getParameter("channel"));
		System.out.println(request.getParameter("key"));
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("doPost() 호출되었습니다.");
		System.out.println(request.getParameter("channel"));
		System.out.println(request.getParameter("key"));
	}

}
