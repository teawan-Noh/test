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
		
		System.out.println("doGetHttp ȣ��Ǿ����ϴ�.");
		response.setContentType("text/html;charset=UTF-8");
//		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		writer.print(
				"<html> "
				+ "<head></head>"
				+ "<body>"
				+ "<h3>�ֹ����</h3>"
				+ "<p><form method=\"post\" action=\"test04\">" 
				+ "<p>�̸�:<input type=text name=\"name\"> </p>"
				+ "<p>�ּ�: <textarea name=\"address\"></textarea></p>"
				+ "<p>����: <select name=\"nation\">"
				+ "<option value=\"�ѱ�\">�ѱ�</option>"
				+ "<option value=\"�̱�\">�̱�</option>"
				+ "</select></p>"
				+ "<p><input type=\"radio\" value=\"��\" name=\"shipping\">��\r\n"
				+ "<input type=\"radio\" value=\"�ù�\" checked=\"checked\" name=\"shipping\">�ù�</p>"
				+ "<p>��� ���ǻ���: <textarea name=\"reference\"></textarea></p>"
				+ "<p>�ֽ� ��ǰ ī�޷α׸� �Բ� �����ϴ� <input type=\"checkbox\" name = \"checkbox\" value =\"��\"></p>"
				+ "<button type=\"reset\"> �ʱ�ȭ </button>" 
				+ "<button type=\"submit\"> ����  </button>" 
				+ "</form></p>"
				+ "</body>"
				+ " </html>");
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
	
		System.out.println("doPostHttp ȣ��Ǿ����ϴ�.");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(
				"<html> "
				+ "<head></head>"
				+ "<body>"
				+ "<h1>�ֹ����</h1>"
				+ "<p>�̸�: "+ request.getParameter("name") +"</p>"
				+ "<p>�ּ�: "+ request.getParameter("address") +"</p>"
				+ "<p>����: "+ request.getParameter("nation") +"</p>"
				+ "<p>��� ���ǻ���: "+ request.getParameter("reference") +"</p>"
				+ "<p>��� ���: "+ request.getParameter("shipping") +"</p>"
				+ "<p>īŻ�α׿�û����: "+ request.getParameter("checkbox") +"</p>"
				+ "</body>"
				+ " </html>");
	}
	
		

}
