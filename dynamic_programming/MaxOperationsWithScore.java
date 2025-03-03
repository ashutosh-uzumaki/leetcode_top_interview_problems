package dynamic_programming;

public class MaxOperationsWithScore {
    class Solution {
        int[][] dp;
        public int maxOperations(int[] nums) {
            int n = nums.length;
            dp = new int[n + 1][n + 1];
            for(int i=0; i<=n; i++){
                for(int j=0; j<=n; j++){
                    dp[i][j] = -1;
                }
            }
            return 1 + Math.max(
                helper(2, n - 1, nums, nums[0] + nums[1]),
                Math.max(
                    helper(1, n - 2, nums, nums[0] + nums[n - 1]),
                    helper(0, n - 3, nums, nums[n - 1] + nums[n - 2])
                )
            );
        }
    
        private int helper(int start, int end, int[] nums, int target){
            if(end - start + 1 < 2){
                return 0;
            }
            
            if(dp[start][end] != -1){
                return dp[start][end];
            }
    
            int maxOps = 0;
            if(start + 1 <= end && nums[start] + nums[start + 1] == target){
                maxOps = Math.max(maxOps, 1 + helper(start + 2, end, nums, target));
            }
    
            if(start <= end - 1 && nums[end - 1] + nums[end] == target){
                maxOps = Math.max(maxOps, 1 + helper(start, end - 2, nums, target));
            }
    
            if(start <= end && nums[start] + nums[end] == target){
                maxOps = Math.max(maxOps, 1 + helper(start + 1, end - 1, nums, target));
            }
    
            return dp[start][end] = maxOps;
        } 
    }
}
