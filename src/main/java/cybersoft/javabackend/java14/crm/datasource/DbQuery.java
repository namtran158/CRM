package cybersoft.javabackend.java14.crm.datasource;

public class DbQuery {
	/* USER */
	public static final String USER_WITH_ROLE = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u LEFT JOIN crm_role r ON  u.role_id = r.id";
	public static final String USER_UPDATE ="UPDATE crm_user SET name = ?, email = ?, phone = ?, address = ?, role_id = ? WHERE id = ?";
	public static final String GET_ONE_USER = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u LEFT JOIN crm_role r ON  u.role_id = r.id WHERE u.id = ?";
	public static final String USER_REMOVE ="DELETE FROM crm_user WHERE id = ?";
	public static final String USER_ADD = "INSERT crm_user(name, email, password, phone, address, role_id) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String USER_LEADER = "SELECT u.id as user_id, u.name as user_name, u.email, u.password, u.phone, u.address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u INNER JOIN crm_role r ON u.role_id = r.id WHERE r.name = 'ROLE_LEADER'";
	public static final String GET_ONE_USER_BY_NAME = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u INNER JOIN crm_role r ON  u.role_id = r.id WHERE u.name = ?";
	public static final String USER_ROLE_MEMBER = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u LEFT JOIN crm_role r ON  u.role_id = r.id WHERE u.role_id = 3";
	
	/* PROJECT */
	public static final String PROJECT_WITH_USER = "SELECT p.id as project_id, p.name as project_name, p.description as project_description, p.start_date, p.end_date, u.id as user_id, u.name as user_name, u.email, u.password, u.phone, u.address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_project p INNER JOIN crm_user u INNER JOIN crm_role r ON p.user_id = u.id AND u.role_id = r.id";
	public static final String PROJECT_UPDATE = "UPDATE crm_project SET name = ?, description = ?, start_date = ?, end_date = ? user_id = ? WHERE id = ?";
	public static final String PROJECT_ADD = "INSERT INTO crm_project(name, description, start_date, end_date, user_id) VALUES (?, ?, ?, ?, ?)";
	public static final String PROJECT_REMOVE = "DELETE FROM crm_project WHERE id = ?";
	public static final String GET_ONE_PROJECT_BY_NAME = "SELECT id FROM crm_project WHERE name = ?";
	
	/* TASK */
	public static final String TASK_LIST = "SELECT t.id as task_id, t.name as task_name, t.description as task_description, t.start_date as task_start_date, t.end_date as task_end_date, u.id as user_id, u.name as user_name, u.email, u.password, u.phone, u.address, r.id as role_id, r.name as role_name, r.description as role_description, p.id as project_id, p.name as project_name, p.description as project_description, p.start_date as project_start_date, p.end_date as project_end_date, stt.id as status_id, stt.name as status_name, stt.description as status_description  FROM crm_task t INNER JOIN crm_user u INNER JOIN crm_role r INNER JOIN crm_project p INNER JOIN crm_status stt ON t.user_id = u.id AND t.project_id = p.id AND t.status_id = stt.id AND r.id = u.role_id";
	public static final String TASK_ADD = "INSERT INTO crm_task(name, description, start_date, end_date, user_id, status_id, project_id) VALUES(?,?,?,?,?,?,?)";
	public static final String TASK_REMOVE = "DELETE FROM crm_task WHERE id = ?";
	
	/* CHECK LOGIN */
	public static final String CHECK_LOGIN = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, description FROM crm_user u LEFT JOIN crm_role r ON u.role_id = r.id WHERE email = ? AND password = ?";
}
