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


@WebServlet(name="HttpServletEx06", urlPatterns= {"/request06/sub"})
public class HttpServletEx06 extends HttpServlet{
	
	private static final long serialVersionUID = 1487239472L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		System.out.println("HttpServletEx06:doget() 호출");
//		response.sendRedirect("index.html");//상대경로
//		response.sendRedirect("/01.ServletBasic/index.html");//절대경로
		
		//절대경로로 작성
		//=> /01.ServletBasic/index.html
		//=> /01.ServletBasic/request06/index.html
		
		//상대경로
		//urlPatterns= {"/request06"} => /01.ServletBasic/request06
		//response.sendRedirect("index.html"); => /01.ServletBasic/index.html
		
		//urlPatterns= {"/request06"} => /01.ServletBasic/request06
//		response.sendRedirect("request06/index.html"); //=> /01.ServletBasic/request06/index.html
		
		//urlPatterns= {"/request06/sub"} => /01.ServletBasic/request06/sub
		response.sendRedirect("index.html"); //=> /01.ServletBasic/index.html
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		
	}
		

}
