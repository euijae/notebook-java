package go.there.soon.graph.drivers;

import java.util.HashMap;
import java.util.Map;

import go.there.soon.common.GraphNode;
import go.there.soon.graph.Graph;

public class DijkstraDriver {

	public static void main(String[] args) {
		GraphNode<String> nodeA = new GraphNode<>("A");
		GraphNode<String> nodeB = new GraphNode<>("B");
		GraphNode<String> nodeC = new GraphNode<>("C");
		GraphNode<String> nodeD = new GraphNode<>("D");
		GraphNode<String> nodeE = new GraphNode<>("E");
		GraphNode<String> nodeF = new GraphNode<>("F");
		
		Map<GraphNode<String>, Integer> map1 = new HashMap<>();
		Map<GraphNode<String>, Integer> map2 = new HashMap<>();
		Map<GraphNode<String>, Integer> map3 = new HashMap<>();
		Map<GraphNode<String>, Integer> map4 = new HashMap<>();
		Map<GraphNode<String>, Integer> map5 = new HashMap<>();
		map1.put(nodeB, 10);
		map1.put(nodeC, 15);
		map2.put(nodeD, 12);
		map2.put(nodeF, 15);
		map3.put(nodeE, 10);
		map4.put(nodeE, 2);
		map4.put(nodeF, 1);
		map5.put(nodeE, 5);
		nodeA.setAdjacentNodes(map1);
		nodeB.setAdjacentNodes(map2);
		nodeC.setAdjacentNodes(map3);
		nodeD.setAdjacentNodes(map4);
		nodeF.setAdjacentNodes(map5);
		
		Graph<String> graph = new Graph<>();
		graph.dijkstra(nodeA);
	}
}
