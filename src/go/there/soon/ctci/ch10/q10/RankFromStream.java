package go.there.soon.ctci.ch10.q10;

public class RankFromStream {

	public static void main(String[] args) {
		RankNode root = new RankNode(20);
		
		track(root, 15);
		track(root, 25);
		track(root, 10);
		track(root, 23);
		track(root, 5);
		track(root, 13);
		track(root, 24);
		
		printInOrder(root);
		int number = 240;
		int rank = getRankOfNumber(root, number);
		System.out.println("rank(" + number + ") = " + rank);
	}

	public static void track(RankNode node, int x) {
		if(node == null) {
			node = new RankNode(x);
		} else {
			if(node.data >= x) {
				node.leftSize ++;
				if(node.left == null) {
					node.left = new RankNode(x);
				} else {
					track(node.left, x);
				}
			} else {
				if(node.right == null) {
					node.right = new RankNode(x);
				} else {
					track(node.right, x);
				}
			}
		}
	}
	
	public static int getRankOfNumber(RankNode node, int x) {
		if(node.data == x) {
			return node.leftSize;
		} else if(node.data > x) {
			if(node.left == null)
				return -1;
			
			return getRankOfNumber(node.left, x);
		} else {
			int rightSize = (node.right == null) ? -1 : getRankOfNumber(node.right, x);
			if(rightSize == -1) return -1;
			return node.leftSize + 1 + rightSize;
		}
	}
	
	public static void printInOrder(RankNode root) {
		RankNode tempRoot = root;
		inOrder(tempRoot);
		System.out.println();
	}
	
	public static void inOrder(RankNode root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data + "(" + root.leftSize + ") - ");
			inOrder(root.right);
		}
	}
}
