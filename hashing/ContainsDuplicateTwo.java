package hashing;

import java.util.HashMap;

public class ContainsDuplicateTwo {
    class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int prevIdx = map.get(nums[i]);
                if(Math.abs(i - prevIdx) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
}