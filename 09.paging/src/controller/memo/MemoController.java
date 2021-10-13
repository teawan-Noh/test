package controller.memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.memo.MemoDao;
import dao.memo.MemoDaoImpl;
import model.memo.Memo;

@WebServlet(name="MemoController", 
	urlPatterns= {"/memo_search"})
public class MemoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		
		int lastIndex = uri.lastIndexOf("/");
		
		String action = uri.substring(lastIndex+1);
		System.out.println(action);
		
		if(action.equals("memo_search")) {
			
			MemoDao dao = new MemoDaoImpl();
			List<Memo> memoList = dao.selectAll();
			
			req.setAttribute("memoList", memoList);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("memo_search")) {
			dispatcherUrl = "jsp/memo/list.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
