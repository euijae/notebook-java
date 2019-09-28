package go.there.soon.scratch.onsite.sortSegmentedArray;

public class SortSegmentedArray {
    public static void main(String [] args) {
        int [] arr = {50, 51, 52, 20, 21, 22, 1, 2, 3};

        MinHeap mh = new MinHeap(arr.length);
        for(int numb : arr) {
            mh.insert(numb);
        }

        System.out.printf("list is %s\n", mh.toString());

        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", mh.extractMin());
        }
    }
}
