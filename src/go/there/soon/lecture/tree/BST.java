package go.there.soon.lecture.tree;

import java.util.Comparator;
import java.util.Iterator;

public class BST<T extends Comparable<T>> implements Iterator<T> {
	
	public static void main(String [] args) {
		Integer[] a = {1, 5, 2, 7, 4};
		BST<Integer> bst = new BST<>();
		
		for(Integer n : a) {
			bst.insert(n);
		}
		
		bst.preOrderTraversal();System.out.println("");
		bst.inOrderTraversal();System.out.println("");
		bst.postOrderTraversal();System.out.println("");
		System.out.println("Height: " + bst.height());
		
		//testing restoring a tree from two given traversals
//		bst.restore(new Integer[] {11,8,6,4,7,10,19,43,31,29,37,49},
//                      new Integer[] {4,6,7,8,10,11,19,29,31,37,43,49});
//		bst.preOrderTraversal();
//		System.out.println();
//		bst.inOrderTraversal();
//		System.out.println();
		
		System.out.println("diameter = " + bst.diameter());
		System.out.println("width = " + bst.width());
	}
	
	/*************************
	 * FIELDS AND MAIN CODES *
	 *************************/
	private Node<T> root;
	private Comparator<T> comparator;
	
	public BST() {
		this.root = null;
		this.comparator = null;
	}
	
	public BST(Comparator<T> comparator) {
		this.root = null;
		this.comparator = comparator;
	}
	
	private int compare(T x, T y) {
		if(comparator == null) 
			return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}
	
	/**********
	 * INSERT *
	 **********/
	public void insert(T data) {
		this.root = insert(root, data);
	}
	
	private Node<T> insert(Node<T> p, T toInsert) {
		if(p == null)
			return new Node<T>(toInsert);
		
		if(compare(p.data, toInsert) == 0) 
			return p;
		
		if(compare(toInsert, p.data) < 0)
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);
		
		return p;
	}
	
	/**********
	 * SEARCH *
	 **********/
	public boolean search(T toSearch) {
		return search(root, toSearch);
	}
	
	private boolean search(Node<T> p, T toSearch) {
		if(p == null)
			return false;
		
		if(compare(p.data, toSearch) == 0) {
			return true;
		} else {
			if(compare(toSearch, p.data) < 0) 
				return search(p.left, toSearch);
			else 
				return search(p.right, toSearch);
		}
	}

	/**********
	 * DELETE *
	 **********/
	public void delete(T toDelete) {
		this.root = delete(root, toDelete);
	}
	
	private Node<T> delete(Node<T> p, T toDelete) {
		if(p == null) {
			throw new RuntimeException("Can not Delete.");
		} else {
			if(compare(toDelete, p.data) < 0) {
				p.left = delete(p.left, toDelete);
			} else if(compare(toDelete, p.data) > 0) {
				p.right = delete(p.right, toDelete);
			} else {
				if(p.left == null) 
					return p.right;
				else if(p.right == null)
					return p.left;
				else {
					// get data from the rightmost node in the left subtree
					p.data = retrieveData(p.left);
					// delete the rightmost node in the left subtree
					p.left = delete(p.left, p.data);
				}
			}
		}
		
		return p;
	}
	
	private T retrieveData(Node<T> p) {
		while(p.right != null) p = p.right;
		return p.data;
	}

	/***********************
	 * PRE ORDER TRAVERSAL *
	 ***********************/
	public void preOrderTraversal() {
		preOrderHelper(root);
	}
	
	private void preOrderHelper(Node<T> r) {
		if(r != null) {
			System.out.print(r.data + " ");
			preOrderHelper(r.left);
			preOrderHelper(r.right);
		}
	}

	/**********************
	 * IN ORDER TRAVERSAL *
	 **********************/
	public void inOrderTraversal() {
		inOrderHelper(root);
	}
	
	private void inOrderHelper(Node<T> r) {
		if(r != null) {
			inOrderHelper(r.left);
			System.out.print(r.data + " ");
			inOrderHelper(r.right);
		}
	}
	
	/************************
	 * POST ORDER TRAVERSAL *
	 ************************/
	public void postOrderTraversal() {
		postOrderHelper(root);
	}
	
	private void postOrderHelper(Node<T> r) {
		if(r != null) {
			postOrderHelper(r.left);
			postOrderHelper(r.right);
			System.out.print(r.data + " ");
		}
	}
	
	/****************
	 * CLONE METHOD *
	 ****************/
	public BST<T> clone() {
		BST<T> twin = null;
		
		if(comparator == null)
			twin = new BST<T>();
		else
			twin = new BST<T>(comparator);
		
		twin.root = cloneHelper(root);
		return twin;
	}
	
	private Node<T> cloneHelper(Node<T> p) {
		return (p == null) ? p : new Node<T>(p.data, cloneHelper(p.left), cloneHelper(p.right));
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node<T> p) {
		if(p == null) {
			return -1;
		} else {
			return 1 + Math.max(height(p.left), height(p.right));
		}
	}
	
	public int countLeaves() {
		return countLeaves(root);
	}
	
	private int countLeaves(Node<T> p) {
		if(p == null)
			return 0;
		else {
			if(p.left == null && p.right == null)
				return 1;
			else
				return countLeaves(p.left) + countLeaves(p.right);
		}
	}
	
	/**
	 * To restore a BST given pre order and in order traversals
	 * @param pre
	 * @param in
	 */
	public void restore(T[] pre, T[] in) {
		root = restore(pre, 0, pre.length-1, in, 0, in.length-1);
	}
	
	private Node<T> restore(T [] pre, int preL, int preR, T [] in, int inL, int inR) {
		if(preL <= preR) {
			int count = 0;
			
			while(pre[preL] != in[inL + count]) count++;
			
			Node<T> temp = new Node<T>(pre[preL]);
			temp.left = restore(pre, preL+1, preL+count, in, inL, inL+count-1);
			temp.right = restore(pre, preL+count+1, preR, in, inL+count+1, inR);
			return temp;
		} else {
			return null;
		}
	}
	
	public int width() {
		int max = 0;
		
		for(int k = 0; k <= height(); k++) {
			int temp = width(root, k);
			max = Math.max(max, temp);
		}
		
		return max;
	}
	
	private int width(Node<T> p, int depth) {
		if(p == null) return 0;
		else {
			if(depth == 0) return 1;
			else return width(p.left, depth-1) + width(p.right, depth-1);
		}
	}
	
	public int diameter() {
		return diameter(root);
	}
	
	private int diameter(Node<T> p) {
		if(p == null)
			return 0;
		
		// the path goes through the root
		int len1 = height(p.left) + height(p.right) + 3;
		
		// the path does not pass the root
		int len2 = Math.max(diameter(p.left), diameter(p.right));
		
		return Math.max(len1, len2);
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}
}
