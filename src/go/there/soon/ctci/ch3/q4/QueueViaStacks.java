package go.there.soon.ctci.ch3.q4;

import java.util.Stack;

public class QueueViaStacks {

	public static void main(String[] args) {
		QueueViaStacks qvs = new QueueViaStacks();
		qvs.test();
	}
	
	public void test() {
		QueueStack<Integer> qs = new QueueStack<>();
		qs.push(1);
		qs.push(2);
		qs.push(3);
		qs.push(4);
		qs.printS1();
		qs.printS2();
		System.out.println("removed: " + qs.remove());
		qs.printS1();
		qs.printS2();
		qs.push(5);
		qs.printS1();
		qs.printS2();
		System.out.println("peeked: " + qs.peek());
	}
	
	private class QueueStack<T> {
		private Stack<T> s1;
		private Stack<T> s2;
		
		public QueueStack() {
			s1 = new Stack<>();
			s2 = new Stack<>();
		}
		
		public void push(T item) {
			shiftBack();
			s1.push(item);
		}
		
		public T remove() {
			shiftToOldest();
			return s2.pop();
		}
		
		public T peek() {
			shiftToOldest();
			return s2.peek();
		}
		
		private void shiftToOldest() {
			if(s2.isEmpty()) 
				while(!s1.isEmpty())
					s2.push(s1.pop());
		}
		
		private void shiftBack() {
			if(s1.isEmpty() && !s2.isEmpty()) 
				while(!s2.isEmpty())
					s1.push(s2.pop());
		}
		
		public void printS1() {
			System.out.println("s1: " + s1);
		}
		
		public void printS2() {
			System.out.println("s2: " + s2);
		}
	}
}
