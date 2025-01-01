package sliding_window;

public class SubarrayproductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int start = 0, end = 0;
            int n = nums.length;
            int product = 1;
            int count = 0;
            while(end < n){
                product *= nums[end];
                while(start <= end && product >= k){
                    product /= nums[start];
                    start ++;
                }
    
                count += end - start + 1;
                end++;
            }
            return count;
        }
    }
}
