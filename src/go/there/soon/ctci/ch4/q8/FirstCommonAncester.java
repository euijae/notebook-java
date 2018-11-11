package go.there.soon.ctci.ch4.q8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import go.there.soon.ctci.ch4.tree.TreeNode;

public class FirstCommonAncester {

	public static void main(String[] args) {
		
	}
	
	/**
	 * [wrong!!] clearly out of requirements. 
	 */
	public static void test() {
		TreeNode<String> n1 = new TreeNode<>("n1"); // root of first binary tree
		TreeNode<String> n2 = new TreeNode<>("n2");
		TreeNode<String> c1 = new TreeNode<>("c1");
		TreeNode<String> m1 = new TreeNode<>("m1"); // root of second binary tree
		TreeNode<String> c2 = new TreeNode<>("c2");
		
		n1.setBoth(n2, c1);     
		n2.setBoth(null, null);
		m1.setBoth(c1, null);
		c1.setBoth(null, c2);
		
		Queue<TreeNode<String>> q1 = new LinkedList<>();
		Queue<TreeNode<String>> q2 = new LinkedList<>();
		
		setBinaryTree(n1, q1);
		setBinaryTree(m1, q2);
		List<TreeNode<String>> ancesters = findFirstCommonAncester(q1, q2);
		
		if(ancesters == null || ancesters.size() == 0) {
			System.out.println("No common ancester is found.");
		} else if(ancesters.size() == 2){
			for(TreeNode<String> ancester : ancesters) {
				System.out.print(ancester.data + " ");
			}
		}
	}
	
	/**
	 * [wrong!!] clearly out of requirements.
	 */
	public static void setBinaryTree(TreeNode<String> root, Queue<TreeNode<String>> q) {
		if(root == null)
			return;
		
		Queue<TreeNode<String>> tempQ = new LinkedList<>();
		q.add(root);
		tempQ.add(root);
		
		while(!tempQ.isEmpty()) {
			TreeNode<String> tempNode = tempQ.poll();
			
			if(tempNode.left != null) {
				q.add(tempNode.left);
				tempQ.add(tempNode.left);
			}
			
			if(tempNode.right != null) {
				q.add(tempNode.right);
				tempQ.add(tempNode.right);
			}
		}
	}
	
	/**
	 * [wrong!!] clearly out of requirements.
	 */
	public static List<TreeNode<String>> findFirstCommonAncester(Queue<TreeNode<String>> q1, 
													Queue<TreeNode<String>> q2) {
		if(q1.size() * q2.size() == 0)
			return null;
		
		List<TreeNode<String>> ans = new ArrayList<>();
		
		while(!q1.isEmpty()) {
			TreeNode<String> first = q1.poll();
			
			for(TreeNode<String> node : q2) {
				if(first == node) {
					if(first.left != null && first.left == node.left) {
						ans.add(first);
						ans.add(first.left);
						return ans;
					}
					
					if(first.right != null && first.right == node.right) {
						ans.add(first);
						ans.add(first.right);
						return ans;
					}
				}
			}
		}

		return ans;
	}
}
