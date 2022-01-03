package cybersoft.javabackend.java14.crm.service;

import java.util.List;

import cybersoft.javabackend.java14.crm.entity.Task;
import cybersoft.javabackend.java14.crm.repository.TaskRepository;

public class TaskService {
	private TaskRepository repository;
	
	public TaskService() {
		repository = new TaskRepository();
	}
	public List<Task> getTasks(){
		return repository.getTasks();
	} 
	public boolean addTask(String name, String description, String start_date, String end_date, String user_name, String status_name, String project_name) {
		return repository.addTask(name, description, start_date, end_date, user_name, status_name, project_name) == 1 ? true : false;
	}
	public boolean removeTask(int id) {
		return repository.removeTask(id) == 1 ? true : false;
	}
}
