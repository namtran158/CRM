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
import cybersoft.javabackend.java14.crm.entity.User;

public class ProjectRepository {
	public List<Project> getProjects() {
		List<Project> projects = new LinkedList<Project>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = DbQuery.PROJECT_WITH_USER;
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Project project = new Project();
				project.setId(rs.getInt("project_id"));
				project.setName(rs.getString("project_name"));
				project.setDescription(rs.getString("project_description"));
				project.setStart_date(rs.getString("start_date"));
				project.setEnd_date(rs.getString("end_date"));
				
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
				project.setUser(user);
				
				projects.add(project);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} 
		
		return projects;
	}
	
	public int updateProject(int id, String name, String description, String start_date, String end_date, String leader_name) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.PROJECT_UPDATE;
			
			PreparedStatement statement = connection.prepareStatement(query);
			UserRepository userRepository = new UserRepository();
			User user = userRepository.getOneUserByName(leader_name);
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setString(3, start_date);
			statement.setString(4, end_date);
			statement.setInt(5, user.getId());
			statement.setInt(6, id);
			
			return statement.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Không thể kết nối đến database");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int addProject(String name, String description, String start_date, String end_date, String leader_name) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.PROJECT_ADD;
			PreparedStatement statement = connection.prepareStatement(query);
			UserRepository userRepository = new UserRepository();
			User user = userRepository.getOneUserByName(leader_name);
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setString(3, start_date);
			statement.setString(4, end_date);
			statement.setInt(5, user.getId());
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int removeProject(int id) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.PROJECT_REMOVE;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public List<User> getLeader(){
		List<User> users = new LinkedList<User>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = DbQuery.USER_LEADER;
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
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
				
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} 
		return users;
	}
}
