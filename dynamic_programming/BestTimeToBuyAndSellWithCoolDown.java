package dynamic_programming;

public class BestTimeToBuyAndSellWithCoolDown {
    class Solution {
        int[][] memo;
        public int maxProfit(int[] prices) {
            int n = prices.length;
            memo = new int[n + 1][3];
            for(int i=0; i<=n; i++){
                memo[i][0] = -1;
                memo[i][1] = -1;
                memo[i][2] = -1;
            }
            return helper(0, prices, 0);
        }
    
        public int helper(int idx, int[] prices, int hasNothing){
            if(idx >= prices.length){
                return 0;
            }
    
            if(memo[idx][hasNothing] != -1){
                return memo[idx][hasNothing];
            }
    
            int doNothing = helper(idx + 1, prices, hasNothing);
    
            if(hasNothing == 0){
                int buy = -prices[idx] + helper(idx+1, prices, 1);
                return memo[idx][hasNothing] = Math.max(doNothing, buy);
            }else{
                int sell = prices[idx] + helper(idx + 2, prices, 0);
                return memo[idx][hasNothing] = Math.max(doNothing, sell);
            }
        }
    }
}
