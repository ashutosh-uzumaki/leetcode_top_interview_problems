package dynamic_programming;

public class LongestCommonSubsequence {
    class Solution {
        int[][] memo;
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
    
            memo = new int[m + 1][n + 1];
            for(int i=0; i<=m; i++){
                for(int j=0; j<=n; j++){
                    memo[i][j] = -1;
                }
            }
    
            return helper(0, 0, text1, text2);
        }
    
        public int helper(int i, int j, String s, String p){
            if(i == s.length() || j == p.length()){
                return 0;
            }
    
    
            if(memo[i][j] != -1){
                return memo[i][j];
            }
    
            char c1 = s.charAt(i);
            char c2 = p.charAt(j);
    
            if(c1 == c2){
                return memo[i][j] = 1 + helper(i + 1, j + 1, s, p);
            }
    
            int optionS = helper(i+1, j, s, p);
            int optionP = helper(i, j+1, s, p);
    
            return memo[i][j] = Math.max(optionS, optionP);
        }
    }
}
