package dynamic_programming;

import java.util.Arrays;

public class TargetSum {
    class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] memo = new int[nums.length][2001];
        
        for (int[] arr : memo)
            Arrays.fill(arr, Integer.MIN_VALUE);
        
        return calculateWays(nums, 0, 0, target, memo);
    }

    private int calculateWays(int[] nums, int index, int sum, int target, int[][] memo) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        if (memo[index][sum + 1000] != Integer.MIN_VALUE) {
            return memo[index][sum + 1000];
        }

        int add = calculateWays(nums, index + 1, sum + nums[index], target, memo);
        int subtract = calculateWays(nums, index + 1, sum - nums[index], target, memo);

        memo[index][sum + 1000] = add + subtract;

        return memo[index][sum + 1000];
    }
}
 
}
