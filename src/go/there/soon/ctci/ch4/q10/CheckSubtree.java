package go.there.soon.ctci.ch4.q10;

import java.util.LinkedList;
import java.util.Queue;

import go.there.soon.ctci.ch4.tree.TreeNode;

public class CheckSubtree {

	public static void main(String[] args) {
		TreeNode<Integer> n1  = new TreeNode<Integer>(1);
		TreeNode<Integer> n2  = new TreeNode<Integer>(2);
		TreeNode<Integer> n3  = new TreeNode<Integer>(3);
		TreeNode<Integer> n4  = new TreeNode<Integer>(4);
		TreeNode<Integer> n5  = new TreeNode<Integer>(5);
		TreeNode<Integer> n6  = new TreeNode<Integer>(6);
		TreeNode<Integer> n7  = new TreeNode<Integer>(7);
		TreeNode<Integer> n8  = new TreeNode<Integer>(8);
		TreeNode<Integer> n9  = new TreeNode<Integer>(9);
		TreeNode<Integer> n10 = new TreeNode<Integer>(10);
		TreeNode<Integer> n11 = new TreeNode<Integer>(11);
		TreeNode<Integer> n12 = new TreeNode<Integer>(12);
		TreeNode<Integer> n13 = new TreeNode<Integer>(13);
		TreeNode<Integer> n14 = new TreeNode<Integer>(14);
		TreeNode<Integer> n15 = new TreeNode<Integer>(15);
		TreeNode<Integer> n16 = new TreeNode<Integer>(16);
		TreeNode<Integer> n17 = new TreeNode<Integer>(17);
		TreeNode<Integer> n18 = new TreeNode<Integer>(18);
		TreeNode<Integer> n19 = new TreeNode<Integer>(19);
		TreeNode<Integer> n20 = new TreeNode<Integer>(20);
		TreeNode<Integer> n21 = new TreeNode<Integer>(21);
		TreeNode<Integer> n22 = new TreeNode<Integer>(22);
		TreeNode<Integer> n23 = new TreeNode<Integer>(23);
		TreeNode<Integer> n24 = new TreeNode<Integer>(24);
		TreeNode<Integer> n25 = new TreeNode<Integer>(25);
		TreeNode<Integer> n26 = new TreeNode<Integer>(26);
		TreeNode<Integer> n27 = new TreeNode<Integer>(27);
		TreeNode<Integer> n28 = new TreeNode<Integer>(28);
		TreeNode<Integer> n29 = new TreeNode<Integer>(29);
		TreeNode<Integer> n30 = new TreeNode<Integer>(30);
		TreeNode<Integer> n31 = new TreeNode<Integer>(31);
		
		n1.setBoth(n2, n3);
		n2.setBoth(n8, n9);
		n3.setBoth(n6, n7);
		n4.setBoth(n8, n9);
		n5.setBoth(n10, n11);
		n6.setBoth(n12, n13);
		n7.setBoth(n14, n15);
		n8.setBoth(n16, n17);
		n9.setBoth(n18, n19);
		n10.setBoth(n20, n21);
		n11.setBoth(n22, n23);
		n12.setBoth(n24, n25);
		n13.setBoth(n26, n27);
		n14.setBoth(n28, n29);
		n15.setBoth(n30, n31);
		
		System.out.println(checkSubtree1(n1, n15));
	}
	
	public static boolean checkSubtree2(TreeNode<Integer> t1, TreeNode<Integer> t2) {
		if(t1 == null) 
			return false;
		if(t1.data == t2.data && isIdentical(t1, t2)) {
			return true;
		}
		
		return checkSubtree2(t1.left, t2) || checkSubtree2(t1.right, t2);
	}
	
	public static boolean checkSubtree1(TreeNode<Integer> t1, TreeNode<Integer> t2) {
		if(t1 == null || t2 == null) return false;
		
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(t1);
		
		while(!q.isEmpty()) {
			TreeNode<Integer> first = q.poll();
			
			if(first == t2) {
				return isIdentical(first, t2);
			}
			
			if(first.left != null) {
				q.add(first.left);
			}
			
			if(first.right != null) {
				q.add(first.right);
			}
		}
		
		return false;
	}
	
	public static boolean isIdentical(TreeNode<Integer> r1, TreeNode<Integer> r2) {
		if(r1 == null && r2 == null)
			return true;
		if(r1 != r2)
			return false;
		
		return isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
	}
}
