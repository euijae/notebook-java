package datastructures;

import java.util.ArrayList;
import java.util.List;

import datastructures.common.GraphNode;
import datastructures.lecture.graph.Graph;

public class Scratch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Scratch.class.getName());
		testGraphDFS();
		testGraphBFS();
	}
	
	public static void testGraphDFS() {
		GraphNode<Character> node0 = new GraphNode<>();
		GraphNode<Character> node1 = new GraphNode<>();
		GraphNode<Character> node2 = new GraphNode<>();
		GraphNode<Character> node3 = new GraphNode<>();
		GraphNode<Character> node4 = new GraphNode<>();
		GraphNode<Character> node5 = new GraphNode<>();
		
		node0.setData('a');
		node1.setData('b');
		node2.setData('c');
		node3.setData('d');
		node4.setData('e');
		node5.setData('f');
		
		List<GraphNode<Character>> list0 = new ArrayList<>();
		List<GraphNode<Character>> list1 = new ArrayList<>();
		List<GraphNode<Character>> list2 = new ArrayList<>();
		List<GraphNode<Character>> list3 = new ArrayList<>();
		List<GraphNode<Character>> list4 = new ArrayList<>();
		List<GraphNode<Character>> list5 = new ArrayList<>();
		
		list0.add(node1);
		list0.add(node2);
		list1.add(node3);
		list1.add(node4);
		list2.add(node4);
		list3.add(node4);
		list3.add(node5);
		list4.add(node5);
		
		node0.setSuccessors(list0);
		node1.setSuccessors(list1);
		node2.setSuccessors(list2);
		node3.setSuccessors(list3);
		node4.setSuccessors(list4);
		node5.setSuccessors(list5);
		
		Graph<Character> graph = new Graph<>();
		graph.dfs(node0);
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < graph.getDfsPath().size(); i++)
			sb.append(graph.getDfsPath().get(i).getData() + " ");
		
		System.out.println("DFS: " + sb.toString());
	}
	public static void testGraphBFS() {
		GraphNode<Integer> node0 = new GraphNode<>();
		GraphNode<Integer> node1 = new GraphNode<>();
		GraphNode<Integer> node2 = new GraphNode<>();
		GraphNode<Integer> node3 = new GraphNode<>();
		
		node0.setData(0);
		node1.setData(1);
		node2.setData(2);
		node3.setData(3);
		
		List<GraphNode<Integer>> list0 = new ArrayList<>();
		List<GraphNode<Integer>> list1 = new ArrayList<>();
		List<GraphNode<Integer>> list2 = new ArrayList<>();
		List<GraphNode<Integer>> list3 = new ArrayList<>();
		
		list0.add(node1);
		list0.add(node2);
		list1.add(node2);
		list2.add(node0);
		list2.add(node3);
		list3.add(node3);
		
		node0.setSuccessors(list0);
		node1.setSuccessors(list1);
		node2.setSuccessors(list2);
		node3.setSuccessors(list3);
		
		Graph<Integer> graph = new Graph<>();
		graph.bfs(node2);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < graph.getBfsPath().size(); i++)
			sb.append(graph.getBfsPath().get(i).getData() + " ");
		
		System.out.println("BFS: " + sb.toString());
		System.out.println(graph.hasCycle(node2) ? "Cycle" : "Acycle");
	}
}
