package go.there.soon.common;

import java.util.List;

public class GraphNode<T extends Comparable<T>> {
	
	private T data;
	private boolean visited;
	private String status;
	private List<GraphNode<T>> successors;
	
	/***************
	 * CONSTRUCTOR *
	 ***************/
	public GraphNode() {
		this.visited = false;
		this.status  = Status.UNVISITED.toString();
	}
	
	/*********************
	 * SETTER AND GETTER *
	 *********************/
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
}
