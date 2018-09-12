package go.there.soon.graph.drivers;

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
		
		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);
		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);
		nodeC.addDestination(nodeE, 10);
		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);
		nodeF.addDestination(nodeE, 5);
		
		Graph<String> graph = new Graph<>();

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
		
		graph = graph.calculateShortestPathFromSource(graph, nodeA);
	}

}
