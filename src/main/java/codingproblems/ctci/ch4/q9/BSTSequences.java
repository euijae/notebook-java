package codingproblems.ctci.ch4.q9;

import java.util.ArrayList;
import java.util.List;

import codingproblems.ctci.ch4.tree.TreeNode;

public class BSTSequences {

	public static void main(String[] args) {
		TreeNode<Integer> n5 = new TreeNode<>(5);
		TreeNode<Integer> n2 = new TreeNode<>(2);
		TreeNode<Integer> n7 = new TreeNode<>(7);
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n3 = new TreeNode<>(3);
		
		n5.setBoth(n2, n7);
		n2.setBoth(n1, n3);
		
		List<List<Integer>> listOfArrays = new ArrayList<>();
		bstSquences(listOfArrays, n5);
		
		for(List<Integer> listOfArray : listOfArrays) {
			System.out.println(listOfArray.toString());
		}
	}
	
	public static void bstSquences(List<List<Integer>> listOfArrays, TreeNode<Integer> root) {
		
		if(root != null) {
			bstSquences(listOfArrays, root.left );
			
			Integer rootData  = root.data;
			Integer leftData  = (root.left  != null) ? new Integer(root.left.data)  : null;
			Integer rightData = (root.right != null) ? new Integer(root.right.data) : null;
			
			if(rightData != null || leftData != null) {
				System.out.println("root: " + rootData 
						+ ((leftData != null ? ", left" + leftData : ""))
						+ ((rightData != null ? ", right" + rightData : "")));
				
				List<Integer> temp = new ArrayList<>();
				temp.add(rootData);
				temp.add(leftData);
				temp.add(rightData);
			}
			
			bstSquences(listOfArrays, root.right);
		}
	}
}
