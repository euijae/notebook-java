package go.there.soon.scratch.practice.sortSegmentedArray;

import java.util.NoSuchElementException;

public class MinHeap {
    int CAPACITY;
    int [] heap;
    int size;

    public MinHeap(int cap) {
        this.CAPACITY = cap;
        this.heap = new int[cap];
    }

    public int extractMin() {
        if(size == 0)
            throw new NoSuchElementException("no elements ...");

        int min = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = -1;
        size--;
        bubbleDown(0);

        return min;
    }

    public void insert(int data) {
        if(size == CAPACITY) {
            throw new NoSuchElementException("full ...");
        }

        heap[size] = data;
        size++;

        bubbleUp(size-1);
    }

    public void bubbleDown(int curr) {
        if(curr >= size)
            return ;

        int left    = getLeftChildIndex (curr);
        int right   = getRightChildIndex(curr);

        int minIndex = curr;

        if(left < size && heap[left] < heap[curr]) {
            minIndex = left;
        }

        if(right < size && heap[right] < heap[minIndex]) {
            minIndex = right;
        }

        if(minIndex == curr)
            return;

        // swap
        swap(curr, minIndex);
        bubbleDown(minIndex);
    }

    public void bubbleUp(int curr) {
        int parent = getParentIndex(curr);

        if(parent < 0)
            return;

        if(heap[curr] < heap[parent]) {
            swap(curr, parent);
            bubbleUp(parent);
        }
    }

    public int getParentIndex(int i) {
        return (i-1) / 2;
    }

    public int getLeftChildIndex(int i) {
        return 2*i + 1;
    }

    public int getRightChildIndex(int i) {
        return 2*i + 2;
    }

    public void swap(int i1, int i2) {
        int temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < size; i++) {
            sb.append((i == 0 ? "[" : "") + heap[i] + (i == size-1 ? "]" : ","));
        }

        return sb.toString();
    }
}
