package hashing;

import java.util.HashMap;

public class SubarraySumEqualsK {
    class Solution {
    public int subarraySum(int[] nums, int k) {
        int countOfSubarraysWithGivenSum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        int prefixSum = 0;
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int sumToFind = prefixSum - k;
            if(prefixSumCount.containsKey(sumToFind)){
                countOfSubarraysWithGivenSum += prefixSumCount.get(sumToFind);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return countOfSubarraysWithGivenSum;
    }
}
}
