package codingproblems.scratch;

import java.util.NoSuchElementException;

public class Queue<T extends Comparable<T>> {
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void add(T item) {
		QueueNode<T> t = new QueueNode<>(item);
		
		if(last != null) {
			last.next = t;
		}
		
		last = t;
		
		if(first == null) 
			first = last;
	}
	
	public T peek() {
		if(isEmpty())
			throw new NoSuchElementException("no elem");
		
		return first.data;
	}
	
	public T remove() {
		if(isEmpty())
			throw new NoSuchElementException("no elem");
		
		T firstItem = first.data;
		first = first.next;
		
		if(first == null)
			last = null;
		
		return firstItem;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		QueueNode<T> temp = first;
		
		while(temp != null) {
			sb.append(temp.data);
			temp = temp.next;
			
			if(temp != null)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
