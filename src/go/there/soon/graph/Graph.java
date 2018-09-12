package go.there.soon.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import go.there.soon.common.GraphNode;
import go.there.soon.common.Status;

public class Graph<T extends Comparable<T>> {
	
	/**********
	 * FIELDS *
	 **********/
	private Set<GraphNode<T>> nodeSet;
	private List<GraphNode<T>> bfsPath;
	private List<GraphNode<T>> dfsPath;
	
	/****************
	 * CONSTRUCTORS *
	 ****************/
	public Graph() {
		this.bfsPath = new ArrayList<>();
		this.dfsPath = new ArrayList<>();
	}
	
	public void addNode(GraphNode<T> graphNode) {
		this.nodeSet.add(graphNode);
	}
	
	public Graph<T> calculateShortestPathFromSource(Graph<T> graph, GraphNode<T> source) {
		source.setDistance(0);
		
		Set<GraphNode<T>> visited = new HashSet<>();
		Set<GraphNode<T>> unvisited = new HashSet<>();
		
		unvisited.add(source);
		
		while(unvisited.size() != 0) {
			GraphNode<T> currentNode = getLowestDistanceNode(unvisited);
			unvisited.remove(currentNode);
			
			for(Map.Entry<GraphNode<T>, Integer> adjPair : currentNode.getAdjacentNodes().entrySet()) {
				GraphNode<T> adjNode = adjPair.getKey();
				int edgeWeight = adjPair.getValue();
				
				if(!visited.contains(adjNode)) {
					calculateMinimumDistance(adjNode, currentNode, edgeWeight);
					unvisited.add(adjNode);
				}
			}
			visited.add(currentNode);
		}
		
		return graph;
	}
	
	private void calculateMinimumDistance(
			GraphNode<T> evaluationNode,
			GraphNode<T> sourceNode,
			int edgeWeight) {
		if(sourceNode.getDistance() + edgeWeight < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceNode.getDistance() + edgeWeight);
			List<GraphNode<T>> tempShortestPath = new ArrayList<>(evaluationNode.getShortestPath());
			tempShortestPath.add(sourceNode);
			evaluationNode.setShortestPath(tempShortestPath);
		}
	}
	
	private GraphNode<T> getLowestDistanceNode(Set<GraphNode<T>> unsettledNodes) {
		GraphNode<T> lowestNode = new GraphNode<>();
		int lowest = Integer.MAX_VALUE;
		
		for(GraphNode<T> unsettledNode : unsettledNodes) {
			int distance = unsettledNode.getDistance();
			
			if(lowest > distance) {
				lowestNode.setDistance(distance);
				lowestNode = new GraphNode<>(unsettledNode);
			}
		}
		
		return lowestNode;
	}
	
	/**************
	 * TRAVERSALS *
	 **************/
	public void dfs(GraphNode<T> g) {
		g.setVisited(true);
		
		if(!this.getDfsPath().contains(g))
			this.getDfsPath().add(g);
		
		List<GraphNode<T>> successor = g.getSuccessors();

		for(GraphNode<T> current : successor) {
			if(!current.isVisited()) {
				dfs(current);
			}
		}
	}
	
	public void bfs(GraphNode<T> g) {
		g.setVisited(true);
		
		Queue<GraphNode<T>> q = new LinkedList<>();
		q.add(g);
		
		while(!q.isEmpty()) {
			GraphNode<T> current = q.poll();
			this.getBfsPath().add(current);
			
			List<GraphNode<T>> successors = current.getSuccessors();
			for(GraphNode<T> successor : successors) {
				if(!successor.isVisited()) {
					successor.setVisited(true);
					q.add(successor);
				}
			}
		}
	}
	
	/*************
	 * UTILITIES *
	 *************/
	public boolean hasCycle(GraphNode<T> g) {
		g.setStatus(Status.INPROGRESS.toString());
		List<GraphNode<T>> successor = g.getSuccessors();
		
		for(GraphNode<T> current : successor) {
			if(current.getStatus().equalsIgnoreCase(Status.INPROGRESS.toString()))
				return true;
			
			if(!current.getStatus().equalsIgnoreCase(Status.DONE.toString()))
				if(hasCycle(current))
					return true;
		}
		
		g.setStatus(Status.DONE.toString());
		return false;
	}

	/*********************
	 * SETTER AND GETTER *
	 *********************/
	public List<GraphNode<T>> getBfsPath() {
		return bfsPath;
	}
	public void setBfsPath(List<GraphNode<T>> bfsPath) {
		this.bfsPath = bfsPath;
	}
	public List<GraphNode<T>> getDfsPath() {
		return dfsPath;
	}
	public void setDfsPath(List<GraphNode<T>> dfsPath) {
		this.dfsPath = dfsPath;
	}

	public Set<GraphNode<T>> getNodeSet() {
		return nodeSet;
	}

	public void setNodeSet(Set<GraphNode<T>> nodeSet) {
		this.nodeSet = nodeSet;
	}
}
