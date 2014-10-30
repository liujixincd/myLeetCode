/*
 * key idea: dp
 * 2 Beset time to buy and sell stock I
 * from left to right 
 * from right to left;
 * find the maximal sum
 *
 *
 * */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0];
         int max = prices[prices.length - 1];
        left[0] = 0;
        right[right.length - 1] = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(prices[i] - min, left[i - 1]);
        }
        for (int j = prices.length - 2; j >= 0; j--) {
            max = Math.max(max, prices[j]);
            right[j] = Math.max(right[j + 1], max - prices[j]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(left[i] + right[i], profit);
        }
        return profit;
    }
}
