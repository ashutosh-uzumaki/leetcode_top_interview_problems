package dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;

public class ExtraCharactersInAString {
   class Solution {
    HashSet<String> set;
    
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); 
        set = new HashSet<>();
        
        for (String word : dictionary) {
            set.add(word); 
        }
        
        return helper(0, n, dp, s);
    }

    public int helper(int idx, int n, int[] dp, String s) {
        if (idx == n) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int minExtra = n; 
        for (int j = idx; j < n; j++) {
            String word = s.substring(idx, j + 1);
            if (set.contains(word)) {
                minExtra = Math.min(minExtra, helper(j + 1, n, dp, s));
            }
        }
        minExtra = Math.min(minExtra, 1 + helper(idx + 1, n, dp, s));
        
        return dp[idx] = minExtra;
    }
}
 
}


//INTUTION -> when a substring matches call the helper function with idx + 1 else just increase the count and call 1 + helper(idx + 1)