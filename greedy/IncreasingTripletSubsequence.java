package greedy;

public class IncreasingTripletSubsequence {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int left = Integer.MAX_VALUE;
            int mid = Integer.MAX_VALUE;
    
            for(int i=0; i<nums.length; i++){
                if(nums[i] > mid){
                    return true;
                }else if(nums[i] <= left){
                    left = nums[i];
                }else if(nums[i] <= mid){
                    mid = nums[i];
                }
            }
            return false;
        }
    }
}
