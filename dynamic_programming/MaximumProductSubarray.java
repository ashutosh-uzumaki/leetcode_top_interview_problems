package dynamic_programming;

public class MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int result = nums[0], maxProduct = nums[0], minProduct = nums[0];
    
            for(int i=1; i<nums.length; i++){
                int currMaxProduct = Math.max(nums[i], Math.max(maxProduct * nums[i], minProduct * nums[i]));
                minProduct = Math.min(nums[i], Math.min(maxProduct * nums[i], minProduct * nums[i]));
                maxProduct = currMaxProduct;
                result = Math.max(maxProduct, result); 
            }
    
            return result;
        }
    }
}
