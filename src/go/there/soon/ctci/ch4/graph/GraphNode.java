package go.there.soon.ctci.ch4.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T extends Comparable<T>> {
	public List<GraphNode<T>> adjacents;
	public boolean isVisited;
	public T data;
	
	public GraphNode(T data) {
		adjacents = new ArrayList<>();
		isVisited = false;
		this.data = data;
	}

}
