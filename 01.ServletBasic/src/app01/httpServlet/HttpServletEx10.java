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
		System.out.println("HttpServletEx10 ȣ��Ǿ����ϴ�.");
		//1.
		System.out.println(request.getAttribute("requestInfo")); //�ܱ�����  : ������ �Űܰ��� ������
		
		//2.
		HttpSession session = request.getSession();  //���ǿ��� ���� : ������ ����ɶ����� ����� ex)���ͳ�â ��������
		System.out.println(session.getAttribute("sessionInfo"));
		
		//3.
		ServletContext context = request.getServletContext(); //������ ���� : ������ ���������� �����
		System.out.println(context.getAttribute("contextInfo"));
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		
	}
		

}
