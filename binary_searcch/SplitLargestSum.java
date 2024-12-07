package binary_searcch;

public class SplitLargestSum {
    class Solution {
        public int splitArray(int[] nums, int k) {
            int low = 0;
            int high = 0;
            for(int num: nums){
                low = Math.max(low, num); // Ensure low is at least the maximum element
                high += num; // The maximum possible value for the largest sum
            }
            
            int ans = high;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(isPossibleToSplit(nums, k, mid)){
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            return ans;
        }
    
        public boolean isPossibleToSplit(int[] nums, int k, int kSum){
            int sum = 0;
            int splits = 1;
            for(int num: nums){
                sum += num;
                if(sum > kSum){
                    sum = num;
                    splits++;
                    if(splits > k) {
                        return false; // More than k splits needed
                    }
                }
            }
            return true; // Possible to split into exactly k parts
        }
    }
    
}
