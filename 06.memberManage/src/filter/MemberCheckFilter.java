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
//ȭ�鿡�� ��Ʈ�ѷ� �������� ���Ͱ� ����ȴ�
@WebFilter(filterName="MemberCheckFilter", urlPatterns="/private/*")
///private/*  : * �� ���̸� private�� �����ϴ� ��� ������ 
public class MemberCheckFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//�α����� �ƴ��� �ȵƴ��� üũ(filter) //����ȯ
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(false); // false �ȳ����鼼���� ������ �ִ°� �ְ� ������ ���� �ش�. // false�� ������ �������� �������� ������ ���������� �ֶ�
		
		boolean login = false;
		
		if(session != null) {
			if(session.getAttribute("member")!=null) {
				login = true;
			}
		}
		if(login) {
			chain.doFilter(request, response); //�α����� �Ǿ������� filter�� ������ controller ������
		}
		else {
			//���� ����ȯ
			((HttpServletResponse)response).sendRedirect("/06.memberManage/login_input");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
