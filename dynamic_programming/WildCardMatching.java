package dynamic_programming;

public class WildCardMatching {
    class Solution {
        public boolean helper(int i, int j, String s, String p, Boolean[][] dp){
            if(i == s.length() && j == p.length()){
                return true;
            }
    
            if(i < s.length() && j == p.length()){
                return false;
            }
    
            if(i == s.length() && j < p.length()){
                for(int idx = j; idx < p.length(); idx++){
                    if(p.charAt(idx) != '*'){
                        return false;
                    }
                }
                return true;
            }
    
            if(dp[i][j] != null){
                return dp[i][j];
            }
    
    
            char ch1 = s.charAt(i);
            char ch2 = p.charAt(j);
    
            if(ch1 == ch2 || ch2 == '?'){
                return dp[i][j] = helper(i+1, j+1, s, p, dp);
            }else if(ch2 == '*'){
                boolean no = helper(i, j+1, s, p, dp);
                boolean yes = helper(i+1, j, s, p, dp);
                return dp[i][j] = yes || no;
            }
    
            return dp[i][j] = false;
        }
        public boolean isMatch(String s, String p) {
            Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
    
            return helper(0, 0, s, p, dp);
        }
    }
}
