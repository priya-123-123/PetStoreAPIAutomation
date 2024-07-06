package pojo;

public class CategoryPOJO {
	private int id;
	private String name;
	
	public CategoryPOJO() {
		super();
	}
	public CategoryPOJO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
	public boolean equals(CategoryPOJO pg) {
		return (pg.id==this.id) && (pg.name.equals(this.name));
	}
	
	

}
