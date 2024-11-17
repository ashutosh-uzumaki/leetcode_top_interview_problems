package dynamic_programming;

public class EditDistance {
    class Solution {
        int[][] memo;
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            memo = new int[m + 1][n + 1];
            for(int i=0; i<=m; i++){
                for(int j=0; j<=n; j++){
                    memo[i][j] = -1;
                }
            }
    
            return helper(0, 0, word1, word2);
        }
    
        public int helper(int i, int j, String s, String p){
            if(i == s.length() && j == p.length()){
                return 0;
            }
    
            if(i == s.length()){
                return p.length() - j;
            }
    
            if(j == p.length()){
                return s.length() - i;
            }
    
    
            if(memo[i][j] != -1){
                return memo[i][j];
            }
    
            char c1 = s.charAt(i);
            char c2 = p.charAt(j);
    
            if(c1 == c2){
                return memo[i][j] = helper(i+1, j+1, s, p);
            }
    
            int insertion = helper(i, j+1, s, p);
    
            int deletion = helper(i + 1, j, s, p);
    
            int replacement = helper(i + 1, j + 1, s, p);
    
            return memo[i][j] = 1 + Math.min(insertion, Math.min(deletion, replacement));
        }
    }
}
