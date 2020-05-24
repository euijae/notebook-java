package codingproblems.scratch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TolopogicalSort {
	public static void main(String[] args) {
		(new TolopogicalSort()).test();
	}
	
	@SuppressWarnings("unused")
	public void test() {
		GraphNode n40 = new GraphNode(40);
		GraphNode n10 = new GraphNode(10);
		GraphNode n20 = new GraphNode(20);
		GraphNode n30 = new GraphNode(30);
		GraphNode n50 = new GraphNode(50);
		GraphNode n60 = new GraphNode(60);
		GraphNode n70 = new GraphNode(70);
		
		n40.neighbors.add(n10);
		n40.neighbors.add(n20);
		n10.neighbors.add(n30);
		n20.neighbors.add(n10);
		n20.neighbors.add(n30);
		n20.neighbors.add(n50);
		n20.neighbors.add(n60);
		n30.neighbors.add(n60);
		n50.neighbors.add(n70);
		n60.neighbors.add(n70);
		
		map.put(n10, 2);
		map.put(n20, 1);
		map.put(n30, 2);
		map.put(n40, 0);
		map.put(n50, 1);
		map.put(n60, 2);
		map.put(n70, 2);
		
		topologicalSort(n40);
	}
	
	class GraphNode {
		int data;
		List<GraphNode> neighbors;
		boolean isVisited;
		
		public GraphNode(int data) {
			this.data = data;
			this.neighbors = new ArrayList<>();
			this.isVisited = false;
		}
	}
	
	public Map<GraphNode, Integer> map;
	public List<GraphNode> ans;
	public LinkedList<GraphNode> q;
	
	public TolopogicalSort() {
		this.q = new LinkedList<>();
		this.ans = new ArrayList<>();
		this.map = new HashMap<>();
	}
	
	public void topologicalSort(GraphNode root) {
		q.add(root);
		ans.add(root);
		updateMap(root);
		root.isVisited = true;
		
		while(!q.isEmpty()) {
			List<GraphNode> nodes = q.removeFirst().neighbors;
			for(GraphNode node : nodes) {
				updateMap(node);
				node.isVisited = true;
			}
		}
		
		System.out.println(toString(ans));
	}
	
	public void updateMap(GraphNode node) {
		for(GraphNode n : node.neighbors) {
			int value = map.get(n);
			if(map.containsKey(n) && value >= 1) {
				if(value == 1) {
					q.add(n);
					ans.add(n);
					map.put(n, 0);
				} else {
					map.put(n, value-1);
				}
			}
		}
	}
	
	public String toString(List<GraphNode> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).data + (i == list.size()-1 ? "]" : ", "));
		}
		
		return sb.toString();
	}
}
