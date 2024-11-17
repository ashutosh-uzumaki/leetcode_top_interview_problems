package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    class Solution {
    HashMap<String, Boolean> words = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word: wordDict){
            words.put(word, true);
        }
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return helper(0, s, dp) == 1 ? true : false;
    }

    public int helper(int start, String s, int[] dp){
        if(start == s.length()){
            return 1;
        }
        if(dp[start] != -1){
            return dp[start];
        }

        for(int idx = start; idx < s.length(); idx++){
            String currSubStr = s.substring(start, idx+1);

            if(words.containsKey(currSubStr) && helper(idx + 1, s, dp) == 1){
                return 1;
            }
        }

        return dp[start] = 0;
    }
}
}
