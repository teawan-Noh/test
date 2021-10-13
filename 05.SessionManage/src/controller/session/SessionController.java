package controller.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns= {"/sessionInfo"})
public class SessionController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		List<String> list = new ArrayList<>();
		list.add("�ڹٛ�");
		
		req.setAttribute("wordlist", list);  //"wordlist"�� �̸��� ���� ��� jsp���Ͽ� sessionScope �Ⱥٿ��ָ� request�� ���������� �켱������ �ҷ�����
		
		HttpSession session = req.getSession();
		List<String> wordList = (List<String>)session.getAttribute("wordlist");
		
		if(wordList == null) {
			wordList = new ArrayList<>();
			session.setAttribute("wordlist", wordList);
		}
		
		wordList.add(req.getParameter("name"));
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("03-session.jsp");
		dispatcher.forward(req, resp);
	}
}
