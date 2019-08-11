package go.there.soon.scratch.onsite;

import java.util.*;

public class LRUCache {
    public static void main(String args[]) {
        LRUCache lru = new LRUCache(3);
        lru.put(1);
        lru.print(); // 1
        lru.put(2);
        lru.print(); // 2 1
        lru.put(3);
        lru.print(); // 3 2 1
        lru.put(4);
        lru.print(); // 4 3 2
    }

    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    Map<Integer, Node> map;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
    }

    void put(int data) {
        if(head == null) {
            head = new Node(data);
            head.prev = null;
            tail = null;
        } else {
            if(size < capacity) {
                size++;
            } else {
                tail.prev.next = null;
                tail = tail.prev;
            }

            Node newNode = new Node(data);
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;

            if(tail == null) {
                tail = head;
            }

            head = newNode;
        }
    }

    int get() {
        return (tail == null) ? -1 : tail.value;
    }

    void print() {
        if(head == null) {
            System.out.println("nothing in the node");
        } else {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }

            System.out.println("");
        }
    }
}

class Node {
    Node prev;
    Node next;
    int value;

    Node(int value) {
        this.value = value;
    }
}