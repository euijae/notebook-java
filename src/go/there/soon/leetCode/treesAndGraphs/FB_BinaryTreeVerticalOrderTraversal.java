package go.there.soon.leetCode.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


// [[-4,78,73,-77,-54,-36],[12,-51,-81,4,8,3,-30,-33,86,81,98,24],[-64,-53,-31,47,-35,-67,-37,72,-4,-38,-31,-31,-18,-66,43,-72],[18,-93,33,-51,-38,47,-24,-11,80,44,-91,-42,-40,70,-93],[76,3,-64,26,-31,-19,10,-85,-96,67,34,-92,-1],[3,-44,-60,12,-51,-59,67,-88,48,-26,92,72],[53,-81,27,60,-55,-70,72,56,-88,-98,-84],[11,-49,-90,90,-34,-27,-67,98],[74,17,-17,-65,-53,39],[37]]
// [[-4,78,73,-77,-54,-36],[12,-51,-81,4,8,3,-30,-33,86,81,98,24],[-64,-53,-31,47,-35,-67,-37,72,-4,-38,-31,-31,-18,-66,-72,43],[18,-93,33,-51,-38,47,-24,-11,80,44,-91,-42,-40,70,-93],[76,3,-64,26,-31,-19,10,-85,-96,67,34,-92,-1],[3,-44,-60,12,-59,-51,67,-88,48,-26,92,72],[53,-81,27,60,-55,-70,72,56,-88,-98,-84],[11,-49,-90,90,-34,-27,-67,98],[74,17,-17,-65,-53,39],[37]]
public class FB_BinaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {
		FB_BinaryTreeVerticalOrderTraversal o = new FB_BinaryTreeVerticalOrderTraversal();
		o.test();
	}

	public void test() {
		Solution sol = new Solution();
		TreeNode n3 = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);
		
		n3.setBoth(n9, n20);
		n20.setBoth(n15, n7);
		
		for(List<Integer> level : sol.verticalOrder(n3))
			System.out.println(level.toString());
	}
	
	class Solution {
	    public List<List<Integer>> verticalOrder(TreeNode root) {
	        if(root == null)
	        		return new ArrayList<>();
	        
	        List<List<Integer>> lists = new ArrayList<>();
	        
	        // update the main map this values will be added to 'lists' 
	        Map<Integer, List<Integer>> map1 = new TreeMap<>();
	        List<Integer> list1 = map1.getOrDefault(0, new ArrayList<>());
	        list1.add(root.val);
	        map1.put(0, list1);
	        
	        // this contains nodes at the horizontally same level to avoid duplicate traversal
	        Map<Integer, List<TreeNode>> map2 = new TreeMap<>();
	        List<TreeNode> list2 = map2.getOrDefault(0, new ArrayList<>());
	        list2.add(root);
	        map2.put(0, list2);
	        
	        int numOfNextLevel = map2.size();
	        
	        while(numOfNextLevel != 0) {
	        		Map<Integer, List<TreeNode>> tempMap2 = new TreeMap<>();
	        		tempMap2.putAll(map2);
	        		map2.clear();
	        		
	        		for(Map.Entry<Integer, List<TreeNode>> entry : tempMap2.entrySet()) {
	        			for(TreeNode node : entry.getValue()) {
	        				if(node.left != null) {
	        					List<TreeNode> tempList2 = map2.getOrDefault(entry.getKey()-1, new ArrayList<>());
	        					tempList2.add(node.left);
	        					map2.put(entry.getKey()-1, tempList2);
	        					
	        					List<Integer> tempList1 = map1.getOrDefault(entry.getKey()-1, new ArrayList<>());
        						tempList1.add(node.left.val);
        						map1.put(entry.getKey()-1, tempList1);
	        				}
	        				
	        				if(node.right != null) {
	        					List<TreeNode> tempList2 = map2.getOrDefault(entry.getKey()+1, new ArrayList<>());
	        					tempList2.add(node.right);
	        					map2.put(entry.getKey()+1, tempList2);
	        					
	        					List<Integer> tempList1 = map1.getOrDefault(entry.getKey()+1, new ArrayList<>());
        						tempList1.add(node.right.val);
        						map1.put(entry.getKey()+1, tempList1);
	        				}
	        			}
	        		}
	        		
	        		numOfNextLevel = map2.size(); 
	        }
	        
	        for(Map.Entry<Integer, List<Integer>> entry : map1.entrySet()) {
	        		lists.add(entry.getValue());
	        }
	        
	        return lists;
	    }
	    
	    public void verticalOrderHelper(Map<Integer, List<Integer>> map,
	    									TreeNode current,
	    									int level) {
	    		if(current != null) {
	    			List<Integer> valueOfMap = map.getOrDefault(level, new ArrayList<>());
	    			valueOfMap.add(current.val);
	    			map.put(level, valueOfMap);
	    			
	    			verticalOrderHelper(map, current.left, level-1);
	    			verticalOrderHelper(map, current.right, level+1);
	    		}
	    }
	}
}
