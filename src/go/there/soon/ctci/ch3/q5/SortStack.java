package go.there.soon.ctci.ch3.q5;

import java.util.Stack;

public class SortStack<T extends Comparable<T>> {

	public static void main(String[] args) {
		SortStack<Integer> ss = new SortStack<Integer>();
		Stack<Integer> s = new Stack<>();
		s.push(4);
		s.push(2);
		s.push(5);
		s.push(3);
		System.out.println(s);
		ss.sort(s);
		System.out.println(s);
		System.out.println(s.peek());
	}
	
	public void sort(Stack<T> s) {
		Stack<T> temp = new Stack<>();
		
		while(!s.isEmpty()) {
			temp.push(s.pop());
		}
		
		while(!temp.isEmpty()) {
			T data = temp.pop();
			
			while(!s.isEmpty() && data.compareTo(s.peek()) > 0) {
				temp.push(s.pop());
			}
			
			s.push(data);
		}
	}
}
