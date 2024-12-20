package dynamic_programming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // Arrays to store the length of LIS and count of LIS ending at each index
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLength = 0;

        // Initialize dp and count arrays
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        // Found a longer subsequence ending at i
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; // Reset count[i] to count[j]
                    } else if (dp[i] == dp[j] + 1) {
                        // Found another LIS of the same length
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        // Count the number of LIS with length equal to maxLength
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                totalCount += count[i];
            }
        }

        return totalCount;
    }
}
}
