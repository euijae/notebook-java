package go.there.soon.ctci.ch4.tree;

public class Scractch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = new TreeNode<>(10);
		Tree<Integer> tree = new Tree<>();
		tree.setRoot(root);
		
		TreeNode<Integer> tl = new TreeNode<>(8);
		TreeNode<Integer> tr = new TreeNode<>(15);
		TreeNode<Integer> tll = new TreeNode<>(4);
		TreeNode<Integer> tlr = new TreeNode<>(9);
		TreeNode<Integer> trl = new TreeNode<>(12);
		TreeNode<Integer> trr = new TreeNode<>(17);
		tree.insert(root, tl);
		tree.insert(root, tr);
		tree.insert(root, tll);
		tree.insert(root, tlr);
		tree.insert(root, trl);
		tree.insert(root, trr);
		tree.printBFS(root);
	}

}
