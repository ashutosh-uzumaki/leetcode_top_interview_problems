package dynamic_programming;

public class PartitionEqualSubsetSum {
    class Solution {
        public boolean canPartition(int[] nums) {
            int totalSum = 0;
            for (int num : nums) {
                totalSum += num;
            }
    
            // If the total sum is odd, we can't split it into two equal subsets
            if (totalSum % 2 != 0) {
                return false;
            }
    
            // Use memoization to avoid redundant computation
            int targetSum = totalSum / 2;
            Boolean[][] memo = new Boolean[nums.length][targetSum + 1];
            return helper(0, nums, targetSum, memo);
        }
    
        public boolean helper(int idx, int[] nums, int sum, Boolean[][] memo) {
            if (sum == 0) {
                return true;
            }
            if (idx >= nums.length || sum < 0) {
                return false;
            }
    
            if (memo[idx][sum] != null) {
                return memo[idx][sum];
            }
    
            // Choose to include nums[idx] in the subset or skip it
            boolean include = helper(idx + 1, nums, sum - nums[idx], memo);
            boolean exclude = helper(idx + 1, nums, sum, memo);
    
            memo[idx][sum] = include || exclude;
            return memo[idx][sum];
        }
    }
    
}
