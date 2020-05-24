package codingproblems.scratch;

public class QueueNode<T extends Comparable<T>> {
	public QueueNode<T> next;
	public T data;
	public QueueNode(T data) {
		this.data = data;
	}
}
