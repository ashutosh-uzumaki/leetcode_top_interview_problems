package dynamic_programming;
public class MaxAbsoluteSumSubarrayKadane {
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int currSum = 0;
            for(int num: nums){
                currSum += num;
                maxSum = Math.max(maxSum, currSum);
                if(currSum < 0){
                    currSum = 0;
                }
            }
    
            currSum = 0;
            int minSum = Integer.MAX_VALUE;
            for(int num: nums){
                currSum += num;
                minSum = Math.min(minSum, currSum);
                if(currSum > 0){
                    currSum = 0;
                }
            }
    
            return Math.max(maxSum, Math.abs(minSum));
    
        }
    }
}

//INTUTION -> as negative values added it becomes -ve  (max)

//so calculate both the positive and negative subarray sum and return max of (positive_sum, abs(negative_sum))
