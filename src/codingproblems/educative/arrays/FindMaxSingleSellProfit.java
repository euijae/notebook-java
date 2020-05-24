package codingproblems.educative.arrays;

public class FindMaxSingleSellProfit {
    public static void main(String [] args) {

        int [] arr = { 1, 2, 3, 4, 3, 2, 1, 2, 5 };
        int max = maxProfit(arr);
        System.out.printf("max profit is %d", max);
    }

    public static int maxProfit(int [] arr) {
        if(arr == null || arr.length < 2)
            return 0;

        int minBuy = arr[0];
        int maxProfit = 0;

        for(int i = 1; i < arr.length; i++) {
            minBuy = Math.min(minBuy, arr[i]);
            maxProfit = Math.max(arr[i]-minBuy, maxProfit);
        }

        return maxProfit < 0 ? 0 : maxProfit;
    }
}
