package go.there.soon.lecture.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import go.there.soon.common.GraphNode;
import go.there.soon.common.Status;

public class Graph<T extends Comparable<T>> {
	
	/**********
	 * FIELDS *
	 **********/
	private List<GraphNode<T>> bfsPath;
	private List<GraphNode<T>> dfsPath;
	
	/****************
	 * CONSTRUCTORS *
	 ****************/
	public Graph() {
		this.bfsPath = new ArrayList<>();
		this.dfsPath = new ArrayList<>();
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
}
