package cybersoft.javabackend.java14.crm.entity;

public class Status {
	/* properties */
	private int id;
	private String name;
	private String description;
	
	/* constructors */
	public Status() {
		// TODO Auto-generated constructor stub
	}

	public Status(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/* getters/setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/* methods */
}
