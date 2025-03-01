package dynamic_programming;

public class LongestArithmeticSubsequenceWithDiff {
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int longest = helper(0, -1, 0, arr, difference);
            return longest == Integer.MIN_VALUE ? 1 : longest; 
        }
    
        public int helper(int idx, int prevIdx, int cnt, int[] arr, int difference){
            if(idx == arr.length){
                return cnt;
            }
    
            int take = Integer.MIN_VALUE;
            if (prevIdx == -1 || arr[idx] - arr[prevIdx] == difference) {
                take = helper(idx + 1, idx, cnt + 1, arr, difference);
            }
            int skip = helper(idx + 1, prevIdx, cnt, arr, difference);
            return Math.max(take, skip);
        }
    }
}
