package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.service.UserService;
import cybersoft.javabackend.java14.crm.util.UrlConst;
import cybersoft.javabackend.java14.crm.util.JspConst;

@WebServlet(
		name = "userServlet",
		urlPatterns = {
				UrlConst.DASHBOARD,		
				UrlConst.USER_LIST,
				UrlConst.USER_DELETE,
				UrlConst.USER_UPDATE
		}
)
public class UserServlet extends HttpServlet {
	private UserService service;
	private String action;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new UserService();
		action = "";
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getServletPath();
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		
		switch (action) {
			case UrlConst.DASHBOARD:
				req.getRequestDispatcher(JspConst.DASHBOARD).forward(req, resp);
				break;
			case UrlConst.USER_LIST:
				req.setAttribute("users", service.getUsers());
				req.getRequestDispatcher(JspConst.USER_LIST).forward(req,resp);
				break;
			case UrlConst.USER_UPDATE:
				int userID = Integer.parseInt(req.getParameter("id"));
				req.setAttribute("user", service.getOneUser(userID));
				req.getRequestDispatcher(JspConst.USER_UPDATE).forward(req,resp);
				break;
			case UrlConst.USER_DELETE:
				int UserID = Integer.parseInt(req.getParameter("id"));
				service.removeUser(UserID);
				resp.sendRedirect(req.getContextPath() + UrlConst.USER_LIST);
				break;
			default:
				break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

//		if(type.equalsIgnoreCase(req.getParameter("updateUser"))) {
		
			int userID = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String role = req.getParameter("role");
			
			service.updateUser(userID, name, email, phone, address, role);
			resp.sendRedirect(req.getContextPath() + UrlConst.USER_LIST);
//		}
	}

}
