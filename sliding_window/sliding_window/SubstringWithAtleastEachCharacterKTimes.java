package sliding_window;

import java.util.Arrays;

public class SubstringWithAtleastEachCharacterKTimes {
    class Solution {
    public int longestSubstring(String s, int k) {
        int maxUniqueChars = countUniqueChars(s);
        int [] freq = new int[26];
        int maxLen = 0;
        for(int currUniqueCharCnt = 1; currUniqueCharCnt <= maxUniqueChars; currUniqueCharCnt++){
            Arrays.fill(freq, 0);
            int uniqueCharCnt = 0, countAtLeastK = 0, windowStart = 0, windowEnd = 0;

            while(windowEnd < s.length()){
                if(uniqueCharCnt <= currUniqueCharCnt){
                    int idx = s.charAt(windowEnd) - 'a';
                    if(freq[idx] == 0){
                        uniqueCharCnt++;
                    }
                    freq[idx]++;

                    if(freq[idx] == k){
                        countAtLeastK++;
                    }
                    windowEnd++;
                }else{
                    int idx = s.charAt(windowStart) - 'a';
                    if(freq[idx] == k){
                        countAtLeastK--;
                    }
                    freq[idx]--;
                    if(freq[idx] == 0){
                        uniqueCharCnt--;
                    }
                    windowStart++;
                }

                if(uniqueCharCnt == currUniqueCharCnt && uniqueCharCnt == countAtLeastK){
                    maxLen = Math.max(windowEnd - windowStart, maxLen);
                }
            }
        }
        return maxLen;
    }

    public int countUniqueChars(String s){
        int[] freq = new int[26];
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 0){
                cnt += 1;
            }
            freq[s.charAt(i) - 'a'] = 1;
        }

        return cnt;
    }
}   
}
