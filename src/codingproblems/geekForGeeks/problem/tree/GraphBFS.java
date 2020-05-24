package codingproblems.geekForGeeks.problem.tree;

import java.util.LinkedList;

public class GraphBFS {
	private LinkedList<Integer>[] adj;
	
    @SuppressWarnings("unchecked")
	public GraphBFS(int total) {
    	this.adj = new LinkedList[total];
    	
    	for(int i = 0; i < total; i++)
    		this.adj[i] = new LinkedList<>();
    } 
    
    public void addEdge(int x, int y) {
    	if(!this.adj[x].contains(y))
    		this.adj[x].add(y);
    }
    
    public void bfs(int x) {
    	LinkedList<Integer> list = this.adj[x];
    	LinkedList<Integer> visited = new LinkedList<>();
    	System.out.println(x + " ");
    	visited.add(x);
    	
    	while(!list.isEmpty()) {
    		int y = list.removeFirst();
    		LinkedList<Integer> vertices = this.adj[y];
    		System.out.println(y + " ");
    		visited.add(y);
    		
    		while(!vertices.isEmpty()) {
    			int v = vertices.removeFirst();
    			if(!visited.contains(v))
    				list.add(v);
    		}
    	}
    }
    
    public static void main(String args[])
    {
    	GraphBFS g = new GraphBFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.bfs(2);
    }
}
