package codingproblems.educative.math;

import java.util.*;

public class AllSumCombinations {
    public static void main(String [] args) {
        ArrayList<ArrayList<Integer>> ans = print_all_sum(5);

        for(ArrayList<Integer> list : ans) {
            System.out.println(list.toString());
        }
    }

    /**
     * my solution
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> print_all_sum2(int target) {
        Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> firstValue = new ArrayList<>();
        firstValue.add(new ArrayList<>());
        map.put(0, firstValue);

        for(int key = 1; key <= target; key++) {
            int runner = 0;
            ArrayList<ArrayList<Integer>> newValues = new ArrayList<>();

            while(runner < key) {
                ArrayList<ArrayList<Integer>> tempValues = map.getOrDefault(runner, new ArrayList<>());
                int diff = key - runner;

                for(int i = 0; i < tempValues.size(); i++) {
                    if(diff != target) {
                        ArrayList<Integer> temp = new ArrayList<>(tempValues.get(i));
                        temp.add(diff);

                        if(!isDuplicate(newValues, temp)) {
                            newValues.add(temp);
                        }
                    }
                }

                runner++;
            }

            map.put(key, newValues);
        }

        return map.get(target);
    }

    public static boolean isDuplicate(ArrayList<ArrayList<Integer>> values, List<Integer> newValue) {

        for(ArrayList<Integer> list : values) {
            if(list.size() == newValue.size()) {
                Object [] arr1 = list.toArray();
                Object [] arr2 = newValue.toArray();

                Arrays.sort(arr1);
                Arrays.sort(arr2);

                boolean matching = true;

                for(int i = 0; i < arr1.length; i++) {
                    if(arr1[i] != arr2[i]) {
                        matching = false;
                        break;
                    }
                }

                if(matching)
                    return true;
            }
        }

        return false;
    }

    public static ArrayList<ArrayList<Integer>> print_all_sum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        print_all_sum_rec(target, 0, 1, new ArrayList<>(), output);

        return output;
    }

    public static void print_all_sum_rec(
            int target,
            int currentSum,
            int start,
            ArrayList<Integer> result,
            ArrayList<ArrayList<Integer>> output) {
        if(currentSum == target) {
            output.add(new ArrayList<>(result));
        }

        for(int i = start; i < target; i++) {
            int temp_sum = currentSum + i;
            if(temp_sum <= target) {
                result.add(i);
                print_all_sum_rec(target, temp_sum, i, result, output);
                result.remove(result.size()-1);
            } else {
                return;
            }
        }
    }
}
