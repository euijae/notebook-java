package codingproblems.ctci.ch4.q4;

public class CheckBalanced2 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String [] args) {

    }

    public boolean isBalanced(Node root) {
        if(root == null)
            return true;

        int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));

        if(heightDiff > 1)
            return false;

        return  isBalanced(root.left) &&  isBalanced(root.right);
    }

    public int getHeight(Node root) {
        if(root == null)
            return -1;

        return 1 + Math.max(getHeight(root.right), getHeight(root.left));
    }
}
