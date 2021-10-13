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


@WebServlet(name="HttpServletEx07", urlPatterns= {"/request07"})
public class HttpServletEx07 extends HttpServlet{
	
	private static final long serialVersionUID = 1487239472L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		System.out.println("HttpServletEx06:doget() 호출");
		request.setCharacterEncoding("utf-8");
		
		//request06/index.html 절대경로로 호출
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/request06/index.html"); //절대경로
//		dispatcher.forward(request, response); //디스패치 : 정보를 가지고 넘어감
		
		//request06.html 절대경로로 호출
		RequestDispatcher dispatcher = request.getRequestDispatcher("/request06.html"); //절대경로
		dispatcher.forward(request, response); //디스패치 : 정보를 가지고 넘어감
		
		//request06.html 상대경로로 호출
//		RequestDispatcher dispatcher = request.getRequestDispatcher("request06.html");
//		dispatcher.forward(request, response); //디스패치 : 정보를 가지고 넘어감
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		//urlPatterns= {"/request06/sub"} => /01.ServletBasic/request06/sub
//		response.sendRedirect("index.html"); //=> /01.ServletBasic/index.html
		
	}
		

}
