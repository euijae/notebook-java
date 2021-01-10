package codingproblems.leetCode;

/**
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 * Explanation:
 *  1st customer has wealth = 6
 *  2nd customer has wealth = 10
 *  3rd customer has wealth = 8
 * The 2nd customer is the richest with a wealth of 10.
 */
class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < accounts.length; i++) {
            int innerSum = 0;
            for(int j = 0; j < accounts[i].length; j ++)
                innerSum += accounts[i][j];

            sum = Math.max(sum, innerSum);
        }

        return sum;
    }
}
