package codingproblems.ctci.ch4.q1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import codingproblems.ctci.ch4.graph.GraphNode;

public class RouteBetweenNodes {

	public static void main(String[] args) {
		RouteBetweenNodes rbn = new RouteBetweenNodes();
		rbn.test();
	}
	
	private Stack<GraphNode<Integer>> stack = new Stack<>();
	
	public void test() {
		GraphNode<Integer> n0 = new GraphNode<>(0);
		GraphNode<Integer> n1 = new GraphNode<>(1);
		GraphNode<Integer> n2 = new GraphNode<>(2);
		GraphNode<Integer> n3 = new GraphNode<>(3);
		GraphNode<Integer> n4 = new GraphNode<>(4);
		GraphNode<Integer> n5 = new GraphNode<>(5);
		GraphNode<Integer> n6 = new GraphNode<>(6);
		
		n0.adjacents.add(n1);
		n0.adjacents.add(n4);
		n0.adjacents.add(n5);
		n1.adjacents.add(n3);
		n1.adjacents.add(n4);
		n2.adjacents.add(n1);
		n3.adjacents.add(n2);
		n3.adjacents.add(n4);
		
		System.out.println("dfs_recursive: " + dfs_iterative(n0, n6));
//		System.out.println("dfs_iterative: " + dfs_iterative(n0, n2));
		n0.isVisited = false;
		n1.isVisited = false;
		n2.isVisited = false;
		n3.isVisited = false;
		n4.isVisited = false;
		n5.isVisited = false;
		System.out.println("bfs_iterative: " + bfs_iterative(n0, n3));
	}
	
	public boolean dfs_recursive(GraphNode<Integer> curr, GraphNode<Integer> dest) {
		if(curr == null || dest == null)
			return false;
		
		if(curr.data.compareTo(dest.data) == 0) {
			stack = new Stack<>();
			return true;
		} else {
			stack.push(curr);
			curr.isVisited = true;
		}
		
		List<GraphNode<Integer>> adjacents = curr.adjacents;
		for(GraphNode<Integer> g : adjacents) {
			if(!g.isVisited) {
				dfs_recursive(g, dest);
			}
		}
		stack = new Stack<>();
		return false;
	}
	
	public boolean dfs_iterative(GraphNode<Integer> curr, GraphNode<Integer> dest) {
		if(curr == null || dest == null)
			return false;
		
		if(curr.data.compareTo(dest.data) == 0)
			return true;
		
		stack.push(curr);
		
		while(!stack.isEmpty()) {
			GraphNode<Integer> g = stack.pop();
			if(g != null) {
				if(g.data.compareTo(dest.data) == 0) return true;
				g.isVisited = true;
				
				for(GraphNode<Integer> neighbor : g.adjacents) {
					if(!neighbor.isVisited) {
						if(neighbor.data.compareTo(dest.data) == 0) return true;
						stack.push(neighbor);
					}
				}
				g.isVisited = true;
			}
				
		}
		
		return false;
	}

	public boolean bfs_iterative(GraphNode<Integer> root, GraphNode<Integer> dest) {
		Queue<GraphNode<Integer>> q = new LinkedList<>();
		
		q.add(root);
		root.isVisited = true;
		
		while(!q.isEmpty()) {
			GraphNode<Integer> g = q.poll();
			if(g != null) {
				for(GraphNode<Integer> n : g.adjacents) {
					if(!n.isVisited) {
						if(n==dest) return true;
						n.isVisited = true;
						q.add(n);
					}
				}
				g.isVisited = true;
			}
				
		}
		
		return false;
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		Stack<GraphNode<Integer>> temp = stack;
		while(!temp.isEmpty()) {
			GraphNode<Integer> g = temp.pop();
			sb.append(g.data + " ");
		}
		System.out.println(sb.toString());
	}
}
