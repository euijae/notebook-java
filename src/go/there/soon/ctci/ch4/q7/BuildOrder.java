package go.there.soon.ctci.ch4.q7;

import java.util.ArrayList;
import java.util.List;

import go.there.soon.ctci.ch4.graph.GraphNode;

public class BuildOrder {

	public static void main(String[] args) {
		BuildOrder bo = new BuildOrder();
		bo.setMap();
		bo.topologicalSort();
	}

	private List<GraphNode<Character>> orderList;
	private List<GraphNode<Character>> graphNodes;
	
	public BuildOrder() {
		this.orderList = new ArrayList<>();
		this.graphNodes = new ArrayList<>();
	}
	
	public void setMap() {
		GraphNode<Character> a = new GraphNode<>('a');
		GraphNode<Character> b = new GraphNode<>('b');
		GraphNode<Character> c = new GraphNode<>('c');
		GraphNode<Character> d = new GraphNode<>('d');
		GraphNode<Character> e = new GraphNode<>('e');
		GraphNode<Character> f = new GraphNode<>('f');
		
		a.adjacents.add(b);
		b.adjacents.add(d);
		d.adjacents.add(c);
		f.adjacents.add(a);
		f.adjacents.add(b);
		
		a.dependencies = 1;
		b.dependencies = 2;
		c.dependencies = 1;
		d.dependencies = 1;
		e.dependencies = 0;
		f.dependencies = 0;
		
		graphNodes.add(a);
		graphNodes.add(b);
		graphNodes.add(c);
		graphNodes.add(d);
		graphNodes.add(e);
		graphNodes.add(f);
	}
	
	public void topologicalSort() {
		int index = 0;
		int length = graphNodes.size();
		hasNonDependent(graphNodes);
		while(index < length) {
			GraphNode<Character> node = orderList.get(index);
			for(GraphNode<Character> neighbor : node.adjacents) {
				neighbor.dependencies--;
			}
			
			if(hasNonDependent(node.adjacents)) {
				index++;
			} else {
				return;
			}
		}
		
		print(orderList);
	}
	
	public boolean hasNonDependent(List<GraphNode<Character>> neighbors) {
		if(neighbors.size() == 0)
			return true;

		boolean isAdded = false;
		
		for(GraphNode<Character> neighbor : neighbors) {
			if(neighbor.dependencies == 0) {
				orderList.add(neighbor);
				isAdded =  true;
			}
		}
		
		return isAdded;
	}
	
	public void print(List<GraphNode<Character>> list) {
		for(GraphNode<Character> g : list) {
			System.out.print(g.data + " ");
		}
		System.out.println("");
	}
}
