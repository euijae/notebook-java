package datastructures.stack;

public class ListStack<T> implements StackInterface<T> {

	private Node<T> top;
	
	public ListStack() {
		this.top = null;
	}

	/**
	 * Tests if the stack is empty
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	/**
	 * Removes and returns the item at the top of this stack.
	 * @return
	 * @throws StackException
	 */
	@Override
	public T pop() throws StackException {
		if(top == null) throw new StackException("Stack is empty");
		
		T data = top.data;
		top = top.next;
		return data;
	}

	/**
	 * Returns the top item without its removal
	 * @return
	 * @throws StackException
	 */
	@Override
	public T peek() throws StackException {
		if(isEmpty()) throw new StackException("Stack is empty");
		return top.data;
	}

	/**
	 * Inserts a new item into the stack
	 * @param t
	 * @throws StackException
	 */
	@Override
	public void push(T data) throws StackException {
		top = new Node<T>(data, top);
	}

	/**
	 * Make the stack logically empty.
	 */
	@Override
	public void clear() {
		top = null;
	}

	@Override
	public String toString() {
		if(isEmpty()) return "[ ]";
		
		StringBuffer out = new StringBuffer("[ ");
		Node<T> tmp = top;
		
		while(tmp != null) {
			out.append(tmp.data + " ");
			tmp = tmp.next;
		}
		
		out.append("]");
		
		return out.toString();
	}

	public static void main(String[] args) {
		ListStack<Integer> s = new ListStack<>();
		
		try {
			for(int i = 0; i < 6; i++) s.push(i);
			System.out.println(s);
		} catch (StackException e) {
			System.err.println(e);
		}
	}
}
