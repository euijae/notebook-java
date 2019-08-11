package go.there.soon.ctci.ch3;

import java.util.*;

public class MyStack {
    public static void main(String args[]) {
        MyStack ms = new MyStack();

        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.print();
        System.out.printf("peek: %d\n", ms.peek());
        System.out.printf("pop : %d\n", ms.pop ());
        ms.print();
    }

    private StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);

        if(top != null) {
            newNode.next = top;
        }

        top = newNode;
    }

    public int peek() {
        if(top == null) {
            throw new NoSuchElementException();
        }

        return top.value;
    }

    public int pop() {
        if(top == null) {
            throw new NoSuchElementException();
        }

        int topValue = top.value;
        top = top.next;

        return topValue;
    }

    public void print() {
        StackNode temp = top;

        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

        System.out.println("");
    }

    class StackNode {
        int value;
        StackNode next;

        StackNode(int value) {
            this.value = value;
        }
    }
}