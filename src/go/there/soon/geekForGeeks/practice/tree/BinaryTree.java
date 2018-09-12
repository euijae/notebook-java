package go.there.soon.geekForGeeks.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author eugene.kim
 *
 */
public class BinaryTree {
	
	/**********
	 * FIELDS *
	 **********/
	public Node root;
	public List<Integer> preOrderList  = new ArrayList<>();
	public List<Integer> inOrderList   = new ArrayList<>();
	public List<Integer> postOrderList = new ArrayList<>();

	/****************
	 * CONSTRUCTORS *
	 ****************/
	public BinaryTree() {}

	public BinaryTree(Node root) {
		this.setRoot(root);
	}

	/**********
	 * DELETE *
	 **********/
	public Node delete(int toDelete) {
		return delete(root, toDelete);
	}
	
	private Node delete(Node p, int toDelete) {
		if(p == null)
			throw new RuntimeException("Can not Delete.");
		
		if(toDelete < p.data) {
			p.left = delete(p.left, toDelete);
		} else if(toDelete > p.data) {
			p.right = delete(p.right, toDelete);
		} else {
			if(p.left == null)
				return p.right;
			else if(p.right == null)
				return p.left;
			else {
				p.data = retrieveData(p.left);
				p.left = delete(p.left, p.data);
			}
		}
		
		return p;
	}
	
	private int retrieveData(Node p) {
		while(p.right != null) p = p.right;
		return p.data;
	}
	
	/**********
	 * SEARCH *
	 **********/
	public boolean search(int toSearch) {
		return search(root, toSearch);
	}
	
	private boolean search(Node p, int toSearch) {
		if(p == null)
			return false;
		
		if(p.data == toSearch) 
			return true;
		if(toSearch < p.data) 
			return search(p.left,  toSearch);
		else 
			return search(p.right, toSearch);
	}
	
	/**********
	 * INSERT * 
	 **********/
	public void insert(int toInsert) {
		this.root = insert(root, toInsert);
	}
	
	private Node insert(Node p, int toInsert) {
		if(p == null) 
			return new Node(toInsert);
		
		if(p.data == toInsert)
			return p;
		
		if(toInsert < p.data)
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);
		
		return p;
	}
	
	/****************************
	 * CHECK BINARY SEARCH TREE *
	 ****************************/
	public boolean isValidBST(BinaryTree btree) {
		return isValidBST(btree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isValidBST(Node p, int min, int max) {
		if(p == null) 
			return true;
		
		if(p.data <= min || max <= p.data) 
			return false;
		
		return isValidBST(p.left, min, p.data) && isValidBST(p.right, p.data, max);
	}
	
	/************************************
	 * TRAVERSALS - Pre, In, Post Order *
	 ************************************/
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if(node != null) {
			preOrderList.add(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			inOrderList.add(node.data);
			inOrder(node.right);
		}
	}

	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			postOrderList.add(node.data);
		}
	}
	
	/*****************
	 * MISCELLANEOUS *
	 *****************/
	public int height() {
		return height(root);
	}
	
	private int height(Node p) {
		if(p == null) return -1;
		
		return 1 + Math.max(height(p.left), height(p.right));
	}
	
	public int diameter() {
		return diameter(root);
	}
	
	private int diameter(Node p) {
		if(p == null)
			return 0;
		
		int len1 = height(p.left) + height(p.right) + 3;
		int len2 = Math.max(diameter(p.left), diameter(p.right));
		
		return Math.max(len1, len2);
	}
	
	public int countLeaves() {
		return countLeaves(root);
	}
	
	private int countLeaves(Node p) {
		if(p == null)
			return 0;
		
		if(p.left == null && p.right == null)
			return 1;
		
		return countLeaves(p.left) + countLeaves(p.right);
	}
	
	/***********************
	 * GETTERS AND SETTERS *
	 ***********************/
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public List<Integer> getPreOrderList() {
		return preOrderList;
	}

	public void setPreOrderList(List<Integer> preOrderList) {
		this.preOrderList = preOrderList;
	}

	public List<Integer> getInOrderList() {
		return inOrderList;
	}

	public void setInOrderList(List<Integer> inOrderList) {
		this.inOrderList = inOrderList;
	}

	public List<Integer> getPostOrderList() {
		return postOrderList;
	}

	public void setPostOrderList(List<Integer> postOrderList) {
		this.postOrderList = postOrderList;
	}
}
