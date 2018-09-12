package go.there.soon.geekForGeeks.problem.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @see https://geeksforgeeks.org/top-10-algorithms-in-interview-questions/
 * @author eugene.kim
 *
 */
public class LinkedList<T extends Comparable<T>> {
	
	private Node<T> head;
	
	public LinkedList(){}
	
	public LinkedList(Node<T> head) {
		this.head = head;
	}
	
	public Node<T> setLinkedList(T [] items) {
		if(items.length == 0) 
			return new Node<>();
 		
		Node<T> n1 = (this.getHead() == null) ? new Node<>(items[0]) : this.getHead();
		
		if(this.getHead() == null) {
			this.setHead(n1);
		}
		
		for(int i = 1; i < items.length; i++) {
			Node<T> temp = new Node<>(items[i]);
			n1.next = temp;
			n1 = temp;
		}
		
		return this.getHead();
	}
	
	public int compare(Node<T> n1, Node<T> n2) {
		while(n1 != null && n2 != null && n1.data.compareTo(n2.data) == 0) {
			n1 = n1.next;
			n2 = n2.next;
		}

		if(n1 != null && n2 != null) {
			if(n1.data.compareTo(n2.data) < 0) {
				return -1;
			} else if(n1.data.compareTo(n2.data) > 0) {
				return 1;
			}
		}
		
		if(n1 != null) {
			return 1;
		}
		
		if(n2 != null) {
			return -1;
		}
		
		return 0;
	}
	
	public Node<T> remove(T key) {
		Node<T> head = this.getHead();
		
		// Case 1. If list is an empty
		if(head == null) {
			return head;
		} 
		 
		// Case 2. If the node to be removed is a head
		else if(head.data.compareTo(key) == 0) {
			head = head.next;
			return head;
		}
		
		// Case 3. If the node is somewhere after the head
		Node<T> n1 = head;
		Node<T> n2 = head.next;
		
		while(n2.next != null) {
			if(n2.data == key) {
				n1.next = n2.next;
				return head;
			} else {
				n1 = n1.next;
				n2 = n2.next;
			}
		}

		// Case 5. The node to be removed is the tail
		if(n2.data == key) {
			n1.next = null;
		}
		
		// Case 4. If no such a node is found
		return head;
	}
	
	public Node<T> insert(T key) {
		Node<T> head = this.getHead();
		
		if(head == null) {
			return new Node<T>(key);
		}
		
		Node<T> n = head;
		
		while(n.next != null) {
			n = n.next;
		}
		
		n.next = new Node<T>(key);
		
		return head;
	}
	
	public Node<T> sortedInsert(T key) {
		Node<T> newNode = new Node<T>(key);
		Node<T> head = this.getHead();

		if(head == null || head.data.compareTo(key) >= 0) {
			newNode.next = head;
			return newNode;
		}
		
		Node<T> n1 = head;

		while(n1.next != null && n1.next.data.compareTo(key) <= 0) { 
			n1 = n1.next;
		}
		
		newNode.next = n1.next;
		n1.next = newNode;
		
		return head;
	}
	
	/**
	 * https://practice.geeksforgeeks.org/problems/merge-list-alternatingly/1
	 * @param n1
	 * @param n2
	 */
	public void mergeAlt(Node<Integer> n1, Node<Integer> n2) {
		boolean left= true;
		Node<Integer> newNode = n1;
		Node<Integer> newHead = n1;
		
		n1 = n1.next;
		left = false;
		
		while(n1 != null && n2 != null) {
			int data = (left) ? n1.data : n2.data;
			
			Node<Integer> temp = new Node<>(data);
			newNode.next = temp;
			newNode = temp;
			
			if(left) {
				n1 = n1.next;
				left = false;
			} else {
				n2 = n2.next;
				left = true;
			}
		}
		
		if(!left) {
			Node<Integer> temp = new Node<>(n2.data);
			newNode.next = temp;
			newNode = temp;
			newNode.next = null;
			n2 = n2.next;
		}
		
		newHead.print();
		
		if(n1 == null && n2 != null) {
			n2.print();
		}
		
		if(n2 == null && n1 != null) {
			n1.print();
		}
	}
	
	/**
	 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
	 * @param head
	 * @return
	 */
	public Node<T> reverseIterative() {
		Node<T> head = this.getHead();
		
		Node<T> prev = null;
		Node<T> curr = head;
		Node<T> next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	/**
	 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
	 * @return
	 */
	public Node<T> reverseRecursive() {
		// TODO
		return null;
	}
	
	/**
	 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
	 * @return
	 */
	public Node<T> reverseInGivenSize() {
		// TODO
		return null;
	}
	
	/**
	 * https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1
	 */
	public void mergeSort() {
		
	}
	
	/**
	 * https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
	 * Implement using Floyd's Cycle detecting algorithm
	 * @return
	 */
	public boolean detectLoop1() {
		Node<T> head = this.getHead();

		if(head == null || head.next == null) return false;
		
		Node<T> p1 = head;
		Node<T> p2 = head;
		
		while(p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			
			if(p1 == p2)
				return true;
		}
		
		return false;
	}
	
	public boolean detectLoop2() {
		Node<T> head = this.getHead();
		
		if(head == null || head.next == null) return false;
		
		Node<T> p1 = head;
		
		while(p1 != null) {
			if(p1.visited == true) return true;
			else {
				p1.visited = true; 
				p1 = p1.next;
			}
		}
		
		return false;
	}
	
	public boolean detectLoop3() {
		Node<T> head = this.getHead();
		
		if(head == null || head.next == null) return false;
		
		Node<T> p1 = head;
		Set<Node<T>> set = new HashSet<>();
		
		while(p1 != null) {
			if(set.contains(p1)) {
				return true;
			} else {
				set.add(p1);
				p1 = p1.next;
			}
		}
		
		return false;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * 
	 * @param head
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}
}
