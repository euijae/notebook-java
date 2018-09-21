package go.there.soon.crackingTheCodingInterview.ch7_objectedOrientedDesign.q2_callCenter;

public class Call<T> {
	private boolean isComplete;
	private Employees<T> assignedTo;
	
	public Call() {
		isComplete = false;
	}
}
