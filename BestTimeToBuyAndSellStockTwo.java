import java.util.Arrays;

public class BestTimeToBuyAndSellStockTwo {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];
        for(int i=0; i<prices.length+1; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(prices, 0, 0); 
    }

    public int helper(int[] prices, int idx, int hasStock) {
        if (idx == prices.length) {
            return 0;
        }
        if(dp[idx][hasStock] != -1){
            return dp[idx][hasStock];
        }
        int doNothing = helper(prices, idx + 1, hasStock);

        if (hasStock == 1) {
            int sell = prices[idx] + helper(prices, idx + 1, 0);
            return dp[idx][hasStock] = Math.max(doNothing, sell);
        } else {
            int buy = -prices[idx] + helper(prices, idx + 1, 1);
            return dp[idx][hasStock] = Math.max(doNothing, buy);
        }
    }
}


//MISTAKES
//MISSED THE CONDITION THAT I CAN'T BUY AND SELL AT ITH DAY.
//INSTEAD OF SUBTRACTING THE PRICE OF BUY, I ADDED.