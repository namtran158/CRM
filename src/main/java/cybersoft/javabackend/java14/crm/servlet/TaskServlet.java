package cybersoft.javabackend.java14.crm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.java14.crm.service.TaskService;
import cybersoft.javabackend.java14.crm.service.UserService;
import cybersoft.javabackend.java14.crm.util.JspConst;
import cybersoft.javabackend.java14.crm.util.UrlConst;

@WebServlet(name = "taskServlet", urlPatterns = {
		UrlConst.TASK_UPDATE,
		UrlConst.TASK_LIST,
		UrlConst.TASK_DELETE
})
public class TaskServlet extends HttpServlet {
	private String action;
	private TaskService service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new TaskService();
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
			case UrlConst.TASK_LIST:
				req.setAttribute("tasks", service.getTasks());
				req.getRequestDispatcher(JspConst.TASK_LIST).forward(req, resp);
				break;
			case UrlConst.TASK_UPDATE:
				
				break;
			case UrlConst.TASK_DELETE:
				int id = Integer.parseInt(req.getParameter("id"));
				service.removeTask(id);
				resp.sendRedirect(req.getContextPath() + UrlConst.TASK_LIST);
				break;
		}
	}
}
