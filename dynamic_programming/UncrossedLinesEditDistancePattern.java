package dynamic_programming;

public class UncrossedLinesEditDistancePattern {
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
    
            int[][] dp = new int[len1 + 1][len2 + 1];
            for(int i=nums1.length - 1; i>=0; i--){
                for(int j=nums2.length - 1; j>=0; j--){
                    if(nums1[i] == nums2[j]){
                        dp[i][j] = dp[i+1][j+1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }
    
            return dp[0][0];
        }
    }
}
