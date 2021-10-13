import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Servlet01", urlPatterns= {"/req01"})
public class Servlet01 extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		System.out.println("Servlet01 : doGet() ȣ��Ǿ����ϴ�.");
		
		//urlPatterns= {"/req01"} => /00.pathEx/req01
//		response.sendRedirect("req01.html"); //=> /00.pathEx/req01.html
//		response.sendRedirect("req01/req02.html"); //=> /00.pathEx/req01/req02.html
//		response.sendRedirect("sub01/req03.html"); //=> /00.pathEx/sub01/req03.html
//		response.sendRedirect("sub02/sub03/req04.html"); //=> /00.pathEx/sub02/sub03/req04.html
		
		//���� ȣ��
//		request.setCharacterEncoding("utf-8");
		
		//����ó�� ȣ��
//		RequestDispatcher dispatcher = request.getRequestDispatcher("req01.html"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("req01/req02.html"); 
//		RequestDispatcher dispatcher = request.getRequestDispatcher("sub01/req03.html"); 
//		RequestDispatcher dispatcher = request.getRequestDispatcher("sub02/sub03/req04.html"); 
		dispatcher.forward(request, response); //����ġ : ������ ������ �Ѿ
	}
}
