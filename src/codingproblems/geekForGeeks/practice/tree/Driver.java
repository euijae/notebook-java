package codingproblems.geekForGeeks.practice.tree;

public class Driver {

	public static void main(String[] args) {
		testCheckBST();
//		testInsertSearchDelete();
//		testCheckPreOrderTraversal();
//		testCheckFullBinaryTree();
//		testMaximumSumPath();
//		testFindMinimumPath();
	}
	
	public static void testCheckBST() {
		System.out.println("TEST CHECK BST");
		BinaryTree btree = new BinaryTree();
		Node root = new Node(10);
		root.setLeft(new Node(5));
		root.setRight(new Node(15));
		
		Node right = root.getRight();
		right.setLeft(new Node(6));
		right.setRight(new Node(20));
		
		btree.setRoot(root);
		
		System.out.println("check bst 1: " + btree.isValidBST(btree));
	}
	
	public static void testInsertSearchDelete() {
		System.out.println("TEST INSERT EARCH DELETE");
		BinaryTree btree = new BinaryTree();
		btree.insert(7);
		btree.insert(4);
		btree.insert(2);
		btree.insert(1);
		btree.insert(5);
		btree.insert(6);
		btree.insert(9);
		btree.insert(40);
		int key = 11;
		System.out.println("search " + key + ": " + btree.search(key));
	}
	
	public static void testCheckPreOrderTraversal() {
		System.out.println("TEST CHECK FULL PRE ORDER TRAVERSAL");
		CheckPreOrderTraversal cpot = new CheckPreOrderTraversal();
		System.out.println(cpot.isPreOrderTraversal(new int[]{7,4,2,1,5,6,9,40}));
	}
	
	public static void testCheckFullBinaryTree() {
		System.out.println("TEST CHECK FULL BINARY TREE");
		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		
		Node left = root.getLeft();
		left.setLeft(new Node(4));
		left.setRight(new Node(5));
		
		CheckFullBinaryTree cfbt = new CheckFullBinaryTree();
		System.out.println("Using Level order: " + cfbt.isFullTreeByLevelOrder(root));
		System.out.println("Using recursion  : " + cfbt.isFullTreeByRecursion(root));
	}
	
	public static void testMaximumSumPath() {
		System.out.println("TEST MAXIMUM SUM PATH.");
		Node root = new Node(10);
		root.setLeft(new Node(2));
		root.setRight(new Node(10));
		
		Node left = root.getLeft();
		left.setLeft(new Node(20));
		left.setRight(new Node(1));
		
		Node right = root.getRight();
		right.setRight(new Node(-25));
		
		Node rightRight = right.getRight();
		rightRight.setLeft(new Node(3));
		rightRight.setRight(new Node(4));
		
		MaximumSumPath msp =  new MaximumSumPath();
		System.out.println("maximum sum path: " + msp.maxSumPath(root));
	}
	
	public static void testFindMinimumPath() {
		System.out.println("TEST FIND MINIMUM PATH.");
		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		
		Node left = root.getLeft();
		left.setLeft(new Node(4));
		left.setRight(new Node(5));
		
		Node leftLeft = left.getLeft();
		leftLeft.setLeft(new Node(8));
		
		Node right = root.getRight();
		right.setLeft(new Node(6));
		right.setRight(new Node(7));
		
		FindMinimumPath fmp = new FindMinimumPath();
		int minPath = fmp.findMinimumPath(root);
		System.out.println(minPath);
	}
}
