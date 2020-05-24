package codingproblems.ctci.ch7.q2;

public class Caller {
	private String name;
	private int id;
	
	public Caller(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/** Setters and getters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
