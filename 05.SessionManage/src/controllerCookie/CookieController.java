package controllerCookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/setCookie","/delCookie"})
public class CookieController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String addr = req.getParameter("addr");
		
		req.setAttribute("address", addr);
		
		//1.ÄíÅ° °´Ã¼ ¸¸µé±â
		Cookie cookie = new Cookie("address",addr);
		
		resp.addCookie(cookie);
		resp.sendRedirect("01-cookie.jsp");
	}
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie addressCookie = new Cookie("address", "");
		
		addressCookie.setMaxAge(0);
		
		resp.sendRedirect("01-cookie.jsp");
	}
}
