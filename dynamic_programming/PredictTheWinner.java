package dynamic_programming;

public class PredictTheWinner {
    class Solution {
        public boolean predictTheWinner(int[] nums) {
            int n = nums.length - 1;
            if(n == 0 || n == 1){
                return true;
            }
            return predictionHelper(0, n, nums) >= 0;
        }
    
        public int predictionHelper(int start, int end, int[] nums){
            if(start == end) return nums[start];
    
            int left = nums[start] - predictionHelper(start + 1, end, nums);
            int right = nums[end] - predictionHelper(start, end - 1, nums);
    
            return Math.max(left, right);
        }
    }
}
