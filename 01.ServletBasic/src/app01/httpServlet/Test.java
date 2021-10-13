package app01.httpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Test", urlPatterns= {"/test01"})
public class Test extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("gaga"));
	}
}
