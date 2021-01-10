package codingproblems.ctci.ch8.q11;

import java.util.*;

public class Coins2 {

    public static void main(String [] args) {
        int total = 100;
        int counter = coins(total);
        System.out.printf("There are %d ways to pay $%d", counter, total);
    }

    public static int coins(int total) {
        int [] coins = {25, 10, 5, 1};
        Map<Integer, Integer> dict = new HashMap<>();
        return coins(total, dict, coins, 0);
    }

    public static int coins(int total, Map<Integer, Integer> dict, int [] coins, int currIndex) {
        if(total == 0 || currIndex >= coins.length) {
            return total == 0 ? 1 : 0;
        }

        int counter = 0;
        int lastIndex = total / coins[currIndex];

        for(int i = 0; i <= lastIndex; i++) {
            int remainingAmount = total - i * coins[currIndex];

            if(dict.containsKey(remainingAmount))
                counter += dict.get(remainingAmount);
            else {
                counter += coins(remainingAmount, dict, coins, currIndex + 1);
                dict.put(remainingAmount, counter);
            }
        }

        return counter;
    }
}
