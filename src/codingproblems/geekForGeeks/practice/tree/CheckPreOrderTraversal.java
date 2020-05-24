package codingproblems.geekForGeeks.practice.tree;

import java.util.List;

public class CheckPreOrderTraversal {

	public boolean isPreOrderTraversal(int [] pre) {
		BinaryTree btree = new BinaryTree();
		
		for(int i = 0; i < pre.length; i++)
			btree.insert(pre[i]);
		
		btree.preOrder();
		
		List<Integer> preOrderList = btree.getPreOrderList();
		
		for(int i = 0; i < pre.length; i++)
			if(preOrderList.get(i) != pre[i])
				return false;
		
		return true;
	}
}
