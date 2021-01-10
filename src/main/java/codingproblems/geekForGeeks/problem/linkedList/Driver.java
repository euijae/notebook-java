package codingproblems.geekForGeeks.problem.linkedList;

/**
 * 
 * @author eugene.kim
 *
 */
public class Driver {
	
	private boolean isRead;
	
	private static Integer [] arr1 = {10, 20, 30, 40, 50, 60};
	private static Character [] carr1 = {'g', 'e', 'e', 'k', 's', 'a'};
	private static Character [] carr2 = {'g', 'e', 'e', 'k', 's', 'b'};
	
	public static void main(String[] args) {
//		Reverse();
//		Remove();
//		Insert();
//		Compare();
		
		DetectLoop();
		
		Test test = new Test(null);
		if(test.getStr() == null) {
			System.out.println("yes it is null");
		} else {
			System.out.println("no it is not a null");
		}
	}
	
	public static class Test{
		String str;
		
		public Test(String str) {
			this.str = str;
		}
		
		public void setStr(String str) {
			this.str = str;
		}
		
		public String getStr() {
			return this.str;
		}
	}
	
	public static void DetectLoop() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);
		n1.next = n3;
		n3.next = n4;
		n4.next = n3;
		LinkedList<Integer> list = new LinkedList<>(n1);
		System.out.println("Floyd's Cycle: " + (list.detectLoop1() ? "DETECTED" : "NOT DETECTED"));
		System.out.println("Hash table --: " + (list.detectLoop2() ? "DETECTED" : "NOT DETECTED"));
		System.out.println("Visited Node-: " + (list.detectLoop3() ? "DETECTED" : "NOT DETECTED"));
	}
	
	public static void Reverse() {
		System.out.println("---REVERSE---");
		
		LinkedList<Integer> list = new LinkedList<>();
		Node<Integer> head = list.setLinkedList(arr1);
		
		head = list.reverseIterative();
		head.print();
	}
	
	public static void Remove() {
		System.out.println("---REMOVE---");
		LinkedList<Integer> list = new LinkedList<>();
		Node<Integer> head = list.setLinkedList(arr1);
		
		System.out.print("Remove " + arr1[2] + ": ");
		head = list.remove(arr1[2]);
		head.print();
	}
	
	public static void Insert() {
		System.out.println("---INSERT---");
		LinkedList<Integer> list = new LinkedList<>();
		Node<Integer> head = list.setLinkedList(arr1);
		
		System.out.print("Insert 26: ");
		head = list.sortedInsert(26);
		head.print();
	}
	
	public static void Compare() {
		System.out.println("---COMPARE---");
		LinkedList<Character> list1 = new LinkedList<>();
		LinkedList<Character> list2 = new LinkedList<>();
		
		Node<Character> head1 = list1.setLinkedList(carr1);
		Node<Character> head2 = list2.setLinkedList(carr2);
		
		LinkedList<Character> ll = new LinkedList<>();
		System.out.println("compare: " + ll.compare(head1, head2));
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

}
