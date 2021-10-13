package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//ServletContextListener: server �ø� �� ����� 
@WebListener
public class AppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("���� �ö󰬾�~");
		ServletContext context = sce.getServletContext();
		Map<String, String> countries = new HashMap<>();
		countries.put("kr", "���ѹα�");
		countries.put("us", "�̱�");
		context.setAttribute("countries", countries);
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("���� ���Ⱦ�~");
		
	}
	
	
}
