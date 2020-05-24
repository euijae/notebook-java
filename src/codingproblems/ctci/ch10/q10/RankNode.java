package codingproblems.ctci.ch10.q10;

public class RankNode {
	public RankNode left;
	public RankNode right;
	public int leftSize;
	public int data;
	
	public RankNode(int data) {
		this.data = data;
		this.leftSize = 0;
	}
	
	public void setBoth(RankNode left, RankNode right) {
		this.left = left;
		this.right = right;
	}
}
