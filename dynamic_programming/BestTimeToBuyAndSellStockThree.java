package dynamic_programming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockThree {
    class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2][3];
        for(int i=0; i<prices.length + 1; i++){
            for(int j=0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 0, 0, prices);
    }

    public int helper(int idx, int transactions, int hasNothing, int[] prices){
        if(idx == prices.length || transactions == 2){
            return 0;
        }

        if(dp[idx][hasNothing][transactions] != -1){
            return dp[idx][hasNothing][transactions];
        }

        int doNothing = helper(idx + 1, transactions, hasNothing, prices);

        if(hasNothing == 0){
            int buy = -prices[idx] + helper(idx + 1, transactions, 1, prices);
            return dp[idx][hasNothing][transactions] = Math.max(buy, doNothing); 
        }else{
            int sell = prices[idx] + helper(idx + 1, transactions + 1, 0, prices);
            return dp[idx][hasNothing][transactions] = Math.max(sell, doNothing);
        }
    }
}
}
