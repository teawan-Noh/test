package quiz.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/mapServlet"})
public class MapServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("�±�", "����");
		capitals.put("�����̽þ�", "��˶������");
		capitals.put("�ε��׽þ�", "��ī��Ÿ");
		
		req.setAttribute("capitals", capitals);
		
		Map<String, String[]> citys = new HashMap<String, String[]>();
		citys.put("ȣ��", new String[] {"�õ��, ���, �۽�"});
		citys.put("�ε��׽þ�", new String[] {"��ī��Ÿ, ����پ�, �޴�"});
		citys.put("��������", new String[] {"��Ŭ����, ũ���̽�Ʈóġ, ������"});
		
		req.setAttribute("city", citys);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("05-quizTest2.jsp");
		dispatcher.forward(req, resp);
	}
}
