package dynamic_programming;

public class GreatestSumDivisibleByThree {
    class Solution {
        int[][] memo;
        
        public int maxSumDivThree(int[] nums) {
            memo = new int[nums.length][3];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < 3; j++) {
                    memo[i][j] = -1;
                }
            }
            return helper(0, 0, nums);
        }
    
        private int helper(int idx, int remainder, int[] nums) {
            if (idx == nums.length) {
                return remainder == 0 ? 0 : Integer.MIN_VALUE;
            }
    
            if (memo[idx][remainder] != -1) {
                return memo[idx][remainder];
            }
    
            // Option 1: Take the current number
            int take = nums[idx] + helper(idx + 1, (remainder + nums[idx]) % 3, nums);
    
            // Option 2: Skip the current number
            int notTake = helper(idx + 1, remainder, nums);
    
            // Store the result in the memo table and return the maximum
            memo[idx][remainder] = Math.max(take, notTake);
            return memo[idx][remainder];
        }
    }
    
}

// CHECK ON REMAINDER IF REMAINDER == 0 THEN IT IS DIVISBLE ELSE NOT SO RETURN INT_MIN
// MEMORIZATION STORES BASED ON CURRENT INDEX AND REMAINDER OF THE SUM
