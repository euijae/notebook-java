package codingproblems.scratch;

import java.util.*;

public class DoublyLinkedList {
    public static void main(String [] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(1);
        dll.print(); // 1
        dll.addFirst(2);
        dll.print(); // 2 1
        dll.addLast(3);
        dll.print(); // 2 1 3
        int first = dll.removeFirst();
        dll.print(); // 1 3
        int last = dll.removeLast();
        dll.print();
        System.out.printf("first: %d, last: %d", first, last);
    }

    private Node head;
    private Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if(tail == null) {
            tail = newNode;
            if(head == null) {
                head = tail;
            }
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public int removeFirst() {
        if(head == null) {
            throw new NoSuchElementException(" ... ");
        }

        int first = head.data;

        head.next.prev = null;
        head = head.next;

        return first;
    }

    public int removeLast() {
        if(tail == null) {
            throw new NoSuchElementException(" ... ");
        }

        int last = tail.data;

        tail.prev.next = null;
        tail = tail.prev;

        return last;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node temp = head;

        while(temp != tail) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println(tail.data);
    }

    class Node {
        Node prev;
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}
