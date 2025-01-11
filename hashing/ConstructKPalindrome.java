package hashing;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindrome {
    class Solution {
    public boolean canConstruct(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char ch: s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        int oddCount = 0;
        for(Map.Entry<Character,Integer> entry: mp.entrySet()){
            int cnt = entry.getValue();
            if(cnt % 2 != 0){
                oddCount += 1;
            }
        }

        return oddCount <= k && k <= s.length();
    }
}
}
