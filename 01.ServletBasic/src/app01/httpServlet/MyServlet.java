package app01.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="MyServlet", urlPatterns= {"/my"})
public class MyServlet implements Servlet{

	
	private transient ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
		this.servletConfig = config; 
		
	}
	
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig() 호출");
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo() 호출");
		return "my servelet 입니다";
	}


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println(getServletConfig().getServletName());
		System.out.println(getServletInfo());
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.print("<html> <head></head> <body>Hello Servlet</body> </html>");
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
		
	}
	
}
