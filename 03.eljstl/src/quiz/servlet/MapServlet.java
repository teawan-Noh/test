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
		capitals.put("태국", "방콕");
		capitals.put("말레이시아", "쿠알라룸프르");
		capitals.put("인도네시아", "자카르타");
		
		req.setAttribute("capitals", capitals);
		
		Map<String, String[]> citys = new HashMap<String, String[]>();
		citys.put("호주", new String[] {"시드니, 멜번, 퍼스"});
		citys.put("인도네시아", new String[] {"자카르타, 수라바야, 메단"});
		citys.put("뉴질랜드", new String[] {"오클랜드, 크라이스트처치, 웰링턴"});
		
		req.setAttribute("city", citys);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("05-quizTest2.jsp");
		dispatcher.forward(req, resp);
	}
}
