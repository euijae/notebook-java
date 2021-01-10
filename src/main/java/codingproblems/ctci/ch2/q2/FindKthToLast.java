package codingproblems.ctci.ch2.q2;

public class FindKthToLast {

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
		
		for(int i = 1; i <= chars.length; i++) {
			System.out.println("<" + sol2(nodes[0], i).data + ">");
		}
	}

	public static Node sol1(Node head, int k) {
		Node n = head;
		int tot = countElement(n);
		if(tot == 0)
			return null;
		if(tot == k+1)
			return head;
		
		for(int i = 0; i < (tot - k - 1); i++)
			n = n.next;
		
		return n;
	}
	
	public static Node sol2(Node head, int k) {
		Node p1 = head;
		Node p2 = head;
		
		for(int i = 0; i < k; i++) {
			if(p2 == null) return null;
			else p2 = p2.next;
		}
		
		while(p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static int countElement(Node head) {
		int total = 0;
		Node n = head;
		while(n != null) {
			total ++;
			n = n.next;
		}
		
		return total;
	}
	
}

class Node {
	Node next;
	char data;
	
	public Node(char d) {
		data = d;
		next = null;
	}
}