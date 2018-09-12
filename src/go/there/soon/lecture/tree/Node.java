package go.there.soon.lecture.tree;

public class Node<T extends Comparable<T>> {
	public T data;
	public Node<T> left, right;
	
	public Node(T data, Node<T> l, Node<T> r) {
		this.left = l;
		this.right = r;
		this.data = data;
	}
	
	public Node(T data) {
		left = right = null;
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
