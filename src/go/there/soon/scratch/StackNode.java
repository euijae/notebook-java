package go.there.soon.scratch;

public class StackNode<T extends Comparable<T>> {
	public StackNode<T> next;
	public T data;
	
	public StackNode(T data) {
		this.data = data;
		this.next = null;
	}
}
