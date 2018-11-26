package go.there.soon.scratch;

public class StackDriver {

	public static int arithmeticShift(int x, int count) {
		for(int i = 0; i < count; i++)
			x >>= 1;
		return x;
	}
	
	public static int logicalShift(int x, int count) {
		for(int i = 0; i < count; i++)
			x >>>= 1;
		return x;
	}
	
	public static void main(String[] args) {
		int x = -93242;
		int count = 40;
		System.out.println(-1 << (2));
		System.out.println(arithmeticShift(x, count));
		System.out.println(logicalShift(x, count));
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.print());
		System.out.println("peek: " + stack.peek());
		System.out.println("pop : " + stack.pop());
		System.out.println(stack.print());
	}

}
