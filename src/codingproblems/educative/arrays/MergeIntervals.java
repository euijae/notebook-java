package codingproblems.educative.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String [] args) {
        Tuple<Integer, Integer> t1 = new Tuple<>(1,5);
        Tuple<Integer, Integer> t2 = new Tuple<>(3,7);
        Tuple<Integer, Integer> t3 = new Tuple<>(4,6);
        Tuple<Integer, Integer> t4 = new Tuple<>(6,8);
        ArrayList<Tuple<Integer, Integer>> tuples = new ArrayList<>();
        tuples.add(t4);
        tuples.add(t2);
        tuples.add(t3);
        tuples.add(t1);

        for(Tuple<Integer, Integer> tuple : tuples) {
            tuple.print();
        }

        System.out.println("------");

        Collections.sort(tuples, new IntervalComparator());

        for(Tuple<Integer, Integer> tuple : tuples) {
            tuple.print();
        }

        ArrayList<Tuple<Integer, Integer>> result = mergeIntervals(tuples);

        for(Tuple<Integer, Integer> interval : result) {
            interval.print();
        }
    }

    public static ArrayList<Tuple<Integer, Integer>> mergeIntervals(
            ArrayList<Tuple<Integer, Integer>> intervals) {
        ArrayList<Tuple<Integer, Integer>> result = new ArrayList<>();

        for(Tuple<Integer, Integer> interval : intervals) {
            if(result.isEmpty()) {
                result.add(interval);
            } else {
                int lastIndex = result.size()-1;
                Tuple<Integer, Integer> lastInterval = result.get(lastIndex);
                int x1 = lastInterval.x;
                int y1 = lastInterval.y;
                int x2 = interval.x;
                int y2 = interval.y;

                if(y1 < x2) {
                    result.add(interval);
                } else {
                    result.set(lastIndex,
                            new Tuple<Integer, Integer>(x1, Math.max(y1, y2)));
                }
            }
        }

        return result;
    }
}

class Tuple<X extends Comparable<X>, Y extends Comparable<Y>> {
    public X x;
    public Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("[" + this.x + ", " + this.y + "]");
    }
}

class IntervalComparator implements Comparator<Tuple<Integer, Integer>> {

    @Override
    public int compare(Tuple<Integer, Integer> t1, Tuple<Integer, Integer> t2) {
        return t1.x - t2.x;
    }
}