package go.there.soon.leetCode.treesAndGraphs;

public class ClosestValue {

	public static void main(String[] args) {
		ClosestValue cv = new ClosestValue();
		cv.test();
	}
	
	public void test() {
		Solution s = new Solution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n4.setBoth(n2, n5);
		n2.setBoth(n1, n3);
		
		double target = 3.714286;
		int closestValue = s.closestValue2(n4, target);
		
		System.out.println("closest value of " 
					+ target + " is " 
					+ closestValue);
	}
	
	class Solution {
		public int closestValue2(TreeNode root, double target) {
			double diff = Double.MAX_VALUE;
			int min = 0;
			
			while(root != null) {
				if(Math.abs(root.val - target) < diff) {
					diff = Math.abs(root.val - target);
					min = root.val;
				} else if(root.val < target) {
					root = root.right;
				} else if(root.val > target) {
					root = root.left;
				} else {
					return min;
				}
			}
			
			return min;
		}
		
	    public int closestValue(TreeNode root, double target) {
	    		int [] arr = new int[1]; 
	    		Double minDiff = null;
	    		closestValueHelper(root, target, arr, minDiff);
	        return arr[0];
	    }
	    
	    public void closestValueHelper(TreeNode root, double target, int [] min, Double minDiff) {
	    		if(root != null) {
	    			if(minDiff == null || minDiff > Math.abs(target-root.val)) {
	    				minDiff = Math.abs(target-root.val);
	    				min[0] = root.val;
	    			}
	    			
	    			closestValueHelper(root.left, target, min, minDiff);
	    			closestValueHelper(root.right, target, min, minDiff);
	    		}
	    }
	}
}