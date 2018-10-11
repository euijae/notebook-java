package go.there.soon.ctci.ch7.q9;

import java.util.Arrays;
import java.util.Iterator;

public class CircularArray <T> implements Iterable<T>{
	private T[] circularArray;
	private int head = 0;
	
	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		circularArray = (T[]) new Object[size];
	}

	public int convert(int index) {
		int len = circularArray.length;
		return (index < 0) ? index + len : (head + index) % len;
	}
	
	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}
	
	public T get(int index) {
		if(index < 0 || index >= circularArray.length) {
			throw new java.lang.IndexOutOfBoundsException("Index " + index + " is out of bounds");

		} else {
			return circularArray[convert(index)];
		}
	}
	
	public void set(int i, T element) {
		circularArray[convert(i)] = element;
	}
	
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>();
	}

	public T next() {
		return null;
	}
	
	/** setters and getters */
	public T[] getCircularArray() {
		return circularArray;
	}

	public void setCircularArray(T[] circularArray) {
		this.circularArray = circularArray;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}
	
	@SuppressWarnings("hiding")
	private class CircularArrayIterator<T> implements Iterator<T> {

		private int _current = -1;
		
		@Override
		public boolean hasNext() {
			return _current < circularArray.length - 1;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			_current++;
			return (T) circularArray[convert(_current)];
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove is not supported by CircularArray");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(circularArray);
		result = prime * result + head;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		CircularArray<T> other = (CircularArray<T>) obj;
		if (!Arrays.equals(circularArray, other.circularArray))
			return false;
		if (head != other.head)
			return false;
		return true;
	}
}
