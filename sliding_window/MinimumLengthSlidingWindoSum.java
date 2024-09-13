package sliding_window;

public class MinimumLengthSlidingWindoSum {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int minLength = Integer.MAX_VALUE;
            int left = 0, right = 0;
            int n = nums.length;
            int currSum = 0;
            while(right < n){
                currSum += nums[right];
                while(left <= right && currSum >= target){
                    minLength = Math.min(right - left + 1, minLength);
                    currSum -= nums[left];
                    left++;
                }
                right++;
            }
            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
    }
}

//MISTAKE -> DIDN'T ACCOUNT IF THERE IS NO SUBARRAY WITH SUM >= TARGET
