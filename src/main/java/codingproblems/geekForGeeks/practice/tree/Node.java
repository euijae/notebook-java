package codingproblems.geekForGeeks.practice.tree;

public class Node {
	public int data;
	public int hd;
	public Node left;
	public Node right;

	public Node() {}
	
	public Node(Node p, int hd) {
		this.data = p.data;
		this.left = p.left;
		this.right = p.right;
		this.hd = hd;
	}
	
	public Node(Node p) {
		this.data = p.data;
		this.left = p.left;
		this.right = p.right;
	}
	
	public Node(int data) {
		this.data  = data;
		this.right = null;
		this.left  = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}
}
