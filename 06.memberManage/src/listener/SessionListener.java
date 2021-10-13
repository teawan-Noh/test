package listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//Listener: server �ø� �� ����� 
@WebListener
public class SessionListener implements ServletContextListener, HttpSessionListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("���� �ö󰬾�~");
		ServletContext context = sce.getServletContext();
		context.setAttribute("userCounter", new AtomicInteger());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("���� ���Ⱦ�~");
		
	}
	//������ �������� ���������� �����ȴ�
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//System.out.println("������ �����ƶ�");
		
		HttpSession session = se.getSession(); //������ �����
		ServletContext context = session.getServletContext(); //context�� ��������
		AtomicInteger userCounter = (AtomicInteger)context.getAttribute("userCounter"); //set�س����ָ� �����´� , context�� �⺻���� Object�̹Ƿ� ����ȯ
		
		int userCount = userCounter.incrementAndGet(); //������ �����Ҷ����� 1�� �����Ͽ� ����
		
		//System.out.println("userCount ����" + userCount);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//System.out.println("������ �Ҹ�ƶ�");
		
		HttpSession session = se.getSession(); //������ �����
		ServletContext context = session.getServletContext(); //context�� ��������
		AtomicInteger userCounter = (AtomicInteger)context.getAttribute("userCounter"); //set�س����ָ� �����´� , context�� �⺻���� Object�̹Ƿ� ����ȯ
		
		int userCount = userCounter.decrementAndGet(); //������ �Ҹ�� ������ 1�� �����Ͽ� ����
		
		//System.out.println("userCount ����" + userCount);
	}
}
