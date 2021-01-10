package codingproblems.ctci.ch3;

import java.util.NoSuchElementException;

public class MyQueue {
    public static void main(String [] args) {
        MyQueue mq = new MyQueue();
        mq.add(1);
        mq.add(2);
        mq.add(3);
        mq.print();
        mq.printHeadTail();
        mq.add(4);
        mq.print();
        mq.printHeadTail();
        System.out.printf("peek: %d\n", mq.peek());
        System.out.printf("poll: %d\n", mq.poll());
        mq.print();
        mq.printHeadTail();
    }

    private QueueNode head;
    private QueueNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        QueueNode newNode = new QueueNode(data);

        if(tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        if(head == null)
            head = tail;
    }

    public int peek() {
        if(head == null) throw new NoSuchElementException("hm...");
        return head.value;
    }

    public int poll() {
        if(head == null) throw new NoSuchElementException("hm...");
        int firstElement = head.value;

        head = head.next;

        if(head == null)tail=null;
        return firstElement;
    }

    public void print() {
        QueueNode temp = head;

        while(temp != tail) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

        System.out.println(tail.value);
    }

    public void printHeadTail() {
        System.out.printf("head: %d, tail: %d\n", head.value, tail.value);
    }

    class QueueNode {
        int value;
        QueueNode next;

        QueueNode(int value) {
            this.value = value;
        }
    }
}
