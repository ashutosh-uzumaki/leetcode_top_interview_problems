public class MinimumOperationsToFlipBinaryArray {
    class Solution {
        public int minOperations(int[] nums) {
            int size = nums.length;
            if(size < 3){
                return -1;
            }
            int opsCount = 0;
            for(int i=0; i<=size-3; i++){
                if(nums[i] == 0){
                    nums[i] ^= 1;
                    nums[i + 1] ^= 1;
                    nums[i + 2] ^= 1;
                    opsCount += 1;
                }
            }
    
            for(int num: nums){
                if(num == 0){
                    return -1;
                }
            }
    
            return opsCount;
        }
    }
}
