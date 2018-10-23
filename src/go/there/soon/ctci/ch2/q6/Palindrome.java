package go.there.soon.ctci.ch2.q6;

import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {
		char [] arr = {'c','a','b','b','a','c'};
		
		Node [] nodes = new Node[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			nodes[i] = new Node(arr[i]);
			if(i > 0) {
				nodes[i-1].next = nodes[i];
				if(i == arr.length-1)
					nodes[i].next = null;
			}
		}
		
		System.out.println(sol1(nodes[0], nodes[0]));
		System.out.println(sol2(nodes[0], nodes[0]));
		System.out.println(sol3(nodes[0], nodes[0]));
	}

	public static boolean sol3(Node head1, Node head2) {
		Node reverseHead = reverse(head1);
		Node originalHead = head2;
		
		while(originalHead != null) {
			if(originalHead.data != reverseHead.data)
				return false;
			originalHead = originalHead.next;
			reverseHead = reverseHead.next;
		}
		
		return true;
	}
	
	public static boolean sol2(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return false;
		
		Node p1 = head1;
		Node p2 = head2;
		
		Stack<Node> stack = new Stack<>();
		while(p2 != null && p2.next != null) {
			stack.push(p1);
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		if(p2 != null)
			p1 = p1.next;
		
		while(!stack.isEmpty()) {
			Node top = stack.pop();
			if(top.data != p1.data) {
				return false;
			}
			
			p1 = p1.next;
		}
		
		return true;
	}
	
	public static boolean sol1(Node p1, Node p2) {
		if(p1==null || p2 == null)
			return false;
		
		return sol1Helper(p1, p2, true, false, false);
	}
	
	public static boolean sol1Helper(
			Node p1, 
			Node p2, 
			boolean isPalindrome, 
			boolean isReachedLast, 
			boolean isCrossed) {
		
		if(isReachedLast && p1 == p2) {
			isCrossed = true;
		}
		
		if(isCrossed) {
			return isPalindrome;
		}
		
		if(p2.next == null) {
			isReachedLast = true;
			return isPalindrome && p1.data == p2.data;
		} else {
			if(!isReachedLast) {
				return sol1Helper(p1, p2.next, isPalindrome, isReachedLast, isCrossed);
			} else {
				return isPalindrome && p1.next.data == p2.data;
			}
		}
	}
	
	public static Node reverse(Node head) {
		Node p1 = head;
		Node p2 = p1.next;
		
		p1.next = null;
		
		while(p2 != null) {
			Node p2Next = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p2Next;
		}
		
		return p1;
	}
	
	public static void print(Node head) {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		
		System.out.println("");
	}
}

class Node {
	Node next;
	char data;
	
	Node(char d) {
		data = d;
		next = null;
	}
}