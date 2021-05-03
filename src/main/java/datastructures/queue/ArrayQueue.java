package main.java.datastructures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements QueueInterface<T>, Iterable<T> {

	private static final int DEFAULT_CAPACITY = 10;
	private int cap,		// total number of elements in the queue
				cur,		// current number of elements
				front,		// front index
				back;		// back index
	private T [] A;

	/**
	 * Creates a new empty queue
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		cap = DEFAULT_CAPACITY;
		A = (T []) new Object[DEFAULT_CAPACITY];
		back = -1;
		front = 0;
 	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	/**
	 * Tests if the queue is logically empty.
	 * @return true if the queue is empty and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return cur == 0;
	}

	/**
	 * Returns and removes the front element of the queue.
	 * It works with wraparound.
	 *
	 * @return element at front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	@Override
	public T dequeue() throws QueueException {
		T e = getFront();
		A[front%cap] = null;
		front ++;
		cur --;
		return e;
	}

	/**
	 * Returns the first element in the Queue
	 */
	@Override
	public T getFront() throws QueueException {
		if(isEmpty()) throw new QueueException();
		else
			return A[front%cap];
	}

	@Override
	public void enqueue(T e) {
		if(isFull()) doubleSize();
		else {
			back++;
			A[back%cap] = e;
			cur ++;
		}
	}

	/**
	 * Returns the first element in the queue.
	 *
	 * @return element at front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	public boolean isFull() {
		return cur == cap;
	}

	/**
	 * Increase the queue capacity by doubling the size.
	 */
	public void doubleSize() {
		@SuppressWarnings("unchecked")
		T [] newArray = (T []) new Object[2*cap];

		for(int i = front; i <= back; i++) {
			newArray[i-front] = A[i%cap];
		}

		A = newArray;
		front = 0;
		back = cur - 1;
		cap *= 2;
	}

	private class QueueIterator implements Iterator<T> {
		private int index; // traversal index

		/**
		 * Create a new empty iterator
		 */
		public QueueIterator() {
			index = front;
		}

		/**
		 * Tests if there are more items in the Queue
		 */
		@Override
		public boolean hasNext() {
			return index <= back;
		}

		/**
		 * Returns the next item in the Queue
		 */
		@Override
		public T next() {
			return A[(index++)%cap];
		}

		/**
		 * Remove is not implemented
		 */
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
	}
}
