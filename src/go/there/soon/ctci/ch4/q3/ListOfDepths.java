package go.there.soon.ctci.ch4.q3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import go.there.soon.ctci.ch4.tree.TreeNode;

public class ListOfDepths {

	public static void main(String[] args) {
		TreeNode<String> d11 = new TreeNode<>("d11");
		TreeNode<String> d21 = new TreeNode<>("d21");
		TreeNode<String> d22 = new TreeNode<>("d22");
		TreeNode<String> d31 = new TreeNode<>("d31");
		TreeNode<String> d32 = new TreeNode<>("d32");
		TreeNode<String> d33 = new TreeNode<>("d33");
		TreeNode<String> d34 = new TreeNode<>("d34");
		TreeNode<String> d41 = new TreeNode<>("d41");
		TreeNode<String> d42 = new TreeNode<>("d42");
		
		d11.setBoth(d21, d22);
		d21.setBoth(d31, d32);
		d22.setBoth(d33, d34);
		d31.setBoth(d41, d42);
		
		List<Node<String>> lists = sol1(d11);
		for(Node<String> list : lists) {
			print(list);
		}
	}

	public static List<Node<String>> sol1(TreeNode<String> root) {
		List<Node<String>> list = new ArrayList<>();
		Queue<TreeNode<String>> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			Node<String> head = null;
			Node<String> temp = head;
			
			for(int i = 0; i < size; i++) {
				TreeNode<String> node = q.poll();
				if(i == 0) {
					head = new Node<>(node.getData());
					temp = head;
				} else {
					temp.next = new Node<>(node.getData());
					temp = temp.next;
				}
				
				if(node.getLeft()  != null) q.add(node.getLeft());
				if(node.getRight() != null) q.add(node.getRight());
			}
			
			list.add(head);
		}
		
		return list;
	}
	
	public static void print(Node<String> head) {
		Node<String> node = head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("");
	}
}

class Node<T> {
	Node<T> next;
	T data;
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}