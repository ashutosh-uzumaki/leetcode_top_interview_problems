package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    class Solution {
    List<List<String>> result = new ArrayList<>();
    boolean[][] dp;
    public void solve(int idx, List<String> currPart, String s){
        if(idx == s.length()){
            result.add(new ArrayList<>(currPart));
            return;
        }

        for(int j=idx; j < s.length(); j++){
            if(dp[idx][j]){
                currPart.add(s.substring(idx, j+1));
                solve(j+1, currPart, s);
                currPart.remove(currPart.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n + 1][n + 1];

        for(int length = 1; length <= n; length++){
            for(int i=0; i + length - 1 < n; i++){
                int j = i + length - 1;
                if(i == j){
                    dp[i][j] = true;
                }else if(i + 1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
            }
        }

        solve(0, new ArrayList<>(), s);
        return result;
    }
}
}
