import java.util.*;

public class BadPairs{
    class Solution {
        public long countBadPairs(int[] nums) {
            int n = nums.length;
            long totalPairs = (long)n * (n - 1) / 2;
            HashMap<Long, Long> mp = new HashMap<>();
            long goodPairs = 0;
            for(int i=0; i<n; i++){
                long val = (long) nums[i] - i;
                if(mp.containsKey(val)){
                    long cnt = mp.get(val);
                    goodPairs += cnt;
                }
                mp.put(val, mp.getOrDefault(val, 0l) + 1);
            }
    
            return totalPairs - goodPairs;
        }
    }
}

// nums[i] - nums[j] != i - j

// equates to nums[i] - i = nums[j] - j;
// so we have to find nums[i] - i count and reduce from total number of pairs