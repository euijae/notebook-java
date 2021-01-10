package datastructures.tree;

import java.util.Iterator;
import java.util.Stack;

public class MyIterator<T extends Comparable<T>> implements Iterator<T> {

	private Stack<Node<T>> stk;
	private Node<T> root;
	
	public MyIterator(Node<T> root) {
		this.root = root;
		this.stk = new Stack<Node<T>>();
		
		if(root != null) {
			stk.push(root);
		}
	}
	
	@Override
	public boolean hasNext() {
		return !stk.isEmpty();
	}

	@Override
	public T next() {
		Node<T> cur = stk.peek();
		if(cur.left != null) {
			stk.push(cur.left);
		} else {
			Node<T> temp = stk.pop();
			
			while(temp.right == null) {
				if(stk.isEmpty()) return cur.data;
				temp = stk.pop();
			}
			
			stk.push(temp.right);
		}
		
		return cur.data;
	}

	public Stack<Node<T>> getStk() {
		return stk;
	}

	public void setStk(Stack<Node<T>> stk) {
		this.stk = stk;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
}
