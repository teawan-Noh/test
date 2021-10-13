package jstl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jstl.medel.Book;
import jstl.medel.Dog;

@WebServlet(urlPatterns= {"/jstlTest"})
public class jstlUseTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<String> subjects = new ArrayList<String>();
		subjects.add("music");
		subjects.add("cumputer");
		subjects.add("sience");
		
		req.setAttribute("subjectList", subjects);
		
		req.setAttribute("userType", "member");
		
		Dog dog = new Dog();
		req.setAttribute("dog", dog);
		
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		
		req.setAttribute("bookList", bookList);
		
		
		Map<String, String> nations = new HashMap<String, String>();
		nations.put("태국", "방콕");
		nations.put("말레이시아", "쿠알라룸프르");
		nations.put("인도네시아", "자카르타");
		
		req.setAttribute("nation", nations);
		
		Map<String, String> citys = new HashMap<String, String>();
		citys.put("호주", "시드니, 멜번, 퍼스");
		citys.put("인도네시아", "자카르타, 수라바야, 메단");
		citys.put("뉴질랜드", "오클랜드, 크라이스트처치, 웰링턴");
		
		req.setAttribute("city", citys);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("03-jstlUseTest.jsp");
		dispatcher.forward(req, resp);
	}
}
