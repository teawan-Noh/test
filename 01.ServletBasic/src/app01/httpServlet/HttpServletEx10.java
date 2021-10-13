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


@WebServlet(name="HttpServletEx10", urlPatterns= {"/reConfirmInfo"})
public class HttpServletEx10 extends HttpServlet{
	
	private static final long serialVersionUID = 1487239472L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		System.out.println("HttpServletEx10 호출되었습니다.");
		//1.
		System.out.println(request.getAttribute("requestInfo")); //단기저장  : 페이지 옮겨가면 지워짐
		
		//2.
		HttpSession session = request.getSession();  //세션에서 저장 : 세션이 만료될때까지 저장됨 ex)인터넷창 끌때까지
		System.out.println(session.getAttribute("sessionInfo"));
		
		//3.
		ServletContext context = request.getServletContext(); //서버에 저장 : 서버가 꺼질때까지 저장됨
		System.out.println(context.getAttribute("contextInfo"));
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		
	}
		

}
