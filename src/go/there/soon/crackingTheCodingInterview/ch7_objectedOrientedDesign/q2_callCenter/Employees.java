package go.there.soon.crackingTheCodingInterview.ch7_objectedOrientedDesign.q2_callCenter;

import java.util.Stack;

public class Employees <T>{
	private Stack<T> available;
	private Stack<T> unavailable;
	
	public Employees(Stack<T> employees) {
		available = employees;
		unavailable = new Stack<>();
	}
	
	public boolean isAvailable() {
		return !available.isEmpty();
	}
	
	public boolean rearrange() {
		if(isAvailable()) {
			T employee = available.pop();
			unavailable.push(employee);
			return true;
		} 

		return false;
	}
}
