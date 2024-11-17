package dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n+1];
        Arrays.fill(lis, 1);
        int maxLength = 1;
        for(int i=0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }

            maxLength = Math.max(maxLength, lis[i]);
        }

        return maxLength;
    }
}
}
