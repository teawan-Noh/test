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
import page.PageDao;
import page.PageDaoImpl;
import page.PageGroupResult;
import page.PageManager;
import page.PageSql;

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
		
		if(action.equals("memo_search")) {
			
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			System.out.println(requestPage + "확인중");
			
			MemoDao dao = new MemoDaoImpl();
			List<Memo> memoList = dao.selectAll(requestPage);
			
			//총 줄수 가져오기
			PageDao pageDao = new PageDaoImpl();
			int cnt = pageDao.getCount(PageSql.MEMO_COUNT_SQL);
			
			//getPageGroupResult(cnt)
			PageManager pm = new PageManager(requestPage);
			PageGroupResult pgr = pm.getPageGroupResult(cnt);
			
			req.setAttribute("memoList", memoList);
			req.setAttribute("pageGroupResult", pgr); //링크 시작넘버, 끝넘버 객체
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("memo_search")) {
			dispatcherUrl = "jsp/memo/list.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
