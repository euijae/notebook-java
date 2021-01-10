package codingproblems.ctci.ch4.q3;

import java.util.LinkedList;

import codingproblems.ctci.ch4.tree.TreeNode;

public class ListOfDepths2 {

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = new TreeNode<>(2);
		TreeNode<Integer> n3 = new TreeNode<>(3);
		TreeNode<Integer> n4 = new TreeNode<>(4);
		TreeNode<Integer> n5 = new TreeNode<>(5);
		TreeNode<Integer> n6 = new TreeNode<>(6);
		TreeNode<Integer> n7 = new TreeNode<>(7);
		
		n4.setBoth(n2, n5);
		n2.setBoth(n1, n3);
		n5.setBoth(n6, n7);
		
		LinkedList<LinkedList<TreeNode<Integer>>> lists = depths(n4);
		
		int depth = 0;
		
		for(LinkedList<TreeNode<Integer>> list : lists) {
			System.out.println("[Depth " + depth + "]");
			for(TreeNode<Integer> node : list) {
				System.out.print(node.data + " ");
			}
			System.out.println("");
			depth++;
		}
	}

	public static LinkedList<LinkedList<TreeNode<Integer>>> depths(TreeNode<Integer> root) {
		if(root == null)
			return new LinkedList<>();
		
		LinkedList<LinkedList<TreeNode<Integer>>> lists = new LinkedList<>();
		LinkedList<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			LinkedList<TreeNode<Integer>> list = new LinkedList<>();
			
			for(int i = 0; i < size; i++) {
				TreeNode<Integer> node = q.removeFirst();
				list.add(node);
				
				if(node.left != null)
					q.add(node.left);
				
				if(node.right != null)
					q.add(node.right);
			}
			
			lists.add(list);
		}
		
		return lists;
	}
}
