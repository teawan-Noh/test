package listener;


import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
//Listener: server 올릴 때 실행됨 
@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
//		System.out.println("요청왔어");
		ServletRequest request = sre.getServletRequest();
		request.setAttribute("start", System.nanoTime());
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
//		System.out.println("요청처리 끝났어");
		long end = System.nanoTime();
		
		ServletRequest request = sre.getServletRequest();
		long start = (long)request.getAttribute("start");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String uri = httpServletRequest.getRequestURI();
		
		System.out.println(uri + " 요청처리시간: " + ((end - start)/1000) + "ms");
		
		long diff = end - start;
		if(diff > 10) {
			System.out.println("#################");
			System.out.println(uri + "요청처리시간이 너무 오래 걸립니다.");
			System.out.println("#################");
		}
	}
}
