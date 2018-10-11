package go.there.soon.ctci.ch7.q9;

public class CircularArray2 <T extends Comparable<T>>{
	private int startIndex;
	private int endIndex;
	private int size;
	private int arraySize;
	private T[] circularArray;
	
	@SuppressWarnings("unchecked")
	public CircularArray2(int aSize) {
		startIndex = 0;
		endIndex = 0;
		size = 0;
		arraySize = aSize;
		circularArray = (T[]) new Object[aSize];
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean remove(T element) {
		int arrayPointer = startIndex;
		
		for(int i = 0; i < size; i++, arrayPointer++) {
			int newIndex = (arrayPointer + 1) % arraySize;
			
			if(circularArray[newIndex].equals(element)) {
				// traverse and copy them
				size --;
				endIndex = (endIndex==0) ? arraySize-1 : endIndex-1;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean remove(int at) {
		if(arraySize <= at || size <= at) {
			return false;
		} 
		
		if(circularArray[at].compareTo(null) == 0) {
			// traverse and copy
			size -- ;
			endIndex = (endIndex==0) ? arraySize-1 : endIndex-1;
			return true;
		}
			
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if(arraySize <= index || size <= index) 
			return (T) new Object();
		
		int newIndex = (startIndex + index) % arraySize;
		
		if(newIndex <= endIndex) 
			return circularArray[newIndex];
		else
			return (T) new Object();
	}
	
	public boolean add(T element) {
		if(size == arraySize) {
			// double and add it
			return true;
		} 
			
		int newIndex = (endIndex + 1) % arraySize;
		
		if(circularArray[newIndex].compareTo(null) == 0) {
			circularArray[newIndex] = element;
			size ++;
			endIndex = newIndex;
			return true;
		}
		
		return false;
	}
	
	public boolean add(int at, T element) {
		if(arraySize <= at || size <= at) {
			return false;
		} 
		
		if((startIndex <= endIndex && startIndex <= at && at <= endIndex) 
			|| (startIndex >  endIndex && startIndex <= at || at <= endIndex)) {
			if(size == arraySize) {
				// double size and add it
			} else {
				// traverse copy them
				circularArray[at] = element;
			}
			
			return true;
		}
			
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void traverse() {
		for(Object obj : circularArray) {
			System.out.print((T) obj.toString());
		}
	}
	
	/** getters and setters */
	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public T[] getCircularArray() {
		return circularArray;
	}

	public void setCircularArray(T[] circularArray) {
		this.circularArray = circularArray;
	}
}
