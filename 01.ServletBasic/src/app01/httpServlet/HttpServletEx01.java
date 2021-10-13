package app01.httpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="HttpServletEx01", urlPatterns= {"/request01"})
public class HttpServletEx01 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("doGet() 호출되었습니다.");
		System.out.println(request.getParameter("fruit"));
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("doPost() 호출되었습니다.");
		System.out.println(request.getParameter("subject"));
	}

}
