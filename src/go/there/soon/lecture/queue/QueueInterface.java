package go.there.soon.lecture.queue;

public interface QueueInterface<T> {
	/**
	 * Tests if the queue is empty
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Removes and returns the front item
	 * @return
	 * @throws QueueException
	 */
	public T dequeue() throws QueueException;
	
	/**
	 * Return the front item without its removal
	 * @return
	 * @throws QueueException
	 */
	public T getFront() throws QueueException;
	
	/**
	 * Inserts an item to the back
	 * @param e
	 */
	public void enqueue(T e);
	
	/**
	 * Removes all items from the Queue
	 */
	public void clear();
}
