package go.there.soon.ctci.ch2.q1;

import java.util.HashSet;
import java.util.Set;

public class DuplicateDups {

	public static void main(String[] args) {
		char [] chars = {'f', 'o', 'l', 'l', 'o', 'w', 'w', 'w', 'w'};
		Node [] nodes = new Node[9];
		
		for(int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(chars[i]);
			if(i > 0)
				nodes[i-1].next = nodes[i];
			
			if(i == nodes.length - 1)
				nodes[i].next = null;
		}
		
		print(nodes[0]);
		sol2(nodes[0]);
		print(nodes[0]);
	}
	
	public static Node sol1(Node head) {
		Set<Character> checker = new HashSet<>();
		checker.add(head.data);
		Node curr = head;
		while(curr.next != null) {
			if(checker.contains(curr.next.data)) {
				curr.next = curr.next.next;
			} else {
				checker.add(curr.next.data);
				curr = curr.next;
			}
		}
		
		return head;
	}
	
	public static Node sol1_2(Node head) {
		Node prev = null;
		Node curr = head;
		Set<Character> dupChecker = new HashSet<>();
		
		while(curr != null) {
			if(dupChecker.contains(curr.data)) {
				prev.next = curr.next;
			} else {
				prev = curr;
				dupChecker.add(curr.data);
			}
			curr = curr.next;
		}
		
		return head;
	}
	
	public static Node sol2(Node head) {
		
		Node p1 = head;
		
		while(p1 != null) {
			Node p2 = p1;
			
			while(p2.next != null) {
				if(p1.data == p2.next.data) {
					p2.next = p2.next.next;
				} else {
					p2 = p2.next;
				}
			}
			
			p1 = p1.next;
		}
		
		return head;
	}
	
	public static Node sol2_incorrect(Node head) {
		Node cur = head;
		
		while(cur.next != null) {
			char ch = cur.data;
			Node prev = cur;
			Node run = cur.next;
			
			if(prev.data == run.data) {
				prev.next = run.next;
			} else {
				while(run != null) {
					if(ch == run.data) {
						prev.next = run.next;
						run = prev.next;
					} else {
						prev = run;
						run = run.next;
					}
						
				}
			}
				
			cur = cur.next;
		}
		
		return head;
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

class Node {
	Node next;
	char data;
	
	public Node(char ch) {
		data = ch;
		next = null;
	}
}