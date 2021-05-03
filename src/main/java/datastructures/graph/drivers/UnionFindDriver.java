package main.java.datastructures.graph.drivers;

import main.java.datastructures.graph.UnionFind;

public class UnionFindDriver {

	public static void main(String[] args) {
		System.out.println(UnionFindDriver.class.getName());
		UnionFind uf = new UnionFind(6);
		uf.print();
		uf.weightedUnion(0, 1);
		uf.print();
		uf.weightedUnion(1, 2);
		uf.print();
		uf.weightedUnion(3, 2);
		uf.print();

		System.out.println("uf.find(1, 4) = " + uf.find(1, 4));
		System.out.println("uf.find(1, 4) = " + uf.find(3, 5));
	}
}
