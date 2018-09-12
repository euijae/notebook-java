package go.there.soon.geekForGeeks.practice.tree;

public class MaximumSumPath {
	
	public int maxSumPath(Node p) {
		if(p == null) return 0;
		
		return p.data + maxSumUtil(p.left) + maxSumUtil(p.right);
	}
	
	public int maxSumUtil(Node p) {
		if(p == null || p.data < 0) return 0;
		
		int parent = p.data;
		int lvalue = (p.left == null) ? Integer.MIN_VALUE : p.left.data;
		int rvalue = (p.right == null) ? Integer.MIN_VALUE : p.right.data;
		
		return parent + maxSumUtil((lvalue < rvalue) ? p.right : p.left);
	}
}
