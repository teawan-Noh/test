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
import form.memo.MemoForm;
import formError.MemoError;
import model.memo.Memo;
import validator.memo.MemoValidator;

@WebServlet(name="MemoController", 
	urlPatterns= {"/memo_input", "/memo_save_v1", "/memo_save_v2", "/memo_search", "/memo_detail", "/memo_update", "/memo_delete"})
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
		
		if(action.equals("memo_input")) {
		}
		else if(action.equals("memo_save_v1")) {
			
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			
			MemoForm memoForm = new MemoForm(name, age); //화면에서 받아온 값으로 세팅
			
			//체크
			MemoValidator validator = new MemoValidator();
			List<String> errors = validator.validate(memoForm);

			if(errors.isEmpty()) {
				Memo memo = new Memo();
				memo.setName(memoForm.getName());
				memo.setAge(Integer.parseInt(memoForm.getAge()));
				
				MemoDao dao = new MemoDaoImpl();
				dao.insert(memo);
				
				req.setAttribute("message", "잘 저장되었습니다.");
			}
			else {
				req.setAttribute("errors", errors);
				req.setAttribute("memoForm", memoForm);
			}
		}
		else if(action.equals("memo_save_v2")) {
			
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			
			MemoForm memoForm = new MemoForm(name, age); //화면에서 받아온 값으로 세팅
			
			//체크
			MemoValidator validator = new MemoValidator();
			MemoError memoErrors = validator.validate_v2(memoForm);//v2

			if(!memoErrors.isResult()) {//v2
				Memo memo = new Memo();
				memo.setName(memoForm.getName());
				memo.setAge(Integer.parseInt(memoForm.getAge()));
				
				MemoDao dao = new MemoDaoImpl();
				dao.insert(memo);
				
				req.setAttribute("message", "잘 저장되었습니다.");
			}
			else {
				req.setAttribute("memoErrors", memoErrors);//v2
				req.setAttribute("memoForm", memoForm);
			}
		}
		else if(action.equals("memo_search")) {
			
			MemoDao dao = new MemoDaoImpl();
			List<Memo> memoList = dao.selectAll();
			
			req.setAttribute("memoList", memoList);
			
		}
		else if(action.equals("memo_detail")) {
			
			int memoid = Integer.parseInt(req.getParameter("memoid")); //화면에서 가져와
			
			MemoDao dao = new MemoDaoImpl();
			
			Memo memo = dao.selectByMemoid(memoid);
			
			req.setAttribute("memodetail", memo);
			
		}
		else if(action.equals("memo_update")) {
			
			int memoid = Integer.parseInt(req.getParameter("memoid"));
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			
			Memo memo = new Memo(memoid, name, age);
			
			MemoDao dao = new MemoDaoImpl();
			dao.update(memo);
			
			req.setAttribute("message", "잘 수정되었습니다.");
			
		}
		else if(action.equals("memo_delete")) {
			
			int memoid = Integer.parseInt(req.getParameter("memoid")); //화면에서 가져와
			
			MemoDao dao = new MemoDaoImpl();
			dao.delete(memoid);
			
			List<Memo> memoList = dao.selectAll();
			
			req.setAttribute("memoList", memoList);
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("memo_input")) {
			dispatcherUrl = "jsp/memo/memo.jsp";
		}
		else if(action.equals("memo_save_v1") || action.equals("memo_save_v2")) {
			
			dispatcherUrl = "jsp/memo/memo.jsp";
		}
		else if(action.equals("memo_search")) {
			
			dispatcherUrl = "jsp/memo/list.jsp";
		}
		else if(action.equals("memo_detail")) {
			
			dispatcherUrl = "jsp/memo/detail.jsp";
		}
		else if(action.equals("memo_update")) {
			
			dispatcherUrl = "jsp/memo/memo_search.jsp";
		}
		else if(action.equals("memo_delete")) {
			
			dispatcherUrl = "jsp/memo/list.jsp"; 
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
