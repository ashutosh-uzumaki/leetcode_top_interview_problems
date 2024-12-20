package strings;

public class SubsequenceWithMinScoreBruteForce {
    class Solution {
        public int minimumScore(String s, String t) {
            int n = s.length();
            int m = t.length();
            if(isSubsequence(t, s)){
                return 0;
            }
            int minimumScore = m + 1;
    
            for(int left = 0; left < m; left++){
                for(int right = left; right < m; right++){
                    String remainAfterRemoval = t.substring(0, left) + t.substring(right+1);
                    if(isSubsequence(remainAfterRemoval, s)){
                        minimumScore = Math.min(right - left + 1, minimumScore);
                    }
                }
            }
    
            return minimumScore;
        }
    
        public boolean isSubsequence(String t, String s){
            int j = t.length() - 1;
            int i = s.length() - 1;
    
            for(; i>=0 && j >= 0; i--){
                if(s.charAt(i) == t.charAt(j)){
                    j--;
                }
            }
            return j < 0;
        }
    }
}
