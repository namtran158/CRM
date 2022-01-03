package cybersoft.javabackend.java14.crm.service;

import java.util.List;

import cybersoft.javabackend.java14.crm.entity.User;
import cybersoft.javabackend.java14.crm.repository.UserRepository;

public class UserService {
	private UserRepository repository;
	
	public UserService() {
		repository = new UserRepository();
	}

	public List<User> getUsers() {
		return repository.getUsers();
	}
	
	public List<User> getUserRoleMember() {
		return repository.getUserRoleMember();
	}
	
	public User getOneUser(int id) {
		return repository.getOneUser(id);
	}
	
	public boolean updateUser(int userID, String name, String email, String phone, String address, String role) {		
		return repository.updateUser(userID, name, email, phone, address, role) == 1 ? true : false;
	}
	
	public boolean removeUser(int userID) {
		return repository.removeUser(userID) == 1 ? true : false;
	}
	
	public boolean addUser(String name, String email, String password, String phone, String address, String role) {
		return repository.addUser(name, email, password, phone, address, role) == 1 ? true : false;
	}
	

}
