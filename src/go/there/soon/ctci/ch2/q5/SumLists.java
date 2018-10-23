package go.there.soon.ctci.ch2.q5;

import java.util.Stack;

public class SumLists {

	public static void main(String[] args) {
		Node n11 = new Node(7);
		Node n12 = new Node(1);
		Node n13 = new Node(6);
//		Node n14 = new Node(4);
		n11.next = n12;
		n12.next = n13;
		n13.next = null;
		Node n21 = new Node(5);
		Node n22 = new Node(9);
		Node n23 = new Node(2);
		n21.next = n22;
		n22.next = n23;
		n23.next = null;
		Node newNode1 = sol1(n11, n21);
		Node newNode2 = sol2(n11, n21);
		print(newNode1);
		print(newNode2);
	}

	public static Node sol2(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return (head1 == null) ? head2 : head1;
		}
		
		Stack<Node> stack1 = setStack(head1);
		Stack<Node> stack2 = setStack(head2);
		
		Node p1 = stack1.pop();
		Node p2 = stack2.pop();
		
		int value = p1.data + p2.data;
		int add   = (value >= 10) ? 1 : 0;
		Node newHead  = new Node(value % 10);
		
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			p1 = stack1.pop();
			p2 = stack2.pop();
			value = p1.data + p2.data + add;
			add = (value >= 10) ? 1 :0;
			Node temp = new Node(value % 10);
			temp.next = newHead;
			newHead = temp;
		}
		
		while(!stack1.isEmpty()) {
			p1 = stack1.pop();
			value = p1.data + add;
			add = (value >= 10) ? 1 :0;
			Node temp = new Node(value % 10);
			temp.next = newHead;
			newHead = temp;
		}
		
		while(!stack2.isEmpty()) {
			p2 = stack2.pop();
			value = p2.data + add;
			add = (value >= 10) ? 1 :0;
			Node temp = new Node(value % 10);
			temp.next = newHead;
			newHead = temp;
		}
		
		if(add == 1) {
			Node temp = new Node(1);
			temp.next = newHead;
			newHead = temp;
		}
		
		return newHead;
	}
	
	public static Stack<Node> setStack(Node head) {
		Node n = head;
		Stack<Node> stack = new Stack<>();
		while(n != null) {
			stack.push(n);
			n = n.next;
		}
		return stack;
	}
	
	public static Node sol1(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return (head1 == null) ? head2 : head1;
		
		Node n1 = head1;
		Node n2 = head2;
		
		int value = n1.data + n2.data;
		int add = (value >= 10) ? 1 : 0;
		
		Node temp = new Node(value % 10);
		Node newHead = temp;
		n1 = n1.next;
		n2 = n2.next;
		
		while(n1 != null && n2 != null) {
			value = n1.data + n2.data + add;
			add = (value >= 10) ? 1 : 0;
			temp.next = new Node(value % 10);
			temp = temp.next;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		while(n1 != null) {
			value = n1.data + add;
			add = (value >= 10) ? 1 : 0;
			temp.next = new Node(value % 10);
			temp = temp.next;
			n1 = n1.next;
		}
		
		while(n2 != null) {
			value = n2.data + add;
			add = (value >= 10) ? 1 : 0;
			temp.next = new Node(value % 10);
			temp = temp.next;
			n2 = n2.next;
		}

		if(add == 1) {
			temp.next = new Node(1);
		}
		
		return newHead;
	}
	
	public static void print(Node head) {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println("");
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
}

class Node {
	Node next;
	int data;
	
	Node(int d) {
		data = d;
		next = null;
	}
}