package contoroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.BoardDaoImpl;
import dao.CustomerDao;
import dao.CustomerDaoImpl;
import model.Board;
import model.Customer;

@WebServlet(name="BoardController", 
	urlPatterns= {"/board_list", "/board_save", "/board_input", "/board_search", "/board_detail", "/board_update", "/board_delete"})
public class BoardController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req,resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		if(action.equals("board_list")) {
			
			String searchValue = req.getParameter("search");
			
			if(searchValue != null) {
				BoardDao dao = new BoardDaoImpl();
				List<Board> boardList = dao.selectBySubject(searchValue);
				req.setAttribute("boardList", boardList);
			}
			else if((searchValue == null)) {
				BoardDao dao = new BoardDaoImpl();
				List<Board> boardList = dao.selectAll();
				req.setAttribute("boardList", boardList);
			}
		}
		else if(action.equals("board_input")) {
			HttpSession session = req.getSession();
			Object value = session.getAttribute("member");
			long customerSeq = (long)value;
			CustomerDao dao = new CustomerDaoImpl();
			Customer customer = dao.selectByCustomerseq(customerSeq);
			
			req.setAttribute("customerId", customer.getId());
		}
		else if(action.equals("board_save")) {
			String subject = req.getParameter("subject");
			String content = req.getParameter("content");
			String id = req.getParameter("id");
			
			BoardDao dao = new BoardDaoImpl();
			Board board = new Board(subject, content, id);
			
			dao.insert(board);
		}
		else if(action.equals("board_detail")) {
			
			int number = Integer.parseInt(req.getParameter("no"));
			BoardDao BoardDao = new BoardDaoImpl();
			Board board = BoardDao.selectByNo(number);
			
			req.setAttribute("board", board);
			
			HttpSession session = req.getSession();
			if(session.getAttribute("member") != null) {
				Object value = session.getAttribute("member");
				long customerSeq = (long)value;
				CustomerDao customerDao = new CustomerDaoImpl();
				Customer customer = customerDao.selectByCustomerseq(customerSeq);
				
				req.setAttribute("customerId", customer.getId());
			}
			int cnt = board.getCnt()+1;
			int no = board.getNo();
			Board board1 = new Board(no ,cnt);
			
			BoardDao dao = new BoardDaoImpl();
			dao.cntUpdate(board1);
		}
		else if(action.equals("board_update")) {
			
			String subject = req.getParameter("subject");
			String content = req.getParameter("content");
			int no = Integer.parseInt(req.getParameter("no"));
			
			Board board = new Board(no, subject, content);
			
			BoardDao dao = new BoardDaoImpl();
			dao.update(board);
			
			int number = Integer.parseInt(req.getParameter("no"));
			
			BoardDao BoardDao = new BoardDaoImpl();
			Board board1 = BoardDao.selectByNo(number);
			
			req.setAttribute("board", board1);
		}
		else if(action.equals("board_delete")) {
			int number = Integer.parseInt(req.getParameter("boardno"));
			BoardDao BoardDao = new BoardDaoImpl();
			
			BoardDao.delete(number);
			
			HttpSession session = req.getSession();
			session.removeAttribute("member");
			
			BoardDao dao = new BoardDaoImpl();
			List<Board> boardList = dao.selectAll();
			req.setAttribute("boardList", boardList);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("board_list")) {
			dispatcherUrl = "board/list.jsp";
		}
		else if(action.equals("board_input")) {
			dispatcherUrl = "board/boardSave.jsp";
		}
		else if(action.equals("board_save")) {
			dispatcherUrl = "board/list.jsp";
		}
		else if(action.equals("board_detail")) {
			dispatcherUrl = "board/boardDetail.jsp";
		}
		else if(action.equals("board_update")) {
			dispatcherUrl = "board/boardDetail.jsp";
		}
		else if(action.equals("board_delete")) {
			dispatcherUrl = "board/list.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
