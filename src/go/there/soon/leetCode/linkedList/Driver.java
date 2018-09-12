package go.there.soon.leetCode.linkedList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		merge();
	}
	
	public static void merge() {
		int [] arr1 = {};
		int [] arr2 = {1, 3, 4};
		int [] arr3 = {2, 6};

		Node list1 = new Node(Integer.MIN_VALUE);
		Node p1 = list1;
		
		for(int i = 1; i < arr1.length; i++) {
			Node temp = new Node(arr1[i]);
			p1.next = temp;
			p1 = temp;
		}
		
		Node list2 = new Node(arr2[0]);
		Node p2 = list2;
		for(int i = 1; i < arr2.length; i++) {
			Node temp = new Node(arr2[i]);
			p2.next = temp;
			p2 = temp;
		}
		list2.print(list2);
		
		Node list3 = new Node(arr3[0]);
		Node p3 = list3;
		for(int i = 1; i < arr3.length; i++) {
			Node temp = new Node(arr3[i]);
			p3.next = temp;
			p3 = temp;
		}
		list3.print(list3);
		
		Node [] lists = {list1, list2, list3};
		
		LinkedList ll = new LinkedList();
		Node node = ll.merge(lists);
		node.print(node);
	}
}
