package dynamic_programming;

public class CanBeDoneValidPartition {
    class Solution {

        public boolean validPartition(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return false;
            }
    
            // Initialize the dp array to memoize results
            boolean[] dp = new boolean[n + 1];
            dp[n] = true;  // Base case: If we've processed all elements, it's a valid partition.
    
            // Start checking from the end
            for (int i = n - 2; i >= 0; i--) {
                if (i + 1 < n && nums[i] == nums[i + 1]) {
                    dp[i] = dp[i + 2] || dp[i];  // Check pair condition
                }
                if (i + 2 < n && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                    dp[i] = dp[i + 3] || dp[i];  // Check triplet condition
                }
                if (i + 2 < n && nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
                    dp[i] = dp[i + 3] || dp[i];  // Check consecutive condition
                }
            }
    
            return dp[0];  // Return whether the array can be partitioned starting from index 0
        }
    }
    
}

//recursion + memorization approach

// class Solution {
//     // Declare a memoization array to store results of subproblems
//     Boolean[] dp;

//     public boolean validPartition(int[] nums) {
//         int n = nums.length;
        
//         // If the array length is less than 2, it's not possible to partition
//         if (n < 2) {
//             return false;
//         }
        
//         // Initialize the memoization array
//         dp = new Boolean[n];
        
//         // Start the recursion from index 0
//         return helper(0, nums);
//     }

//     public boolean helper(int i, int[] nums) {
//         // If we have reached the end of the array, it's a valid partition
//         if (i == nums.length) {
//             return true;
//         }

//         // If the result is already computed for this index, return it
//         if (dp[i] != null) {
//             return dp[i];
//         }

//         // Check for two equal adjacent elements
//         if (i + 1 < nums.length && nums[i] == nums[i + 1] && helper(i + 2, nums)) {
//             return dp[i] = true;
//         }

//         // Check for three equal adjacent elements
//         if (i + 2 < nums.length && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2] && helper(i + 3, nums)) {
//             return dp[i] = true;
//         }

//         // Check for three consecutive increasing elements
//         if (i + 2 < nums.length && nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2] && helper(i + 3, nums)) {
//             return dp[i] = true;
//         }

//         // If no valid partition is found from this point, mark it as false
//         return dp[i] = false;
//     }
// }
