package cybersoft.javabackend.java14.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cybersoft.javabackend.java14.crm.entity.User;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebFilter(urlPatterns = {
		UrlConst.DASHBOARD, UrlConst.PROJECT_ADD, UrlConst.PROJECT_DELETE, UrlConst.PROJECT_LIST,
		UrlConst.PROJECT_UPDATE, UrlConst.TASK_ADD, UrlConst.TASK_DELETE, UrlConst.TASK_LIST,
		UrlConst.TASK_UPDATE, UrlConst.USER_ADD, UrlConst.USER_DELETE, UrlConst.USER_LIST,
		UrlConst.USER_UPDATE
		
})
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null) {
			chain.doFilter(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/auth");
		}
		
		
	}

}
