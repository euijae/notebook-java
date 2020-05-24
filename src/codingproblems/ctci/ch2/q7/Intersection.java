package codingproblems.ctci.ch2.q7;

import java.util.Stack;

public class Intersection {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		n7.next = n6;
		n6.next = null;
		Node ans = sol3(n1, n7);
		print(ans);
	}
	
	public static Node sol3(Node head1, Node head2) {
		int len1 = getLength(head1);
		int len2 = getLength(head2);

		Node p1 = head1;
		Node p2 = head2;
		
		if(len1 > len2) {
			p2 = padLists(p2, len1 - len2);
		} else if(len1 < len2) {
			p1 = padLists(p1, len2 - len1);
		}
		
		while(p1 != null) {
			if(p1 == p2) {
				return p1;
			} else {
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		
		return p1;
	}
	
	public static Node padLists(Node head, int diff) {
		for(int i = 0; i < diff; i++) {
			Node temp = new Node(-1);
			temp.next = head;
			head = temp;
		}
		
		return head;
	}
	
	public static int getLength(Node head) {
		Node p = head;
		int length = 0;
		while(p != null) {
			p = p.next;
			length++;
		}
		
		return length;
	}
	
	/**
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node sol2(Node head1, Node head2) {
		Stack<Node> s1 = setStack(head1);
		Stack<Node> s2 = setStack(head2);
		Node intersection = null;
		
		while(!s1.isEmpty() && !s2.isEmpty()) {
			Node p1 = s1.pop();
			Node p2 = s2.pop();
			
			if(p1 != p2) {
				return intersection;
			} else {
				intersection = p1;
			}
		}
		
		return intersection;
	}
	
	public static Stack<Node> setStack(Node head) {
		Node p = head;
		Stack<Node> s = new Stack<>();
		while(p != null) {
			s.push(p);
			p = p.next;
		}
		return s;
	}
	
	/**
	 * brute-force
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node sol1(Node head1, Node head2) {
		if(head1 == null || head2 ==null) 
			return (head1 == null) ? head2 : head1;

		if(head1 == head2)
			return head1;
		
		Node p1 = head1;
		
		while(p1 != null) {
			Node p2 = head2;
			
			while(p2 != null) {
				if(p1 == p2)
					return p1;
				else
					p2 = p2.next;
			}
			
			p1 = p1.next;
		}
		
		return null;
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
		if(head != null) {
			while(n != null) {
				System.out.print(n.data + " ");
				n = n.next;
			}
			
			System.out.println("");
		} else {
			System.out.println("null is found");
		}
			
	}
}

class Node {
	Node next;
	int data;
	
	Node(int d) {
		data = d;
		next = null;
	}
}