package codingproblems.geekForGeeks.problem.tree;

import java.util.*;

public class GraphDFS {
	
	private List<Integer> visited;
	private LinkedList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public GraphDFS(int v) {
		visited = new LinkedList<>();
		adj = new LinkedList[v];
		
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int start, int end) {
		if(!this.adj[start].contains(end))
			this.adj[start].add(end);
	}
	
	public void dfs(int start) {
		LinkedList<Integer> list = this.adj[start];
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i : list) {
			stack.push(i);
		}
		
		visited.add(start);
		System.out.print(start + " ");
		
		while(!stack.isEmpty()) {
			int top = stack.pop();
			
			if(!visited.contains(top)) {
				System.out.print(top + " ");
				visited.add(top);
				
				LinkedList<Integer> tempList = this.adj[top];
				
				while(!tempList.isEmpty()) {
					int t = tempList.removeFirst();
					if(!visited.contains(t)) {
						stack.push(t);
					}
				}
			}
		}
	}
	
    public static void main(String args[])
    {
    	GraphDFS g = new GraphDFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.dfs(2);
    }

}
