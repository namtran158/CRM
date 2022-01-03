package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.service.ProjectService;
import cybersoft.javabackend.java14.crm.service.TaskService;
import cybersoft.javabackend.java14.crm.service.UserService;
import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet(urlPatterns = {
		UrlConst.TASK_ADD
})
public class AddTaskServlet extends HttpServlet {
	private ProjectService projectService;
	private UserService userService;
	private TaskService service;
	
	@Override
	public void init() throws ServletException {
		projectService = new ProjectService();
		userService = new UserService();
		service = new TaskService();
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		req.setAttribute("projects", projectService.getProjects());
		req.setAttribute("users", userService.getUserRoleMember());
		req.getRequestDispatcher(JspConst.TASK_ADD).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String project = req.getParameter("project");
		String user = req.getParameter("user");
		String status = req.getParameter("status");
		
		
		service.addTask(name, description, start_date, end_date, user, status, project);
		resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
		
	}
}
