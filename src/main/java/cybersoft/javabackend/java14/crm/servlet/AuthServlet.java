package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.javabackend.java14.crm.entity.User;
import cybersoft.javabackend.java14.crm.repository.UserRepository;
import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	private UserRepository repository = null;
	
	public AuthServlet() {
		repository = new UserRepository();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String action = req.getParameter("action");
		if(action != null && !action.isEmpty()) {
			HttpSession session = req.getSession();
			session.removeAttribute("user");
		}
		req.getRequestDispatcher(JspConst.LOGIN).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = repository.checkLogin(email, password);
		if(user != null && user.getEmail() != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect(req.getContextPath() + UrlConst.DASHBOARD);
		} else {
			req.setAttribute("error", "Tai khoan hoac mat khau khong dung!");
			req.getRequestDispatcher(JspConst.LOGIN).forward(req, resp);
			
		}
	}
}
