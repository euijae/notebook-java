package go.there.soon.ctci.ch4.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode<T extends Comparable<T>> {
	public List<GraphNode<T>> adjacents;
	public Map<T, GraphNode<T>> map;
	public boolean isVisited;
	public T data;
	public int dependencies;
	
	public GraphNode() {}
	
	public GraphNode(T data) {
		adjacents = new ArrayList<>();
		map = new HashMap<>();
		dependencies = 0;
		
		isVisited = false;
		this.data = data;
	}

	public void decreaseDependencies() {
		this.dependencies --;
	}
	
	public void increaseDependencies() {
		this.dependencies ++;
	}
}
