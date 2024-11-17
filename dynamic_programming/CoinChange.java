package dynamic_programming;

import java.util.Arrays;

public class CoinChange {
    class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = coinChangeHelper(amount, coins);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }

        return ans;
        
    }

    public int coinChangeHelper(int amount, int[] coins){
        if(amount == 0){
            return 0;
        }

        if(dp[amount] != -1){
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++){
            if(amount - coins[i] >= 0){
                minCoins = Math.min(minCoins, coinChangeHelper(amount - coins[i], coins));
            }
        }

        if(minCoins < Integer.MAX_VALUE){
            minCoins += 1;
        }

        return dp[amount] = minCoins;
    }

}
}
