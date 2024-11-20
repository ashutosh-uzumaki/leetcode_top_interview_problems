package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class InterLeavingStrings {
    public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        
        if (m + n != l) {
            return false;
        }
        
        Map<String, Boolean> memo = new HashMap<>();
        
        return helper(0, 0, 0, s1, s2, s3, memo);
    }
    
    private boolean helper(int i, int j, int k, String s1, String s2, String s3, Map<String, Boolean> memo) {
        if (k == s3.length()) {
            return true;
        }
        
        String key = i + "-" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = ans || helper(i + 1, j, k + 1, s1, s2, s3, memo);
        }
        
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = ans || helper(i, j + 1, k + 1, s1, s2, s3, memo);
        }
        
        memo.put(key, ans);
        return ans;
    }
}
}
