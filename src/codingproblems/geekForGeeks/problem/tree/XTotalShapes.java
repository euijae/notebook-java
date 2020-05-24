package codingproblems.geekForGeeks.problem.tree;

import java.util.LinkedList;
import java.util.Queue;

public class XTotalShapes {

	public static void main(String[] args) {
		int [][] m = {
		    // OOOOXXO OXOXOOX XXXXOXO OXXXOOO
			// {0, 0, 0, 0, 1, 1, 0},{0, 1, 0, 1, 0, 0, 1},{1, 1, 1, 1, 0, 1, 0},{0, 1, 1, 1, 0, 0, 0}
			// XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO
			{1, 1, 0},
			{0, 0, 1},
			{0, 1, 0},
			{0, 0, 0},
			{1, 0, 1},
			{1, 0, 1},
			{0, 1, 0},
			{1, 1, 0},
			{1, 1, 1},
			{0, 0, 0}
		};
		
		int result = counter(m);
		
		System.out.println(result);
	}
	
	public static int counter(int [][] m) {
	    int count = 0;
	    
	    if(m.length * m[0].length == 0 || m == null) {
	        return count;
	    }
	    
	    for(int i = 0; i < m.length; i++) {
	        for(int j = 0; j < m[0].length; j++) {
	            if(isValid(m, i, j)) {
	                Queue<Integer []> q = new LinkedList<>();
	                
	                q.add(new Integer[]{i, j});
                    
	                while(!q.isEmpty()) {
	                    Integer [] coordi = q.poll();
	                    
	                    int x = coordi[0];
	                    int y = coordi[1];
	                    
	                    if(isValid(m, x+1, y)) {
	                        m[x+1][y] = 0;
	                        q.add(new Integer[]{x+1, y});
	                    }
	                    
	                    if(isValid(m, x-1, y)) {
	                        m[x-1][y] = 0;
	                        q.add(new Integer[]{x-1, y});
	                    }
	                    
	                    if(isValid(m, x, y+1)) {
	                        m[x][y+1] = 0;
	                        q.add(new Integer[]{x, y+1});
	                    }
	                    
	                    if(isValid(m, x, y-1)) {
	                        m[x][y-1] = 0;
	                        q.add(new Integer[]{x, y-1});
	                    }
	                }
	                
	                count ++;
	            }
	        }
	    }
	    
	    return count;
	}
	
	public static boolean isValid(int [][] m, int x, int y) {
	    return !(x < 0 || y < 0  || x >= m.length || y >= m[0].length || m[x][y] == 0);
	}
}