package go.there.soon.ctci.ch3.q6.animal;

public abstract class Animal {
	private String name;
	private int order;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
}
