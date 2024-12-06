package dynamic_programming;

public class DistinctSubsequences {
    class Solution {
        public int getCount(int i, int j, String s, String t, int[][] dp){
            if(j == t.length()) return 1;
            if(i == s.length()) return 0;
    
            if(dp[i][j] != -1){
                return dp[i][j];
            }
    
            char actual = s.charAt(i);
            char required = t.charAt(j);
    
            if(actual == required){
                return dp[i][j] = getCount(i+1, j+1, s, t, dp) + getCount(i+1, j, s, t, dp);
            }
    
            return dp[i][j] = getCount(i+1, j, s, t, dp);
        }
        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for(int i=0; i<=s.length(); i++){
                for(int j=0; j<=t.length(); j++){
                    dp[i][j] = -1;
                }
            }
            return getCount(0, 0, s, t, dp);
        }
    } 
}
