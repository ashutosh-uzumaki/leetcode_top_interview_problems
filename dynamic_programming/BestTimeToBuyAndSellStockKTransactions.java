package dynamic_programming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockKTransactions {
    class Solution {
    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length + 1][2][k]; // idx, hasStock, transactions
        for (int i = 0; i < prices.length + 1; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 0, 0, k, prices); // idx = 0, hasStock = 0, transactions = 0
    }

    public int helper(int idx, int hasStock, int transactions, int k, int[] prices) {
        if (idx == prices.length || transactions == k) {
            return 0;
        }

        if (dp[idx][hasStock][transactions] != -1) {
            return dp[idx][hasStock][transactions];
        }

        int doNothing = helper(idx + 1, hasStock, transactions, k, prices);

        if (hasStock == 0) {
            int buy = -prices[idx] + helper(idx + 1, 1, transactions, k, prices);
            dp[idx][hasStock][transactions] = Math.max(buy, doNothing);
        } else {
            int sell = prices[idx] + helper(idx + 1, 0, transactions + 1, k, prices);
            dp[idx][hasStock][transactions] = Math.max(sell, doNothing);
        }

        return dp[idx][hasStock][transactions];
    }
}

}
