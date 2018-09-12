package go.there.soon.lecture.stack;

public class ArrayStack<T> implements StackInterface<T> {

	private static final int DEFAULT_CAPACITY = 15;
	private int top; // reference to the top element
	private T[] t;
	
	/**
	 * Creates a Stack of the size initialCapacity
	 * @param initialCapacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		int size = (initialCapacity <= 0) ? DEFAULT_CAPACITY : initialCapacity; 
		
		t = (T []) new Object[size];
		top = -1; // stack is empty
	}
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Tests if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public T pop() throws StackException {
		T x = peek();
		t[top] = null; // make sure the object is destroyed
		top --;
		return x;
	}

	/**
	 * Returns the top item without its removal
	 */
	@Override
	public T peek() throws StackException {
		if(isEmpty()) throw new StackException("Stack is Empty");
		return t[top];
	}

	/**
	 * Inserts an item onto the top of the stack
	 */
	@Override
	public void push(T x) throws StackException {
		if(top == t.length) throw new StackException("Stack has overflowed");
		t[++top] = x;
		System.out.println("size: " + t.length);
	}

	/**
	 * Removes all items from the Stack
	 */
	@Override
	public void clear() {
		for(int i = 0; i < t.length; i++) 
			t[i] = null;
		
		top = -1;
	}
	
	/**
	 * Returns a string representation of the Stack
	 */
	public String toString() {
		if(isEmpty()) return "[ ]";
		StringBuffer out = new StringBuffer("[");
		for(int i = 0; i < top; i++)
			out.append(t[i] + ", ");
		
		out.append(t[top] + "]");
		
		return out.toString();
	}
	
	public static void main(String[] args) {
		ArrayStack<Integer> s = new ArrayStack<>(6);
		
		try {
			for(int i = 0; i < 6; i++) s.push(i);
			System.out.println(s);

			for(int i = 0; i < 7; i++) s.pop();
			System.out.println(s);
		} catch (StackException e) {
			System.err.println(e);
		}
	}
}
