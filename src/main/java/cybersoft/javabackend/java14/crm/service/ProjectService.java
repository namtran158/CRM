package cybersoft.javabackend.java14.crm.service;

import java.util.List;

import cybersoft.javabackend.java14.crm.entity.Project;
import cybersoft.javabackend.java14.crm.entity.User;
import cybersoft.javabackend.java14.crm.repository.ProjectRepository;

public class ProjectService {
	ProjectRepository repository;
	public ProjectService() {
		repository = new ProjectRepository();
	}

	public List<Project> getProjects() {
		return repository.getProjects();
	}
	
	public boolean updateProject(int id, String name, String description, String start_date, String end_date, String leader_name) {		
		return repository.updateProject(id, name, description, start_date, end_date, leader_name) == 1 ? true : false;
	}
	
	public boolean addProject(String name, String description, String start_date, String end_date, String leader_name) {
		return repository.addProject(name, description, start_date, end_date, leader_name) == 1 ? true : false;
	}
	
	public boolean removeProject(int id) {
		return repository.removeProject(id) == 1 ? true : false;
	}
	
	public List<User> getLeader() {
		return repository.getLeader();
	}
}
