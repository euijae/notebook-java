package go.there.soon.ctci.ch3.q2;

import java.util.Stack;

public class MinStack {

	private static Stack<Integer> s1 = new Stack<>();
	private static Stack<Integer> s2 = new Stack<>();
	
	public static void main(String[] args) {
		push1(4);
		System.out.println(s1 + ", " + min1());
		push1(1);
		System.out.println(s1 + ", " + min1());
		push1(7);
		System.out.println(s1 + ", " + min1());
		push1(5);
		System.out.println(s1 + ", " + min1());
	}

	public static void push1(int item) {
		if(s1.size() == 0) {
			s1.push(item);
		} else {
			boolean inserted = false;
			while(!inserted && !s1.isEmpty()) {
				int top = s1.peek();
				
				if(item > top) {
					top = s1.pop();
					s2.push(top);
				} else {
					s1.push(item);
					inserted = true;
				}
			}
			
			if(!inserted) {
				s1.push(item);
			}
			
			while(!s2.isEmpty()) {
				int top = s2.pop();
				s1.push(top);
			}
		}
	}
	
	public static int min1() {
		return s1.peek();
	}
}
