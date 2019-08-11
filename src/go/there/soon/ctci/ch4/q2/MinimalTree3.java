package go.there.soon.ctci.ch4.q2;

public class MinimalTree3 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    public static void main(String [] args) {
        MinimalTree3 mt3 = new MinimalTree3();
        mt3.test();
    }

    public void test() {
        int [] arr = {1,2,3,4,5,6,7};
        Node tree = createTree(arr);
        inOrder(tree);
    }

    public Node createTree(int [] arr) {
        return createTreeHelper(arr, 0, arr.length-1);
    }

    public Node createTreeHelper(int [] arr, int left, int right) {
        if(left > right)
            return null;

        int mid = (left + right) / 2;

        Node current = new Node(arr[mid]);
        current.left = createTreeHelper(arr, left, mid-1);
        current.right = createTreeHelper(arr, mid+1, right);

        return current;
    }

    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }
}
