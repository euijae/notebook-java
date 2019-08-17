package go.there.soon.ctci.ch10.q1;

import java.util.Arrays;

public class SortedMerge3 {

    public static void main(String [] args) {
        int [] a = new int[10];
        int [] b = {5, 7, 9};

        Arrays.fill(a, -1);
        a[0] = 4;
        a[1] = 6;
        a[2] = 8;
        a[3] = 10;

        System.out.println(Arrays.toString(sortedMerge(a, b)));
    }

    public static int [] sortedMerge(int [] a, int [] b) {
        if(a.length == 0)
            return b;

        if(b.length == 0)
            return a;

        // find the number of elements in array a
        int pa = 0;
        while(a[pa] != -1) pa++;

        // find the number of elements in array b
        int pb = b.length-1;
        pa--;
        int lastIndex = pa + pb + 1;

        while(pb >= 0) {
            if(a[pa] >= b[pb]) {
                a[lastIndex] = a[pa];
                pa--;
            } else {
                a[lastIndex] = b[pb];
                pb--;
            }

            lastIndex--;
        }

        return a;
    }
}
