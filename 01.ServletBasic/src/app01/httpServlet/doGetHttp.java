package app01.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

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


@WebServlet(name="doGetHttp", urlPatterns= {"/test04"})
public class doGetHttp extends HttpServlet{
	
	private static final long serialVersionUID = 1487239472L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		System.out.println("doGetHttp 호출되었습니다.");
		response.setContentType("text/html;charset=UTF-8");
//		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		writer.print(
				"<html> "
				+ "<head></head>"
				+ "<body>"
				+ "<h3>주문양식</h3>"
				+ "<p><form method=\"post\" action=\"test04\">" 
				+ "<p>이름:<input type=text name=\"name\"> </p>"
				+ "<p>주소: <textarea name=\"address\"></textarea></p>"
				+ "<p>국가: <select name=\"nation\">"
				+ "<option value=\"한국\">한국</option>"
				+ "<option value=\"미국\">미국</option>"
				+ "</select></p>"
				+ "<p><input type=\"radio\" value=\"퀵\" name=\"shipping\">퀵\r\n"
				+ "<input type=\"radio\" value=\"택배\" checked=\"checked\" name=\"shipping\">택배</p>"
				+ "<p>배송 유의사항: <textarea name=\"reference\"></textarea></p>"
				+ "<p>최신 제품 카달로그를 함께 보냅니다 <input type=\"checkbox\" name = \"checkbox\" value =\"예\"></p>"
				+ "<button type=\"reset\"> 초기화 </button>" 
				+ "<button type=\"submit\"> 제출  </button>" 
				+ "</form></p>"
				+ "</body>"
				+ " </html>");
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
	
		System.out.println("doPostHttp 호출되었습니다.");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(
				"<html> "
				+ "<head></head>"
				+ "<body>"
				+ "<h1>주문양식</h1>"
				+ "<p>이름: "+ request.getParameter("name") +"</p>"
				+ "<p>주소: "+ request.getParameter("address") +"</p>"
				+ "<p>국가: "+ request.getParameter("nation") +"</p>"
				+ "<p>배송 유의사항: "+ request.getParameter("reference") +"</p>"
				+ "<p>배송 방법: "+ request.getParameter("shipping") +"</p>"
				+ "<p>카탈로그요청여부: "+ request.getParameter("checkbox") +"</p>"
				+ "</body>"
				+ " </html>");
	}
	
		

}
