package dynamic_programming;

import java.util.Arrays;

public class PalindromeParitioningTwo {
    class Solution {
    int[] memo;
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        for(int length=1; length<=n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;
                if(i == j){
                    dp[i][j] = true;
                }else if(i + 1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(i + 1));
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
            }
        }
        return helper(0, s, dp) - 1;
    }

    public int helper(int idx, String s, boolean[][] dp){
        if(idx == s.length()){
            return 0;
        }

        if(memo[idx] != -1){
            return memo[idx];
        }

        int minCost = Integer.MAX_VALUE;
        for(int j = idx; j < s.length(); j++){
            if(dp[idx][j]){
                int currCost = 1 + helper(j + 1, s, dp);
                minCost = Math.min(currCost, minCost);
            }
        }

        return memo[idx] = minCost;
    }
}
}
