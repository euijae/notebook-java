package go.there.soon.leetCode.tree;

import java.util.Stack;

public class BSTIterator {

	private TreeNode root;
	private Stack<TreeNode> stack; 
	
    public BSTIterator(TreeNode root) {
    	this.root = root;
    	this.stack = new Stack<>();
    	this.setIterator();
    }
    
    public void setIterator() {
    	Stack<TreeNode> tempStack = new Stack<>();
    	tempStack.push(root);
    	stack.push(root);
    	
    	while(!tempStack.isEmpty()) {
    		TreeNode temp = tempStack.pop();
    		
    		if(temp.right != null)
    			stack.push(temp.right);
    		
    		if(temp.left != null)
    			stack.push(temp.left);
    	}
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	return stack.peek().val;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */