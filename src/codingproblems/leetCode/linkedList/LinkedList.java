package codingproblems.leetCode.linkedList;

public class LinkedList {
	public Node merge(Node [] lists) {
		if(lists.length == 0) return new Node();
		
		Node head = new Node(-1);
		Node pHead = head;
		
		for(int i = 0; i < lists.length; i++) {
			Node p = lists[i];
			
			while(p != null) {
				pHead = insertSort(pHead, p.data);
				p = p.next;
			}
		}
		
		return head.next;
	}
	
	public Node insertSort(Node head, int data) {
		Node p = new Node(data);
		
		// if head is null
		if(head == null) {
			return p;
		}
		
		// will be a first node
		if(head.next == null || data <= head.data) {
			p.next = head;
			return p;
		}
		
		Node p1 = head;
		
		// find location either in between or last
		while(p1.next != null && p1.next.data <= data) {
			p1 = p1.next;
		}
		
		p.next = p1.next;
		p1.next = p;
		
		return head;
	}
}
