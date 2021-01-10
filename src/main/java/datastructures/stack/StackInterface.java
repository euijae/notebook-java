package datastructures.stack;

public interface StackInterface<T> {
	/**
	 * Tests if the stack is empty
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Removes and returns the item at the top of this stack
	 * @return
	 * @throws StackException
	 */
	public T pop() throws StackException;
	
	/**
	 * Returns the top item without its removal 
	 * @return
	 * @throws StackException
	 */
	public T peek() throws StackException;
	
	/**
	 * Inserts an item onto the top of the stack
	 * @param t
	 * @throws StackException
	 */
	public void push(T t) throws StackException;
	
	/**
	 * Removes all items from the stack
	 */
	public void clear();
}
