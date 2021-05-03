package main.java.datastructures.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static main.java.datastructures.common.Status.*;

public class GraphNode<T extends Comparable<T>> {

	private T data;
	private int distance;
	private boolean visited;
	private String status;
	private GraphNode<T> predecessor;
	private List<GraphNode<T>> successors   = new LinkedList<>();
	private List<GraphNode<T>> predecessors = new LinkedList<>();
	private List<GraphNode<T>> shortestPath = new LinkedList<>();
	private Map<GraphNode<T>, Integer> adjacentNodes = new HashMap<>();

	/** Constructors */
	public GraphNode() {
		this.setVisited(false);
		this.setStatus(UNVISITED.toString());
		this.setDistance(Integer.MAX_VALUE);
		this.setPredecessor(null);
	}

	public GraphNode(T data) {
		this();
		this.setData(data);
	}

	public GraphNode(GraphNode<T> g) {
		this.setAdjacentNodes(g.getAdjacentNodes());
		this.setData(g.getData());
		this.setDistance(g.getDistance());
		this.setPredecessors(g.getPredecessors());
		this.setShortestPath(g.getShortestPath());
	}

	/** Setter and getter */
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<GraphNode<T>> getSuccessors() {
		return successors;
	}
	public void setSuccessors(List<GraphNode<T>> successors) {
		this.successors = successors;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<GraphNode<T>> getPredecessors() {
		return predecessors;
	}
	public void setPredecessors(List<GraphNode<T>> predecessors) {
		this.predecessors = predecessors;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<GraphNode<T>> getShortestPath() {
		return shortestPath;
	}
	public void setShortestPath(List<GraphNode<T>> shortestPath) {
		this.shortestPath = shortestPath;
	}
	public Map<GraphNode<T>, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}
	public void setAdjacentNodes(Map<GraphNode<T>, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	public GraphNode<T> getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(GraphNode<T> predecessor) {
		this.predecessor = predecessor;
	}
}
