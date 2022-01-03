package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.service.ProjectService;
import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet(urlPatterns = {
		UrlConst.PROJECT_ADD
})
public class AddProjectServlet extends HttpServlet {
	private String action;
	private ProjectService service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProjectService();
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
		
		req.setAttribute("users", service.getLeader());
		req.getRequestDispatcher(JspConst.PROJECT_ADD).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String start_date = req.getParameter("start-date");
		String end_date = req.getParameter("end-date");
		String leader_name = req.getParameter("leader");
		
		service.addProject(name, description, start_date, end_date, leader_name);
		resp.sendRedirect(req.getContextPath() +UrlConst.PROJECT_LIST);
	}
}
