package app01.httpServlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="HttpServletEx03", 
urlPatterns= {"/request03"},
initParams = {
		@WebInitParam(name="admin", value="Noh taewan"),
		@WebInitParam(name="email", value="admin@example.com")
}
)
public class HttpServletEx03 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("name"));
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("name"));
		
		ServletConfig config = getServletConfig();
		System.out.println("서블릿 초기 매개변수:"+ config.getInitParameter("admin"));
		System.out.println("서블릿 초기 매개변수:"+ config.getInitParameter("email"));
		System.out.println("서블릿 이름:"+ config.getServletName());
	}

}
