package codingproblems.ctci.ch2.q3;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		char [] chars = {'f', 'o', 'l', 'l', 'o', 'w', ' ', 'u', 'p'};
		Node [] nodes = new Node[9];
		
		for(int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(chars[i]);
			if(i > 0)
				nodes[i-1].next = nodes[i];
			
			if(i == nodes.length - 1)
				nodes[i].next = null;
		}
		
		print(nodes[0]);
		sol1(nodes[0]);
		print(nodes[0]);
	}
	
	public static boolean sol1(Node head) {
		if(head == null || head.next == null) {
			return false;
		}
		
		Node p1_prev = null;
		Node p1 = head;
		Node p2 = head;
		
		while(p2 != null && p2.next != null) {
			p2 = p2.next.next;
			p1_prev = p1;
			p1 = p1.next;
		}
		
		p1_prev.next = p1.next;
		return true;
	}
	
	public static void print(Node head) {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + "-");
			n = n.next;
		}
		System.out.print(">\n");
	}
}

class Node{
	Node next;
	char data;
	
	Node(char d) {
		data = d;
		next = null;
	}
}