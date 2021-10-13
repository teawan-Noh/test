package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//ServletContextListener: server 올릴 때 실행됨 
@WebListener
public class AppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("서버 올라갔어~");
		ServletContext context = sce.getServletContext();
		Map<String, String> countries = new HashMap<>();
		countries.put("kr", "대한민국");
		countries.put("us", "미국");
		context.setAttribute("countries", countries);
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("서버 내렸어~");
		
	}
	
	
}
