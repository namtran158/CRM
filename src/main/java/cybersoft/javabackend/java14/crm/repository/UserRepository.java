package cybersoft.javabackend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.javabackend.java14.crm.datasource.DbQuery;
import cybersoft.javabackend.java14.crm.datasource.MySQLConnection;
import cybersoft.javabackend.java14.crm.entity.Role;
import cybersoft.javabackend.java14.crm.entity.User;

public class UserRepository {
	public List<User> getUsers() {
		List<User> users = new LinkedList<User>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = DbQuery.USER_WITH_ROLE;
			
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
	
	public List<User> getUserRoleMember() {
		List<User> users = new LinkedList<User>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = DbQuery.USER_ROLE_MEMBER;
			
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
	
	public int updateUser(int userID, String name, String email, String phone, String address, String role) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.USER_UPDATE;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			int role_id;
			if(role.equals("ROLE_LEADER")) {
				role_id = 2;
			} else if(role.equals("ROLE_ADMIN")) {
				role_id = 1;
			} else {
				role_id = 3;
			}
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, phone);
			statement.setString(4, address);
			statement.setInt(5, role_id);
			statement.setInt(6, userID);
			
			
			
			return statement.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Không thể kết nối đến database");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int addUser(String name, String email, String password, String phone, String address, String role) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.USER_ADD;
			PreparedStatement statement = connection.prepareStatement(query);
			int role_id;
			if(role.equals("ROLE_LEADER")) {
				role_id = 2;
			} else if(role.equals("ROLE_ADMIN")) {
				role_id = 1;
			} else {
				role_id = 3;
			}
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, phone);
			statement.setString(5, address);
			statement.setInt(6, role_id);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int removeUser(int UserID) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.USER_REMOVE;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, UserID);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public User getOneUserByName(String name) {
		User user = new User();
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.GET_ONE_USER_BY_NAME;
			
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, name);
			
			ResultSet rs = statement.executeQuery();
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
		} catch(SQLException e) {
			System.out.println("Không thể kết nối đến database");
			e.printStackTrace();
		}
		
		return user;
	}
	public User getOneUser(int id) {
		User user = new User();
		Role role = new Role();
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.GET_ONE_USER;
			
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			user.setId(rs.getInt("user_id"));
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			
			role.setId(rs.getInt("role_id"));
			role.setName(rs.getString("role_name"));
			role.setDescription(rs.getString("role_description"));
			
			user.setRole(role);
		} catch(SQLException e) {
			System.out.println("Không thể kết nối đến database");
			e.printStackTrace();
		}
		
		return user;
	}

	public User checkLogin(String email, String password) {
		User user = new User();
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.CHECK_LOGIN;
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				
				Role role = new Role();
				role.setId(rs.getInt("role_id"));
				role.setName(rs.getString("role_name"));
				role.setDescription(rs.getString("description"));
				
				user.setRole(role);
			}
			
			
		} catch(SQLException e) {
			System.out.println("Không thể kết nối đến database");
			e.printStackTrace();
		}
		return user;
	}
}
