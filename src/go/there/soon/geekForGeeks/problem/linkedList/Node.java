package go.there.soon.geekForGeeks.problem.linkedList;

public class Node<T> {
	public T data;
	public Node<T> next;
	public boolean visited;
	
	/**
	 * Constructors
	 */
	public Node() {}
	
	public Node(T d) {
		this.data = d;
		this.next = null;
		this.visited = false;
	}

	/**
	 * Getters and setters
	 * @return
	 */
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * Utility
	 */
	public void print() {
		Node<T> head = this;
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + (visited ? 1231 : 1237);
		return result;
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Node)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Node<T> other = (Node<T>) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (next == null) {
			if (other.next != null) {
				return false;
			}
		} else if (!next.equals(other.next)) {
			return false;
		}
		if (visited != other.visited) {
			return false;
		}
		return true;
	}
}
