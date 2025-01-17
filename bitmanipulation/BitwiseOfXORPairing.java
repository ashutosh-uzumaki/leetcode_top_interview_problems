package bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class BitwiseOfXORPairing {
    class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;

        for(int num: nums1){
            freq.put(num, freq.getOrDefault(num, 0) + n);
        }

        for(int num: nums2){
            freq.put(num, freq.getOrDefault(num, 0) + m);
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entrySet: freq.entrySet()){
            long currFreq = entrySet.getValue();
            if(currFreq % 2 != 0){
                result ^= entrySet.getKey();
            }
        }

        return result;
    }
}
}

//INTUTION -> PAIRS MEANS EACH ELEMENT FROM ARRAY1 AND ARRAY2 WILL COME ATLEAST TWICE
//SO THEY WILL BECOME A ZERO
//INCLUDE ONLY THE ODD ELEMENTS.
