package binary_searcch;
import java.util.*;

public class MakeArrayElementsEqual {
    class Solution {
        public long minCost(int[] nums, int[] cost) {
            long minCost = 0;
            long left = 1L;
            long right = 1000000L;
    
            for(int num: nums){
                left = Math.min(num, left);
                right = Math.max(num, right);
            }
    
            long ans = findCost(nums, cost, 1);
    
            while(left <= right){
                long mid = left + (right - left) / 2;
                long curr = findCost(nums, cost, mid);
                long nextCurr = findCost(nums, cost, mid + 1);
    
                ans = Math.min(curr, nextCurr);
                if(curr < nextCurr){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
    
            return ans;
        }
    
        public long findCost(int[] nums, int[] cost, long x){
            long res = 0L;
    
            for(int i=0; i<nums.length; i++){
                res += Math.abs(nums[i] - x) * cost[i];
            }
    
            return res;
        }
    }
}
