package main.java.datastructures.common;

public class TreeNode<T extends Comparable<T>> {

	private TreeNode<T> root;
	private TreeNode<T> left;
	private TreeNode<T> right;
	private T data;
	private int horizonDistance;

	public TreeNode(TreeNode<T> root) {
		this.root = root;
		this.left = root.left;
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
	public int getHorizonDistance() {
		return horizonDistance;
	}
	public void setHorizonDistance(int horizonDistance) {
		this.horizonDistance = horizonDistance;
	}
	public TreeNode<T> getRoot() {
		return root;
	}
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
}
