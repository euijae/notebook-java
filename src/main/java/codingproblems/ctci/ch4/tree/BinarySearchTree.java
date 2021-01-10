package codingproblems.ctci.ch4.tree;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private TreeNode<T> root;
	
	public BinarySearchTree() {}
	
	public BinarySearchTree(TreeNode<T> root) {
		this.root = root;
	}
	
	public void insert(TreeNode<T> node, T toBeInserted) {
		if(node == null) {
			node = new TreeNode<>(toBeInserted);
		} else {
			if(node.data.compareTo(toBeInserted) > 0){
				if(node.left == null) {
					node.left = new TreeNode<>(toBeInserted);
				} else {
					insert(node.left, toBeInserted);
				}
			} else {
				if(node.right == null) {
					node.right = new TreeNode<>(toBeInserted);
				} else {
					insert(node.right, toBeInserted);
				}
			}
		}
	}
	
	public boolean find(TreeNode<T> node, T target) {
		if(node == null)
			return false;
		
		if(node.data.compareTo(target) == 0)
			return true;
		
		return find(node.left, target) || find(node.right, target);
	}
	
	public boolean delete(T target) {
		if(!find(root, target))
			return false;

		TreeNode<T> parent = root;
		TreeNode<T> node   = null;
		
		if(root.data.compareTo(target) == 0) {
			if(root.left == null && root.right == null) {
				System.out.println("yes");
				root = null;
				return true;
			} else {
				System.out.println("no");
				node = root;
			}
		} else {
			while(parent.left != null && parent.right != null) {
				if(parent.left != null && parent.left.data.compareTo(target) == 0) {
					node = parent.left;
					break;
				}
				
				if(parent.right != null && parent.right.data.compareTo(target) == 0) {
					node = parent.right;
					break;
				}
				
				parent = (target.compareTo(parent.data) <= 0) ? parent.left : parent.right;
			}
		}
		
		if(node.left == null && node.right == null) {
			if(parent.left != null && parent.left.data.compareTo(node.data) == 0) {
				parent.left = null;
				return true;
			}
			
			if(parent.right != null && parent.right.data.compareTo(node.data) == 0){
				parent.right = null;
				return true;
			}
		}
		
		if(node.right != null) {
			TreeNode<T> leftmost = findLeftmost(node.right);
			
			if(leftmost.left == null) {
				node.data  = leftmost.data;
				node.right = null;
			} else {
				node.data = leftmost.left.data;
				leftmost.left = null;
			}
			
			return true;
		}

		if(node.left != null) {
			TreeNode<T> rightmost = findRightmost(node.left);
			
			if(rightmost.right == null) {
				node.data  = rightmost.data;
				node.left = null;
			} else {
				node.data = rightmost.right.data;
				rightmost.right = null;
			}
			
			return true;
		}
		
		return false;
	}
	
	public TreeNode<T> findLeftmost(TreeNode<T> node) {
		TreeNode<T> parent = node;

		if(parent.left != null && parent.left.left != null)
			parent = parent.left;
		
		return parent;
	}
	
	public TreeNode<T> findRightmost(TreeNode<T> node) {
		TreeNode<T> parent = node;

		if(parent.right != null && parent.right.right != null)
			parent = parent.right;
		
		return parent;
	}
	
	public void preOrder(TreeNode<T> root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void inOrder(TreeNode<T> node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}
	
	public void postOrder(TreeNode<T> node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
}
