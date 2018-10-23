package go.there.soon.ctci.ch2.q8;

public class LoopDetection {

	public static void main(String[] args) {
		Node n1 = new Node('a');
		Node n2 = new Node('b');
		Node n3 = new Node('c');
		Node n4 = new Node('d');
		Node n5 = new Node('e');
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n1;
		
		Node n = loopDetection(n1);
		System.out.println((n == null) ? "null" : n.data);
	}
	
	public static Node loopDetection(Node head) {
		Node looped = circular(head);
		
		if(looped == null)
			return looped;
		
		Node clone = looped;
		Node n = head;
		
		while(n != clone) {
			Node checker = clone.next;
			
			while(clone != checker) {
				if(n == checker) {
					return n;
				} else {
					checker = checker.next;
				}
			}
			
			n = n.next;
		}
		
		return clone;
	}
	
	public static Node circular(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node cur = head.next;
		Node run = head.next.next;
		
		while(run != null && run.next != null) {
			if(cur == run)
				return cur;
			else {
				cur = cur.next;
				run = run.next.next;
			}
		}
		
		return null;
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