package greedy;

import java.util.Arrays;

public class MinimumSumAfterRemovingTwoEle {
    class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int caseOne = nums[nums.length - 1] - nums[2];
        int caseTwo = nums[nums.length - 3] - nums[0];
        int caseThree = nums[nums.length - 2] - nums[1];

        return Math.min(caseOne, Math.min(caseTwo, caseThree));

    }
}
}

// CASE ONE -> IGNORING THE FIRST TWO SMALLEST ELEMENTS
// CASE TWO -> IGNORING THE LAST TWO LARGEST ELEMENTS
// CASE THREE -> IGNORING THE SMALLEST AND LARGEST ELEMENTS 
