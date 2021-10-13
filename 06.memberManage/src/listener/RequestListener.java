package listener;


import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
//Listener: server 棵副 锭 角青凳 
@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
//		System.out.println("夸没吭绢");
		ServletRequest request = sre.getServletRequest();
		request.setAttribute("start", System.nanoTime());
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
//		System.out.println("夸没贸府 场车绢");
		long end = System.nanoTime();
		
		ServletRequest request = sre.getServletRequest();
		long start = (long)request.getAttribute("start");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String uri = httpServletRequest.getRequestURI();
		
		System.out.println(uri + " 夸没贸府矫埃: " + ((end - start)/1000) + "ms");
	}
}
