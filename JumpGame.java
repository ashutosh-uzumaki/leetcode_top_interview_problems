public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int reach = 0;
            for(int i=0; i<nums.length; i++){
                if(i > reach){
                    return false;
                }
    
                reach = Math.max(i + nums[i], reach);
            }
    
            return true;
        }
    }
    
}
//keep calculating the max distance can be reached from i. (i + nums[i]);
//at some point when i > reach from previous i that means we were not able to move forward from some point. (return false)
