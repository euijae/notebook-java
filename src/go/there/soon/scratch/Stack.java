package go.there.soon.scratch;

import java.util.EmptyStackException;

public class Stack<T extends Comparable<T>> {
	private StackNode<T> top;
	public Stack() {}
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public void push(T data) {
		StackNode<T> node = new StackNode<>(data);
		if(top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
	}
	
	public T peek() {
		if(top == null) 
			throw new EmptyStackException();
		
		return top.data;
	}
	
	public T pop() {
		if(top == null) 
			throw new EmptyStackException();
		
		T topData = top.data;
		top = top.next;
		return topData;
	}
	
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		StackNode<T> tempTop = top;
		
		while(tempTop != null) {
			sb.append(tempTop.data);
			sb.append((tempTop.next != null) ? ", " : "");
			tempTop = tempTop.next;
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
