package quiz.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.model.Book2;

@WebServlet(urlPatterns= {"/quizTest"})
public class ListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Book2> books = new ArrayList<Book2>();
		
		Book2 book1 = new Book2("9788960771468", "����� ������ 3", 50.00);
		Book2 book2 = new Book2("9788960772761", "Node.js ������̿��� ���α׷���", 28.00);
		Book2 book3 = new Book2("9788960771512", "��¥�� ��� ���� �ڹ� ���۾ۿ���", 25.00);
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		req.setAttribute("bookList", books);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("04-quizTest.jsp");
		dispatcher.forward(req, resp);
	}
	
}
