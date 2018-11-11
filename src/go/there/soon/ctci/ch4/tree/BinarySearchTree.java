package go.there.soon.ctci.ch4.tree;

public class BinarySearchTree<T extends Comparable<T>> {
	public void insert(TreeNode<T> root, T toBeInserted) {
		if(root == null) {
			root = new TreeNode<>(toBeInserted);
		} else {
			if(root.data.compareTo(toBeInserted) > 0){
				if(root.left == null) {
					root.left = new TreeNode<>(toBeInserted);
				} else {
					insert(root.left, toBeInserted);
				}
			} else {
				if(root.right == null) {
					root.right = new TreeNode<>(toBeInserted);
				} else {
					insert(root.right, toBeInserted);
				}
			}
		}
	}
	
	public boolean find(TreeNode<T> root, T target) {
		if(root == null)
			return false;
		
		if(root.data.compareTo(target) == 0)
			return true;
		
		return find(root.left, target) || find(root.right, target);
	}
	
	public boolean delete(TreeNode<T> root, T target) {
		if(!find(root, target))
			return false;
		
		TreeNode<T> parent = root;
		TreeNode<T> node   = null;
		
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
		
		if(node == null) {
			if(root.data.compareTo(target) == 0) {
				node = root;
			} else {
				return false;
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
	
	public void inOrder(TreeNode<T> root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	public void postOrder(TreeNode<T> root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
}
