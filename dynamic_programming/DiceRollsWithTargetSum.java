package dynamic_programming;

public class DiceRollsWithTargetSum {
    class Solution {
        private static final int MOD = 1_000_000_007;
        int[][] dp;
    
        public int numRollsToTarget(int n, int k, int target) {
            dp = new int[n + 1][target + 1];  
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= target; j++) {
                    dp[i][j] = -1;  // Initialize dp with -1 to indicate uncomputed values
                }
            }
            return helper(n, k, target);
        }
    
        public int helper(int n, int k, int target) {
            if (target < 0) return 0; // Prevent negative index access
            if (n == 0 && target == 0) return 1; // Valid case
            if (n == 0 || target < 0) return 0;  // Invalid case
    
            if (dp[n][target] != -1) return dp[n][target];
    
            int ways = 0;
            for (int faceValue = 1; faceValue <= k; faceValue++) {
                ways = (ways + helper(n - 1, k, target - faceValue)) % MOD;
            }
            
            return dp[n][target] = ways;
        }
    }
    
}
