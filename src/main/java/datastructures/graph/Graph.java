package main.java.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import main.java.datastructures.common.GraphNode;
import main.java.datastructures.common.Status;

public class Graph<T extends Comparable<T>> {

	/** Fields */
	private List<GraphNode<T>> bfsPath;
	private List<GraphNode<T>> dfsPath;

	/** Recipe for Topological Order */
	private Queue<T> toQueue;
	private Queue<T> toSortQueue;
	private Map<T, Integer> toInDegree;
	private Map<T, List<T>> toAdjacentMap;
	private T toSource;

	/** Constructors */
	public Graph() {
		this.bfsPath = new ArrayList<>();
		this.dfsPath = new ArrayList<>();

		this.toQueue 	 = new LinkedList<>();
		this.toSortQueue = new LinkedList<>();

		this.toInDegree 	= new HashMap<>();
		this.toAdjacentMap  = new HashMap<>();
	}

	/** Traversals */
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

	public void dijkstra(GraphNode<T> g) {
		Queue<GraphNode<T>> queue = new LinkedList<>();
		g.setDistance(0);
		queue.add(g);

		Map<GraphNode<T>, Integer> shortestPath = new LinkedHashMap<>();
		shortestPath.put(g, 0);

		while(!queue.isEmpty()) {
			GraphNode<T> current = queue.poll();

			for(Map.Entry<GraphNode<T>, Integer> entry : current.getAdjacentNodes().entrySet()) {
				GraphNode<T> adj = entry.getKey();
				int weight = entry.getValue();

				if(current.getDistance() + weight < adj.getDistance()) {
					int d = current.getDistance() + weight;
					adj.setDistance(d);
					adj.setPredecessor(current);
					shortestPath.put(adj, d);
					queue.add(adj);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(Map.Entry<GraphNode<T>, Integer> map : shortestPath.entrySet())
			sb.append("[" + map.getKey().getData() + ", " + map.getValue() + "] ");

		System.out.println(sb.toString());
	}

	public void topologicalSort(T source) {
		toQueue.add(source);
		toSortQueue.add(source);
		toInDegree.remove(source);

		while(!toQueue.isEmpty()) {
			T node = toQueue.poll();
			topologicalSortUtility(node);
		}
	}

	public void topologicalSortUtility(T nodeKey) {
		List<T> entrySet = this.toAdjacentMap.get(nodeKey);

		if(entrySet != null) {
			for(T key : entrySet) {
				int value = this.toInDegree.get(key);

				if(value == 1) {
					this.toQueue.add(key);
					this.toSortQueue.add(key);
					this.toInDegree.remove(key);
				} else {
					this.toInDegree.put(key, value-1);
				}
			}
		}

		this.toAdjacentMap.remove(nodeKey);
	}

	/** Utilities */
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

	/** Setter and getter */
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
	public Queue<T> getToQueue() {
		return toQueue;
	}
	public void setToQueue(Queue<T> toQueue) {
		this.toQueue = toQueue;
	}
	public Map<T, Integer> getToInDegree() {
		return toInDegree;
	}
	public void setToInDegree(Map<T, Integer> toInDegree) {
		this.toInDegree = toInDegree;
	}
	public Map<T, List<T>> getToAdjacentMap() {
		return toAdjacentMap;
	}
	public void setToAdjacentMap(Map<T, List<T>> toAdjacentMap) {
		this.toAdjacentMap = toAdjacentMap;
	}
	public T getToSource() {
		return toSource;
	}
	public void setToSource(T toSource) {
		this.toSource = toSource;
	}

	public Queue<T> getToSortQueue() {
		return toSortQueue;
	}

	public void setToSortQueue(Queue<T> toSortQueue) {
		this.toSortQueue = toSortQueue;
	}
}
