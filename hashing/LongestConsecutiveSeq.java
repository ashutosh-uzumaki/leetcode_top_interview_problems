package hashing;
import java.util.*;
public class LongestConsecutiveSeq {
    class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums.length == 0){
                return 0;
            }
            HashSet<Integer> set = new HashSet<>();
            for(int num: nums){
                set.add(num);
            }
            int longestLength = 1;
            for(int num: nums){
                if(!set.contains(num-1)){
                    int currLength = 1;
                    int currSeqNum = num + 1;
                    while(set.contains(currSeqNum)){
                        currLength++;
                        currSeqNum += 1;
                    }
                    longestLength = Math.max(currLength, longestLength);
                }
            }
            return longestLength;
        }
    }
}
