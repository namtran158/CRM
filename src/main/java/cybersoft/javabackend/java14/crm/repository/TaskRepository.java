package cybersoft.javabackend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.javabackend.java14.crm.datasource.DbQuery;
import cybersoft.javabackend.java14.crm.datasource.MySQLConnection;
import cybersoft.javabackend.java14.crm.entity.Project;
import cybersoft.javabackend.java14.crm.entity.Role;
import cybersoft.javabackend.java14.crm.entity.Status;
import cybersoft.javabackend.java14.crm.entity.Task;
import cybersoft.javabackend.java14.crm.entity.User;

public class TaskRepository {
	public List<Task> getTasks(){
		List<Task> tasks = new LinkedList<Task>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = DbQuery.TASK_LIST;
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart_date(rs.getString("task_start_date"));
				task.setEnd_date(rs.getString("task_end_date"));
				
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				
				Role role = new Role();
				role.setId(rs.getInt("role_id"));
				role.setName(rs.getString("role_name"));
				role.setDescription(rs.getString("role_description"));
				
				user.setRole(role);
				task.setUser(user);
				
				Project project = new Project();
				project.setId(rs.getInt("project_id"));
				project.setName(rs.getString("project_name"));
				project.setDescription(rs.getString("project_description"));
				project.setStart_date(rs.getString("project_start_date"));
				project.setEnd_date(rs.getString("project_end_date"));
				project.setUser(user);
				
				task.setProject(project);
				
				Status status = new Status();
				status.setId(rs.getInt("status_id"));
				status.setName(rs.getString("status_name"));
				status.setDescription(rs.getString("status_description"));
				
				task.setStatus(status);
				
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} 
		return tasks;
	}
	
	public int addTask(String name, String description, String start_date, String end_date, String user_name, String status_name, String project_name) {
		try {
			Connection connection = MySQLConnection.getConnection();
			
			String query1 = DbQuery.TASK_ADD;
			PreparedStatement statement1 = connection.prepareStatement(query1);
			
			String query2 = DbQuery.GET_ONE_USER_BY_NAME;
			PreparedStatement statement2 = connection.prepareStatement(query2);
			ResultSet rs2 = statement2.executeQuery();
			statement2.setString(1, user_name);
			
			int user_id = rs2.getInt("user_id");
			
			String query3 = DbQuery.GET_ONE_PROJECT_BY_NAME;
			PreparedStatement statement3 = connection.prepareStatement(query3);
			ResultSet rs3 = statement3.executeQuery();
			statement3.setString(1, project_name);
			
			int project_id = rs3.getInt("id");
			
			int status_id;
			if(status_name.equals("Completed")) {
				status_id = 1;
			} else if(status_name.equals("Processing")) {
				status_id = 2;
			} else {
				status_id = 3;
			}
			
			
			statement1.setString(1, name);
			statement1.setString(2, description);
			statement1.setString(3, start_date);
			statement1.setString(4, end_date);
			statement1.setInt(5, user_id);
			statement1.setInt(6, status_id);
			statement1.setInt(7, project_id);
			
			return statement1.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateTask() {
		
		return 0;
	}
	public int removeTask(int id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.TASK_REMOVE;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
}
