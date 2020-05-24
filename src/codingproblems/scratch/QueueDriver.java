package codingproblems.scratch;

public class QueueDriver {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println("peek: " + q.peek());
		System.out.println(q.toString());
		System.out.println("dequeue: " + q.remove());
		System.out.println(q.toString());
		System.out.println("empty: " + q.isEmpty());
	}
}
