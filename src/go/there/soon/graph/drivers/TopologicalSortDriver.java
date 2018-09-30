package go.there.soon.graph.drivers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import go.there.soon.common.GraphNode;
import go.there.soon.graph.Graph;

public class TopologicalSortDriver {

	public static void main(String[] args) {
		GraphNode<String> v1 = new GraphNode<>("v1");
		v1.toString();
		v1.notify();
		GraphNode<String> v2 = new GraphNode<>("v2");
		GraphNode<String> v3 = new GraphNode<>("v3");
		GraphNode<String> v4 = new GraphNode<>("v4");
		GraphNode<String> v5 = new GraphNode<>("v5");
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		List<String> list4 = new ArrayList<>();
		List<String> list5 = new ArrayList<>();
		
		list1.add(v2.getData());
		list1.add(v3.getData());
		list1.add(v4.getData());
		
		list2.add(v4.getData());
		list2.add(v5.getData());
		
		list4.add(v3.getData());
		list4.add(v5.getData());
		
		Map<String, Integer> toInDegree = new HashMap<>();
		toInDegree.put("v1", 0);
		toInDegree.put("v2", 1);
		toInDegree.put("v3", 2);
		toInDegree.put("v4", 2);
		toInDegree.put("v5", 2);
		
		Map<String, List<String>> toAdjacentMap = new HashMap<>();
		toAdjacentMap.put("v1", list1);
		toAdjacentMap.put("v2", list2);
		toAdjacentMap.put("v3", list3);
		toAdjacentMap.put("v4", list4);
		toAdjacentMap.put("v5", list5);
		
		Graph<String> graph = new Graph<>();
		graph.setToAdjacentMap(toAdjacentMap);
		graph.setToInDegree(toInDegree);
		graph.topologicalSort("v1");
		System.out.println(graph.getToSortQueue().toString());
	}
}
