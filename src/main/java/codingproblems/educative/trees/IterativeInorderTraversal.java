package codingproblems.educative.trees;

import java.util.Stack;

public class IterativeInorderTraversal {
    public static void main(String [] args) {
        IterativeInorderTraversal iit = new IterativeInorderTraversal();
        iit.test();
    }

    public void test() {
        BinaryTreeNode n100 = new BinaryTreeNode(100);
        BinaryTreeNode n50 = new BinaryTreeNode(50);
        BinaryTreeNode n200 = new BinaryTreeNode(200);
        BinaryTreeNode n25 = new BinaryTreeNode(25);
        BinaryTreeNode n75 = new BinaryTreeNode(75);
        BinaryTreeNode n125 = new BinaryTreeNode(125);
        BinaryTreeNode n350 = new BinaryTreeNode(350);

        n100.left = n50;
        n100.right = n200;

        n50.left = n25;
        n50.right = n75;

        n200.left = n125;
        n200.right = n350;
        String result = iterativeInorderTraversal(n100);
        System.out.println(result);
    }

    public String iterativeInorderTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode runner = root;

        while(runner != null) {
            stack.push(runner);
            runner = runner.left;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            BinaryTreeNode top = stack.pop();
            BinaryTreeNode temp = top.right;

            while(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }

            sb.append(top.data + ", ");
        }

        int lastCommaIndex = sb.toString().lastIndexOf(",");

        return sb.toString().substring(0, lastCommaIndex);
    }

    class BinaryTreeNode {
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public int data;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }
}
