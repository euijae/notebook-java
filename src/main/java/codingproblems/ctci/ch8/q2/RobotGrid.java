package codingproblems.ctci.ch8.q2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RobotGrid {

	public static void main(String[] args) {
		for(Point path : getPath(2, 2)) 
			System.out.println(path.toString());
		
		for(String str : sol1(2, 2))
			System.out.println(str);
		
		for(List<Point> path : sol2(2, 2))
			System.out.println(path.toString());
	}

	public static List<String> sol1(int row, int col) {
		List<String> path = new ArrayList<>();
		sol1_helper(row, col, "", path);
		return path;
	}
	
	public static void sol1_helper(int r, int c, String str, List<String> path) {
		if(r == 0 && c == 0) {
			path.add(str);
		} 
		
		if(r >= 0 && c >=0) {
			sol1_helper(r-1, c, (str.isEmpty() ? "r" : str + "-r"), path);
			sol1_helper(r, c-1, (str.isEmpty() ? "c" : str + "-c"), path);
		}
	}
	
	public static List<List<Point>> sol2(int row, int col) {
		List<List<Point>> paths = new ArrayList<>();
		sol2_helper(row, col, new ArrayList<>(), paths);
		
		return paths;
	}
	
	public static void sol2_helper(int r, int c, List<Point> path, List<List<Point>> paths) {
		if(r == 0 && c == 0) {
			path.add(new Point(0, 0));
			paths.add(path);
		} else if(r >= 0 && c >= 0) {
			path.add(new Point(r, c));
			sol2_helper(r-1, c, path, paths);
			sol2_helper(r, c-1, path, paths);
		}
	}
	
	public static ArrayList<Point> getPath(int row, int col) {
		ArrayList<Point> path = new ArrayList<>();
		HashSet<Point> failedPoints = new HashSet<>();
		if(getPath(row, col, path, failedPoints))
			return path;
		return null;
	}
	
	public static boolean getPath(int row, int col,
			ArrayList<Point> path, HashSet<Point> failedPoints) {
		if(col < 0 || row < 0) {
			return false;
		}
		
		Point p = new Point(row, col);
		
		if(failedPoints.contains(p)) {
			return false;
		}
			
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		if(isAtOrigin || getPath(row, col-1, path, failedPoints)
				|| getPath(row-1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}
		
		failedPoints.add(p);
		return false;
	}
}

class Point {
	public int row;
	public int col;
	public Point() {}
	public Point(int r, int c) {
		row = r;
		col = c;
	}
	@Override
	public String toString() {
		return row + "-" + col;
	}
}