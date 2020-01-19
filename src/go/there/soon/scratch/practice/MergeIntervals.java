package go.there.soon.scratch.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		mi.test();
	}
	
	public void test() {
		List<Point> points = new ArrayList<>();
		
		Point p1 = new Point(2, 4);
		Point p2 = new Point(6, 8);
		Point p3 = new Point(1, 3);
		Point p4 = new Point(9, 12);
		Point p5 = new Point(13, 15);
		Point p6 = new Point(5, 7);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		
		Collections.sort(points, new IntervalSort());
		
		List<Point> ans = new ArrayList<>();
		
		for(Point p : points) {
			if(ans.isEmpty()) {
				ans.add(p);
			} else {
				Point last = ans.get(ans.size()-1);
				int x1 = last.x;
				int y1 = last.y;
				
				int x2 = p.x;
				int y2 = p.y;
				
				if(x1 <= x2 && x2 <= y1) {
					last.x = Math.min(x1, x2);
					last.y = Math.max(y1, y2);
				} else {
					ans.add(p);
				}
			}
		}
		
		for(Point a : ans) {
			System.out.printf("[x, y] = [%d, %d]\n", a.x, a.y);
		}
	}
	
	public class IntervalSort implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			return (o1.x == o2.x) ? o1.y - o2.y : o1.x - o2.x;
		}
		
	}

	public class Point {
		public int x;
		public int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
