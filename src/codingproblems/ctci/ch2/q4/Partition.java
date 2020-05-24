package codingproblems.ctci.ch2.q4;

import java.util.ArrayList;
import java.util.List;

public class Partition {

	public static void main(String[] args) {
		int [] arr = {3, 5, 8, 5, 1, 4, 2};
		Node [] nodes = new Node[arr.length];
		for(int i = 0; i < arr.length; i++) {
			nodes[i] = new Node(arr[i]);
			if(i > 0)
				nodes[i-1].next = nodes[i];
			if(i == arr.length-1)
				nodes[i].next = null;
		}
		print(nodes[0]);
		nodes[0] = sol2(nodes[0], 5);
		print(nodes[0]);
	}

	public static Node sol2(Node head, int partition) {
		Node p1 = head;
		Node p2 = head;
		
		while(p2.next != null) {
			if(p2.next.data < partition) {
				Node nodeTemp = p2.next;
				p2.next = p2.next.next;
				nodeTemp.next = p1;
				p1 = nodeTemp;
			} else {
				p2 = p2.next;
			}
		}
		
		return p1;
	}
	
	public static Node sol1(Node head, int partition) {
		Node n = head;
		List<Node> left = new ArrayList<>();
		List<Node> right = new ArrayList<>();
		
		while(n != null) {
			if(n.data < partition) {
				left.add(n);
			} else {
				right.add(n);
			}
			
			n = n.next;
		}
		
		int rightIndex = 0;
		Node newHead = null;
		
		if(left.size() > 0) {
			newHead = left.get(0); 
		} else {
			newHead = right.get(0);
			rightIndex = 1;
		}
		Node newN = newHead;
		
		if(left.size() > 0)
			for(int i = 1; i < left.size(); i++, newN = newN.next)
				newN.next = left.get(i);
		
		for(int i = rightIndex; i < right.size(); i++, newN = newN.next)
			newN.next = right.get(i);
		
		newN.next = null;
		return newHead;
	}
	
	public static void print(Node head) {
		Node n = head;
		while(n != null)  {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println("");
	}
}

class Node {
	Node next;
	int data;
	
	Node (int d) {
		data = d;
		next = null;
	}
}