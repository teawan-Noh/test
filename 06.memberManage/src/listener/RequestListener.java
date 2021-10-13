package listener;


import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
//Listener: server �ø� �� ����� 
@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
//		System.out.println("��û�Ծ�");
		ServletRequest request = sre.getServletRequest();
		request.setAttribute("start", System.nanoTime());
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
//		System.out.println("��ûó�� ������");
		long end = System.nanoTime();
		
		ServletRequest request = sre.getServletRequest();
		long start = (long)request.getAttribute("start");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String uri = httpServletRequest.getRequestURI();
		
		System.out.println(uri + " ��ûó���ð�: " + ((end - start)/1000) + "ms");
	}
}
