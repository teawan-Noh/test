package listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//Listener: server 올릴 때 실행됨 
@WebListener
public class SessionListener implements ServletContextListener, HttpSessionListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("서버 올라갔어~");
		ServletContext context = sce.getServletContext();
		context.setAttribute("userCounter", new AtomicInteger());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("서버 내렸어~");
		
	}
	//세션은 브라우저가 열릴때마다 생성된다
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//System.out.println("세션이 생성됄때");
		
		HttpSession session = se.getSession(); //세션을 만들고
		ServletContext context = session.getServletContext(); //context를 가져오고
		AtomicInteger userCounter = (AtomicInteger)context.getAttribute("userCounter"); //set해놓은애를 가져온다 , context의 기본형은 Object이므로 형변환
		
		int userCount = userCounter.incrementAndGet(); //유저가 접속할때마다 1씩 증가하여 들어간다
		
		//System.out.println("userCount 증가" + userCount);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//System.out.println("세션이 소멸됄때");
		
		HttpSession session = se.getSession(); //세션을 만들고
		ServletContext context = session.getServletContext(); //context를 가져오고
		AtomicInteger userCounter = (AtomicInteger)context.getAttribute("userCounter"); //set해놓은애를 가져온다 , context의 기본형은 Object이므로 형변환
		
		int userCount = userCounter.decrementAndGet(); //유저가 소멸될 때마다 1씩 감소하여 들어간다
		
		//System.out.println("userCount 증가" + userCount);
	}
}
