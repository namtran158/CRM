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

@WebServlet(name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT_LIST,
		UrlConst.PROJECT_UPDATE,
		UrlConst.PROJECT_DELETE
})
public class ProjectServlet extends HttpServlet {
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
		
		switch(action) {
			case UrlConst.PROJECT_LIST:
				req.setAttribute("projects", service.getProjects());
				req.getRequestDispatcher(JspConst.PROJECT_LIST).forward(req, resp);
				break;
			case UrlConst.PROJECT_UPDATE:
				req.setAttribute("users", service.getLeader());
				req.getRequestDispatcher(JspConst.PROJECT_UPDATE).forward(req,resp);
				break;
			case UrlConst.PROJECT_DELETE:
				int id = Integer.parseInt(req.getParameter("id"));
				service.removeProject(id);
				resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_LIST);
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
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String start_date = req.getParameter("start-date");
		String end_date = req.getParameter("end-date");
		String leader_name = req.getParameter("leader");
		
		service.updateProject(id, name, description, start_date, end_date, leader_name);
		resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_LIST);
	}
}
