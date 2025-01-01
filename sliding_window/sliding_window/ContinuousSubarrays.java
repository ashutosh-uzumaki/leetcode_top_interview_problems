package sliding_window;
import java.util.*;

public class ContinuousSubarrays {
    class Solution {
        public long continuousSubarrays(int[] nums) {
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            int left = 0, right = 0;
            int size = nums.length;
            long totalSubarrays = 0;
            while(right < size){
                mp.put(nums[right],mp.getOrDefault(nums[right], 0) + 1);
    
                while(Math.abs(mp.lastKey() - mp.firstKey()) > 2){
                    mp.put(nums[left], mp.get(nums[left]) - 1);
                    if(mp.get(nums[left]) == 0){
                        mp.remove(nums[left]);
                    }
                    left++;
                }
    
                totalSubarrays += (right - left + 1);
                right++;
            }
    
            return totalSubarrays;
        }
    }
}
