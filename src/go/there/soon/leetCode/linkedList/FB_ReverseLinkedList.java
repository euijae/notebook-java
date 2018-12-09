package go.there.soon.leetCode.linkedList;

public class FB_ReverseLinkedList {

	public static void main(String[] args) {
		String s = "abc\n";
		System.out.println(s.length() + ", " +s.charAt(3));
		FB_ReverseLinkedList f = new FB_ReverseLinkedList();
		f.test();
	}

	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Solution s = new Solution();
		ListNode n = s.reverseList(n1);
		print(n);
	}
	
	class Solution {
		public ListNode reverseList(ListNode head) {
	        if(head == null)
	            return head;
	        
	        return reverseHelper(null, head);
	    }
		
		public ListNode reverseHelper(ListNode p0, ListNode p1) {
			if(p1 == null)
				return p0;
			
			ListNode p2 = p1.next;
			p1.next = p0;
			p0 = p1;
			p1 = p2;
			
			return reverseHelper(p0, p1);
		}
	    public ListNode reverseList1(ListNode head) {
	        if(head == null)
	            return head;
	        
	        ListNode p0 = null;
	        ListNode p1 = head;
	        
	        while(p1 != null) {
	        		ListNode p2 = p1.next;
	        		p1.next = p0;
	        		p0 = p1;
	        		p1 = p2;
	        }
	        
	        return p0;
	    }
	}
	
	public void print(ListNode node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
