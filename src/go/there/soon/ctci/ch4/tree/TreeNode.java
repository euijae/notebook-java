package go.there.soon.ctci.ch4.tree;

public class TreeNode<T extends Comparable<T>> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	public T data;
	
	public TreeNode() {}
	
	public TreeNode(T data) {
		this.data  = data;
		this.left  = null;
		this.right = null;
	}
	
	public void setBoth(TreeNode<T> left, TreeNode<T> right) {
		this.left = left;
		this.right = right;
	}
	
	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
