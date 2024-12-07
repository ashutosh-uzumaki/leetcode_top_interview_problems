package binary_searcch;

public class MinimumBallsInBag {
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int low = 1;
            int high = 0;
            for(int num: nums){
                high = Math.max(num, high);
            }
            int res = Integer.MAX_VALUE;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(possible(mid, nums, maxOperations)){
                    res = mid;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
    
            return res;
        }
    
        public boolean possible(int currMaxBalls, int[] nums, int maxOperations){
            int totalOps = 0;
            for(int num: nums){
                totalOps += (int)Math.ceil((double) num / currMaxBalls) - 1;
                if(totalOps > maxOperations){
                    return false;
                }
            }
    
            return true;
        }
    }
}
