package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//화면에서 컨트롤러 가기전에 필터가 실행된다
@WebFilter(filterName="MemberCheckFilter", urlPatterns="/private/*")
///private/*  : * 을 붙이면 private로 시작하는 모든 페이지 
public class MemberCheckFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//로그인이 됐는지 안됐는지 체크(filter) //형변환
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(false); // false 안넣으면세션이 있으면 있는걸 주고 없으면 만들어서 준다. // false를 넣으면 있을때만 가져오고 없으면 만들지말고 둬라
		
		boolean login = false;
		
		if(session != null) {
			if(session.getAttribute("member")!=null) {
				login = true;
			}
		}
		if(login) {
			chain.doFilter(request, response); //로그인이 되어있으면 filter를 지나서 controller 실행해
		}
		else {
			//강제 형변환
			((HttpServletResponse)response).sendRedirect("/06.memberManage/login_input");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
