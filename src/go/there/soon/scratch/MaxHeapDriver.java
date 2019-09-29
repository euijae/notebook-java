package go.there.soon.scratch;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapDriver {
    public static void main(String [] args) {

        int [] arr = { 10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67 };
        List<Integer> result = maximumWindow(arr, 3);
        System.out.println(result.toString());
    }

    public static List<Integer> maximumWindow(int [] arr, int windowSize) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i <= arr.length - windowSize; i++) {
            MaxHeap heap = new MaxHeap(windowSize);
            for(int j = i; j < i+windowSize; j++) {
                heap.insert(arr[j]);
            }

            result.add(heap.extract_max());
        }
//10, 9, 23, 23, 34, 56, 67, 67, 67, -1, -2, 9, 10, 34, 67
        return result;
    }
}
