package codingproblems.ctci.ch8.q4;

import java.util.*;

public class PowerSet2 {
    public static void main(String [] args) {
        int [] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> lists = powerSet(nums);
        print(lists);
    }

    public static List<List<Integer>> powerSet(int [] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        lists.add(firstList);

        for(int num : nums) {
            int size = lists.size();

            for(int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(lists.get(i));
                temp.add(num);
                lists.add(temp);
            }
        }

        return lists;
    }

    public static void print(List<List<Integer>> lists) {
        System.out.printf("There are %d elements\n", lists.size());
        for(List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
