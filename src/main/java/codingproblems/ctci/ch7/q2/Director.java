package codingproblems.ctci.ch7.q2;

public class Director extends Employee {
	public Director(CallCenter callCenter) {
		super(callCenter);
		rank = Rank.Director;
	}
}
