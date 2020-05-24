package codingproblems.scratch;

import java.util.NoSuchElementException;

public class MaxHeap {
    private int [] heap;
    private int CAPACITY;
    private int length;

    public MaxHeap(int capacity) {
        this.CAPACITY = capacity;
        this.length = 0;
        heap = new int[capacity];
    }

    public void insert(int data) {
        if(CAPACITY == length) {
            throw new NoSuchElementException(" ... ");
        }

        heap[length] = data;
        bubbleUp(length);
        length++;
    }

    public int extract_max() {
        if(length == 0) {
            throw new NoSuchElementException(" ... ");
        }

        int top = heap[0];
        heap[0] = heap[length-1];
        length--;
        bubbleDown(0);

        return top;
    }

    public int getMax() {
        if(length == 0)
            throw new NoSuchElementException(" ... ");

        return heap[0];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private void bubbleDown(int currIndex) {
        if(currIndex < length) {
            int left = getLeft(currIndex);
            int right = getRight(currIndex);

            int maxIndex = currIndex;

            if(left != currIndex && left < length && heap[left] > heap[currIndex]) {
                maxIndex = left;
            }

            if(right != currIndex && right < length && heap[right] > heap[maxIndex]) {
                maxIndex = right;
            }

            if(maxIndex != currIndex) {
                swap(maxIndex, currIndex);
                bubbleDown(maxIndex);
            }
        }
    }

    private void bubbleUp(int currIndex) {
        int parent = getParent(currIndex);

        if(parent < 0 || parent == currIndex)
            return;

        if(heap[parent] < heap[currIndex]) {
            swap(currIndex, parent);
            bubbleUp(parent);
        }
    }

    private void swap(int left, int right) {
        int temp = heap[left];
        heap[left] = heap[right];
        heap[right] = temp;
    }

    private int getParent(int i) {
        return (i-1) / 2;
    }

    private int getLeft(int i) {
        return 2*i + 1;
    }

    private int getRight(int i) {
        return 2*i + 2;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i = 0; i < length; i++) {
            sb.append(heap[i] + (i == length-1 ? "]" : ", "));
        }

        System.out.println(sb.toString());
    }
}
