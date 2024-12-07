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

//WE CAN HAVE THE MAXIMUM BALLS AS THE HIGHEST IN BAG. SO IT WILL BE OUR RIGHT BOUND
//MINIMUM WE CAN HAVE IS 1 BALL SO IT'S OUR LEFT BOUND.
//SO WE TRY TO FIGURE IF WE CAN HOLD THE MINIMUM NUMBER OF BALLS PER BAG BY PERFORMING BINARY SEARCH.
//TOTAL OPERATIONS += (NUMS[I] / CURR_BALLS_TO_HOLD) - 1
// -1 BECAUSE THERE WILL BE THE ORIGINAL BAG AND IF WE DON'T SUBTRACT IT WILL GIVE GREATER ANS