package codingproblems.leetCode.treesAndGraphs;

public class FB_SameTree {

	public static void main(String[] args) {
		String s = "12";
		System.out.println(s.substring(0, s.length()-1));
		FB_SameTree o = new FB_SameTree();
		o.test();
	}

	@SuppressWarnings("unused")
	public void test() {
		Solution sol = new Solution();
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(1);
		TreeNode p3 = new TreeNode(3);
		
		p1.setBoth(p2, null);
		
		TreeNode q1 = new TreeNode(1);
		TreeNode q2 = new TreeNode(3);
		TreeNode q3 = new TreeNode(1);
		
		q1.setBoth(null, q3);
		
		System.out.println(sol.isSameTree(p1, q1));
	}
	
	class Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if(p == null && q == null)
				return true;
			else if(p == null || q == null)
				return false;
			
			return matchTree(p, q);
		}
		
		public boolean matchTree(TreeNode p, TreeNode q) {
			if(p == null && q == null) {
				return true;
			} else if(p == null || q == null) {
				return false;
			} else {
				if(p.val != q.val)
					return false;
				else {
					return matchTree(p.left, q.left) && matchTree(p.right, q.right);
				}
			}
		}
		
	    public boolean isSameTree1(TreeNode p, TreeNode q) {
	        StringBuilder pathP = new StringBuilder();
	        StringBuilder pathQ = new StringBuilder();
	        getPath(p, pathP);
	        getPath(q, pathQ);
	        
	        System.out.println("p: " + pathP.toString());
	        System.out.println("q: " + pathQ.toString());
	        
	        return pathP.toString().equalsIgnoreCase(pathQ.toString());
	    }
	    
	    public void getPath(TreeNode n, StringBuilder sb) {
	        if(n != null) {
	            getPath(n.left, sb);
	            
	            if(n.left == null)
	            		if(n.right != null)
	            			sb.append("X");
	            
	            sb.append(n.val);
	            
	            if(n.right == null)
	            		if(n.left != null)
	            			sb.append("X");
	            
	            getPath(n.right, sb);
	        }
	    }
	}
}
