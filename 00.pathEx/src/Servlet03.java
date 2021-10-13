import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Servlet03", urlPatterns= {"/req01/sub01/sub02"})
public class Servlet03 extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		System.out.println("Servlet03 : doGet() ȣ��Ǿ����ϴ�.");
		
		//urlPatterns= {"/req01/sub01/sub02"} => /00.pathEx/req01/sub01/sub02
//		response.sendRedirect("../../req01.html"); //=> /00.pathEx/req01.html
//		response.sendRedirect("../../req01/req02.html"); //=> /00.pathEx/req01/req02.html
//		response.sendRedirect("../../sub01/req03.html"); //=> /00.pathEx/sub01/req03.html
//		response.sendRedirect("../../sub02/sub03/req04.html"); //=> /00.pathEx/sub02/sub03/req04.html
		
		//������
//		response.sendRedirect("/00.pathEx/req01.html");
//		response.sendRedirect("/00.pathEx/req01/req02.html");
//		response.sendRedirect("/00.pathEx/sub01/req03.html");
//		response.sendRedirect("/00.pathEx/sub02/sub03/req04.html");
		
		//����ó�� ȣ��
//		RequestDispatcher dispatcher = request.getRequestDispatcher("../../req01.html"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("../../req01/req02.html"); 
//		RequestDispatcher dispatcher = request.getRequestDispatcher("../../sub01/req03.html"); 
//		RequestDispatcher dispatcher = request.getRequestDispatcher("../../sub02/sub03/req04.html"); 
		dispatcher.forward(request, response); //����ġ : ������ ������ �Ѿ
		
	}
}
