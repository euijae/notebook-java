package codingproblems.ctci.ch7.q2;

public class Manager extends Employee {
	public Manager(CallCenter callCenter) {
		super(callCenter);
		rank = Rank.Manager;
	}
}
