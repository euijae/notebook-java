package go.there.soon.ctci.ch4.q3;

import java.util.*;

public class ListOfDepths3 {
    class Node {
        int depth;
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public Map<Integer, List<Node>> map;

    public static void main(String [] args) {
        ListOfDepths3 ld3 = new ListOfDepths3();
        ld3.test();
    }

    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        listOfDepth(n1);

        System.out.println(map.size());

        for(Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            System.out.printf("at %d >> %s", entry.getKey(), toString(entry.getValue()) + "\n");
        }
    }

    public String toString(List<Node> list) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).data + " ");
        }

        return sb.toString();
    }

    public void listOfDepth(Node root) {
        map = new HashMap<>();
        LinkedList<Node> q = new LinkedList<>();

        root.depth = 0;
        q.add(root);

        List<Node> temp = new ArrayList<>();
        temp.add(root);
        map.put(0, temp);

        while(!q.isEmpty()) {
            Node top = q.removeFirst();
            int currentDepth = top.depth;

            if(top.left != null) {
                top.left.depth = currentDepth - 1;
                q.add(top.left);
                List<Node> groupAtDepth = map.getOrDefault(top.left.depth, new ArrayList<>());
                groupAtDepth.add(top.left);
                map.put(top.left.depth, groupAtDepth);
            }

            if(top.right != null) {
                top.right.depth = currentDepth + 1;
                q.add(top.right);
                List<Node> groupAtDepth = map.getOrDefault(top.right.depth, new ArrayList<>());
                groupAtDepth.add(top.right);
                map.put(top.right.depth, groupAtDepth);
            }
        }
    }
}
