package go.there.soon.geekForGeeks.practice;

import go.there.soon.geekForGeeks.problem.linkedList.Node;

/**
 * https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 * @author eugene.kim
 *
 */
public class SumTowNumbers2 {
	
	public static Node<Integer> addTwoLists(Node<Integer> n1, Node<Integer> n2) {
		if(n1 == null && n2 == null) {
			return null;
		} 
		
		if(n1 == null || n2 == null) {
			return (n1 == null) ? n2 : n1;
		} 
		
		int inc = 0;
		int val = n1.data + n2.data;
		
		if(val >= 10) {
			val -= 10;
			inc = 1;
		}
		
		n1 = n1.next;
		n2 = n2.next;
		
		Node<Integer> head = new Node<>(val);
		Node<Integer> node = head;
		
		while(n1 != null && n2 != null) {
			val = (n1.data + n2.data + inc);
			
			if(val >= 10) {
				val -= 10;
				inc = 1;
			} else {
				inc = 0;
			}
			
			Node<Integer> temp = new Node<>(val);
			node.next = temp;
			node = temp;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		if(n1 != null) {
			if(inc == 1) {
				while(n1 != null) {
					val = (n1.data + inc);
					
					if(val >= 10) {
						val -= 10;
						inc = 1;
					} else {
						inc = 0;
					}
					
					Node<Integer> temp = new Node<>(val);
					node.next = temp;
					node = temp;
					n1 = n1.next;
				}
			} else {
				node.next = n1;
			}
		}
		
		if(n2 != null) {
			if(inc == 1) {
				while(n2 != null) {
					val = (n2.data + inc);
					
					if(val >= 10) {
						val -= 10;
						inc = 1;
					} else {
						inc = 0;
					}
					
					Node<Integer> temp = new Node<>(val);
					node.next = temp;
					node = temp;
					n2 = n2.next;
				}
			} else {
				node.next = n2;
			}
		}
		
		return head;
	}
}
