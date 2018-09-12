package go.there.soon.leetCode.linkedList;

public class Node {
	public int data;
	public Node next;
	
	/**
	 * Constructor
	 * @param data
	 */
	public Node() {
		super();
	}
	
	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}
	
	public void print(Node head) {
		Node h = head;
		while(h != null) {
			System.out.print(h.data + " ");
			h = h.next;
		}
		System.out.println("");
	}
	
	/**
	 * Setters and getters
	 * @return
	 */
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
