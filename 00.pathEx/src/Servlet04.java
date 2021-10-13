import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Servlet04", urlPatterns= {"/req01/sub03"})
public class Servlet04 extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		System.out.println("Servlet04 : doGet() 호출되었습니다.");
		
		//urlPatterns= {"/req01/sub03"} => /00.pathEx//req01/sub03
//		response.sendRedirect("../req01.html"); //=> /00.pathEx/req01.html
//		response.sendRedirect("../req01/req02.html"); //=> /00.pathEx/req01/req02.html
//		response.sendRedirect("../sub01/req03.html"); //=> /00.pathEx/sub01/req03.html
		response.sendRedirect("../sub02/sub03/req04.html"); //=> /00.pathEx/sub02/sub03/req04.html
	}
}
