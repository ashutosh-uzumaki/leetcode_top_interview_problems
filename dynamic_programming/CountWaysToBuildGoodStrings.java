package dynamic_programming;

import java.util.Arrays;

public class CountWaysToBuildGoodStrings {
    class Solution {
    int mod = (int)1e9+7;
    int[] dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        for(int len = low; len <= high; len++){
            ans = (ans + helper(len, zero, one)) % mod;
        }

        return ans;
    }

    public int helper(int len, int zero, int one){
        if(len == 0){
            return 1;
        }
        if(len < 0){
            return 0;
        }
        if(dp[len] != -1){
            return dp[len];
        }

        return dp[len] = (helper(len - zero, zero, one) + helper(len - one, zero, one)) % mod;
    }
}
}
