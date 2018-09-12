package go.there.soon.geekForGeeks.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * @author eugene.kim
 *
 */
public class VerticalOrder {

	public static void printBottomView(Map<Integer, List<Node>> tree) {
		for(Map.Entry<Integer, List<Node>> entry : tree.entrySet()) {
			List<Node> value = entry.getValue();
			int size = value.size();
			System.out.print(value.get(size-1).getData() + " ");
		}
	}
	
	public static void printTopView(Map<Integer, List<Node>> tree) {
		for(Map.Entry<Integer, List<Node>> entry : tree.entrySet()) {
			System.out.print(entry.getValue().get(0).getData() + " ");
		}
	}
	
	public static void printVerticalOrder(Node root) {
		Map<Integer, List<Node>> tree = new TreeMap<>();
		Queue<Node> coordinator = new LinkedList<>();
		
		List<Node> temp = new ArrayList<>();
		temp.add(root);
		
		coordinator.add(root);
		tree.put(0, temp);
		
		while(!coordinator.isEmpty()) {
			Node node = coordinator.poll();
			int hd = node.getHd();
			
			if(node.left != null) {
				node.left.setHd(hd-1);
				coordinator.add(node.left);
				
				List<Node> leftList = (tree.containsKey(hd-1)) ? tree.get(hd-1) : new ArrayList<>();
				leftList.add(node.left);
				tree.put(hd-1, leftList);
			}
			
			if(node.right != null) {
				node.right.setHd(hd+1);
				coordinator.add(node.right);
				
				List<Node> rightList = (tree.containsKey(hd+1)) ? tree.get(hd+1) : new ArrayList<>();
				rightList.add(node.right);
				tree.put(hd+1, rightList);
			}
		}
		
		for(Map.Entry<Integer, List<Node>> entry : tree.entrySet()) {
			System.out.println(entry.getKey() + ": " + getString(entry.getValue()));
		}
		
		System.out.println("Print from top");
		printTopView(tree);
		System.out.println("Print from bottom");
		printBottomView(tree);
	}
	
	public static String getString(List<Node> list) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).getData());
			
			if(i != list.size() - 1)
				sb.append(", ");
		}
		
		return sb.toString();
	}
	
    public static void main(String[] args) {
    	Node root = new Node(20);
    	root.setHd(0);
    	
    	root.setLeft(new Node(8));
    	root.setRight(new Node(22));
    	
    	Node left = root.getLeft();
    	left.setLeft(new Node(5));
    	left.setRight(new Node(3));
    	
    	Node right = root.getRight();
    	right.setRight(new Node(25));
    	
    	Node leftRight = left.getRight();
    	leftRight.setLeft(new Node(10));
    	leftRight.setRight(new Node(14));
    	
    	printVerticalOrder(root);
    }
}
